package id.smarta.five.scheduler.service;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import id.smarta.five.scheduler.dao.SchedulerDetailRepository;
import id.smarta.five.scheduler.entity.SchedulerDetail;
import id.smarta.five.scheduler.entity.TriggerTypes;

public class SchedulerManager {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerManager.class);

	private Scheduler schedulerFactory;
	private SchedulerJobListener schedulerJobListener;
	private SchedulerDetailRepository schedulerDetailRepository;
	
	private volatile boolean initialized = false;

	public void initManager() {
		if (initialized) {
			return;
		}
		try {
			schedulerFactory.getListenerManager().addJobListener(schedulerJobListener);
			initialized = true;
		} catch (SchedulerException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void startScheduler() throws SchedulerException {
		schedulerFactory.start();
	}

	@SuppressWarnings("unchecked")
	public Date insertNewJob(SchedulerDetail detail) throws Exception {
		
		Date result = null;
		Class<?> jobClass = Class.forName(detail.getJobClassName());
		
		JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) jobClass)
				.withIdentity(detail.getJobName(), detail.getGroupJobName()).build();
		
		if (detail.getTriggerTypes().getCode().equals(TriggerTypes.CRON.getCode())) {
			CronTriggerImpl trigger = new CronTriggerImpl();
			trigger.setCronExpression(detail.getCronExpression());
			trigger.setGroup(detail.getGroupTriggerName());
			trigger.setName(detail.getTriggerName());
			result = schedulerFactory.scheduleJob(jobDetail, trigger);
		} else {
			@SuppressWarnings("deprecation")
			SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl(detail.getTriggerName(), detail.getGroupTriggerName());
			simpleTrigger.setRepeatInterval(detail.getInterval());
			simpleTrigger.setRepeatCount(100);
			result = schedulerFactory.scheduleJob(jobDetail, simpleTrigger);
		}

		return result;
	}

	public boolean deleteJob(SchedulerDetail detail)  {
		boolean result = false;
		try {
			TriggerKey triggerKey = new TriggerKey(detail.getTriggerName(), detail.getGroupTriggerName());
			schedulerFactory.unscheduleJob(triggerKey);
			
			JobKey jobKey = new JobKey(detail.getJobName(), detail.getGroupJobName());
			result = schedulerFactory.deleteJob(jobKey);
			schedulerDetailRepository.delete(detail);
		} catch (SchedulerException e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	public void runManualyJob(SchedulerDetail detail) throws SchedulerException {
		JobKey jobKey = new JobKey(detail.getJobName(), detail.getGroupJobName());
		schedulerFactory.triggerJob(jobKey);
	}

	@SuppressWarnings("unchecked")
	public Date modifyJobAndTrigger(SchedulerDetail schedulerDetail)
			throws SchedulerException, ClassNotFoundException, ParseException {
		Date result = null;
		Class<?> jobClass = null;
		JobDetail detail = null;
	
		TriggerKey triggerKey = new TriggerKey(schedulerDetail.getTriggerName(), schedulerDetail.getGroupTriggerName());
		schedulerFactory.unscheduleJob(triggerKey);

		jobClass = Class.forName(schedulerDetail.getJobClassName());
		detail = JobBuilder.newJob((Class<? extends Job>) jobClass)
				.withIdentity(schedulerDetail.getJobName(), schedulerDetail.getGroupJobName()).build();
		
		if (schedulerDetail.getTriggerTypes().getCode().equals(TriggerTypes.CRON.getCode())) {
			CronTriggerImpl trigger = new CronTriggerImpl();
			trigger.setCronExpression(schedulerDetail.getCronExpression());
			trigger.setGroup(schedulerDetail.getGroupTriggerName());
			trigger.setName(schedulerDetail.getTriggerName());
			result = schedulerFactory.scheduleJob(detail, trigger);
		} else {
			@SuppressWarnings("deprecation")
			SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl(schedulerDetail.getTriggerName(), schedulerDetail.getGroupTriggerName());
			simpleTrigger.setRepeatInterval(schedulerDetail.getInterval());
			simpleTrigger.setRepeatCount(100);
			result = schedulerFactory.scheduleJob(detail, simpleTrigger);
		}
		
		return result;
	}

	public Date changeTriggerValue(SchedulerDetail SchedulerDetail)
			throws SchedulerException, ParseException {
		Date result = null;
		TriggerKey triggerKey = new TriggerKey(SchedulerDetail.getTriggerName(), SchedulerDetail.getGroupTriggerName());

		if (SchedulerDetail.getTriggerTypes().getCode().equals(TriggerTypes.CRON.getCode())) {
			CronTriggerImpl trigger = (CronTriggerImpl) schedulerFactory.getTrigger(triggerKey);			
			trigger.setCronExpression(SchedulerDetail.getCronExpression());
			result = schedulerFactory.rescheduleJob(triggerKey, trigger);
		} else {
			SimpleTriggerImpl simpleTrigger = (SimpleTriggerImpl) schedulerFactory.getTrigger(triggerKey);
			simpleTrigger.setRepeatInterval(SchedulerDetail.getInterval());
			result = schedulerFactory.rescheduleJob(triggerKey, simpleTrigger);
		}
		return result;
	}
	
	public void saveOrUpdateJobDetails(SchedulerDetail schedulerDetail) throws Exception {
		Date nextFireTime = null;
		nextFireTime = insertNewJob(schedulerDetail);

		if (nextFireTime != null) { 
			schedulerDetail.setNextFireTime(nextFireTime);
			modifyJobAndTrigger(schedulerDetail);
			schedulerDetailRepository.save(schedulerDetail);
		}
	}
	
	public void updateJobDetails(SchedulerDetail schedulerDetail) throws Exception {
		modifyJobAndTrigger(schedulerDetail);
		schedulerDetailRepository.save(schedulerDetail);
	}
	
	public void changeTriggerValueOnDetails(SchedulerDetail schedulerDetail) throws SchedulerException, ParseException {
		Date nextFireTime = changeTriggerValue(schedulerDetail);
		if (nextFireTime != null) {
			schedulerDetail.setNextFireTime(nextFireTime);
			schedulerDetailRepository.save(schedulerDetail);
		}
	}

	public void fireNow(SchedulerDetail schedulerDetail) throws SchedulerException {
		runManualyJob(schedulerDetail);
	}

	public Set<SchedulerDetail> getAllJobDetails() {
		return null;
	}

	public Scheduler getSchedulerFactory() {
		return schedulerFactory;
	}

	public void setSchedulerFactory(Scheduler schedulerFactory) {
		this.schedulerFactory = schedulerFactory;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}

	public SchedulerJobListener getSchedulerJobListener() {
		return schedulerJobListener;
	}

	public void setSchedulerJobListener(SchedulerJobListener schedulerJobListener) {
		this.schedulerJobListener = schedulerJobListener;
	}

	public SchedulerDetailRepository getSchedulerDetailRepository() {
		return schedulerDetailRepository;
	}

	public void setSchedulerDetailRepository(SchedulerDetailRepository schedulerDetailRepository) {
		this.schedulerDetailRepository = schedulerDetailRepository;
	}
	
	
}
