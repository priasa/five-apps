package id.kemenkes.sip.masterdata.entity;

import java.io.Serializable;

public class MasterDataContentRestDTO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1914465074926321077L;
		
	private String id;
	private String code;
	private String value;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
