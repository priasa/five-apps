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
import id.kemenkes.sip.ukme.dao.UKME6Repository;
import id.kemenkes.sip.ukme.entity.UKME6;
import id.kemenkes.sip.ukme.entity.UKME6DTO;


@Controller
@RequestMapping("/rest")
public class UKME6Api {
	
	@Autowired
	UKME6Repository ukme6Repository; 
	
	@RequestMapping(value="/{tokenId}/ukme6/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKME6DTO ukme6dto) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		UKME6 ukme6 = new UKME6();
		PropertyUtils.copyProperties(ukme6, ukme6dto);
		if (!ukme6.getKodePuskesmas().isEmpty() && ukme6.getTahun() != 0 && ukme6.getBulan() != 0
				&& !ukme6.getNamaPuskesmas().isEmpty() && ukme6.getProvinsi() != 0 && ukme6.getKotaKabupaten() != 0) {
			String id = "UKME6-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukme6.setId(id.toUpperCase());
			ukme6.setSubmittedDate(new Date());
			ukme6Repository.save(ukme6);
			response.setMessage(ukme6.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
