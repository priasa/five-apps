package id.kemenkes.sip.kabupaten.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;


public class JsonApiKabupatenResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 975488502970673123L;
	
	private STATUS status;
	private String messageCode = "";
	private String message = "";
	private List<KabupatenEntity> entities = new ArrayList<KabupatenEntity>();
	private Integer provisi;
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
	public List<KabupatenEntity> getEntities() {
		return entities;
	}
	public void setEntities(List<KabupatenEntity> entities) {
		this.entities = entities;
	}
	public Integer getProvisi() {
		return provisi;
	}
	public void setProvisi(Integer provisi) {
		this.provisi = provisi;
	}
	
}
