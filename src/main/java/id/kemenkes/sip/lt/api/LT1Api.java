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
import id.kemenkes.sip.lt.dao.LT1Repository;
import id.kemenkes.sip.lt.entity.LT1;


@Controller
@RequestMapping("/rest")
public class LT1Api {
	
	@Autowired
	LT1Repository lt1Repository; 
	
	@RequestMapping(value="/{tokenId}/lt1/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) LT1 lt1) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!lt1.getKodePuskesmas().isEmpty() && lt1.getTahun() != 0 && !lt1.getNamaPuskesmas().isEmpty() 
				&& lt1.getProvinsi() != 0 && lt1.getKotaKabupaten() != 0) {
			String id = "LT1-".concat(RandomStringUtils.randomAlphanumeric(8));
			lt1.setId(id.toUpperCase());
			lt1.setSubmittedDate(new Date());
			lt1Repository.save(lt1);
			response.setMessage(lt1.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
