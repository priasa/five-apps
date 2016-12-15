package id.smarta.five.security.api;

import id.smarta.five.common.api.JsonApiCommonResponse;

public class JsonHashResponse extends JsonApiCommonResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9129015796255230403L;

	private String hashText;

	public String getHashText() {
		return hashText;
	}

	public void setHashText(String hashText) {
		this.hashText = hashText;
	}
	
	
	
}
