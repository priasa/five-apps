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
import id.kemenkes.sip.lt.dao.LT2Repository;
import id.kemenkes.sip.lt.entity.LT2;
import id.kemenkes.sip.lt.entity.LT2Detail;

@Controller
@RequestMapping("/web/lt2")
public class LT2Controller {

    static final Logger LOGGER = LoggerFactory.getLogger(LT2Controller.class);

	@Autowired
	LT2Repository lt2Repository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		LT2 lt2 = new LT2();
		lt2.setSubmittedDate(null);
		lt2.setKodePuskesmas("P140101102");
		lt2.setNamaPuskesmas("BANGKINANG KOTA");
		lt2.setProvinsi(14);
		lt2.setKotaKabupaten(1401);
		lt2.setTahun(2016);
		
		List<LT2Detail> details = new ArrayList<LT2Detail>();
		LT2Detail detail1 = new LT2Detail();
		detail1.setNomor(1);
		detail1.setKode_unit("kode unit 1");
		detail1.setNik("1234567890");
		detail1.setNip_id("nip 01");
		detail1.setNama("nama 01");
		detail1.setJenis_kelamin("L");
		detail1.setStatus_kepegawaian("status pgw 01");
		detail1.setKode_sdmk("kode sdmk 01");
		detail1.setTanggal_mulai("28/04/2016");
		detail1.setTanggal_berakhir("28/04/2017");
		detail1.setKode_pendidikan("kode pdkk 01");
		detail1.setTahun_lulus("2014");
		detail1.setRiwayat_pelatihan("pelatihan 01");
		detail1.setJabatan("jabatan 01");
		detail1.setJenjang_jabatan("jenjang jbt 01");
		detail1.setTahun_jabatan("2016");
		detail1.setEmail("01@email.com");
		details.add(detail1);
		
		LT2Detail detail2 = new LT2Detail();
		detail2.setKode_unit("kode unit 2");
		detail2.setNik("2341572890");
		detail2.setNip_id("nip 02");
		detail2.setNama("nama 02");
		detail2.setJenis_kelamin("P");
		detail2.setStatus_kepegawaian("status pgw 02");
		detail2.setKode_sdmk("kode sdmk 02");
		detail2.setTanggal_mulai("23/05/2016");
		detail2.setTanggal_berakhir("23/05/2017");
		detail2.setKode_pendidikan("kode pdkk 02");
		detail2.setTahun_lulus("2014");
		detail2.setRiwayat_pelatihan("pelatihan 02");
		detail2.setJabatan("jabatan 02");
		detail2.setJenjang_jabatan("jenjang jbt 02");
		detail2.setTahun_jabatan("2016");
		detail2.setEmail("02@email.com");
		details.add(detail2);
		
		lt2.setDetail(details);
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"LT2-UYHKLM10\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(lt2));
        model.addAttribute("menu", "howto.lt2");

		return "lt2/howto";
    }
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        LT2 lt2 = lt2Repository.getById(id);
        
        model.addAttribute("lt2", lt2);
        model.addAttribute("menu", "report.lt2");
        
        return "lt2/view";
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
    	    	    	
        String id = "lt2";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<LT2> returnPage = lt2Repository.getByFilter(kodePuskesmas, tahun, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.lt2");
        
        return "lt2/list";
    }
	
	@RequestMapping("delete")
	public String deleteLT2(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					lt2Repository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting lt2", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/lt2/list";
	}
}
