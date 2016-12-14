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
import id.kemenkes.sip.ukp.dao.UKP1Repository;
import id.kemenkes.sip.ukp.entity.UKP1;


@Controller
@RequestMapping("/rest")
public class UKP1Api {
	
	@Autowired
	UKP1Repository ukp1Repository; 
	
	@RequestMapping(value="/{tokenId}/ukp1/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKP1 ukp1) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!ukp1.getKodePuskesmas().isEmpty() && ukp1.getTahun() != 0 && ukp1.getBulan() != 0
				&& !ukp1.getNamaPuskesmas().isEmpty() && ukp1.getProvinsi() != 0 && ukp1.getKotaKabupaten() != 0) {
			String id = "UKP1-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukp1.setId(id.toUpperCase());
			ukp1.setSubmittedDate(new Date());
			ukp1Repository.save(ukp1);
			response.setMessage(ukp1.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
