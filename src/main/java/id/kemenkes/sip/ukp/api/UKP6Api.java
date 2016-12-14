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
import id.kemenkes.sip.ukp.dao.UKP6Repository;
import id.kemenkes.sip.ukp.entity.UKP6;


@Controller
@RequestMapping("/rest")
public class UKP6Api {
	
	@Autowired
	UKP6Repository ukp6Repository; 
	
	@RequestMapping(value="/{tokenId}/ukp6/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKP6 ukp6) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!ukp6.getKodePuskesmas().isEmpty() && ukp6.getTahun() != 0 && ukp6.getBulan() != 0
				&& !ukp6.getNamaPuskesmas().isEmpty() && ukp6.getProvinsi() != 0 && ukp6.getKotaKabupaten() != 0) {
			String id = "UKP6-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukp6.setId(id.toUpperCase());
			ukp6.setSubmittedDate(new Date());
			ukp6Repository.save(ukp6);
			response.setMessage(ukp6.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
