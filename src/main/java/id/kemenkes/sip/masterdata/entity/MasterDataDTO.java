package id.kemenkes.sip.masterdata.entity;

import java.io.Serializable;
import java.util.List;

public class MasterDataDTO implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -4316799494176913326L;
	
	private String id;
    private String name;
    private List<MasterDataContentRestDTO> content;
    private boolean numberOnly;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MasterDataContentRestDTO> getContent() {
        return content;
    }

    public void setContent(List<MasterDataContentRestDTO> content) {
        this.content = content;
    }

	public boolean isNumberOnly() {
		return numberOnly;
	}

	public void setNumberOnly(boolean numberOnly) {
		this.numberOnly = numberOnly;
	}
}
