package id.kemenkes.sip.user.view;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.kemenkes.sip.security.service.LocalUserDetails;
import id.kemenkes.sip.user.entity.User;
import id.kemenkes.sip.user.entity.UserProfileDTO;
import id.kemenkes.sip.user.service.UserService;

@Controller
@RequestMapping("/web")
public class UserController {
	
static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    UserService userService;
	
	@RequestMapping(value="profile", method=RequestMethod.GET)
    public String edit(ModelMap model){
    	UserProfileDTO form = new UserProfileDTO();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            
            LocalUserDetails loginUser = (LocalUserDetails)auth.getPrincipal();
            User user = userService.getUserByUsername(loginUser.getUsername());
            if(user != null){
                
                form.setId(user.getId());
                form.setAddress(user.getAddress());
                form.setFirstname(user.getFirstname());
                form.setLastname(user.getLastname());
                form.setNickname(user.getNickname());
                form.setUsername(user.getUsername());
            }
            
        }
        
        model.addAttribute("userProfileDTO", form);
        model.addAttribute("menu", "admin.myprofile");
        return "user/profile";
    }
	
	
    @RequestMapping(value="profile", method=RequestMethod.POST)
    public String edit(ModelMap model, RedirectAttributes redirectAttributes, @Valid UserProfileDTO profileForm, BindingResult result) 
    		throws IOException{
        
        boolean validForm = validateUserForm(model, profileForm, result);
        if(validForm){
            //put success message and update user
            try{
                userService.updateUserProfile(profileForm);
                redirectAttributes.addFlashAttribute("message", "user.profile.updateSuccess");
            }
            catch(Exception e){
                LOGGER.error("Error in updating profile", e);
            }
            
            return "redirect:/web/profile";
            
        }else{
            model.addAttribute("userProfileDTO", profileForm);
            model.addAttribute("menu", "admin.myprofile");
            return "user/profile";
        }
    }
    
    protected boolean validateUserForm(ModelMap model, UserProfileDTO profileForm, BindingResult result) throws IOException{
		User existingUserByEmail = userService.getUserByEmail(profileForm.getUsername());
        boolean valid = true;
        
        if(result.hasErrors()){
            valid = false;
        }
        
        if(StringUtils.isNotEmpty(profileForm.getPassword())){
            
        	if (profileForm.getPassword().length() >= UserService.DEFAULT_PASSWORD_LENGTH) {
	        	if(StringUtils.isEmpty(profileForm.getRetypePassword())){
	                valid = false;
	                result.rejectValue("retypePassword", "NotEmpty.userForm.retypePassword");
	            }
	            else if(!StringUtils.equals(profileForm.getPassword(), profileForm.getRetypePassword())){
	                valid = false;
	                result.rejectValue("retypePassword", "NotEqual.userForm.retypePassword");
	            }
        	} else {
        		valid = false;
                result.rejectValue("password", "MinLength.userForm.password");
        	}
        }
        
        if (existingUserByEmail != null) {
        	if (!existingUserByEmail.getUsername().equals(profileForm.getUsername())) {
        		result.rejectValue("email", "Duplicate.userDTO.email", "Duplicate email detected. Please enter another email.");
				valid = false;
        	}
		}
        
        return valid;
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }

}
