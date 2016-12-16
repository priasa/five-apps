package id.smarta.five.scheduler.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import id.smarta.five.common.util.CommonUtil;
import id.smarta.five.common.util.DisplayTagUtil;
import id.smarta.five.scheduler.dao.SchedulerDetailRepository;
import id.smarta.five.scheduler.dao.SchedulerLogRepository;
import id.smarta.five.scheduler.entity.JobStatus;
import id.smarta.five.scheduler.entity.SchedulerDetail;
import id.smarta.five.scheduler.entity.SchedulerLog;
import id.smarta.five.scheduler.entity.TriggerTypes;
import id.smarta.five.scheduler.service.SchedulerManager;

/**
 * 
 * @author X230
 *
 */
@Controller
@RequestMapping("/web/scheduler")
public class SchedulerController {

    static final Logger LOGGER = LoggerFactory.getLogger(SchedulerController.class);
    
    @Autowired
    SchedulerDetailRepository schedulerDetailRepository;
    
    @Autowired
    SchedulerLogRepository schedulerLogRepository;
    
    @Autowired
    SchedulerManager schedulerManager;

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
	
	@ModelAttribute("schedulerLogStatus")
    public JobStatus[] getAllUserStatus(){
    	return JobStatus.values();
    }
	
	@RequestMapping(value="/detail/new", method=RequestMethod.GET)
    public String newScheduler(ModelMap model){
        
        SchedulerDetail schedulerDetail = new SchedulerDetail();
        schedulerDetail.setId(null);
        model.addAttribute("schedulerDetail", schedulerDetail);
        model.addAttribute("menu", "scheduler.detail");
        
        return "scheduler/new";
    }
    
    @RequestMapping(value="/detail/edit/{id}", method=RequestMethod.GET)
    public String editScheduler(ModelMap model, @PathVariable("id") String id){
        
    	SchedulerDetail schedulerDetail = schedulerDetailRepository.findOne(id);
        
        model.addAttribute("schedulerDetail", schedulerDetail);
        model.addAttribute("menu", "scheduler.detail");
        
        return "scheduler/new";
    }
    
    @RequestMapping(value="/detail/firenow/{id}", method=RequestMethod.POST)
    public String fireNowScheduler(ModelMap model,  RedirectAttributes redirectAttributes, @PathVariable("id") String id){
    	SchedulerDetail schedulerDetail = schedulerDetailRepository.findOne(id);
        try {
			schedulerManager.fireNow(schedulerDetail);
			redirectAttributes.addFlashAttribute("message", "scheduler.detail.firenow.success.message");
		} catch (SchedulerException e) {
			LOGGER.error(e.getMessage());
			redirectAttributes.addFlashAttribute("error", "scheduler.detail.firenow.failed.message");
		}
    	
        return "redirect:/web/scheduler/detail/list";
    }
	
