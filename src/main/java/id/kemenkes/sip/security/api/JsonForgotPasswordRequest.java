package id.kemenkes.sip.security.api;

import id.kemenkes.sip.common.api.JsonApiCommonRequest;

public class JsonForgotPasswordRequest extends JsonApiCommonRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8471325985321855912L;

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
