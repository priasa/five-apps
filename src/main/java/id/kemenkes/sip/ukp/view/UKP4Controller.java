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
import id.kemenkes.sip.ukp.dao.UKP4Repository;
import id.kemenkes.sip.ukp.entity.UKP4;
import id.kemenkes.sip.ukp.entity.UKP4Detail;

@Controller
@RequestMapping("/web/ukp4")
public class UKP4Controller {

    static final Logger LOGGER = LoggerFactory.getLogger(UKP4Controller.class);

	@Autowired
	UKP4Repository ukp4Repository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		UKP4 ukp4 = new UKP4();
		ukp4.setSubmittedDate(null);
		ukp4.setKodePuskesmas("P140101102");
		ukp4.setNamaPuskesmas("BANGKINANG KOTA");
		ukp4.setProvinsi(14);
		ukp4.setKotaKabupaten(1401);
		ukp4.setBulan(1);
		ukp4.setTahun(2016);
		ukp4.setPoskesdes_lapor(5);
		ukp4.setPoskesdes_total(5);
		ukp4.setPustu_lapor(5);
		ukp4.setPustu_total(5);
		
		List<UKP4Detail> details = new ArrayList<UKP4Detail>();
		UKP4Detail detail1 = new UKP4Detail();
		detail1.setNomor(1);
		detail1.setJenis_penyakit("Penyakit 01");
		detail1.setIcdx("ICDX 01");
		details.add(detail1);
		
		UKP4Detail detail2 = new UKP4Detail();
		detail2.setNomor(2);
		detail2.setJenis_penyakit("Penyakit 02");
		detail2.setIcdx("ICDX 02");
		details.add(detail2);
		
		ukp4.setDetail(details);
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"UKP4-AUSY9XT9\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(ukp4));
        model.addAttribute("menu", "howto.ukp4");

		return "ukp4/howto";
    }
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        UKP4 ukp4 = ukp4Repository.getById(id);
        
        model.addAttribute("ukp4", ukp4);
        model.addAttribute("menu", "report.ukp4");
        
        return "ukp4/view";
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
    	    	
        String id = "ukp4";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        model.addAttribute("bulan", bulan);
        
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<UKP4> returnPage = ukp4Repository.getByFilter(kodePuskesmas, tahun, bulan, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.ukp4");
        
        return "ukp4/list";
    }
	
	@RequestMapping("delete")
	public String deleteUKP4(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					ukp4Repository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting ukp4", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/ukp4/list";
	}
}
