package id.smarta.five.user.entity;

import java.io.Serializable;

public class UserDirectory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2247966216818177416L;
	
	private String id;
	private String fullname;
	private String username;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
