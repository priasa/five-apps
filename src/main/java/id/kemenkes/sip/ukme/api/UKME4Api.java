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
import id.kemenkes.sip.ukme.dao.UKME4Repository;
import id.kemenkes.sip.ukme.entity.UKME4;
import id.kemenkes.sip.ukme.entity.UKME4DTO;


@Controller
@RequestMapping("/rest")
public class UKME4Api {
	
	@Autowired
	UKME4Repository ukme4Repository; 
	
	@RequestMapping(value="/{tokenId}/ukme4/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKME4DTO ukme4dto) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		UKME4 ukme4 = new UKME4();
		PropertyUtils.copyProperties(ukme4, ukme4dto);
		if (!ukme4.getKodePuskesmas().isEmpty() && ukme4.getTahun() != 0 && ukme4.getBulan() != 0
				&& !ukme4.getNamaPuskesmas().isEmpty() && ukme4.getProvinsi() != 0 && ukme4.getKotaKabupaten() != 0) {
			String id = "UKME4-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukme4.setId(id.toUpperCase());
			ukme4.setSubmittedDate(new Date());
			ukme4Repository.save(ukme4);
			response.setMessage(ukme4.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
