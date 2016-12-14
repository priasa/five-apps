package id.kemenkes.sip.home;

import id.kemenkes.sip.common.user.util.UserUtils;
import id.kemenkes.sip.forgotpassword.entity.ForgotPassword;
import id.kemenkes.sip.forgotpassword.service.ForgotPasswordService;
import id.kemenkes.sip.user.entity.ForgotPasswordForm;
import id.kemenkes.sip.user.entity.User;
import id.kemenkes.sip.user.entity.User.STATUS;
import id.kemenkes.sip.user.service.UserService;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    
	static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ForgotPasswordService forgotPasswordService;
   
//	@RequestMapping(value={"/","/home"})
//    public String home(ModelMap model){
//        if (UserUtils.isAnnonymous()) {
//        	return "redirect:/web/login";
//        }
//        
//        return "home";
//    }
    
	@RequestMapping("/")
    public String base(ModelMap model){
        if (UserUtils.isAnnonymous()) {
        	return "redirect:/web/login";
        }
        
        return "redirect:/web/home";
    }
	
	@RequestMapping("/home")
    public String home(ModelMap model){
//        if (UserUtils.isAnnonymous()) {
//        	return "redirect:/web/login";
//        }
        
        return "home";
    }
    
    @RequestMapping("/unauthorized")
    public String unauthorized()    {
        return "unauthorized";
    }
    
    @RequestMapping(value="forgotpassword", method=RequestMethod.GET)
    public String forgotPassword(ModelMap model){
    	ForgotPasswordForm form = new ForgotPasswordForm();
        model.put("forgotPasswordForm", form);
        
    	return "forgotpassword";
    }
    
    @RequestMapping(value="forgotpassword", method=RequestMethod.POST)
    public String submitRequestForgotPassword(ModelMap model, RedirectAttributes redirectAttributes, @Valid ForgotPasswordForm form, BindingResult result, HttpServletRequest httpServletRequest) throws Exception{
    	if(invalidForgotPassword(model, form, result)){
            model.put("forgotPasswordForm", form);
            return "forgotPassword";
        }
    	User user = userService.getUserByEmail(form.getEmail());
        if (user != null) {
        	ForgotPassword forgotPassword = new ForgotPassword();
        	forgotPassword.setEmail(user.getEmail());
        	forgotPassword.setUsername(user.getUsername());
    		forgotPassword.setConfirmationId(UUID.randomUUID().toString());
        	forgotPasswordService.save(forgotPassword);
        	
        	redirectAttributes.addFlashAttribute("message", "forgotpassword.message.success");
        } else {
        	 model.put("forgotPasswordForm", form);
 			 result.rejectValue("email", "forgotpassword.emailnotfound", "Email not found.");
             return "forgotPassword";
        }
    	return "redirect:/web/login";
    }
   	
    @RequestMapping(value = "resetpassword/{confirmationId}", method = RequestMethod.GET)
    public String resetPassword(ModelMap model, RedirectAttributes redirectAttributes, @PathVariable(value = "confirmationId") String confirmationId) {
    	Long currentTime = new Date().getTime();
    	ForgotPassword forgotPassword = forgotPasswordService.findByConfirmationId(confirmationId);
    	if(forgotPassword != null) {
    		if(currentTime < forgotPassword.getValidUntil()) {
    			ResetPasswordForm resetPasswordForm = new ResetPasswordForm();
    			resetPasswordForm.setUsername(forgotPassword.getUsername());
    			
    			model.addAttribute("resetPasswordForm", resetPasswordForm);
    			return "resetpassword";
    		} else {
    			redirectAttributes.addFlashAttribute("message", "forgotpassword.message.expired");
    			return "redirect:/web/login";
    		}
    	} else {
    		redirectAttributes.addFlashAttribute("message", "forgotpassword.message.notfound");
    		return "redirect:/web/login";
    	}
    }
	
	@RequestMapping(value = "activation/{activationId}", method = RequestMethod.GET)
    public String activationUser(ModelMap model, RedirectAttributes redirectAttributes, @PathVariable(value = "activationId") String activationId) {
    	
		User user = userService.getUserById(activationId);
    	if(user != null) {
    		if(user.getStatus() == STATUS.ACTIVE.getValue() && user.getNeedToActivation() == null) {
    			ResetPasswordForm resetPasswordForm = new ResetPasswordForm();
    			resetPasswordForm.setUsername(user.getUsername());
    			
    			model.addAttribute("resetPasswordForm", resetPasswordForm);
    			return "resetpassword";
    		} else {
    			redirectAttributes.addFlashAttribute("message", "user.message.inactive");
    			return "redirect:/web/login";
    		}
    	} else {
    		redirectAttributes.addFlashAttribute("message", "user.message.notfound");
    		return "redirect:/web/login";
    	}
    }
	
	@RequestMapping(value="submitpassword", method=RequestMethod.POST)
    public String submitpassword(ModelMap model, RedirectAttributes redirectAttributes, @Valid ResetPasswordForm resetPasswordForm, BindingResult result){
        
        boolean validForm = validateResetPasswordForm(model, resetPasswordForm, result);
        
        if(validForm){
            try{
                userService.updatePassword(resetPasswordForm);
                redirectAttributes.addFlashAttribute("message", "user.password.updateSuccess");
            }
            catch(Exception e){
                LOGGER.error("Error in updating profile", e);
            }
            
            return "redirect:/web/login";
            
        }else{
        	model.addAttribute("resetPasswordForm", resetPasswordForm);
			return "resetpassword";
        }
    }
    
    protected boolean invalidForgotPassword(ModelMap model, ForgotPasswordForm form, BindingResult result){
        boolean invalid = false;
        if(result.hasErrors()){
            invalid = true;
        }
        
        return invalid;
    }
    
    protected boolean validateResetPasswordForm(ModelMap model, ResetPasswordForm resetPasswordForm, BindingResult result){
        boolean valid = true;
        
        if(result.hasErrors()){
            valid = false;
        }
        
        if(StringUtils.isNotEmpty(resetPasswordForm.getPassword())){
            
        	if (resetPasswordForm.getPassword().length() >= UserService.DEFAULT_PASSWORD_LENGTH) {
	        	if(StringUtils.isEmpty(resetPasswordForm.getRetypePassword())){
	                valid = false;
	                result.rejectValue("retypePassword", "NotEmpty.userForm.retypePassword");
	            }
	            else if(!StringUtils.equals(resetPasswordForm.getPassword(), resetPasswordForm.getRetypePassword())){
	                valid = false;
	                result.rejectValue("retypePassword", "NotEqual.userForm.retypePassword");
	            }
        	} else {
        		valid = false;
                result.rejectValue("password", "MinLength.userForm.password");
        	}
        }
        
        return valid;
    }
    
}