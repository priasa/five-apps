package id.kemenkes.sip.lt.view;

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
import id.kemenkes.sip.lt.dao.LT1Repository;
import id.kemenkes.sip.lt.entity.LT1;
import id.kemenkes.sip.lt.entity.LT1Detail;

@Controller
@RequestMapping("/web/lt1")
public class LT1Controller {

    static final Logger LOGGER = LoggerFactory.getLogger(LT1Controller.class);

	@Autowired
	LT1Repository lt1Repository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		LT1 lt1 = new LT1();
		lt1.setSubmittedDate(null);
		lt1.setKodePuskesmas("P140101102");
		lt1.setNamaPuskesmas("BANGKINANG KOTA");
		lt1.setProvinsi(14);
		lt1.setKotaKabupaten(1401);
		lt1.setTahun(2016);
		
		List<LT1Detail> details = new ArrayList<LT1Detail>();
		LT1Detail detail1 = new LT1Detail();
		detail1.setNomor(1);
		detail1.setJenis_namaruangan("jenis atau nama ruangan 1");
		detail1.setJenis_alat("jenis alat 1");
		detail1.setKetersediaan_ada(5);
		detail1.setKetersediaan_tidakada(3);
		detail1.setNomor_seri("nomor seri 1");
		detail1.setMerk("merk 1");
		detail1.setType("type 1");
		detail1.setTahun_perolehan("2016");
		detail1.setTahun_operasional("2016");
		detail1.setKondisi_berfungsi(3);
		detail1.setKondisi_rusak(2);
		detail1.setTanggal_kalibrasi("28/04/2016");
		detail1.setDistributor("distributor 1");
		detail1.setHarga(1000000d);
		detail1.setApbd2(1000000d);
		detail1.setNegara_pembuat("negara 1");
		details.add(detail1);
		
		LT1Detail detail2 = new LT1Detail();
		detail2.setNomor(2);
		detail2.setJenis_namaruangan("jenis atau nama ruangan 2");
		detail2.setJenis_alat("jenis alat 2");
		detail2.setKetersediaan_ada(5);
		detail2.setKetersediaan_tidakada(3);
		detail2.setNomor_seri("nomor seri 2");
		detail2.setMerk("merk 2");
		detail2.setType("type 2");
		detail2.setTahun_perolehan("2016");
		detail2.setTahun_operasional("2016");
		detail2.setKondisi_berfungsi(3);
		detail2.setKondisi_rusak(2);
		detail2.setTanggal_kalibrasi("28/04/2016");
		detail2.setDistributor("distributor 2");
		detail2.setHarga(2000000d);
		detail2.setApbd2(2000000d);
		detail2.setNegara_pembuat("negara 2");
		details.add(detail2);
		
		lt1.setDetail(details);
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"LT1-TYRKLM10\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(lt1));
        model.addAttribute("menu", "howto.lt1");

		return "lt1/howto";
    }
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        LT1 lt1 = lt1Repository.getById(id);
        
        model.addAttribute("lt1", lt1);
        model.addAttribute("menu", "report.lt1");
        
        return "lt1/view";
    }
	
	@RequestMapping(value="list", method=RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request, @RequestParam(value = "kodePuskesmas", required = false) String kodePuskesmas, 
    		@RequestParam(value = "tahun", required = false) Integer tahun) throws ParseException{
        
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
    	    	    	
        String id = "lt1";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<LT1> returnPage = lt1Repository.getByFilter(kodePuskesmas, tahun, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.lt1");
        
        return "lt1/list";
    }
	
	@RequestMapping("delete")
	public String deleteLT1(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					lt1Repository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting lt1", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/lt1/list";
	}
}
