package id.kemenkes.sip.ukmp.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import id.kemenkes.sip.ukmp.dao.UKMP2Repository;
import id.kemenkes.sip.ukmp.entity.UKMP2;

@Controller
@RequestMapping("/web/ukmp2")
public class UKMP2Controller {

    static final Logger LOGGER = LoggerFactory.getLogger(UKMP2Controller.class);

	@Autowired
	UKMP2Repository ukmp2Repository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		UKMP2 ukmp2 = new UKMP2();
		ukmp2.setKodePuskesmas("P140101102");
		ukmp2.setNamaPuskesmas("BANGKINANG KOTA");
		ukmp2.setProvinsi(14);
		ukmp2.setKotaKabupaten(1401);
		ukmp2.setBulan(1);
		ukmp2.setTahun(2016);
		ukmp2.setPoskesdes_lapor(5);
		ukmp2.setPoskesdes_total(5);
		ukmp2.setPustu_lapor(5);
		ukmp2.setPustu_total(5);
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"UKMP2-XXD486G2\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(ukmp2));
        model.addAttribute("menu", "howto.ukmp2");

		return "ukmp2/howto";
    }
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        UKMP2 ukmp2 = ukmp2Repository.getById(id);
        
        model.addAttribute("ukmp2", ukmp2);
        model.addAttribute("menu", "report.ukmp2");
        
        return "ukmp2/view";
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
    	    	
        String id = "ukmp2";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        model.addAttribute("bulan", bulan);
        
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<UKMP2> returnPage = ukmp2Repository.getByFilter(kodePuskesmas, tahun, bulan, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.ukmp2");
        
        return "ukmp2/list";
    }
	
	@RequestMapping("delete")
	public String deleteUKMP2(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					ukmp2Repository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting ukmp2", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/ukmp2/list";
	}
}
