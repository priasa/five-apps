package id.smarta.five.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

import id.smarta.five.common.user.util.UserUtils;

@MappedSuperclass
public class AbstractAuditablePersistable extends AbstractPersistable{

	private static final long serialVersionUID = -7247763130255953923L;
	
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;
    
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;
    
    @Column(name = "modified_by")
    private String modifiedBy;
	
    @PrePersist
    public void onPrePersist(){
        createdDate = new Date();
        modifiedDate = new Date();
        createdBy = UserUtils.getLoginUsername();
        modifiedBy = UserUtils.getLoginUsername();
    }
    
    @PreUpdate
    public void onPreUpdate(){
    	modifiedDate = new Date();
    	modifiedBy = UserUtils.getLoginUsername();
    }

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
    
}
