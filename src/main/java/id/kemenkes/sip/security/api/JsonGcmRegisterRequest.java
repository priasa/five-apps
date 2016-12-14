package id.kemenkes.sip.security.api;

import id.kemenkes.sip.common.api.JsonApiCommonRequest;

public class JsonGcmRegisterRequest extends JsonApiCommonRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6049163702883035617L;
	
	private String username;
	private String gcmRegistrationId;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGcmRegistrationId() {
		return gcmRegistrationId;
	}
	public void setGcmRegistrationId(String gcmRegistrationId) {
		this.gcmRegistrationId = gcmRegistrationId;
	}
	
	
	
	

}
