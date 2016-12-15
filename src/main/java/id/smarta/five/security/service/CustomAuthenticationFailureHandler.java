package id.smarta.five.security.service;

import id.smarta.five.user.entity.User;
import id.smarta.five.user.service.UserService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	
	@Autowired
    private UserService userService;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException,
	        ServletException {
	    
		String username = request.getParameter("j_username");
		User user = userService.getUserByUsername(username);
		
		if(user != null){
			user.setFailLoginCounter(user.getFailLoginCounter()+1);
			userService.updateUser(user);
		}
		
	    super.onAuthenticationFailure(request, response, exception);
	}

}
