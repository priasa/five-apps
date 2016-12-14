package id.kemenkes.sip.kabupaten.api;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;
import id.kemenkes.sip.kabupaten.dao.KabupatenRepository;
import id.kemenkes.sip.kabupaten.entity.JsonApiKabupatenResponse;
import id.kemenkes.sip.kabupaten.entity.KabupatenEntity;

@Controller
@RequestMapping("/rest")
public class KabupatenApi {

	@Autowired
	KabupatenRepository kabupatenRepository;

	@RequestMapping(value = "/{tokenId}/kabupaten/findByProvinsi", method = RequestMethod.GET, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<JsonApiKabupatenResponse> findByProvinsi(@PathVariable("tokenId") String tokenId, @RequestParam(value="provinsi", required=true) Integer kodeProvinsi)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiKabupatenResponse response = new JsonApiKabupatenResponse();
		response.setStatus(STATUS.fail);
		
		List<KabupatenEntity> entities = kabupatenRepository.findByProvinsi(kodeProvinsi);
		if (entities != null) {
			response.setEntities(entities);
			response.setSize(entities.size());
			response.setStatus(STATUS.success);
		} else {
			response.setMessage("not found");
		}
		return new ResponseEntity<JsonApiKabupatenResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{tokenId}/kabupaten/findByKode", method = RequestMethod.GET, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<JsonApiKabupatenResponse> findByCode(@PathVariable("tokenId") String tokenId, @RequestParam(value="kode", required=true) Integer kode)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiKabupatenResponse response = new JsonApiKabupatenResponse();
		response.setStatus(STATUS.fail);

		KabupatenEntity entity = kabupatenRepository.getOne(kode);
		if (entity != null) {
			response.getEntities().add(entity);
			response.setSize(1);
			response.setStatus(STATUS.success);
		}else {
			response.setMessage("not found");
		}
		
		return new ResponseEntity<JsonApiKabupatenResponse>(response, HttpStatus.OK);
	}
}
