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
import id.kemenkes.sip.ukme.dao.UKME2Repository;
import id.kemenkes.sip.ukme.entity.UKME2;
import id.kemenkes.sip.ukme.entity.UKME2DTO;


@Controller
@RequestMapping("/rest")
public class UKME2Api {
	
	@Autowired
	UKME2Repository ukme2Repository; 
	
	@RequestMapping(value="/{tokenId}/ukme2/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKME2DTO ukme2dto) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		UKME2 ukme2 = new UKME2();
		PropertyUtils.copyProperties(ukme2, ukme2dto);
		if (!ukme2.getKodePuskesmas().isEmpty() && ukme2.getTahun() != 0 && ukme2.getBulan() != 0
				&& !ukme2.getNamaPuskesmas().isEmpty() && ukme2.getProvinsi() != 0 && ukme2.getKotaKabupaten() != 0) {
			String id = "UKME2-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukme2.setId(id.toUpperCase());
			ukme2.setSubmittedDate(new Date());
			ukme2Repository.save(ukme2);
			response.setMessage(ukme2.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
