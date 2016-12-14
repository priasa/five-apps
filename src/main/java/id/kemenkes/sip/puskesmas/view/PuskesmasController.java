package id.kemenkes.sip.puskesmas.view;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import id.kemenkes.sip.puskesmas.dao.PuskesmasRepository;
import id.kemenkes.sip.puskesmas.entity.PuskesmasEntity;

@Controller
@RequestMapping("/web/puskesmas")
public class PuskesmasController {

	static final Logger LOGGER = LoggerFactory.getLogger(PuskesmasController.class);
	
	@Autowired
	PuskesmasRepository puskesmasRepository;
	
	@RequestMapping(value = "/listByFilter", method = RequestMethod.GET)
    public @ResponseBody List<PuskesmasEntity> list(@RequestParam(value = "provinsi", required = true) int provinsi,
    		@RequestParam(value = "kabupaten", required = true) int kabupaten) {
    	return puskesmasRepository.findByProvinsiAndKabupaten(provinsi, kabupaten);
    }
}
