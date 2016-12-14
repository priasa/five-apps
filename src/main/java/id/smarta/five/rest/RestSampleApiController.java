package id.kemenkes.sip.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;

@Controller
@RequestMapping("/rest")
public class RestSampleApiController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(RestSampleApiController.class);
	
	private List<JsonSampleRestData> sampleDataList;
	
	@PostConstruct
	public void init(){
		LOGGER.debug("RestSampleApiController|init");
		
		sampleDataList = Lists.newArrayList();
		
		for(int i=0; i<6; i++){
			sampleDataList.add(new JsonSampleRestData(String.valueOf(i), String.valueOf(i), "label"+String.valueOf(i)));
		}
		
	}
	
	@RequestMapping(value="/masterdatas", method=RequestMethod.GET)
	@ResponseBody
	public List<JsonSampleRestData> getSampleRestDataList(){
		
		return sampleDataList;
	}
	
	@RequestMapping("/masterdata/{id}")
	@ResponseBody
	public ResponseEntity<JsonSampleRestData> getSampleRestData(@PathVariable("id") String id){
		
		for(JsonSampleRestData data: sampleDataList){
			if(StringUtils.equals(data.getId(), id)){
				return new ResponseEntity<JsonSampleRestData>(data, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<JsonSampleRestData>(HttpStatus.NOT_FOUND);
	}

}
