package id.kemenkes.sip.forgotpassword.service;

import id.kemenkes.sip.common.user.util.UserUtils;
import id.kemenkes.sip.forgotpassword.dao.ForgotPasswordRepository;
import id.kemenkes.sip.forgotpassword.entity.ForgotPassword;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService {

	private static final int HOURS_TO_ADD = 1;
	
	@Autowired
	private ForgotPasswordRepository forgotPasswordRepository;
	
	public ForgotPassword findByConfirmationId(String confirmationId) {
		
		return forgotPasswordRepository.findByConfirmationId(confirmationId);
	}
	
	public void save(ForgotPassword forgotPassword) {
		Date currentDate = new Date();
		forgotPassword.setCreatedDate(currentDate);
		forgotPassword.setCreatedBy(UserUtils.getLoginUsername());
		forgotPassword.setModifiedDate(currentDate);
		forgotPassword.setModifiedBy(UserUtils.getLoginUsername());
				
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.HOUR, HOURS_TO_ADD);
		
		forgotPassword.setValidUntil(calendar.getTimeInMillis());
		forgotPasswordRepository.save(forgotPassword);
	}
	
	public ForgotPassword findById(String id) {
		return forgotPasswordRepository.findOne(id);
	}
	
}
