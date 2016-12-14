package id.kemenkes.sip.provinsi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;


public class JsonApiProvinsiResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 975488502970673123L;
	
	private STATUS status;
	private String messageCode = "";
	private String message = "";
	private List<ProvinsiEntity> entities = new ArrayList<ProvinsiEntity>();
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<ProvinsiEntity> getEntities() {
		return entities;
	}
	public void setEntities(List<ProvinsiEntity> entities) {
		this.entities = entities;
	}
	
}
