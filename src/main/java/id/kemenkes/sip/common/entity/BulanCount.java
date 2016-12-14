package id.kemenkes.sip.common.entity;

import java.io.Serializable;

public class BulanCount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1127880804261691835L;
	
	private Integer bulan;
	private Integer totalData;
	
	public Integer getBulan() {
		return bulan;
	}
	public void setBulan(Integer bulan) {
		this.bulan = bulan;
	}
	public Integer getTotalData() {
		return totalData;
	}
	public void setTotalData(Integer totalData) {
		this.totalData = totalData;
	}
	
	
}
