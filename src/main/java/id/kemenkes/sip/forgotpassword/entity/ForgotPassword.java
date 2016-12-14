package id.kemenkes.sip.forgotpassword.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import id.kemenkes.sip.common.entity.AbstractAuditablePersistable;

@Entity
@Table(name = "forgot_password")
public class ForgotPassword extends AbstractAuditablePersistable{

	private static final long serialVersionUID = 8745842575075211323L;

	private String email;
	private String username;
	private String confirmationId;
	private Long validUntil;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmationId() {
		return confirmationId;
	}
	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}
	public Long getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(Long validUntil) {
		this.validUntil = validUntil;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
