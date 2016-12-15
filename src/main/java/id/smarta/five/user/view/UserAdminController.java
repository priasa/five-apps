package id.smarta.five.user.view;

import id.smarta.five.common.util.DisplayTagUtil;
import id.smarta.five.group.entity.Group;
import id.smarta.five.group.service.GroupService;
import id.smarta.five.masterdata.entity.MasterData;
import id.smarta.five.masterdata.entity.MasterDataContent;
import id.smarta.five.masterdata.service.MasterDataService;
import id.smarta.five.user.entity.User;
import id.smarta.five.user.entity.UserDTO;
import id.smarta.five.user.service.UserService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/web/user")
public class UserAdminController {
    
    static final Logger LOGGER = LoggerFactory.getLogger(UserAdminController.class);

    @Autowired
    UserService userService;
    
    @Autowired
    GroupService groupService;
	
    @Autowired
    MasterDataService masterDataService; 
    
    @ModelAttribute("userStatusList")
    public User.STATUS[] getAllUserStatus(){
    	return User.STATUS.values();
    }
    
    @ModelAttribute("allGroupList")
    public List<Group> getAllGroup(){
        return groupService.getAllGroup();
    }
    
    @ModelAttribute("productTypes")
    public List<Group> getProductType(){
        return groupService.getAllGroup();
    }
    
    @RequestMapping(value="new", method=RequestMethod.GET)
    public String newUser(ModelMap model){
        UserDTO form = new UserDTO();
        form.setEdit(false);
        
        model.addAttribute("userDTO", form);
        model.addAttribute("menu", "admin.user");
        
        return "user/new";
    }
    
    @RequestMapping(value="edit/{id}", method=RequestMethod.GET)
    public String editUser(ModelMap model, @PathVariable("id") String id){
        
        User user = userService.getUserById(id);
        
        UserDTO form = new UserDTO();
        form.setEdit(true);
        form.setGroupId(user.getGroup().getId());
        
        try{
            PropertyUtils.copyProperties(form, user);
            form.setPlainTextPassword(user.getPlainTextPassword());
            form.setPassword("");
            form.setGroupId(user.getGroup().getId());
        }
        catch(Exception e){
            LOGGER.error("Error in copying properties to user form", e);
        }
        
        model.addAttribute("userDTO", form);
        model.addAttribute("menu", "admin.user");
        
        List<MasterDataContent> availableServices = new ArrayList<MasterDataContent>();
        MasterData md = masterDataService.findMasterDataByName(MasterDataService.BPJS_PCARE);
        if (md != null) {
            availableServices = masterDataService.getMDContentByParentId(md.getId());
        }
        model.addAttribute("availableServices", availableServices);
        
        return "user/new";
    }
    
    @RequestMapping(value="save/submit", method=RequestMethod.POST)
    public String submitUser(ModelMap model, RedirectAttributes redirectAttributes, HttpServletRequest request, @Valid UserDTO userForm, BindingResult result){
        if(invalidUserForm(model, userForm, result)){
        	List<FieldError> errors = result.getFieldErrors();
        	for (FieldError error: errors) {
        		LOGGER.error("Field :"+error.getField());
        		LOGGER.error("Message :"+error.getDefaultMessage());
        	}
            model.addAttribute("userDTO", userForm);
            return "user/new";
            
        } else {
            try {
                if (StringUtils.isEmpty(userForm.getId())) {
                	userService.addUser(userForm);
                    redirectAttributes.addFlashAttribute("message", "user.add.success.message");
                } else {
                   userService.updateUser(userForm);
                   redirectAttributes.addFlashAttribute("message", "user.update.success.message");
                }
            } catch (DataIntegrityViolationException e) {
                model.addAttribute("userDTO", userForm);
                result.rejectValue("username", "user.error.duplicate.username");
                
                return "user/new";
            } catch(Exception e){
                model.addAttribute("userDTO", userForm);
                model.addAttribute("error", "user.error.general");
                
                return "user/new";
            }
            model.addAttribute("menu", "admin.user");
            
            return "redirect:/web/user/list";
        }
    }
    
    protected boolean invalidUserForm(ModelMap model, UserDTO userForm, BindingResult result){
		User existingUser = userService.getUserByEmail(userForm.getUsername());

    	boolean invalid = false;
        
        if(result.hasErrors()){        	
            invalid = true;
        }
        
        if(!userForm.isEdit()){
        	
        }
        
        if (existingUser != null) {
        	if (!existingUser.getUsername().equals(userForm.getUsername())) {
        		result.rejectValue("email", "Duplicate.userDTO.email", "Duplicate email detected. Please enter another email.");
				invalid = true;
        	}
		}
			
        if (!StringUtils.isEmpty(userForm.getPassword())) {
            if (!StringUtils.equals(userForm.getPassword(), userForm.getRetypePassword())) {
                result.rejectValue("retypePassword", "NotEqual.userDTO.retypePassword");
                invalid = true;
            }
            if (userForm.getPassword().length()<8){
            	result.rejectValue("password", "NotEmpty.userDTO.password","Minimum 8 characters.");
            	invalid = true;
            }
        } else {
        	if (!userForm.isEdit()) {
        		result.rejectValue("password", "NotEmpty.userDTO.password");
        		invalid = true;
        	}
        }
        
        return invalid;
    }
    
    @RequestMapping(value="list", method=RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request, 
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "firstname", required = false) String firstname,
            @RequestParam(value = "lastname", required = false) String lastname,
            @RequestParam(value = "groupId", required = false) String groupId){
        
        String id = "user";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "username", "firstname", "lastname", "modifiedDate"}, "username");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("username", username);
        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);
        model.addAttribute("groupId", groupId);
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<User> returnPage = userService.getUserByUsernameFirstnameLastnameGroup(username, firstname, lastname, groupId, page); 
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "admin.user");
        
        return "user/list";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
     
    @RequestMapping("delete")
    public String deleteUser(ModelMap model, RedirectAttributes redirectAttributes, @RequestParam(value = "id", required = false) String[] ids){
        boolean allDeleted = true;
        if(ids !=  null && ids.length > 0){
            for(String id: ids){
                if(validForDelete(id)){
                    try{
                        userService.deleteUserById(id);
                    }
                    catch(DataIntegrityViolationException e){
                        LOGGER.error("Error in deleting user", e);
                        allDeleted = false;
                    }
                }else{
                    allDeleted = false;
                }
            }

            if(allDeleted){
                redirectAttributes.addFlashAttribute("message", "user.delete.success.message");
            }
            else{
                redirectAttributes.addFlashAttribute("message", "user.delete.partial.success.message");
            }
        }
        return "redirect:/web/user/list";
    }

    protected boolean validForDelete(String id){
        User u = userService.getUserById(id);
        if(StringUtils.equals(u.getUsername(), UserService.ADMIN_USER_NAME)){
            return false;
        }
        else{
            return true;
        }
    }
    
}
