package id.kemenkes.sip.kabupaten.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;
import id.kemenkes.sip.kabupaten.dao.KabupatenRepository;
import id.kemenkes.sip.kabupaten.entity.JsonApiKabupatenResponse;
import id.kemenkes.sip.kabupaten.entity.KabupatenEntity;
import id.kemenkes.sip.lt.view.LT1Controller;

@Controller
@RequestMapping("/web/kabupaten")
public class KabupatenController {

	static final Logger LOGGER = LoggerFactory.getLogger(LT1Controller.class);
	
	@Autowired
	KabupatenRepository kabupatenRepository;
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		JsonApiKabupatenResponse response = new JsonApiKabupatenResponse();
		List<KabupatenEntity> returnPage = kabupatenRepository.findByProvinsi(11);
		response.setEntities(returnPage);
		response.setSize(returnPage.size());
		response.setProvisi(11);
		response.setStatus(STATUS.success);
		
		model.addAttribute("responseJsonFormat", new Gson().toJson(response));
        model.addAttribute("menu", "howto.kabupaten");

		return "kabupaten/howto";
    }
	
	@RequestMapping(value = "/listByProvinsi", method = RequestMethod.GET)
    public @ResponseBody List<KabupatenEntity> jobForDepartment(@RequestParam(value = "provinsi", required = true) int provinsi) {
    	return kabupatenRepository.findByProvinsi(provinsi);
    }
}
