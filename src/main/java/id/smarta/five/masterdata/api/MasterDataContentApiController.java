package id.smarta.five.masterdata.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import id.smarta.five.masterdata.entity.MasterData;
import id.smarta.five.masterdata.entity.MasterDataContent;
import id.smarta.five.masterdata.service.MasterDataService;



@Controller
@RequestMapping("/rest")
public class MasterDataContentApiController {

	static final Logger LOGGER = LoggerFactory.getLogger(MasterDataContentApiController.class);
	
	@Autowired
    MasterDataService mdService;
	
	@RequestMapping(value="/{tokenId}/v1/masterdata/content", method=RequestMethod.GET)
	@ResponseBody
	public List<String> getDefaultProductType(@PathVariable("tokenId") String tokenId, 
			@RequestParam(value="name", required=true) String name, HttpServletRequest request) throws SQLException, IllegalAccessException, NoSuchMethodException{
	
        List<String> result = new ArrayList<String>();

		MasterData masterData = mdService.findMasterDataByName(name);
		if (masterData != null) {
			List<MasterDataContent> mdcList = mdService.getMDContentByParentId(masterData.getId());
			for(MasterDataContent mdc : mdcList){
                result.add(mdc.getFieldValue());
            }
		}
		
		return result;
	}
}
