package id.kemenkes.sip.user.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO extends UserProfileDTO{
    
    private boolean edit;
    
    @NotEmpty
    private String groupId;
    
    @NotNull
    private Integer status;
    
    public UserDTO() {
		
	}
    
    public UserDTO(String username, String firstName, String lastName, String groupId, String password) {
		setUsername(username);
		setFirstname(firstName);
		setLastname(lastName);
		setGroupId(groupId);
		setPassword(password);
	}
    
    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}
