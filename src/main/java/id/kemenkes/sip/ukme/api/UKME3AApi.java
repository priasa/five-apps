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
import id.kemenkes.sip.ukme.dao.UKME3ARepository;
import id.kemenkes.sip.ukme.entity.UKME3A;
import id.kemenkes.sip.ukme.entity.UKME3ADTO;


@Controller
@RequestMapping("/rest")
public class UKME3AApi {
	
	@Autowired
	UKME3ARepository ukme3aRepository; 
	
	@RequestMapping(value="/{tokenId}/ukme3a/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) UKME3ADTO ukme3adto) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		UKME3A ukme3a = new UKME3A();
		PropertyUtils.copyProperties(ukme3a, ukme3adto);
		if (!ukme3a.getKodePuskesmas().isEmpty() && ukme3a.getTahun() != 0 && ukme3a.getBulan() != 0
				&& !ukme3a.getNamaPuskesmas().isEmpty() && ukme3a.getProvinsi() != 0 && ukme3a.getKotaKabupaten() != 0) {
			String id = "UKME3A-".concat(RandomStringUtils.randomAlphanumeric(8));
			ukme3a.setId(id.toUpperCase());
			ukme3a.setSubmittedDate(new Date());
			ukme3aRepository.save(ukme3a);
			response.setMessage(ukme3a.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}

}
