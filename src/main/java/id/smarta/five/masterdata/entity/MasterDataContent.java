package id.smarta.five.masterdata.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import id.smarta.five.common.entity.AbstractAuditablePersistable;

@Entity
@Table(name="master_data_content")
public class MasterDataContent extends AbstractAuditablePersistable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3141696601876135889L;
	
	@NotBlank
    private String code;
	@NotBlank
    private String fieldValue;
    @ManyToOne
    private MasterData parentId;
    
    @Transient
    private String displayValue;
    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the fieldValue
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * @param fieldValue the fieldValue to set
     */
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    /**
     * @return the parentId
     */
    public MasterData getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(MasterData parentId) {
        this.parentId = parentId;
    }

	public String getDisplayValue() {
		StringBuilder builder = new StringBuilder("");
		if (getCode() != null)
			builder.append(getCode()).append(" ");
		
		if (getFieldValue() != null)
			builder.append(getFieldValue());
		
		return builder.toString();
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
    
    

}
