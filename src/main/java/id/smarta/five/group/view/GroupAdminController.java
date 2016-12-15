package id.smarta.five.group.view;

import id.smarta.five.common.util.DisplayTagUtil;
import id.smarta.five.group.entity.Group;
import id.smarta.five.group.entity.GroupDTO;
import id.smarta.five.group.entity.GroupPermission;
import id.smarta.five.group.service.GroupService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Maps;

@Controller
@RequestMapping("/web/group")
public class GroupAdminController {
    
    static final Logger LOGGER = LoggerFactory.getLogger(GroupAdminController.class);
    
    @Autowired
    GroupService groupService;
    
    @RequestMapping(value="new", method=RequestMethod.GET)
    public String newGroup(ModelMap model){
        
        GroupDTO form = new GroupDTO();
        model.addAttribute("groupDTO", form);
        model.addAttribute("menu", "admin.group");
        
        return "group/new";
    }
    
    @RequestMapping(value="edit/{id}", method=RequestMethod.GET)
    public String editGroup(ModelMap model, @PathVariable("id") String id){
        
        Group group = groupService.getGroupById(id);
        
        GroupDTO form = new GroupDTO();
        form.setId(group.getId());
        form.setName(group.getName());
        
        if(group.getName().equals(GroupService.ADMIN_GROUP_NAME)){
            form.setDefaultAdminGroup(true);
        }
        
        Map<String, Boolean> existingPermissionMap = Maps.newHashMap();
        for(GroupPermission permission: group.getPermissionList()){
            existingPermissionMap.put(permission.getPermissionKey(), true);
        }
        
        model.addAttribute("groupDTO", form);
        model.addAttribute("existingRoleMap", existingPermissionMap);
        model.addAttribute("menu", "admin.group");
        
        return "group/new";
    }
    
    @RequestMapping(value="save/submit", method=RequestMethod.POST)
    public String submitGroup(ModelMap model, RedirectAttributes redirectAttributes, HttpServletRequest request, @Valid GroupDTO groupForm, BindingResult result){
        
        String[] permissionArray = request.getParameterValues("permission");
        groupForm.setPermissionArray(permissionArray);
        
        Map<String, Boolean> existingPermissionMap = Maps.newHashMap();
        if(permissionArray != null){
            for(String permission: permissionArray){
                existingPermissionMap.put(permission, true);
            }
        }
        
        if(invalidGroupForm(model, groupForm, result)){
            model.addAttribute("groupDTO", groupForm);
            model.addAttribute("existingRoleMap", existingPermissionMap);
            return "group/new";
        }
        else{
            
            try{
                if(StringUtils.isEmpty(groupForm.getId())){
                	groupService.addGroup(groupForm);
                    redirectAttributes.addFlashAttribute("message", "group.add.success.message");
                }else{
                	groupService.updateGroup(groupForm);
                    redirectAttributes.addFlashAttribute("message", "group.update.success.message");
                }
            }
            catch(DataIntegrityViolationException e){
                model.addAttribute("groupDTO", groupForm);
                model.addAttribute("existingRoleMap", existingPermissionMap);
                
                result.rejectValue("name", "group.error.duplicate.name");
                
                return "group/new";
            }
            
            return "redirect:/web/group/list";
        }
        
    }
    
    protected boolean invalidGroupForm(ModelMap model, GroupDTO form, BindingResult result){
        boolean invalid = false;
        
        if(result.hasErrors()){
            invalid = true;
        }
        
        if(form.getPermissionArray() == null){
            invalid = true;
            model.addAttribute("error", "NotEmpty.groupForm.permission");
        }
        
        return invalid;
    }
    
    @ModelAttribute("roleMap")
    public Map<String, List<String>> getAllRoleMap(){
        return groupService.getAllPermissionMap();
    }
    
    @RequestMapping(value="list", method=RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request, @RequestParam(value = "name", required = false) String name){
        
        String id = "group";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "name", "modifiedDate"}, "name");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("name", name);
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<Group> groupPage = groupService.getGroupByName(name, page);
        
        model.put("rows", groupPage);
        model.put("size", (int)groupPage.getTotalElements());
        model.addAttribute("menu", "admin.group");
        
        return "group/list";
    }
    
    @RequestMapping("delete")
    public String deleteGroup(ModelMap model, RedirectAttributes redirectAttributes, @RequestParam(value = "id", required = false) String[] ids){
        boolean allDeleted = true;
        if(ids !=  null && ids.length > 0){
            for(String id: ids){
                if(validForDelete(id)){
                    try{
                        groupService.deleteGroupById(id);
                    }
                    catch(DataIntegrityViolationException e){
                        LOGGER.error("Error in deleting group", e);
                        allDeleted = false;
                    }
                }else{
                    allDeleted = false;
                }
            }
            
            if(allDeleted){
                redirectAttributes.addFlashAttribute("message", "group.delete.success.message");
            }
            else{
                redirectAttributes.addFlashAttribute("message", "group.delete.partial.success.message");
            }
        }
        return "redirect:/web/group/list";
    }
    
    protected boolean validForDelete(String id){
        Group group = groupService.getGroupById(id);
        if(StringUtils.equals(group.getName(), GroupService.ADMIN_GROUP_NAME)){
            return false;
        }
        else{
            return true;
        }
    }

}