	@RequestMapping(value="/detail/list", method=RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request, @RequestParam(value = "jobOrTriggerName", required = false) String jobOrTriggerName) throws ParseException{
        
    	if (jobOrTriggerName != null) {
    		if (jobOrTriggerName.isEmpty())
    			jobOrTriggerName = "";
    	}
    	
    	String wildCardJobName = CommonUtil.addWildCard(jobOrTriggerName);
    	String wildCardTriggerName = CommonUtil.addWildCard(jobOrTriggerName);
    	
        String id = "schedulerDetail";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "jobName","triggerName"}, "jobName");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("jobOrTriggerName", jobOrTriggerName);
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<SchedulerDetail> returnPage = schedulerDetailRepository.findByJobNameOrTriggerName(wildCardJobName, wildCardTriggerName, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "scheduler.detail");
        
        return "scheduler/list";
    }
	
	@RequestMapping(value="/log/list", method=RequestMethod.GET)
    public String log(ModelMap model, HttpServletRequest request, @RequestParam(value = "jobOrClassName", required = false) String jobOrClassName, 
    		@RequestParam(value = "logStatus", required = false) String logStatus) throws ParseException{
        
    	if (jobOrClassName != null) {
    		if (jobOrClassName.isEmpty())
    			jobOrClassName = "";
    	}
    	 
    	if (logStatus != null) {
    		if (logStatus.isEmpty())
    			logStatus = JobStatus.SUCCESS.getCode();
    	}
    	
    	String wildCardJobName = CommonUtil.addWildCard(jobOrClassName);
    	String wildCardJobClassName = CommonUtil.addWildCard(jobOrClassName);

        String id = "schedulerLog";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "jobName","jobClassName"}, "jobName");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("jobOrClassName", jobOrClassName);
        model.addAttribute("logStatus", logStatus);

        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        JobStatus jobStatus = JobStatus.SUCCESS.getCode().equalsIgnoreCase(logStatus)?JobStatus.SUCCESS:JobStatus.FAIL;
        
        Page<SchedulerLog> returnPage = schedulerLogRepository.findByJobNameOrJobClassName(wildCardJobName, wildCardJobClassName, jobStatus, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "scheduler.log");
        
        return "scheduler/log";
    }
	
	@RequestMapping(value="/detail/save", method=RequestMethod.POST)
    public String submitScheduler(ModelMap model, RedirectAttributes redirectAttributes, HttpServletRequest request, @Valid SchedulerDetail schedulerDetail, BindingResult result) throws Exception{
		if(result.hasErrors()){
    		model.addAttribute("schedulerDetail", schedulerDetail);
            model.addAttribute("menu", "scheduler.detail");
            return "scheduler/new";
        }
    	
    	boolean isValid = true;
    	if (schedulerDetail.getId().isEmpty()) {
    		SchedulerDetail currentByJob = schedulerDetailRepository.findByJobAndGroupName(schedulerDetail.getJobName(), schedulerDetail.getGroupJobName());
        	if (currentByJob != null) {
        		result.rejectValue("jobName", "scheduler.detail.error.jobOrGroupExist");
        		result.rejectValue("groupJobName", "scheduler.detail.error.jobOrGroupExist");
        		isValid = false;
        	}
    		
    		SchedulerDetail currentByTrigger = schedulerDetailRepository.findByTriggerAndGroupName(schedulerDetail.getTriggerName(), schedulerDetail.getGroupTriggerName());
            if (currentByTrigger != null) {
            	result.rejectValue("jobName", "scheduler.detail.error.jobOrGroupExist");
        		result.rejectValue("groupJobName", "scheduler.detail.error.jobOrGroupExist");
        		isValid = false;
            } 
            
            if (!isValid) {
            	model.addAttribute("schedulerDetail", schedulerDetail);
                model.addAttribute("menu", "scheduler.detail");
                
                return "scheduler/new";
            } else {
            	schedulerDetail.setTriggerTypes(TriggerTypes.CRON);
            	schedulerManager.saveOrUpdateJobDetails(schedulerDetail);
        	    redirectAttributes.addFlashAttribute("message", "scheduler.detail.add.success.message");
            }
    	} else {
        	SchedulerDetail detail = schedulerDetailRepository.findOne(schedulerDetail.getId());
        	detail.setCronExpression(schedulerDetail.getCronExpression());
        	detail.setJobClassName(schedulerDetail.getJobClassName());
        	schedulerManager.updateJobDetails(detail);
           
        }
    	
    	return "redirect:/web/scheduler/detail/list";
    }
	
	@RequestMapping("/detail/delete")
	public String deleteScheduler(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					SchedulerDetail detail = schedulerDetailRepository.findOne(id);
					schedulerManager.deleteJob(detail);
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting scheduler", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "scheduler.detail.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("message", "scheduler.detail.partial.success.message");
			}
		}
		return "redirect:/web/scheduler/detail/list";
	}
}
