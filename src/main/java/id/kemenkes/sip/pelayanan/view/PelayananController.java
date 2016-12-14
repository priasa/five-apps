package id.kemenkes.sip.pelayanan.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

import id.kemenkes.sip.common.entity.BulanCount;
import id.kemenkes.sip.common.entity.ProvinsiCount;
import id.kemenkes.sip.common.util.DisplayTagUtil;
import id.kemenkes.sip.kabupaten.dao.KabupatenRepository;
import id.kemenkes.sip.laporan.dao.LaporanRepository;
import id.kemenkes.sip.laporan.entity.LaporanEntity;
import id.kemenkes.sip.pelayanan.dao.PelayananRepository;
import id.kemenkes.sip.pelayanan.entity.PelayananEntity;
import id.kemenkes.sip.provinsi.dao.ProvinsiRepository;
import id.kemenkes.sip.provinsi.entity.ProvinsiCounterVo;
import id.kemenkes.sip.provinsi.entity.ProvinsiEntity;
import id.kemenkes.sip.puskesmas.dao.PuskesmasRepository;


@Controller
@RequestMapping("/web/pelayanan")
public class PelayananController {

	static final Logger LOGGER = LoggerFactory.getLogger(PelayananController.class);

	@Autowired
	PelayananRepository pelayananRepository;
	
	@Autowired
	ProvinsiRepository provinsiRepository;
	
	@Autowired
	KabupatenRepository kabupatenRepository;
	
	@Autowired
	PuskesmasRepository puskesmasRepository;
	
	@Autowired
	LaporanRepository laporanRepository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		PelayananEntity pelayananEntity = new PelayananEntity();
		pelayananEntity.setKodePuskesmas("P140101102");
		pelayananEntity.setNamaPuskesmas("BANGKINANG KOTA");
		pelayananEntity.setProvinsi(14);
		pelayananEntity.setKotaKabupaten(1401);
		pelayananEntity.setBulan(11);
		pelayananEntity.setTahun(2016);
		
		pelayananEntity.setSubmittedDate(null);
		pelayananEntity.setNama("nama 01");
		pelayananEntity.setNik_kk("1122334455667788");
		pelayananEntity.setTanggal_kunjungan("04/11/2016");
		pelayananEntity.setNomor_bpjs("BPJS 01");
		pelayananEntity.setKode_diagnosa1("ICD 01");
		pelayananEntity.setKode_diagnosa2("ICD 02");
		pelayananEntity.setKode_diagnosa3("ICD 03");
		pelayananEntity.setKeluhan("Keluhan 01");
		
		pelayananEntity.setSistole(0);
		pelayananEntity.setSistole(0);
		pelayananEntity.setCatatan("Catatan 01");
		pelayananEntity.setPemeriksaan_fisikLain("fisik 01");
		pelayananEntity.setTindakan("Tindakan 01");
		
		model.addAttribute("responseJsonFormat", "{\"status\": \"success\", \"messageCode\": \"\",\"message\": \"PELAYANAN-XXD486G2\"}");
		model.addAttribute("requestJsonFormat", new Gson().toJson(pelayananEntity));
        model.addAttribute("menu", "howto.pelayanan");

