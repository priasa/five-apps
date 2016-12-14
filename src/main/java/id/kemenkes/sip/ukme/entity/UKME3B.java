package id.kemenkes.sip.ukme.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UKME3B")
public class UKME3B implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7216803086113024122L;
	
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
	
	private String sekolah = "";
	
	private int a1 = 0;
	private int a2 = 0;
	private int b2 = 0;
	private int c2 = 0;
	private int d2 = 0;
	private int e2 = 0;
	private int f2 = 0;
	private int g2 = 0;
	private int h2 = 0;
	
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
	public Integer getTahun() {
		return tahun;
	}
	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}
	public String getSekolah() {
		return sekolah;
	}
	public void setSekolah(String sekolah) {
		this.sekolah = sekolah;
	}
	public int getA1() {
		return a1;
	}
	public void setA1(int a1) {
		this.a1 = a1;
	}
	public int getA2() {
		return a2;
	}
	public void setA2(int a2) {
		this.a2 = a2;
	}
	public int getB2() {
		return b2;
	}
	public void setB2(int b2) {
		this.b2 = b2;
	}
	public int getC2() {
		return c2;
	}
	public void setC2(int c2) {
		this.c2 = c2;
	}
	public int getD2() {
		return d2;
	}
	public void setD2(int d2) {
		this.d2 = d2;
	}
	public int getE2() {
		return e2;
	}
	public void setE2(int e2) {
		this.e2 = e2;
	}
	public int getF2() {
		return f2;
	}
	public void setF2(int f2) {
		this.f2 = f2;
	}
	public int getG2() {
		return g2;
	}
	public void setG2(int g2) {
		this.g2 = g2;
	}
	public int getH2() {
		return h2;
	}
	public void setH2(int h2) {
		this.h2 = h2;
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
	
	
}
