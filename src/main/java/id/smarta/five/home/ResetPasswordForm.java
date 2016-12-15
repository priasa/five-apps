package id.smarta.five.home;

import java.io.Serializable;

public class ResetPasswordForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3206892743052184576L;
	
	private String username;
	private String password;
	private String retypePassword;
	
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
	public String getRetypePassword() {
		return retypePassword;
	}
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	
	
}

