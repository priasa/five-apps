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
import id.kemenkes.sip.ukp.dao.UKP3Repository;
import id.kemenkes.sip.ukp.entity.UKP3;


@Controller
@RequestMapping("/rest")
public class UKP3Api {
	
	@Autowired
	UKP3Repository ukp3Repository; 
	
	@RequestMapping(value="/{tokenId}/ukp3/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKP3 ukp3) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!ukp3.getKodePuskesmas().isEmpty() && ukp3.getTahun() != 0 && ukp3.getBulan() != 0
				&& !ukp3.getNamaPuskesmas().isEmpty() && ukp3.getProvinsi() != 0 && ukp3.getKotaKabupaten() != 0) {
			String id = "UKP3-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukp3.setId(id.toUpperCase());
			ukp3.setSubmittedDate(new Date());
			ukp3Repository.save(ukp3);
			response.setMessage(ukp3.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
