package id.smarta.five.common.entity;

import java.io.Serializable;

public class KabupatenCount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1127880804261691835L;
	
	private Integer provinsi;
	private Integer kotaKabupaten;
	private Integer totalData;
	
	public Integer getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(Integer provinsi) {
		this.provinsi = provinsi;
	}
	public Integer getTotalData() {
		return totalData;
	}
	public void setTotalData(Integer totalData) {
		this.totalData = totalData;
	}
	public Integer getKotaKabupaten() {
		return kotaKabupaten;
	}
	public void setKotaKabupaten(Integer kotaKabupaten) {
		this.kotaKabupaten = kotaKabupaten;
	}
	
	
}
