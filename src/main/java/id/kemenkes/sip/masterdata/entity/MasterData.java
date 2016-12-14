package id.kemenkes.sip.masterdata.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import id.kemenkes.sip.common.entity.AbstractAuditablePersistable;

@Entity
@Table(name="master_data")
public class MasterData extends AbstractAuditablePersistable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2849689799140070401L;

	@NotBlank
    @Column(unique=true, nullable=false)
    private String name;
    
    @OneToMany
    private List<MasterDataContent> masterDataContent;
    
    private boolean numberOnly = false;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<MasterDataContent> getMasterDataContent() {
        return masterDataContent;
    }

    public void setMasterDataContent(List<MasterDataContent> masterDataContent) {
        this.masterDataContent = masterDataContent;
    }

	public boolean isNumberOnly() {
		return numberOnly;
	}

	public void setNumberOnly(boolean numberOnly) {
		this.numberOnly = numberOnly;
	}
    
}
