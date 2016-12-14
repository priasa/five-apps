package id.kemenkes.sip.ukme.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;
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
import id.kemenkes.sip.ukme.dao.UKME1Repository;
import id.kemenkes.sip.ukme.entity.UKME1;
import id.kemenkes.sip.ukme.entity.UKME1DTO;


@Controller
@RequestMapping("/rest")
public class UKME1Api {
	
	@Autowired
	UKME1Repository ukme1Repository; 
	
	@RequestMapping(value="/{tokenId}/ukme1/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKME1DTO ukme1dto) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		UKME1 ukme1 = new UKME1();
		PropertyUtils.copyProperties(ukme1, ukme1dto);
		if (!ukme1.getKodePuskesmas().isEmpty() && ukme1.getTahun() != 0 && ukme1.getBulan() != 0
				&& !ukme1.getNamaPuskesmas().isEmpty() && ukme1.getProvinsi() != 0 && ukme1.getKotaKabupaten() != 0) {
			String id = "UKME1-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukme1.setId(id.toUpperCase());
			ukme1.setSubmittedDate(new Date());
			ukme1Repository.save(ukme1);
			response.setMessage(ukme1.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
