package id.smarta.five.scheduler.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.smarta.five.scheduler.entity.SchedulerDetail;

@Repository("schedulerDetailRepository")
public interface SchedulerDetailRepository extends JpaRepository<SchedulerDetail, String> {

	@Query("SELECT md FROM SchedulerDetail md WHERE md.jobName LIKE ?1 or md.triggerName LIKE ?2")
    public Page<SchedulerDetail> findByJobNameOrTriggerName(String wildCardJobName, String wildCardTriggerName, Pageable page);

	@Query("SELECT md FROM SchedulerDetail md WHERE md.jobName LIKE ?1 and md.groupJobName LIKE ?2")
    public SchedulerDetail findByJobAndGroupName(String jobName, String triggerName);
	
	@Query("SELECT md FROM SchedulerDetail md WHERE md.triggerName LIKE ?1 and md.groupTriggerName LIKE ?2")
    public SchedulerDetail findByTriggerAndGroupName(String triggerName, String groupName);
	

}
