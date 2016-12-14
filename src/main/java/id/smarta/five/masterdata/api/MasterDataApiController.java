package id.kemenkes.sip.masterdata.api;

import id.kemenkes.sip.common.api.JsonApiCommonResponse.STATUS;
import id.kemenkes.sip.masterdata.entity.MasterData;
import id.kemenkes.sip.masterdata.entity.MasterDataContent;
import id.kemenkes.sip.masterdata.entity.MasterDataContentRestDTO;
import id.kemenkes.sip.masterdata.entity.MasterDataDTO;
import id.kemenkes.sip.masterdata.service.MasterDataService;

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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class MasterDataApiController {

	static final Logger LOGGER = LoggerFactory.getLogger(MasterDataApiController.class);
	
	@Autowired
    MasterDataService mdService;
	
	@RequestMapping(value="/{tokenId}/v1/masterdata/defaultproducttype", method=RequestMethod.GET)
	@ResponseBody
	public JsonMasterDataResponse getDefaultProductType(@PathVariable("tokenId") String tokenId, 
			HttpServletRequest request) throws SQLException, IllegalAccessException, NoSuchMethodException{
	
		JsonMasterDataResponse response = new JsonMasterDataResponse();
		response.setStatus(STATUS.fail);
		
		MasterData masterData = mdService.findMasterDataByName(MasterDataService.DEFAULT_PRODUCT_TYPE);
		if (masterData != null) {
			MasterDataDTO dto = new MasterDataDTO();
			dto.setId(masterData.getId());
			dto.setName(masterData.getName());
			dto.setNumberOnly(masterData.isNumberOnly());
            List<MasterDataContentRestDTO> content = new ArrayList<MasterDataContentRestDTO>();
            List<MasterDataContent> mdcList = mdService.getMDContentByParentId(masterData.getId());
            for(MasterDataContent mdc : mdcList){
                MasterDataContentRestDTO mdcDto = new MasterDataContentRestDTO();
                mdcDto.setId(mdc.getId());
                mdcDto.setCode(mdc.getCode());
                mdcDto.setValue(mdc.getFieldValue());
                content.add(mdcDto);
            }
            dto.setContent(content);
            response.setMasterData(dto);
            response.setStatus(STATUS.success);
		}
		
		return response;
	}
}
