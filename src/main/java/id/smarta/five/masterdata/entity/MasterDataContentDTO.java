package id.smarta.five.masterdata.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class MasterDataContentDTO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1914465074926321077L;
	
	private String id;
	
	@NotBlank
	private String code;
    @NotBlank
	private String fieldValue;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
