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
import id.kemenkes.sip.ukme.dao.UKME3BRepository;
import id.kemenkes.sip.ukme.entity.UKME3B;
import id.kemenkes.sip.ukme.entity.UKME3BDTO;


@Controller
@RequestMapping("/rest")
public class UKME3BApi {
	
	@Autowired
	UKME3BRepository ukme3bRepository; 
	
	@RequestMapping(value="/{tokenId}/ukme3b/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKME3BDTO ukme3bdto) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		UKME3B ukme3b = new UKME3B();
		PropertyUtils.copyProperties(ukme3b, ukme3bdto);
		if (!ukme3b.getKodePuskesmas().isEmpty() && ukme3b.getTahun() != 0 && ukme3b.getBulan() != 0
				&& !ukme3b.getNamaPuskesmas().isEmpty() && ukme3b.getProvinsi() != 0 && ukme3b.getKotaKabupaten() != 0) {
			String id = "UKME3B-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukme3b.setId(id.toUpperCase());
			ukme3b.setSubmittedDate(new Date());
			ukme3bRepository.save(ukme3b);
			response.setMessage(ukme3b.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
