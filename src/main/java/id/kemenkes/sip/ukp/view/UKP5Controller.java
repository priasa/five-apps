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
import id.kemenkes.sip.ukp.dao.UKP5Repository;
import id.kemenkes.sip.ukp.entity.UKP5;
import id.kemenkes.sip.ukp.entity.UKP5Detail;

@Controller
@RequestMapping("/web/ukp5")
public class UKP5Controller {

    static final Logger LOGGER = LoggerFactory.getLogger(UKP5Controller.class);

	@Autowired
	UKP5Repository ukp5Repository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		UKP5 ukp5 = new UKP5();
		ukp5.setSubmittedDate(null);
		ukp5.setKodePuskesmas("P140101102");
		ukp5.setNamaPuskesmas("BANGKINANG KOTA");
		ukp5.setProvinsi(14);
		ukp5.setKotaKabupaten(1401);
		ukp5.setBulan(1);
		ukp5.setTahun(2016);
		ukp5.setPoskesdes_lapor(5);
		ukp5.setPoskesdes_total(5);
		ukp5.setPustu_lapor(5);
		ukp5.setPustu_total(5);
		
		List<UKP5Detail> details = new ArrayList<UKP5Detail>();
		UKP5Detail detail1 = new UKP5Detail();
		detail1.setNomor("01");
		detail1.setTanggal("19/11/2016");
		detail1.setNik_nkk("123456");
		detail1.setNama("Nama 01");
		detail1.setKepala_keluarga("Kepala Keluarga 01");
		detail1.setAlamat_lengkap("Alamat 01");
		detail1.setTanggal_lahir("19/11/2016");
		detail1.setLokasi_meninggal("Lokasi 01");
		detail1.setSebab_langsung("Kode 01");
		detail1.setSebab_dasar("Kode 01");
		detail1.setPenyakit_penyerta("Kode 01");
		detail1.setTanggal_meninggal("19/11/2016");
		detail1.setJenis_kelamin("L");
		details.add(detail1);
		
		UKP5Detail detail2 = new UKP5Detail();
		detail2.setNomor("02");
		detail2.setTanggal("19/11/2016");
		detail2.setNik_nkk("789012");
		detail2.setNama("Nama 02");
		detail2.setKepala_keluarga("Kepala Keluarga 02");
		detail2.setAlamat_lengkap("Alamat 02");
		detail2.setTanggal_lahir("19/11/2016");
		detail2.setLokasi_meninggal("Lokasi 02");
		detail2.setSebab_langsung("Kode 02");
		detail2.setSebab_dasar("Kode 02");
		detail2.setPenyakit_penyerta("Kode 02");
		detail2.setTanggal_meninggal("19/11/2016");
		detail2.setJenis_kelamin("P");
		details.add(detail2);
		
		ukp5.setDetail(details);
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"UKP5-JLIAMHOI\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(ukp5));
        model.addAttribute("menu", "howto.ukp5");

		return "ukp5/howto";
    }
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        UKP5 ukp5 = ukp5Repository.getById(id);
        
        model.addAttribute("ukp5", ukp5);
        model.addAttribute("menu", "report.ukp5");
        
        return "ukp5/view";
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
    	    	
        String id = "ukp5";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        model.addAttribute("bulan", bulan);
        
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<UKP5> returnPage = ukp5Repository.getByFilter(kodePuskesmas, tahun, bulan, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.ukp5");
        
        return "ukp5/list";
    }
	
	@RequestMapping("delete")
	public String deleteUKP5(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					ukp5Repository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting ukp5", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/ukp5/list";
	}
}
