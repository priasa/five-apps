package id.smarta.five.twitter.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import id.smarta.five.twitter.dao.TwitterStreamRepository;
import id.smarta.five.twitter.entity.TwitterStream;

/**
 * 
 * @author X230
 *
 */
@Controller
@RequestMapping("/web/twitter/stream")
public class TwitterStreamController {

    static final Logger LOGGER = LoggerFactory.getLogger(TwitterStreamController.class);

    @Autowired
    TwitterStreamRepository twitterStreamRepository;
        
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }
    
    
    @ModelAttribute("twitterStreamStatusList")
    public List<String> getTwitterStreamStatus(){
    	List<String> result = new ArrayList<String>();
    	result.add(TwitterStream.STARTED);
    	result.add(TwitterStream.RUNNING);
    	result.add(TwitterStream.NEED_TO_RESTART);
        return result;
    }
    
    @RequestMapping(value={"/","/new", "/clear"}, method=RequestMethod.GET)
    public String newTenant(ModelMap model){
        
        TwitterStream twitterStream = new TwitterStream();
    	
        model.addAttribute("twitterStream", twitterStream);
        model.addAttribute("menu", "twitter.stream");
        
        return "twitter/stream/new";
    }
    
    @RequestMapping(value="view/{id}", method=RequestMethod.GET)
    public String viewTenant(ModelMap model, @PathVariable("id") String id){
        
    	 TwitterStream twitterStream = twitterStreamRepository.findOne(id);
        
        model.addAttribute("twitterStream", twitterStream);
        model.addAttribute("menu", "twitter.stream");
        
        return "twitter/stream/view";
    }
    
    @RequestMapping(value="list", method=RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request, @RequestParam(value = "streamCode", required = false) String streamCode) throws ParseException{
        
    	if (streamCode != null) {
    		if (streamCode.isEmpty())
    			streamCode = "";
    	}
    	
    	String wildCardTenantName = CommonUtil.addWildCard(streamCode);
    	
        String id = "twitterStream";
        String sort = DisplayTagUtil.getListSort(id, request, new String[]{"", "code"}, "code");
        Boolean desc = DisplayTagUtil.getListDesc(id, request, false);
        Integer start = DisplayTagUtil.getListStart(id, request, null);
        
        model.addAttribute("streamCode", streamCode);
        model.addAttribute("id", id);
        
        Pageable page = new PageRequest(start, DisplayTagUtil.DEFAULT_PAGE_SIZE, (desc != null && desc)?Sort.Direction.DESC:Sort.Direction.ASC, sort);
        
        Page<TwitterStream> returnPage = twitterStreamRepository.findByLikeCode(wildCardTenantName, page);
        
        model.put("rows", returnPage);
        model.put("size", (int)returnPage.getTotalElements());
        model.addAttribute("menu", "twitter.stream");
        
        return "twitter/stream/list";
    }
    
    @RequestMapping(value="save/submit", method=RequestMethod.POST)
    public String submitGuest(ModelMap model, RedirectAttributes redirectAttributes, HttpServletRequest request, @Valid TwitterStream twitterStream, BindingResult result){
    	boolean isValid = true;
    	if(result.hasErrors()){
    		isValid = false;
    		
        }
    	
    	TwitterStream currentTwitterStream = twitterStreamRepository.findByCode(twitterStream.getCode());
    	if (currentTwitterStream != null) {
    		result.rejectValue("code", "twitter.stream.code.exist");
    		isValid = false;
    	}
    	
    	if (!isValid) {
    		model.addAttribute("twitterStream", twitterStream);
            model.addAttribute("menu", "twitter.stream");
            
            return "twitter/stream/new";
    	}
    	
    	twitterStreamRepository.save(twitterStream);
    	redirectAttributes.addFlashAttribute("message", "twitter.stream.add.success.message");
    	
    	return "redirect:/web/twitter/stream/list";
    }
    
	@RequestMapping("delete")
	public String deleteTwitterStream(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					twitterStreamRepository.delete(id);
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting tenant", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "twitter.stream.delete.success.message");
			} else {
				redirectAttributes.addFlashAttribute("warning", "twitter.stream.delete.partial.success.message");
			}
		}
		return "redirect:/web/twitter/stream/list";
	}
	
	@RequestMapping("restart")
	public String restartTwitterStream(ModelMap model, RedirectAttributes redirectAttributes,
			@RequestParam(value = "id", required = false) String[] ids) {
		boolean allDeleted = true;
		if (ids != null && ids.length > 0) {
			for (String id : ids) {
				try {
					TwitterStream ts = twitterStreamRepository.findOne(id);
					ts.setStatus(TwitterStream.NEED_TO_RESTART);
					twitterStreamRepository.save(ts);
				} catch (DataIntegrityViolationException e) {
					LOGGER.error("Error in deleting tenant", e);
					allDeleted = false;
				}

			}

			if (allDeleted) {
				redirectAttributes.addFlashAttribute("message", "twitter.stream.restart.success.message");
			} else {
				redirectAttributes.addFlashAttribute("warning", "twitter.stream.restart.partial.success.message");
			}
		}
		return "redirect:/web/twitter/stream/list";
	}
}
