package id.kemenkes.sip.common.user.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtils {
    
	public static String ANNONYMOUS = "annonymous";
	public static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	private static Matcher matcher;
	
    public static String getLoginUsername(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            return auth.getName();
        }else{
            return ANNONYMOUS;
        }
    }
    
    public static boolean isAnnonymous(){
    	return StringUtils.equals(ANNONYMOUS, getLoginUsername());
    }
    
    public static boolean isLoginByEmail(final String email) {
    	matcher = pattern.matcher(email);
		return matcher.matches();
    }
}
