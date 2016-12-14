package id.kemenkes.sip.common.entity;

import java.io.Serializable;

public class PuskesmasCount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1127880804261691835L;
	
	private Integer provinsi;
	private Integer kotaKabupaten;
	private String kodePuskesmas;
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
	public String getKodePuskesmas() {
		return kodePuskesmas;
	}
	public void setKodePuskesmas(String kodePuskesmas) {
		this.kodePuskesmas = kodePuskesmas;
	}
	
	
}
