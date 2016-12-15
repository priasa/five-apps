package id.smarta.five.masterdata.view;

import id.smarta.five.common.util.DisplayTagUtil;
import id.smarta.five.masterdata.entity.MasterData;
import id.smarta.five.masterdata.entity.MasterDataContent;
import id.smarta.five.masterdata.entity.MasterDataContentRestDTO;
import id.smarta.five.masterdata.entity.MasterDataDTO;
import id.smarta.five.masterdata.service.MasterDataService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/web/masterdata")
public class MasterDataManagement {

    static final Logger LOGGER = LoggerFactory.getLogger(MasterDataManagement.class);
    
    @Autowired
    MasterDataService mdService;
    
    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newData(ModelMap model, HttpSession session) {
        MasterData md = new MasterData();
        model.addAttribute("masterData", md);
        model.addAttribute("menu", "masterdata");
        session.setAttribute("contentList", null);
        session.setAttribute("editedContent", null);
        
        return "masterdata/new";
    }

    @SuppressWarnings("unchecked")
	@RequestMapping(value = "edit/{masterDataId}", method = RequestMethod.GET)
    public String editData(ModelMap model, HttpSession session, HttpServletRequest request, @PathVariable("masterDataId") String masterDataId) {
        MasterData md = mdService.getMDById(masterDataId);
    	MasterData form = new MasterData();
        form.setId(md.getId());
        form.setName(md.getName());
        form.setNumberOnly(md.isNumberOnly());
        model.addAttribute("masterData", form);

        String idForm = "content";
        String sort = DisplayTagUtil.getListSort(idForm, request, new String[]{"", "orderIndex", "code", "fieldValue", "modifiedDate"}, "fieldValue");
        Boolean desc = DisplayTagUtil.getListDesc(idForm, request, false);
        Integer start = DisplayTagUtil.getListStart(idForm, request, null);

        model.addAttribute("id", "content");

        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc) ? Sort.Direction.DESC : Sort.Direction.ASC, sort);
        List<MasterDataContent> mdContentPage = new ArrayList<MasterDataContent>();
        if (session.getAttribute("contentList") == null) {
             mdContentPage = mdService.getMDContentParentById(masterDataId);
        } else {
        	mdContentPage = (List<MasterDataContent>) session.getAttribute("contentList");
        }
        
        if (session.getAttribute("editedContent") != null) {
        	MasterDataContent editedContent = (MasterDataContent) session.getAttribute("editedContent");
        	mdContentPage.add(editedContent);
        }
        
        int startIndex = start*DisplayTagUtil.DEFAULT_PAGE_SIZE;
        int endIndex = (startIndex + DisplayTagUtil.DEFAULT_PAGE_SIZE);
        
        if (endIndex > mdContentPage.size()) {
        	endIndex = mdContentPage.size();
        }
        
        model.put("rows", new PageImpl<MasterDataContent>(mdContentPage.subList(startIndex, endIndex), page, mdContentPage.size()));
        model.put("size", (int) mdContentPage.size());
        model.addAttribute("menu", "masterdata");
        session.setAttribute("contentList", mdContentPage);
        
        return "masterdata/new";
    }

    @SuppressWarnings("unchecked")
	@RequestMapping(value = "save/submit", method = RequestMethod.POST)
    public String submitData(ModelMap model, HttpSession session, RedirectAttributes redirectAttributes, HttpServletRequest request, @Valid MasterData mdForm, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("masterData", mdForm);
            model.addAttribute("menu", "masterdata");
            return "masterdata/new";
        } else {
            try {
                if (StringUtils.isEmpty(mdForm.getId())) {
                    mdService.addData(mdForm);
                    redirectAttributes.addFlashAttribute("message", "md.add.success.message");
                } else {
                    mdService.updateData(mdForm);
                    List<MasterDataContent> contents = (List<MasterDataContent>) session.getAttribute("contentList");
                    if (contents != null) {
                    	for (MasterDataContent content : contents) {
                    		content.setParentId(mdForm);
                    		mdService.addContent(content);
                    	}
                    }
                    redirectAttributes.addFlashAttribute("message", "md.update.success.message");
                }
            } catch (DataIntegrityViolationException e) {
                model.addAttribute("masterdata", mdForm);
                model.addAttribute("menu", "masterdata");
                result.rejectValue("name", "md.error.duplicate.name");

                return "masterdata/new";
            }
        }
        session.setAttribute("contentList", null);
        session.setAttribute("editedContent", null);
        
        return "redirect:/web/masterdata/mdList";
    }

    @RequestMapping(value = {"/mdList"}, method = RequestMethod.GET)
    public String masterDataList(ModelMap model, HttpSession session, HttpServletRequest request, @RequestParam(value = "name", required = false) String name) {
        String id = "md";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "name", "modifiedDate"}, "name");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        model.addAttribute("name", name);
        model.addAttribute("id", id);

        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc) ? Sort.Direction.DESC : Sort.Direction.ASC, sort);
        Page<MasterData> mdPage = mdService.getMDByName(name, page);
        model.put("rows", mdPage);
        model.put("size", (int) mdPage.getTotalElements());
        model.addAttribute("menu", "masterdata");
        session.setAttribute("contentList", null);
        session.setAttribute("editedContent", null);
        
        return "masterdata/list";
    }

    @RequestMapping("delete")
    public String deleteUser(ModelMap model, HttpSession session, RedirectAttributes redirectAttributes, @RequestParam(value = "id", required = false) String[] ids) {
        boolean allDeleted = true;
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                try {
                    mdService.deleteMDById(id);
                } catch (DataIntegrityViolationException e) {
                    LOGGER.error("Error in deleting user", e);
                    allDeleted = false;
                }
            }

            if (allDeleted) {
                redirectAttributes.addFlashAttribute("message", "md.delete.success.message");
            } else {
                redirectAttributes.addFlashAttribute("message", "md.delete.partial.success.message");
            }
        }
        session.setAttribute("contentList", null);
        session.setAttribute("editedContent", null);
        
        return "redirect:/web/masterdata/mdList";
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = {"/getMDRest"}, method = RequestMethod.GET, produces={"application/json"})
    public @ResponseBody List<MasterDataDTO> getMDTypeRest(){
        List<MasterDataDTO> mdDtoList = new ArrayList();
        List<MasterData> mdList = mdService.findAll();
        if(mdList!=null){
            for(MasterData md : mdList){
                MasterDataDTO mdDto = new MasterDataDTO();
                mdDto.setId(md.getId());
                mdDto.setName(md.getName());
                List<MasterDataContentRestDTO> mdcDtoList = new ArrayList();
                List<MasterDataContent> mdcList = mdService.getMDContentByParentId(md.getId());
                for(MasterDataContent mdc : mdcList){
                    MasterDataContentRestDTO mdcDto = new MasterDataContentRestDTO();
                    mdcDto.setCode(mdc.getCode());
                    mdcDto.setValue(mdc.getFieldValue());
                    mdcDtoList.add(mdcDto);
                }
                    mdDto.setContent(mdcDtoList);
                    mdDtoList.add(mdDto);
            }
        }
        
        return mdDtoList;
    }
    
}
