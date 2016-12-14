package id.kemenkes.sip.common.api;

import java.io.Serializable;


public class JsonApiCommonResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2824929455860865680L;
	
	public static enum STATUS{
		success,
		fail,
		error,
		;
	}
	
	private STATUS status;
	private String messageCode = "";
	private String message = "";
	
	public STATUS getStatus() {
		return status;
	}
	public void setStatus(STATUS status) {
		this.status = status;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
