package id.smarta.five.scheduler.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import id.smarta.five.common.entity.AbstractAuditablePersistable;

/**
 * 
 * @author X230
 *
 */
@Entity
@Table(name="scheduler_detail")
public class SchedulerDetail extends AbstractAuditablePersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4883996781992255018L;
	
	@NotEmpty
	private String jobName;
	@NotEmpty
	private String groupJobName;
	@NotEmpty
	private String triggerName;
	@NotEmpty
	private String groupTriggerName;
	@NotEmpty
	private String jobClassName;
	@NotEmpty
	private String cronExpression;
	
	@Column(name="jobInterval")
	private Long interval;
	
	private TriggerTypes triggerTypes;
	
	private Date nextFireTime;
	
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getGroupJobName() {
		return groupJobName;
	}
	public void setGroupJobName(String groupJobName) {
		this.groupJobName = groupJobName;
	}
	public String getTriggerName() {
		return triggerName;
	}
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}
	public String getGroupTriggerName() {
		return groupTriggerName;
	}
	public void setGroupTriggerName(String groupTriggerName) {
		this.groupTriggerName = groupTriggerName;
	}
	public String getJobClassName() {
		return jobClassName;
	}
	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public Long getInterval() {
		return interval;
	}
	public void setInterval(Long interval) {
		this.interval = interval;
	}
	public TriggerTypes getTriggerTypes() {
		return triggerTypes;
	}
	public void setTriggerTypes(TriggerTypes triggerTypes) {
		this.triggerTypes = triggerTypes;
	}
	public Date getNextFireTime() {
		return nextFireTime;
	}
	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}
	@Override
	public String toString() {
		return "SchedulerDetail [jobName=" + jobName + ", groupJobName=" + groupJobName + ", triggerName=" + triggerName
				+ ", groupTriggerName=" + groupTriggerName + ", jobClassName=" + jobClassName + ", cronExpression="
				+ cronExpression + ", interval=" + interval + ", triggerTypes=" + triggerTypes + ", nextFireTime="
				+ nextFireTime + "]";
	}
	
	
}
