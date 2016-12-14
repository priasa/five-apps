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
import id.kemenkes.sip.lt.dao.LT2Repository;
import id.kemenkes.sip.lt.entity.LT2;


@Controller
@RequestMapping("/rest")
public class LT2Api {
	
	@Autowired
	LT2Repository lt2Repository; 
	
	@RequestMapping(value="/{tokenId}/lt2/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) LT2 lt2) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!lt2.getKodePuskesmas().isEmpty() && lt2.getTahun() != 0 && !lt2.getNamaPuskesmas().isEmpty() 
				&& lt2.getProvinsi() != 0 && lt2.getKotaKabupaten() != 0) {
			String id = "LT2-".concat(RandomStringUtils.randomAlphanumeric(8));
			lt2.setId(id.toUpperCase());
			lt2.setSubmittedDate(new Date());
			lt2Repository.save(lt2);
			response.setMessage(lt2.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
