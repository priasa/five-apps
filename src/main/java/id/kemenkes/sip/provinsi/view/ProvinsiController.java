package id.kemenkes.sip.provinsi.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;
import id.kemenkes.sip.lt.view.LT1Controller;
import id.kemenkes.sip.provinsi.dao.ProvinsiRepository;
import id.kemenkes.sip.provinsi.entity.JsonApiProvinsiResponse;
import id.kemenkes.sip.provinsi.entity.ProvinsiEntity;

@Controller
@RequestMapping("/web/provinsi")
public class ProvinsiController {

	static final Logger LOGGER = LoggerFactory.getLogger(LT1Controller.class);
	
	@Autowired
	ProvinsiRepository provinsiRepository;
	
	@RequestMapping(value="howto", method=RequestMethod.GET)
    public String howTo(ModelMap model){
		
		JsonApiProvinsiResponse response = new JsonApiProvinsiResponse();
		List<ProvinsiEntity> returnPage = provinsiRepository.findAll();
		response.setEntities(returnPage);
		response.setSize(returnPage.size());
		response.setStatus(STATUS.success);
		
		model.addAttribute("responseJsonFormat", new Gson().toJson(response));
        model.addAttribute("menu", "howto.provinsi");

		return "provinsi/howto";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<ProvinsiEntity> list() {
    	return provinsiRepository.findAll();
    }
}
