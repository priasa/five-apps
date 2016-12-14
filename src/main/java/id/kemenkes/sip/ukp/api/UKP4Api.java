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
import id.kemenkes.sip.ukp.dao.UKP4Repository;
import id.kemenkes.sip.ukp.entity.UKP4;


@Controller
@RequestMapping("/rest")
public class UKP4Api {
	
	@Autowired
	UKP4Repository ukp4Repository; 
	
	@RequestMapping(value="/{tokenId}/ukp4/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKP4 ukp4) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!ukp4.getKodePuskesmas().isEmpty() && ukp4.getTahun() != 0 && ukp4.getBulan() != 0
				&& !ukp4.getNamaPuskesmas().isEmpty() && ukp4.getProvinsi() != 0 && ukp4.getKotaKabupaten() != 0) {
			String id = "UKP4-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukp4.setId(id.toUpperCase());
			ukp4.setSubmittedDate(new Date());
			ukp4Repository.save(ukp4);
			response.setMessage(ukp4.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
