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
import id.kemenkes.sip.ukme.dao.UKME5Repository;
import id.kemenkes.sip.ukme.entity.UKME5;
import id.kemenkes.sip.ukme.entity.UKME5DTO;


@Controller
@RequestMapping("/rest")
public class UKME5Api {
	
	@Autowired
	UKME5Repository ukme5Repository; 
	
	@RequestMapping(value="/{tokenId}/ukme5/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKME5DTO ukme5dto) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		UKME5 ukme5 = new UKME5();
		PropertyUtils.copyProperties(ukme5, ukme5dto);
		if (!ukme5.getKodePuskesmas().isEmpty() && ukme5.getTahun() != 0 && ukme5.getBulan() != 0
				&& !ukme5.getNamaPuskesmas().isEmpty() && ukme5.getProvinsi() != 0 && ukme5.getKotaKabupaten() != 0) {
			String id = "UKME5-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukme5.setId(id.toUpperCase());
			ukme5.setSubmittedDate(new Date());
			ukme5Repository.save(ukme5);
			response.setMessage(ukme5.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
