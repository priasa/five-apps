package id.kemenkes.sip.security.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import id.kemenkes.sip.common.user.util.UserUtils;

@Controller
public class SecurityController {
    
    static final Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

    @RequestMapping("/web/login")
    public String login(){
    	if(UserUtils.isAnnonymous()){
    		return "login";
    	}
    	else{
    		return "redirect:/web/home";
    	}
    }

}
