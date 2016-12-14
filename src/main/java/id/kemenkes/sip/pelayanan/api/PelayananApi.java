package id.kemenkes.sip.pelayanan.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

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
import id.kemenkes.sip.pelayanan.dao.PelayananRepository;
import id.kemenkes.sip.pelayanan.entity.PelayananEntity;


@Controller
@RequestMapping("/rest")
public class PelayananApi {

	@Autowired
	PelayananRepository pelayananRepository; 
	
	@RequestMapping(value="/{tokenId}/pelayanan/save", method=RequestMethod.POST, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiCommonResponse>  saveFormData(@PathVariable("tokenId") String tokenId, @RequestBody(required=true) PelayananEntity pelayananEntity) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiCommonResponse response = new JsonApiCommonResponse();
		response.setStatus(STATUS.fail);
		
		if (!pelayananEntity.getKodePuskesmas().isEmpty() && pelayananEntity.getTahun() != 0 && pelayananEntity.getBulan() != 0
				&& !pelayananEntity.getNamaPuskesmas().isEmpty() && pelayananEntity.getProvinsi() != 0 && pelayananEntity.getKotaKabupaten() != 0) {
			String id = UUID.randomUUID().toString();
			pelayananEntity.setId(id.toUpperCase());
			pelayananEntity.setSubmittedDate(new Date());
			pelayananRepository.save(pelayananEntity);
			
			response.setMessage(pelayananEntity.getId());
			response.setStatus(STATUS.success);
		}
		
		return new ResponseEntity<JsonApiCommonResponse>(response, HttpStatus.OK);
	}
}
