package id.smarta.five.security.api;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import id.smarta.five.common.api.JsonApiCommonResponse;
import id.smarta.five.security.service.SecurityManager;
import id.smarta.five.user.entity.User;

@Controller
@RequestMapping("/rest/")
public class SecurityApiController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(SecurityApiController.class);
    
	@Autowired
    private SecurityManager securityManager;
	
	
	@RequestMapping(value="/{tokenId}/v1/user/permission", method=RequestMethod.POST)
    @ResponseBody
    public JsonLoginResponse login(ModelMap model, @PathVariable("tokenId") String tokenId,
            @RequestBody JsonLoginRequest loginRequest){
		JsonLoginResponse  response = new JsonLoginResponse();
        response.setStatus(JsonApiCommonResponse.STATUS.success);
        
        String trimUsername = StringUtils.trim(loginRequest.getUsername());
        try{
        	User user = securityManager.authenticateRestUser(trimUsername, loginRequest.getPassword());
        	if (user != null) {
        		
        	}
        } catch(BadCredentialsException e){
            LOGGER.error("", e);
            response.setStatus(JsonApiCommonResponse.STATUS.fail);
            response.setMessageCode("login.invalid");
            response.setMessage(e.getMessage());
        }
        catch(Exception e){
            LOGGER.error("", e);
            response.setStatus(JsonApiCommonResponse.STATUS.fail);
            response.setMessageCode("login.error");
            response.setMessage(e.getMessage());
        }
        return response;
	}
	
	
}
