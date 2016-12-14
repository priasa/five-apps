package id.kemenkes.sip.provinsi.api;

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
import id.kemenkes.sip.provinsi.dao.ProvinsiRepository;
import id.kemenkes.sip.provinsi.entity.JsonApiProvinsiResponse;
import id.kemenkes.sip.provinsi.entity.ProvinsiEntity;

@Controller
@RequestMapping("/rest")
public class ProvinsiApi {

	@Autowired
	ProvinsiRepository provinsiRepository;

	@RequestMapping(value = "/{tokenId}/provinsi/list", method = RequestMethod.GET, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<JsonApiProvinsiResponse> findAll(@PathVariable("tokenId") String tokenId)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiProvinsiResponse response = new JsonApiProvinsiResponse();

		List<ProvinsiEntity> entities = provinsiRepository.findAll();
		if (entities != null) {
			response.setEntities(entities);
			response.setSize(entities.size());
			response.setStatus(STATUS.success);
		} else {
			response.setStatus(STATUS.fail);
			response.setMessage("not found");
		}
		return new ResponseEntity<JsonApiProvinsiResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{tokenId}/provinsi/findByKode", method = RequestMethod.GET, consumes = { "application/json" })
	@ResponseBody
	public ResponseEntity<JsonApiProvinsiResponse> findAll(@PathVariable("tokenId") String tokenId, @RequestParam(value="kode", required=true) Integer kode)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		JsonApiProvinsiResponse response = new JsonApiProvinsiResponse();

		ProvinsiEntity entity = provinsiRepository.getOne(kode);
		if (entity != null) {
			response.getEntities().add(entity);
			response.setSize(1);
			response.setStatus(STATUS.success);
		} else {
			response.setStatus(STATUS.fail);
			response.setMessage("not found");
		}
		return new ResponseEntity<JsonApiProvinsiResponse>(response, HttpStatus.OK);
	}
}
