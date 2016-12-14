package id.kemenkes.sip.tenant.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.kemenkes.sip.common.util.CommonUtil;
import id.kemenkes.sip.common.util.DisplayTagUtil;
import id.kemenkes.sip.kabupaten.dao.KabupatenRepository;
import id.kemenkes.sip.kabupaten.entity.KabupatenEntity;
import id.kemenkes.sip.provinsi.dao.ProvinsiRepository;
import id.kemenkes.sip.provinsi.entity.ProvinsiEntity;
import id.kemenkes.sip.puskesmas.dao.PuskesmasRepository;
import id.kemenkes.sip.puskesmas.entity.PuskesmasEntity;
import id.kemenkes.sip.tenant.dao.TenantRepository;
import id.kemenkes.sip.tenant.entity.TenantEntity;


@Controller
@RequestMapping("/web/tenant")
public class TenantController {

    static final Logger LOGGER = LoggerFactory.getLogger(TenantController.class);

    @Autowired
    TenantRepository tenantRepository;
    
    @Autowired
    ProvinsiRepository provinsiRepository; 
    
    @Autowired
    KabupatenRepository kabupatenRepository;
    
    @Autowired
    PuskesmasRepository puskesmasRepository;
    
    @ModelAttribute("provinsiList")
    public List<ProvinsiEntity> getAllProvinsi(){
        return provinsiRepository.findAll();
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
    
    @RequestMapping(value={"/","/new", "/clear"}, method=RequestMethod.GET)
    public String newTenant(ModelMap model){
        
        TenantEntity tenantEntity = new TenantEntity();
        String tenantCode =  RandomStringUtils.randomAlphanumeric(6);
    	tenantEntity.setTenantCode(tenantCode.toUpperCase());
    	
        model.addAttribute("tenantEntity", tenantEntity);
        model.addAttribute("menu", "tenant.new");
        
        return "tenant/new";
    }
    
    @RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        TenantEntity tenantEntity = tenantRepository.findOne(id);
        
        model.addAttribute("tenantEntity", tenantEntity);
        model.addAttribute("menu", "tenant.view");
        
        return "tenant/view";
    }
    
    @RequestMapping(value="list", method=RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request, @RequestParam(value = "tenantCode", required = false) String tenantCode) throws ParseException{
        
    	if (tenantCode != null) {
    		if (tenantCode.isEmpty())
    			tenantCode = "";
    	}
    	
    	String wildCardTenantCode = CommonUtil.addWildCard(tenantCode);
    	
        String id = "tenantEntity";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "tenantCode"}, "tenantCode");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("tenantCode", tenantCode);
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<TenantEntity> returnPage = tenantRepository.findByLikeTenantCode(wildCardTenantCode, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "admin.tenant");
        
        return "tenant/list";
    }
    
    @RequestMapping(value="save/submit", method=RequestMethod.POST)
    public String submitGuest(ModelMap model, RedirectAttributes redirectAttributes, HttpServletRequest request, @Valid TenantEntity tenantEntity, BindingResult result){
    	if(result.hasErrors()){
    		tenantEntity.setProvinsi(null);
    		tenantEntity.setKabupaten(null);
    		model.addAttribute("tenantEntity", tenantEntity);
            model.addAttribute("menu", "tenant.new");
            return "tenant/new";
        }
    	
    	boolean isValid = true; 
    	if (tenantEntity.getTenantCode() != null) {
    		PuskesmasEntity puskesmas = puskesmasRepository.findOne(tenantEntity.getTenantCode());
    		tenantEntity.setTenantName(puskesmas.getNama());
    	} else {
    		isValid = false;
    	}
    	
    	if (tenantEntity.getProvinsi() != null) {
    		ProvinsiEntity provinsi = provinsiRepository.findOne(tenantEntity.getProvinsi());
    		tenantEntity.setProvinsiName(provinsi.getNama());
    	} else {
    		isValid = false;
    	}
    	
    	if(tenantEntity.getKabupaten() != null) {
    		KabupatenEntity kabupaten = kabupatenRepository.findOne(tenantEntity.getKabupaten());
    		tenantEntity.setKabupatenName(kabupaten.getNama());
    	} else {
    		isValid = false;
    	}
    	
    	if (isValid) {
	    	tenantEntity.setTokenId(UUID.randomUUID().toString());
	    	tenantRepository.save(tenantEntity);
	    	redirectAttributes.addFlashAttribute("message", "tenant.add.success.message");
    	} else {
    		model.addAttribute("tenantEntity", tenantEntity);
            model.addAttribute("menu", "tenant.new");
	    	redirectAttributes.addFlashAttribute("message", "tenant.add.failed.message");
    	}
    	return "redirect:/web/tenant/list";
    }
    
	@RequestMapping("delete")
	public String deleteTenant(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					tenantRepository.delete(id);
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting tenant", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "tenant.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "tenant.delete.partial.success.message");
			}
		}
		return "redirect:/web/tenant/list";
	}
}
