package id.smarta.five.scheduler.service;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import id.smarta.five.scheduler.dao.SchedulerLogRepository;
import id.smarta.five.scheduler.entity.JobStatus;
import id.smarta.five.scheduler.entity.SchedulerLog;

public class SchedulerJobListener implements JobListener {

	private static final Logger logger = LoggerFactory.getLogger(SchedulerJobListener.class);

	public static final String LISTENER_NAME = "schedulerJobListenerName";

	@Autowired
	private SchedulerLogRepository schedulerLogRepository;

	public String getName() {
		return LISTENER_NAME;
	}

	public void jobToBeExecuted(JobExecutionContext context) {
		String jobName = context.getJobDetail().getKey().toString();
		logger.info("jobToBeExecuted");
		logger.info("Job : " + jobName + " is going to start...");
	}

	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		logger.info("jobWasExecuted");

		Date finishTime = new Date();
		String jobName = context.getJobDetail().getKey().toString();
		String jobClassName = context.getJobDetail().getJobClass().getName();
		logger.info("Job : " + jobName + " is finished...");

		StringBuilder sb = new StringBuilder(
				"Job : " + jobName + (jobException == null ? " is success" : " is fail") + " at " + finishTime);

		JobStatus status;
		if (jobException == null) {
			status = JobStatus.SUCCESS;
		} else {
			status = JobStatus.FAIL;
			if (jobException.getCause() != null) {
				sb.append(" -> " + jobException.getCause().getMessage() + "\n");

				StackTraceElement[] st = jobException.getCause().getStackTrace();
				for (StackTraceElement element : st) {
					sb.append("\n" + element.getFileName() + " : " + element.getClassName() + "."
							+ element.getMethodName() + "." + element.getLineNumber());
				}
			}
		}

		String message = sb.toString();
		if (message.length() > SchedulerLog.MESSAGE_MAX_LENGTH) {
			message = message.substring(0, SchedulerLog.MESSAGE_MAX_LENGTH);
		}
		SchedulerLog schedulerLog = new SchedulerLog();
		schedulerLog.setFinishTime(finishTime);
		schedulerLog.setJobClassName(jobClassName);
		schedulerLog.setJobStatus(status);
		schedulerLog.setJobName(jobName);
		schedulerLog.setMessage(message);
		schedulerLogRepository.save(schedulerLog);

	}

	public void jobExecutionVetoed(JobExecutionContext context) {
		logger.info("");
	}

	public SchedulerLogRepository getSchedulerLogRepository() {
		return schedulerLogRepository;
	}

	public void setSchedulerLogRepository(SchedulerLogRepository schedulerLogRepository) {
		this.schedulerLogRepository = schedulerLogRepository;
	}

}
