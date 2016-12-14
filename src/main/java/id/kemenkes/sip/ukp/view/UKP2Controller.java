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
import id.kemenkes.sip.ukp.dao.UKP2Repository;
import id.kemenkes.sip.ukp.entity.UKP2;
import id.kemenkes.sip.ukp.entity.UKP2Detail;

@Controller
@RequestMapping("/web/ukp2")
public class UKP2Controller {

    static final Logger LOGGER = LoggerFactory.getLogger(UKP2Controller.class);

	@Autowired
	UKP2Repository ukp2Repository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		UKP2 ukp2 = new UKP2();
		ukp2.setSubmittedDate(null);
		ukp2.setKodePuskesmas("P140101102");
		ukp2.setNamaPuskesmas("BANGKINANG KOTA");
		ukp2.setProvinsi(14);
		ukp2.setKotaKabupaten(1401);
		ukp2.setBulan(1);
		ukp2.setTahun(2016);
		ukp2.setPoskesdes_lapor(5);
		ukp2.setPoskesdes_total(5);
		ukp2.setPustu_lapor(5);
		ukp2.setPustu_total(5);
		
		List<UKP2Detail> details = new ArrayList<UKP2Detail>();
		UKP2Detail detail1 = new UKP2Detail();
		detail1.setNomor(1);
		detail1.setKelompok_penyakit("Kelompok Penyakit 01");
		detail1.setJenis_penyakit("Penyakit 01");
		detail1.setIcdx("ICDX 01");
		details.add(detail1);
		
		UKP2Detail detail2 = new UKP2Detail();
		detail2.setNomor(2);
		detail2.setKelompok_penyakit("Kelompok Penyakit 02");
		detail2.setJenis_penyakit("Penyakit 02");
		detail2.setIcdx("ICDX 02");
		details.add(detail2);
		
		ukp2.setDetail(details);
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"UKP2-YOEVQK10\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(ukp2));
        model.addAttribute("menu", "howto.ukp2");

		return "ukp2/howto";
    }
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        UKP2 ukp2 = ukp2Repository.getById(id);
        
        model.addAttribute("ukp2", ukp2);
        model.addAttribute("menu", "report.ukp2");
        
        return "ukp2/view";
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
    	    	
        String id = "ukp2";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        model.addAttribute("bulan", bulan);
        
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<UKP2> returnPage = ukp2Repository.getByFilter(kodePuskesmas, tahun, bulan, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.ukp2");
        
        return "ukp2/list";
    }
	
	@RequestMapping("delete")
	public String deleteUKP2(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					ukp2Repository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting ukp2", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/ukp2/list";
	}
}
