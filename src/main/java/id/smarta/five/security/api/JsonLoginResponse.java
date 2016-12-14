package id.kemenkes.sip.security.api;

import id.kemenkes.sip.common.api.JsonApiCommonResponse;

public class JsonLoginResponse extends JsonApiCommonResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1397083643172782510L;
	
	private boolean enableBpjsPcare = false;
    private boolean enableKki = false;
    private boolean enableSimpus = false;
    private boolean enableKomdat = false;
    private boolean enableAdminduk = false;
    private boolean enableMtki = false;
    private boolean enablePpsdm = false;
	
    public boolean isEnableMtki() {
		return enableMtki;
	}
	public void setEnableMtki(boolean enableMtki) {
		this.enableMtki = enableMtki;
	}
	public boolean isEnablePpsdm() {
		return enablePpsdm;
	}
	public void setEnablePpsdm(boolean enablePpsdm) {
		this.enablePpsdm = enablePpsdm;
	}
	public boolean isEnableBpjsPcare() {
		return enableBpjsPcare;
	}
	public void setEnableBpjsPcare(boolean enableBpjsPcare) {
		this.enableBpjsPcare = enableBpjsPcare;
	}
	public boolean isEnableKki() {
		return enableKki;
	}
	public void setEnableKki(boolean enableKki) {
		this.enableKki = enableKki;
	}
	public boolean isEnableSimpus() {
		return enableSimpus;
	}
	public void setEnableSimpus(boolean enableSimpus) {
		this.enableSimpus = enableSimpus;
	}
	public boolean isEnableKomdat() {
		return enableKomdat;
	}
	public void setEnableKomdat(boolean enableKomdat) {
		this.enableKomdat = enableKomdat;
	}
	public boolean isEnableAdminduk() {
		return enableAdminduk;
	}
	public void setEnableAdminduk(boolean enableAdminduk) {
		this.enableAdminduk = enableAdminduk;
	}
	
}
