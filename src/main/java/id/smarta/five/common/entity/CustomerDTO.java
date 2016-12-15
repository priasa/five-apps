package id.smarta.five.common.entity;

import java.io.Serializable;

public class CustomerDTO implements Serializable{

	private static final long serialVersionUID = 1277734925355895040L;
	
	private String fullname;
	private String title;
	private String emailAddress;
	private String phoneNumber;
	private String dateBirthday;
	private String idCard;
	
	public String getFullname() {
		return fullname;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getDateBirthday() {
		return dateBirthday;
	}
	
	public void setDateBirthday(String dateBirthday) {
		this.dateBirthday = dateBirthday;
	}
	
	public String getIdCard() {
		return idCard;
	}
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
}

