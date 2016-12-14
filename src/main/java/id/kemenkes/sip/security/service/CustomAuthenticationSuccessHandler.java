package id.kemenkes.sip.security.service;

import id.kemenkes.sip.user.entity.User;
import id.kemenkes.sip.user.service.UserService;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	
	static final Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);
	
    @Autowired
    private UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		
		LocalUserDetails userDetails = (LocalUserDetails)authentication.getPrincipal();
		User user = userService.getUserByUsername(userDetails.getUsername());
		
		if(user != null){
			user.setFailLoginCounter(0);
			user.setLastLoginDate(new Date());
			userService.updateUser(user);
		}
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
}
