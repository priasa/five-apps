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
import id.kemenkes.sip.ukp.dao.UKP2Repository;
import id.kemenkes.sip.ukp.entity.UKP2;


@Controller
@RequestMapping("/rest")
public class UKP2Api {
	
	@Autowired
	UKP2Repository ukp2Repository; 
	
	@RequestMapping(value="/{tokenId}/ukp2/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKP2 ukp2) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!ukp2.getKodePuskesmas().isEmpty() && ukp2.getTahun() != 0 && ukp2.getBulan() != 0
				&& !ukp2.getNamaPuskesmas().isEmpty() && ukp2.getProvinsi() != 0 && ukp2.getKotaKabupaten() != 0) {
			String id = "UKP2-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukp2.setId(id.toUpperCase());
			ukp2.setSubmittedDate(new Date());
			ukp2Repository.save(ukp2);
			response.setMessage(ukp2.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
