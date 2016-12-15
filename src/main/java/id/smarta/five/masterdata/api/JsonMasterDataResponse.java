package id.smarta.five.masterdata.api;

import id.smarta.five.common.api.JsonApiCommonResponse;
import id.smarta.five.masterdata.entity.MasterDataDTO;

public class JsonMasterDataResponse extends JsonApiCommonResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2828116427607795572L;
	
	private MasterDataDTO masterData;

	public MasterDataDTO getMasterData() {
		return masterData;
	}

	public void setMasterData(MasterDataDTO masterData) {
		this.masterData = masterData;
	}
	
	

}
