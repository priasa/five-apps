package id.kemenkes.sip.icd.api;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;
import id.kemenkes.sip.icd.dao.BpjsIcdRepository;
import id.kemenkes.sip.icd.entity.BpjsIcdEntity;
import id.kemenkes.sip.icd.entity.JsonApiBpjsIcdResponse;

@Controller
@RequestMapping("/rest")
public class ICDApi {

	@Autowired
	BpjsIcdRepository bpjsIcdRepository; 
	
	@RequestMapping(value="/{tokenId}/diagnosa/find", method=RequestMethod.GET, consumes={"application/json"})
	@ResponseBody
	public ResponseEntity<JsonApiBpjsIcdResponse>  findBpjsIcd(@PathVariable("tokenId") String tokenId, @RequestParam(value="keyword", required=true) String keyword) 
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiBpjsIcdResponse response = new JsonApiBpjsIcdResponse();
		response.setStatus(STATUS.fail);
		
		if (keyword.length() >= 2) {
			Pageable page = new PageRequest(0, 25);
			Page<BpjsIcdEntity> returnPage = bpjsIcdRepository.findLikeNamaDiagnosa(keyword, page);
			response.setEntities(returnPage.getContent());
			response.setSize(returnPage.getNumberOfElements());
			response.setStatus(STATUS.success);
		} else {
			response.setMessage("keyword minimal 2 karakter.");
		}
		
		return new ResponseEntity<JsonApiBpjsIcdResponse>(response, HttpStatus.OK);
	}
}
