package id.kemenkes.sip.security.api;

import id.kemenkes.sip.common.api.JsonApiCommonRequest;

public class JsonLoginRequest extends JsonApiCommonRequest{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2890776789038794750L;
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
