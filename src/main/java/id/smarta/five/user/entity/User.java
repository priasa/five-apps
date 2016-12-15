package id.smarta.five.user.entity;

import id.smarta.five.common.entity.AbstractAuditablePersistable;
import id.smarta.five.group.entity.Group;
import id.smarta.five.group.entity.PermissionDTO;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="user")
public class User extends AbstractAuditablePersistable {
    
    private static final long serialVersionUID = 4980168230977242911L;
    
    public static enum STATUS{
    	INACTIVE(0),
		ACTIVE(1),
    	;
    	
    	private int value;
    	
    	private STATUS(int value) {
			this.value = value;
		}
    	
    	public int getValue() {
			return value;
		}
    }
    
    @Column(name="username", unique=true, nullable=false)
    private String username;
    
    private String password;
    private String firstname;
    private String lastname;
    private String nickname;
    private String address;
    private String plainTextPassword;

	@Column(name="email", unique=true, nullable=true)
    private String email;
    
    private String randomSalt;
    
    @OneToOne
    private Group group;
    
    private Integer status;
    
    private Date lastLoginDate;
    
    @Column(columnDefinition="INT DEFAULT 0")
	private int failLoginCounter;
    
    private String needToActivation = null;
	
    @Transient
    private List<PermissionDTO> permissionList;
            
    public String getFullname(){
    	StringBuilder fullname = new StringBuilder(firstname);
    	fullname.append(" ").append(lastname);
    	return fullname.toString();
    }
   
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRandomSalt() {
		return randomSalt;
	}

	public void setRandomSalt(String randomSalt) {
		this.randomSalt = randomSalt;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<PermissionDTO> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<PermissionDTO> permissionList) {
		this.permissionList = permissionList;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public int getFailLoginCounter() {
		return failLoginCounter;
	}

	public void setFailLoginCounter(int failLoginCounter) {
		this.failLoginCounter = failLoginCounter;
	}

	public String getNeedToActivation() {
		return needToActivation;
	}

	public void setNeedToActivation(String needToActivation) {
		this.needToActivation = needToActivation;
	}

	public String getPlainTextPassword() {
		return plainTextPassword;
	}

	public void setPlainTextPassword(String plainTextPassword) {
		this.plainTextPassword = plainTextPassword;
	}
}
