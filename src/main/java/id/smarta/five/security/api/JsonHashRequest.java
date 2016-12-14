package id.kemenkes.sip.security.api;

import id.kemenkes.sip.common.api.JsonApiCommonRequest;

public class JsonHashRequest extends JsonApiCommonRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1329364294655781828L;
	
	private String plainText1;
	private String plainText2;
	
	public String getPlainText1() {
		return plainText1;
	}
	public void setPlainText1(String plainText1) {
		this.plainText1 = plainText1;
	}
	public String getPlainText2() {
		return plainText2;
	}
	public void setPlainText2(String plainText2) {
		this.plainText2 = plainText2;
	}

}
