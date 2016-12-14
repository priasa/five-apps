package id.kemenkes.sip.masterdata.view;

import id.kemenkes.sip.common.util.DisplayTagUtil;
import id.kemenkes.sip.masterdata.entity.MasterData;
import id.kemenkes.sip.masterdata.entity.MasterDataContent;
import id.kemenkes.sip.masterdata.entity.MasterDataContentDTO;
import id.kemenkes.sip.masterdata.service.MasterDataService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/web/masterdata/content")
public class MasterDataContentManagement {
    
	static final Logger LOGGER = LoggerFactory.getLogger(MasterDataContentManagement.class);
    
    @Autowired
    MasterDataService mdService;
    
    @RequestMapping(value = "new/{parentId}", method = RequestMethod.GET)
    public String newContentData(ModelMap model, HttpSession session, @PathVariable("parentId") String parentId) {
        MasterDataContentDTO contentDTO = new MasterDataContentDTO(); 
        model.addAttribute("masterDataContentDTO", contentDTO);
        model.addAttribute("parentId", parentId);
        model.addAttribute("menu", "masterdata");
        session.setAttribute("editedContent", null);   		        

        return "masterdata/newContent";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value="edit/{parentId}/{code}", method=RequestMethod.GET)
    public String editData(ModelMap model, HttpSession session, HttpServletRequest request, @PathVariable("parentId") String parentId, @PathVariable("code") String code){
        MasterDataContentDTO form = new MasterDataContentDTO();
    	List<MasterDataContent> newContentList = new ArrayList<MasterDataContent>();

    	List<MasterDataContent> contentList = (List<MasterDataContent>) session.getAttribute("contentList");
    	if (contentList != null) {
    		for (MasterDataContent masterDataContent : contentList) {
    			if (masterDataContent.getCode().equals(code)) {
    		        form.setId(masterDataContent.getId());
    		        form.setCode(code);
    		        form.setFieldValue(masterDataContent.getFieldValue());
    		        session.setAttribute("editedContent", masterDataContent);   		        
    			} else {
    				newContentList.add(masterDataContent);
    			}
    		}
    	}
    	
    	session.setAttribute("contentList", newContentList);
    	model.addAttribute("masterDataContentDTO", form);
        model.addAttribute("id", form.getId()); 
        model.addAttribute("parentId", parentId);
        model.addAttribute("menu", "masterdata"); 
        return "masterdata/newContent";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "save/submit/{parentId}", method = RequestMethod.POST)
    public String submitData(ModelMap model, HttpSession session, RedirectAttributes redirectAttributes, HttpServletRequest request, @PathVariable String parentId, @Valid MasterDataContentDTO mdcForm, BindingResult result) {
        model.addAttribute("menu", "masterdata");
        List<MasterDataContent> mdContentPage = (List<MasterDataContent>) session.getAttribute("contentList");
        if (result.hasErrors()) {
        	model.addAttribute("masterDataContentDTO", mdcForm);
            model.addAttribute("id", mdcForm.getId());        
            model.addAttribute("parentId", parentId);
            
            return "masterdata/newContent";
        }

        MasterData md = mdService.getMDById(parentId);
        MasterData form = new MasterData();
        form.setId(md.getId());
        form.setName(md.getName());
        form.setNumberOnly(md.isNumberOnly());
        model.addAttribute("masterData", form);
        
        if (form.isNumberOnly()) {
        	Pattern pattern = Pattern.compile("[0-9]+");
        	Matcher matcher = pattern.matcher(mdcForm.getCode());
        	if (!matcher.matches()) {
        		model.addAttribute("masterDataContentDTO", mdcForm);
                model.addAttribute("id", mdcForm.getId());        
                model.addAttribute("parentId", parentId);
        		result.rejectValue("code", "md.error.numberOnly", "Please input number.");
        		
        		return "masterdata/newContent";
        	}
        }
        
        String idForm = "content";
        String sort = DisplayTagUtil.getListSort(idForm, request, new String[]{"", "orderIndex", "code", "fieldValue", "modifiedDate"}, "fieldValue");
        Boolean desc = DisplayTagUtil.getListDesc(idForm, request, false);
        Integer start = DisplayTagUtil.getListStart(idForm, request, null);

        model.addAttribute("id", "content");

        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc) ? Sort.Direction.DESC : Sort.Direction.ASC, sort);
        
        if (isDuplicateContentCode(mdcForm,  parentId, mdContentPage)) {
        	model.addAttribute("masterDataContentDTO", mdcForm);
            model.addAttribute("id", mdcForm.getId());        
            model.addAttribute("parentId", parentId);
            result.rejectValue("code", "md.error.duplicate.code");

            return "masterdata/newContent";
        }
        
        try {
            if (StringUtils.isEmpty(mdcForm.getId())) {
            	MasterDataContent content = new MasterDataContent();
            	PropertyUtils.copyProperties(content, mdcForm);
            	content.setId(null);
            	content.setParentId(md);
            	mdContentPage.add(content);
                redirectAttributes.addFlashAttribute("message", "md.add.success.message");
            } else {
            	MasterDataContent content = new MasterDataContent();
            	PropertyUtils.copyProperties(content, mdcForm);
            	content.setParentId(md);
            	mdContentPage.add(content);
                redirectAttributes.addFlashAttribute("message", "md.update.success.message");
            }
        } catch (DataIntegrityViolationException e) {
        	model.addAttribute("masterDataContentDTO", mdcForm);
            model.addAttribute("id", mdcForm.getId());        
            model.addAttribute("parentId", parentId);
            result.rejectValue("code", "md.error.duplicate.name");
            return "masterdata/newContent";
            
        } catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

        model.put("rows", new PageImpl<MasterDataContent>(mdContentPage, page, mdContentPage.size()));
        model.put("size", (int) mdContentPage.size());
        session.setAttribute("contentList", mdContentPage);
       
        return "masterdata/new";
    }

	@SuppressWarnings("unchecked")
	@RequestMapping("/delete/{parentId}")
    public String deleteUser(ModelMap model, HttpSession session, RedirectAttributes redirectAttributes, @PathVariable("parentId") String parentId, @RequestParam(value = "contentId", required = false) String[] ids) {
        boolean allDeleted = true;
        if (ids != null && ids.length > 0) {
        	Map<String, String> deletedItems = new HashMap<String, String>();
            for (String code : ids) {
                try {
                	deletedItems.put(code, code);
                } catch (DataIntegrityViolationException e) {
                    LOGGER.error("Error in deleting user", e);
                    allDeleted = false;
                }
            }

            List<MasterDataContent> contents = (List<MasterDataContent>) session.getAttribute("contentList");
            List<MasterDataContent> newContents = new ArrayList<MasterDataContent>();
            for (MasterDataContent content : contents) {
            	if (!deletedItems.containsKey(content.getCode())) {
            		newContents.add(content);
            	}
            }
            session.setAttribute("contentList", newContents);
            
            if (allDeleted) {
                redirectAttributes.addFlashAttribute("message", "md.delete.success.message");
            } else {
                redirectAttributes.addFlashAttribute("message", "md.delete.partial.success.message");
            }
        }
        return "redirect:/web/masterdata/edit/"+parentId;
    }
	
	private boolean isDuplicateContentCode(MasterDataContentDTO contentDTO, String parentId, List<MasterDataContent> mdContentPage) {
		boolean isDuplicate = false;
		MasterDataContent existingContentDTO = mdService.findContentByCode(contentDTO.getCode(), parentId);
		if (existingContentDTO  != null) {
			isDuplicate = true;
			if (!contentDTO.getId().isEmpty()) {
				if (contentDTO.getId().equals(existingContentDTO.getId())) {
					isDuplicate = false;
				}
			}
		}
		
		for (MasterDataContent masterDataContent : mdContentPage) {
			if (masterDataContent.getCode().equals(contentDTO.getCode())) {
				isDuplicate = true;
			}
		}
		return isDuplicate;
	}
}
