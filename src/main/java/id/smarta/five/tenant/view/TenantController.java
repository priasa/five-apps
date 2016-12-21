package id.smarta.five.tenant.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.smarta.five.common.util.CommonUtil;
import id.smarta.five.common.util.DisplayTagUtil;
import id.smarta.five.tenant.dao.TenantRepository;
import id.smarta.five.tenant.entity.Tenant;

/**
 * 
 * @author X230
 *
 */
@Controller
@RequestMapping("/web/tenant")
public class TenantController {

    static final Logger LOGGER = LoggerFactory.getLogger(TenantController.class);

    @Autowired
    TenantRepository tenantRepository;
        
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
    
    @RequestMapping(value={"/","/new", "/clear"}, method=RequestMethod.GET)
    public String newTenant(ModelMap model){
        
        Tenant tenant = new Tenant();
    	
        model.addAttribute("tenant", tenant);
        model.addAttribute("menu", "admin.tenant");
        
        return "tenant/new";
    }
    
    @RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
        Tenant tenantEntity = tenantRepository.findOne(id);
        
        model.addAttribute("tenant", tenantEntity);
        model.addAttribute("menu", "admin.tenant");
        
        return "tenant/view";
    }
    
    @RequestMapping(value="list", method=RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request, @RequestParam(value = "tenantName", required = false) String tenantName) throws ParseException{
        
    	if (tenantName != null) {
    		if (tenantName.isEmpty())
    			tenantName = "";
    	}
    	
    	String wildCardTenantName = CommonUtil.addWildCard(tenantName);
    	
        String id = "tenant";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "name"}, "name");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("tenantName", tenantName);
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<Tenant> returnPage = tenantRepository.findByLikeName(wildCardTenantName, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "admin.tenant");
        
        return "tenant/list";
    }
    
    @RequestMapping(value="save/submit", method=RequestMethod.POST)
    public String submitGuest(ModelMap model, RedirectAttributes redirectAttributes, HttpServletRequest request, @Valid Tenant tenantEntity, BindingResult result){
    	if(result.hasErrors()){
    		model.addAttribute("tenant", tenantEntity);
            model.addAttribute("menu", "admin.tenant");
            return "tenant/new";
        }
    	
    	tenantEntity.setToken(UUID.randomUUID().toString());
    	tenantRepository.save(tenantEntity);
    	redirectAttributes.addFlashAttribute("message", "tenant.add.success.message");
    	
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
