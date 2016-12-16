package id.smarta.five.scheduler.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.smarta.five.scheduler.entity.JobStatus;
import id.smarta.five.scheduler.entity.SchedulerLog;

@Repository("schedulerLogRepository")
public interface SchedulerLogRepository extends JpaRepository<SchedulerLog, String>{

	@Query("SELECT md FROM SchedulerLog md WHERE (md.jobName LIKE ?1 or md.jobClassName LIKE ?2) and md.jobStatus = ?3")
    public Page<SchedulerLog> findByJobNameOrJobClassName(String wildCardJobName, String wildCardJobClassName, JobStatus status, Pageable page);
}
