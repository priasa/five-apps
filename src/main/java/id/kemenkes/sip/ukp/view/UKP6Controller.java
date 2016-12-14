package id.kemenkes.sip.ukp.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import id.kemenkes.sip.common.util.DisplayTagUtil;
import id.kemenkes.sip.ukp.dao.UKP6Repository;
import id.kemenkes.sip.ukp.entity.UKP6;
import id.kemenkes.sip.ukp.entity.UKP6Detail;

@Controller
@RequestMapping("/web/ukp6")
public class UKP6Controller {

    static final Logger LOGGER = LoggerFactory.getLogger(UKP6Controller.class);

	@Autowired
	UKP6Repository ukp6Repository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		UKP6 ukp6 = new UKP6();
		ukp6.setSubmittedDate(null);
		ukp6.setKodePuskesmas("P140101102");
		ukp6.setNamaPuskesmas("BANGKINANG KOTA");
		ukp6.setProvinsi(14);
		ukp6.setKotaKabupaten(1401);
		ukp6.setBulan(1);
		ukp6.setTahun(2016);
		ukp6.setPoskesdes_lapor(5);
		ukp6.setPoskesdes_total(5);
		ukp6.setPustu_lapor(5);
		ukp6.setPustu_total(5);
		ukp6.setKunj_umum_bayar(0);
		ukp6.setKunj_umum_tdk_bayar(0);
		ukp6.setKunj_jkn(0);
		ukp6.setKunj_total(0);
		
		List<UKP6Detail> details = new ArrayList<UKP6Detail>();
	
		UKP6Detail detail1 = new UKP6Detail();
		detail1.setNomor("01");
		detail1.setKode_obat("OB01");
		detail1.setNama_obat("OBAT 01");
		detail1.setSatuan("Satuan 01");
		details.add(detail1);
		
		UKP6Detail detail2 = new UKP6Detail();
		detail2.setNomor("02");
		detail2.setKode_obat("OB02");
		detail2.setNama_obat("OBAT 02");
		detail2.setSatuan("Satuan 02");
		details.add(detail2);
		
		ukp6.setDetail(details);
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"UKP6-YERBQLF0\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(ukp6));
        model.addAttribute("menu", "howto.ukp6");

		return "ukp6/howto";
    }
	

	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        UKP6 ukp6 = ukp6Repository.getById(id);
        
        model.addAttribute("ukp6", ukp6);
        model.addAttribute("menu", "report.ukp6");
        
        return "ukp6/view";
    }
	
	@RequestMapping(value="list", method=RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request, @RequestParam(value = "kodePuskesmas", required = false) String kodePuskesmas, 
    		@RequestParam(value = "tahun", required = false) Integer tahun,
    		@RequestParam(value = "bulan", required = false) Integer bulan) throws ParseException{
        
		if (kodePuskesmas == null) {
			kodePuskesmas = "";
		} else {
			if (kodePuskesmas.isEmpty()) {
    			kodePuskesmas = "";
			}
    	}
    	
    	if (tahun == null) {
    		tahun = 0;
    	}
    	
    	if (bulan  == null) {
    		bulan = 0;
    	}
    	    	
        String id = "ukp6";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        model.addAttribute("bulan", bulan);
        
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<UKP6> returnPage = ukp6Repository.getByFilter(kodePuskesmas, tahun, bulan, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.ukp6");
        
        return "ukp6/list";
    }
	
	@RequestMapping("delete")
	public String deleteUKP6(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					ukp6Repository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting ukp6", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/ukp6/list";
	}
}
