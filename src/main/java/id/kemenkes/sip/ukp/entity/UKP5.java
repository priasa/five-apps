package id.kemenkes.sip.ukp.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UKP5")
public class UKP5 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7858116962196059481L;
	@Id
	private String id;
	private Date submittedDate = new Date();
	
	private String kodePuskesmas = "";
	private String namaPuskesmas = "";
	private Integer provinsi = 0;
	private Integer kotaKabupaten = 0;
	private Integer bulan = 0;
	private Integer tahun = 0;
	
	private int pustu_total = 0;
	private int pustu_lapor = 0;
	private int poskesdes_total = 0;
	private int poskesdes_lapor = 0;

	private List<UKP5Detail> detail = new ArrayList<UKP5Detail>();

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

	public Integer getBulan() {
		return bulan;
	}

	public void setBulan(Integer bulan) {
		this.bulan = bulan;
	}

	public int getPustu_total() {
		return pustu_total;
	}

	public void setPustu_total(int pustu_total) {
		this.pustu_total = pustu_total;
	}

	public int getPustu_lapor() {
		return pustu_lapor;
	}

	public void setPustu_lapor(int pustu_lapor) {
		this.pustu_lapor = pustu_lapor;
	}

	public int getPoskesdes_total() {
		return poskesdes_total;
	}

	public void setPoskesdes_total(int poskesdes_total) {
		this.poskesdes_total = poskesdes_total;
	}

	public int getPoskesdes_lapor() {
		return poskesdes_lapor;
	}

	public void setPoskesdes_lapor(int poskesdes_lapor) {
		this.poskesdes_lapor = poskesdes_lapor;
	}

	public List<UKP5Detail> getDetail() {
		return detail;
	}

	public void setDetail(List<UKP5Detail> detail) {
		this.detail = detail;
	}

	public Integer getTahun() {
		return tahun;
	}

	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}
	
}
