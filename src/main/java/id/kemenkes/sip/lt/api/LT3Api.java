package id.kemenkes.sip.lt.api;

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
import id.kemenkes.sip.lt.dao.LT3Repository;
import id.kemenkes.sip.lt.entity.LT3;


@Controller
@RequestMapping("/rest")
public class LT3Api {
	
	@Autowired
	LT3Repository lt3Repository; 
	
	@RequestMapping(value="/{tokenId}/lt3/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) LT3 lt3) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!lt3.getKodePuskesmas().isEmpty() && lt3.getTahun() != 0 && !lt3.getNamaPuskesmas().isEmpty() 
				&& lt3.getProvinsi() != 0 && lt3.getKotaKabupaten() != 0) {
			String id = "LT3-".concat(RandomStringUtils.randomAlphanumeric(8));
			lt3.setId(id.toUpperCase());
			lt3.setSubmittedDate(new Date());
			lt3Repository.save(lt3);
			response.setMessage(lt3.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
