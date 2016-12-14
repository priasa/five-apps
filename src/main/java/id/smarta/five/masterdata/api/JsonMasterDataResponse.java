package id.kemenkes.sip.masterdata.api;

import id.kemenkes.sip.common.api.JsonApiCommonResponse;
import id.kemenkes.sip.masterdata.entity.MasterDataDTO;

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
