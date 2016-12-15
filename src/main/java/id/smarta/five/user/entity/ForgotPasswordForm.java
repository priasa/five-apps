package id.smarta.five.user.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class ForgotPasswordForm {
    
    @NotEmpty
    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
