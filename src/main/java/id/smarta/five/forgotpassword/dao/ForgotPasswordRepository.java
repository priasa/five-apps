package id.smarta.five.forgotpassword.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.smarta.five.forgotpassword.entity.ForgotPassword;

@Repository
public interface ForgotPasswordRepository extends JpaRepository<ForgotPassword, String>{
	
	@Query("SELECT p FROM ForgotPassword p WHERE p.confirmationId = ?1")
	public ForgotPassword findByConfirmationId(String confirmationId);
	
}
