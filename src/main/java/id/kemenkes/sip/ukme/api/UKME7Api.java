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
import id.kemenkes.sip.ukme.dao.UKME7Repository;
import id.kemenkes.sip.ukme.entity.UKME7;
import id.kemenkes.sip.ukme.entity.UKME7DTO;


@Controller
@RequestMapping("/rest")
public class UKME7Api {
	
	@Autowired
	UKME7Repository ukme7Repository; 
	
	@RequestMapping(value="/{tokenId}/ukme7/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKME7DTO ukme7dto) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		UKME7 ukme7 = new UKME7();
		PropertyUtils.copyProperties(ukme7, ukme7dto);
		if (!ukme7.getKodePuskesmas().isEmpty() && ukme7.getTahun() != 0 && ukme7.getBulan() != 0
				&& !ukme7.getNamaPuskesmas().isEmpty() && ukme7.getProvinsi() != 0 && ukme7.getKotaKabupaten() != 0) {
			String id = "UKME7-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukme7.setId(id.toUpperCase());
			ukme7.setSubmittedDate(new Date());
			ukme7Repository.save(ukme7);
			response.setMessage(ukme7.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
