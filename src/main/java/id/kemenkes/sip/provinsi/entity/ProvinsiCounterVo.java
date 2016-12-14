package id.kemenkes.sip.provinsi.entity;

import java.io.Serializable;

public class ProvinsiCounterVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2285953057880263403L;
	
	private ProvinsiEntity provinsiEntity;
	private Integer totalData = 0;
	
	public ProvinsiEntity getProvinsiEntity() {
		return provinsiEntity;
	}
	public void setProvinsiEntity(ProvinsiEntity provinsiEntity) {
		this.provinsiEntity = provinsiEntity;
	}
	public Integer getTotalData() {
		return totalData;
	}
	public void setTotalData(Integer totalData) {
		this.totalData = totalData;
	}
	
	
}
