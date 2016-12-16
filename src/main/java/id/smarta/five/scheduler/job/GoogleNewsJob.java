package id.smarta.five.scheduler.job;

import java.security.NoSuchAlgorithmException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import id.smarta.five.gnews.service.GoogleNewsService;

public class GoogleNewsJob implements Job {
	
	static final Logger LOGGER = LoggerFactory.getLogger(GoogleNewsJob.class);
	
	
	@SuppressWarnings("resource")
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ApplicationContext appContext = null;
		try {
			appContext = new ClassPathXmlApplicationContext("context/spring-context.xml");
			GoogleNewsService googleNewsService = (GoogleNewsService) appContext.getBean("googleNewsService");
			googleNewsService.doStream();
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error(e.getMessage());
		} 
	}


}
