package id.kemenkes.sip.icd.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;


public class JsonApiBpjsIcdResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2824929455860865680L;

	
	private STATUS status;
	private String messageCode = "";
	private String message = "";
	private List<BpjsIcdEntity> entities = new ArrayList<BpjsIcdEntity>();
	private int size = 0;
	
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
	public List<BpjsIcdEntity> getEntities() {
		return entities;
	}
	public void setEntities(List<BpjsIcdEntity> entities) {
		this.entities = entities;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
