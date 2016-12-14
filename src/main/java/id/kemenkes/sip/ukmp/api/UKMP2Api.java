package id.kemenkes.sip.ukmp.api;

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
import id.kemenkes.sip.ukmp.dao.UKMP2Repository;
import id.kemenkes.sip.ukmp.entity.UKMP2;


@Controller
@RequestMapping("/rest")
public class UKMP2Api {
	
	@Autowired
	UKMP2Repository ukmp2Repository; 
	
	@RequestMapping(value="/{tokenId}/ukmp2/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKMP2 ukmp2) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!ukmp2.getKodePuskesmas().isEmpty() && ukmp2.getTahun() != 0 && ukmp2.getBulan() != 0
				&& !ukmp2.getNamaPuskesmas().isEmpty() && ukmp2.getProvinsi() != 0 && ukmp2.getKotaKabupaten() != 0) {
			String id = "UKMP2-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukmp2.setId(id.toUpperCase());
			ukmp2.setSubmittedDate(new Date());
			ukmp2Repository.save(ukmp2);
			response.setMessage(ukmp2.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
