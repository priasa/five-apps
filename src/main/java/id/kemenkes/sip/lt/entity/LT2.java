package id.kemenkes.sip.lt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LT2")
public class LT2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3052650231302212735L;
	
	@Id
	private String id;
	private Date submittedDate = new Date();
	
	private String kodePuskesmas = "";
	private String namaPuskesmas = "";
	private Integer provinsi = 0;
	private Integer kotaKabupaten = 0;
	private Integer tahun = 0;
	
	private List<LT2Detail> detail = new ArrayList<LT2Detail>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getKodePuskesmas() {
		return kodePuskesmas;
	}

	public void setKodePuskesmas(String kodePuskesmas) {
		this.kodePuskesmas = kodePuskesmas;
	}

	public String getNamaPuskesmas() {
		return namaPuskesmas;
	}

	public void setNamaPuskesmas(String namaPuskesmas) {
		this.namaPuskesmas = namaPuskesmas;
	}

	public Integer getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(Integer provinsi) {
		this.provinsi = provinsi;
	}

	public Integer getKotaKabupaten() {
		return kotaKabupaten;
	}

	public void setKotaKabupaten(Integer kotaKabupaten) {
		this.kotaKabupaten = kotaKabupaten;
	}

	public Integer getTahun() {
		return tahun;
	}

	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}

	public List<LT2Detail> getDetail() {
		return detail;
	}

	public void setDetail(List<LT2Detail> detail) {
		this.detail = detail;
	}


}
