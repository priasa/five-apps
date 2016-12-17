package id.smarta.five.scheduler.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import id.smarta.five.facebook.service.FacebookService;

public class FacebookPageJob implements Job {
	
	static final Logger LOGGER = LoggerFactory.getLogger(FacebookPageJob.class);
	
	
	@SuppressWarnings("resource")
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ApplicationContext appContext = null;
		try {
			appContext = new ClassPathXmlApplicationContext("context/spring-context.xml");
			FacebookService facebookService = (FacebookService) appContext.getBean("facebookService");
			facebookService.doStream();
		} catch (InterruptedException e) {
			LOGGER.error(e.getMessage());
		} 
	}


}
