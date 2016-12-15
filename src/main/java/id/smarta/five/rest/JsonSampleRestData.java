package id.smarta.five.rest;

import java.io.Serializable;

public class JsonSampleRestData implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
    private String id;
	private String value;
	private String label;
	
	public JsonSampleRestData() {
	    
    }
	
	public JsonSampleRestData(String id, String value, String label) {
	    this.id = id;
	    this.value = value;
	    this.label = label;
    }

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
