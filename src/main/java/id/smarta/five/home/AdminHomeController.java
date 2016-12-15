package id.smarta.five.home;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class AdminHomeController {
    
    static final Logger LOGGER = LoggerFactory.getLogger(AdminHomeController.class);
    
    @RequestMapping(value={"","/", "/home"})
    public String home(ModelMap model){
      
        return "home";
    }
    
    @RequestMapping("/unauthorized")
    public String unauthorized()    {
        return "unauthorized";
    }
    
    public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }
    
}