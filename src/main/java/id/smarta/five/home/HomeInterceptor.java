package id.kemenkes.sip.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HomeInterceptor extends HandlerInterceptorAdapter{
	
	@Value("${enable.workflow}")
	private String enableWorkflow;
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null) {
            modelAndView.getModelMap().addAttribute("appsEnableworkflow", enableWorkflow);
        }
    }

}
