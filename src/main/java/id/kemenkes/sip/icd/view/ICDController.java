package id.kemenkes.sip.icd.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;
import id.kemenkes.sip.icd.dao.BpjsIcdRepository;
import id.kemenkes.sip.icd.entity.BpjsIcdEntity;
import id.kemenkes.sip.icd.entity.JsonApiBpjsIcdResponse;
import id.kemenkes.sip.lt.view.LT1Controller;

@Controller
@RequestMapping("/web/icd")
public class ICDController {

	static final Logger LOGGER = LoggerFactory.getLogger(LT1Controller.class);
	
	@Autowired
	BpjsIcdRepository bpjsIcdRepository;
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		JsonApiBpjsIcdResponse response = new JsonApiBpjsIcdResponse();
		Pageable page = new PageRequest(0, 25);
		Page<BpjsIcdEntity> returnPage = bpjsIcdRepository.findLikeNamaDiagnosa("bon", page);
		response.setEntities(returnPage.getContent());
		response.setSize(returnPage.getNumberOfElements());
		response.setStatus(STATUS.success);
		
		model.addAttribute("responseJsonFormat", new Gson().toJson(response));
        model.addAttribute("menu", "howto.icd");

		return "icd/howto";
    }
}
