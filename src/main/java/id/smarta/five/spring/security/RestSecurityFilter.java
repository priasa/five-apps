package id.smarta.five.spring.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import id.smarta.five.group.service.GroupService;
import id.smarta.five.security.service.LocalUserDetails;
import id.smarta.five.tenant.dao.TenantRepository;
import id.smarta.five.tenant.entity.Tenant;

/**
 * 
 * @author X230
 *
 */
public class RestSecurityFilter extends GenericFilterBean{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestSecurityFilter.class);
	
	@Autowired
	TenantRepository tenantRepository;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		String token = getTokenIdFromUrl(httpRequest.getContextPath(), httpRequest.getRequestURI());
		LOGGER.info("Token :"+token);
		String url = httpRequest.getRequestURI();
	
		List<GrantedAuthority> gaList = new ArrayList<GrantedAuthority>();
		gaList.add(new SimpleGrantedAuthority(GroupService.REST_PERMISSION));
		
		if(StringUtils.contains(url, "/user/permission")){
			if (token.equals("five-2016")) {
				setAuthenticationToContext("anonymous", gaList);
			}
		} else {
			Tenant tenantEntity = tenantRepository.findByToken(token);
			if (tenantEntity != null) {
				setAuthenticationToContext(tenantEntity.getName(), gaList);
			}
		}
		
		
		chain.doFilter(request, response);
	}
	
	private void setAuthenticationToContext(String username, List<GrantedAuthority> gaList){
		
		
		LocalUserDetails userDetails = new LocalUserDetails(username, username, username, username, gaList);
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userDetails, username, gaList);
		
		SecurityContextHolder.getContext().setAuthentication(result); 
	}
	
	public String getTokenIdFromUrl(String contextPath, String uri) {

		String path = StringUtils.removeStart(uri, contextPath);

		String[] pathArray = StringUtils.split(path, "/");

		if (pathArray != null && pathArray.length > 2) {
			return pathArray[1];
		} else {
			return "";
		}

	}
}