		return "pelayanan/howto";
    }
	
	@RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        PelayananEntity pelayananEntity = pelayananRepository.getById(id);
        
        model.addAttribute("pelayananEntity", pelayananEntity);
        model.addAttribute("menu", "report.pelayanan");
        
        return "pelayanan/view";
    }
	
	@ModelAttribute("tahunList")
    public Integer[] getTahunList(){
		List<Integer> list = new ArrayList<Integer>();
		Calendar now = Calendar.getInstance();
		Integer currentYear = now.get(Calendar.YEAR);
		list.add(currentYear);
		for (int i = 1 ; i<=5 ; i++) {
			list.add(currentYear-i);
		}
		
		return list.toArray(new Integer[list.size()]);
    }
	
	@ModelAttribute("laporanList")
    public List<LaporanEntity> getLaporanList(){
		return laporanRepository.findAll();
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
    	    	
        String id = "pelayananEntity";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "kodePuskesmas"}, "kodePuskesmas");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("kodePuskesmas", kodePuskesmas);
        model.addAttribute("tahun", tahun);
        model.addAttribute("bulan", bulan);
        
        model.addAttribute("id", id);
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<PelayananEntity> returnPage = pelayananRepository.getByFilter(kodePuskesmas, tahun, bulan, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "report.pelayanan");
        
        
        return "pelayanan/list";
    }
	
	@RequestMapping(value="dashboard1", method=RequestMethod.GET)
    public String dashboard(ModelMap model, HttpServletRequest request, @RequestParam(value = "tahun", required = false) Integer tahun,  @RequestParam(value = "laporan", required = false) String laporan) throws ParseException{
		
		if (tahun == null) {
			Calendar now = Calendar.getInstance();
			tahun = now.get(Calendar.YEAR);
		}
		
		if (laporan == null) {
			laporan = "PELAYANAN";
		}
		
		model.addAttribute("tahun", tahun);
		model.addAttribute("laporan", laporan.isEmpty()?"PELAYANAN":laporan);
		LaporanEntity laporanEntity = laporanRepository.findOne(laporan);
		model.addAttribute("namaLaporan", laporanEntity.getNama());
		
		long nProvinsi = provinsiRepository.count();
        model.addAttribute("nProvinsi", nProvinsi);
        
        long nKotaKabupaten = kabupatenRepository.count();
        model.addAttribute("nKotaKabupaten", nKotaKabupaten);
		
        long nPuskesmas = puskesmasRepository.count();
        model.addAttribute("nPuskesmas", nPuskesmas);
                
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("tahun", tahun);
        
        if (laporanEntity.getKode().equalsIgnoreCase("Pelayanan")) {
        	processToPelayanan(model, whereQuery, tahun, nProvinsi, nKotaKabupaten, nPuskesmas);
        }
        
        
//        List kabupatenCounter = pelayananRepository.aggregationKabupatenByYear(2016,11);
//        for (Object pc : kabupatenCounter) {
//        	KabupatenCount kabupatenCount = (KabupatenCount)pc;
//        	System.out.println("Provinsi :" +kabupatenCount.getProvinsi()+","+"Kabupaten :"+kabupatenCount.getKotaKabupaten()+",Total :"+kabupatenCount.getTotalData());
//        }
//        List puskesmasCounter = pelayananRepository.aggregationPuskesmasByYear(2016,11,1101);
//        for (Object pc : puskesmasCounter) {
//        	PuskesmasCount puskesmasCount = (PuskesmasCount)pc;
//        	System.out.println("Provinsi :" +puskesmasCount.getProvinsi()+","+"Kabupaten :"+puskesmasCount.getKotaKabupaten()+",Puskesmas :"+puskesmasCount.getKodePuskesmas()+",Total :"+puskesmasCount.getTotalData());
//        }
        
		return "pelayanan/dashboard1";
	}
	
	
	@SuppressWarnings("unchecked")
	private void processToPelayanan(ModelMap model, BasicDBObject whereQuery, Integer tahun, long nProvinsi, long nKotaKabupaten, long nPuskesmas) {
		long totalData = pelayananRepository.countByFilter("", tahun, 0);
        model.addAttribute("totalData", totalData);
        
        
        int totalProvinsi = pelayananRepository.countFieldDistinctByQuery("provinsi", whereQuery);
        model.addAttribute("totalProvinsi", totalProvinsi);
        model.addAttribute("persenProvinsi", String.format("%.2f", (float)totalProvinsi/nProvinsi*100));
        
        int totalKotaKabupaten = pelayananRepository.countFieldDistinctByQuery("kotaKabupaten", whereQuery);
        model.addAttribute("totalKotaKabupaten", totalKotaKabupaten);
        model.addAttribute("persenKotaKabupaten", String.format("%.2f", (float)totalKotaKabupaten/nKotaKabupaten*100));

        
        int totalPuskesmas = pelayananRepository.countFieldDistinctByQuery("kodePuskesmas", whereQuery);
        model.addAttribute("totalPuskesmas", totalPuskesmas);
        model.addAttribute("persenPuskesmas", String.format("%.2f", (float)totalPuskesmas/nPuskesmas*100));
        
        
        @SuppressWarnings("rawtypes")
		List provinsiCounter = pelayananRepository.aggregationProvinsiByYear(tahun);
        Map<Integer, Integer> mapOfProvinsiCount = new HashMap<Integer, Integer>();
        for (Object pc : provinsiCounter) {
        	ProvinsiCount provinsiCount = (ProvinsiCount)pc;
        	mapOfProvinsiCount.put(provinsiCount.getProvinsi(), provinsiCount.getTotalData());
        }
        
        
        List<ProvinsiCounterVo> vos = new ArrayList<ProvinsiCounterVo>();
        List<ProvinsiEntity> provinsiEntities =  provinsiRepository.findAll();
        StringBuilder sbProvinsiName = new StringBuilder("[");
        StringBuilder sbProvinsiData = new StringBuilder("[");

        for (int i = 0 ; i<provinsiEntities.size() ; i++) {
        	ProvinsiEntity p = provinsiEntities.get(i);
        			
        	ProvinsiCounterVo vo = new ProvinsiCounterVo();
        	vo.setProvinsiEntity(p);
        	Integer provinsiTotalData = mapOfProvinsiCount.get(p.getKode());
        	vo.setTotalData(provinsiTotalData == null?0:provinsiTotalData);
        	vos.add(vo);
        	
        	sbProvinsiName.append("\"").append(vo.getProvinsiEntity().getNama()).append("\"");
        	sbProvinsiData.append(vo.getTotalData());
        	if(i<provinsiEntities.size()-1) {
        		sbProvinsiName.append(",");
        		sbProvinsiData.append(",");
        	}
        }
        sbProvinsiName.append("]");
		sbProvinsiData.append("]");
		
		model.addAttribute("provinsiNameList", sbProvinsiName.toString());
		model.addAttribute("provinsiDataList", sbProvinsiData.toString());
		
        model.addAttribute("provinsiData", vos);
        
        @SuppressWarnings("rawtypes")
        List bulanCounter = pelayananRepository.aggregationBulanByYear(tahun);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0;i<bulanCounter.size();i++) {
        	BulanCount bc = (BulanCount)bulanCounter.get(i);
        	sb.append(bc.getTotalData());
        	if(i<bulanCounter.size()-1) {
        		sb.append(",");
        	}
        }
        sb.append("]");
        model.addAttribute("bulanListData", (List<BulanCount>)bulanCounter);
        model.addAttribute("bulanData", sb.toString());
	}

	@RequestMapping("delete")
	public String deletePelayanan(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					pelayananRepository.deleteById(id);;
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting pelayanan", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "general.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "general.delete.partial.success.message");
			}
		}
		return "redirect:/web/pelayanan/list";
	}
}
