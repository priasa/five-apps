package id.kemenkes.sip.ukme.view;

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
import id.kemenkes.sip.ukme.dao.UKME3ARepository;
import id.kemenkes.sip.ukme.entity.UKME3A;
import id.kemenkes.sip.ukme.entity.UKME3ADTO;

@Controller
@RequestMapping("/web/ukme3a")
public class UKME3AController {

    static final Logger LOGGER = LoggerFactory.getLogger(UKME3AController.class);

	@Autowired
	UKME3ARepository ukme3aRepository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		UKME3ADTO ukme3adto = new UKME3ADTO();
		ukme3adto.setKodePuskesmas("P140101102");
		ukme3adto.setNamaPuskesmas("BANGKINANG KOTA");
		ukme3adto.setProvinsi(14);
		ukme3adto.setKotaKabupaten(1401);
		ukme3adto.setBulan(1);
		ukme3adto.setTahun(2016);
		ukme3adto.setDesa("Desa Sukamaju");
		ukme3adto.setPoskesdes_lapor(5);
		ukme3adto.setPoskesdes_total(5);
		ukme3adto.setPustu_lapor(5);
		ukme3adto.setPustu_total(5);
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"UKME3A-UHVNRTLY\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(ukme3adto));
        model.addAttribute("menu", "howto.ukme3a");

		return "ukme3a/howto";
    }
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        UKME3A ukme3a = ukme3aRepository.getById(id);
        
        model.addAttribute("ukme3a", ukme3a);
        model.addAttribute("menu", "report.ukme3a");
        
        return "ukme3a/view";
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
    	    	
        String id = "ukme3a";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        model.addAttribute("bulan", bulan);
        
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<UKME3A> returnPage = ukme3aRepository.getByFilter(kodePuskesmas, tahun, bulan, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.ukme3a");
        
        return "ukme3a/list";
    }
	
	@RequestMapping("delete")
	public String deleteUKME3A(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					ukme3aRepository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting ukme3a", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/ukme3a/list";
	}
}
