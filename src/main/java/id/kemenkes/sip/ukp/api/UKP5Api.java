package id.kemenkes.sip.ukp.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import id.kemenkes.sip.common.api.JsonApiCommonResponse;
import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;
import id.kemenkes.sip.ukp.dao.UKP5Repository;
import id.kemenkes.sip.ukp.entity.UKP5;


@Controller
@RequestMapping("/rest")
public class UKP5Api {
	
	@Autowired
	UKP5Repository ukp5Repository; 
	
	@RequestMapping(value="/{tokenId}/ukp5/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKP5 ukp5) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!ukp5.getKodePuskesmas().isEmpty() && ukp5.getTahun() != 0 && ukp5.getBulan() != 0
				&& !ukp5.getNamaPuskesmas().isEmpty() && ukp5.getProvinsi() != 0 && ukp5.getKotaKabupaten() != 0) {
			String id = "UKP5-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukp5.setId(id.toUpperCase());
			ukp5.setSubmittedDate(new Date());
			ukp5Repository.save(ukp5);
			response.setMessage(ukp5.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
