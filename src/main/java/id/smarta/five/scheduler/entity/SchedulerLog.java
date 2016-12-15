package id.smarta.five.scheduler.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import id.smarta.five.common.entity.AbstractAuditablePersistable;

@Entity
@Table(name="scheduler_log")
public class SchedulerLog extends AbstractAuditablePersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1453099026207945777L;

	public static final String JOB_NAME= "jobName";
	public static final String FINISH_TIME = "finishTime";
	public static final int MESSAGE_MAX_LENGTH = 1000;
		
	private String jobName;
	private String jobClassName;
	private Date finishTime;
	private JobStatus jobStatus;
	private String message;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobClassName() {
		return jobClassName;
	}
	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public JobStatus getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
