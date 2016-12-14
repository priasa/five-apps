package id.kemenkes.sip.common.api;

import java.io.Serializable;

public class JsonApiCommonRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2656839470369574193L;
	
	private String apiVersion;

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	
	
}
