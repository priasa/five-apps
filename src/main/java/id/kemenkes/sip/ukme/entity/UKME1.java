package id.kemenkes.sip.ukme.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UKME1")
public class UKME1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -528901002290295486L;
	
	@Id
	private String id;
	private Date submittedDate = new Date();
	
	private String kodePuskesmas = "";
	private String namaPuskesmas = "";
	private Integer provinsi = 0;
	private Integer kotaKabupaten = 0;
	private Integer bulan = 0;
	private Integer tahun = 0;
	
	private Integer a1a = 0;
	private Integer a1b = 0;
	private Integer a1c = 0;
	private Integer a1d = 0;
	
	private Integer a2 = 0;
	private Integer a3 = 0;
	private Integer a4 = 0;
	
	private Integer a8 = 0;
	private Integer a9 = 0;
	
	private Integer b1 = 0;
	private Integer b2 = 0;
	private Integer b3 = 0;
	private Integer b4 = 0;
	private Integer b5 = 0;
	
	private Integer c1 = 0;
	private Integer c2 = 0;
	
	private Integer d1 = 0;
	private Integer d2 = 0;
	private Integer d3 = 0;
	private Integer d4 = 0;
	
	private Integer e1 = 0;
	
	private Integer f1a = 0;
	private Integer f1b = 0;
	private Integer f1c = 0;
	private Integer f1d = 0;
	
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
	public Integer getA1a() {
		return a1a;
	}
	public void setA1a(Integer a1a) {
		this.a1a = a1a;
	}
	public Integer getA1b() {
		return a1b;
	}
	public void setA1b(Integer a1b) {
		this.a1b = a1b;
	}
	public Integer getA1c() {
		return a1c;
	}
	public void setA1c(Integer a1c) {
		this.a1c = a1c;
	}
	public Integer getA1d() {
		return a1d;
	}
	public void setA1d(Integer a1d) {
		this.a1d = a1d;
	}
	public Integer getA2() {
		return a2;
	}
	public void setA2(Integer a2) {
		this.a2 = a2;
	}
	public Integer getA3() {
		return a3;
	}
	public void setA3(Integer a3) {
		this.a3 = a3;
	}
	public Integer getA4() {
		return a4;
	}
	public void setA4(Integer a4) {
		this.a4 = a4;
	}
	public Integer getA8() {
		return a8;
	}
	public void setA8(Integer a8) {
		this.a8 = a8;
	}
	public Integer getA9() {
		return a9;
	}
	public void setA9(Integer a9) {
		this.a9 = a9;
	}
	public Integer getB1() {
		return b1;
	}
	public void setB1(Integer b1) {
		this.b1 = b1;
	}
	public Integer getB2() {
		return b2;
	}
	public void setB2(Integer b2) {
		this.b2 = b2;
	}
	public Integer getB3() {
		return b3;
	}
	public void setB3(Integer b3) {
		this.b3 = b3;
	}
	public Integer getB4() {
		return b4;
	}
	public void setB4(Integer b4) {
		this.b4 = b4;
	}
	public Integer getB5() {
		return b5;
	}
	public void setB5(Integer b5) {
		this.b5 = b5;
	}
	public Integer getC1() {
		return c1;
	}
	public void setC1(Integer c1) {
		this.c1 = c1;
	}
	public Integer getC2() {
		return c2;
	}
	public void setC2(Integer c2) {
		this.c2 = c2;
	}
	public Integer getD1() {
		return d1;
	}
	public void setD1(Integer d1) {
		this.d1 = d1;
	}
	public Integer getD2() {
		return d2;
	}
	public void setD2(Integer d2) {
		this.d2 = d2;
	}
	public Integer getD3() {
		return d3;
	}
	public void setD3(Integer d3) {
		this.d3 = d3;
	}
	public Integer getD4() {
		return d4;
	}
	public void setD4(Integer d4) {
		this.d4 = d4;
	}
	public Integer getE1() {
		return e1;
	}
	public void setE1(Integer e1) {
		this.e1 = e1;
	}
	public Integer getF1a() {
		return f1a;
	}
	public void setF1a(Integer f1a) {
		this.f1a = f1a;
	}
	public Integer getF1b() {
		return f1b;
	}
	public void setF1b(Integer f1b) {
		this.f1b = f1b;
	}
	public Integer getF1c() {
		return f1c;
	}
	public void setF1c(Integer f1c) {
		this.f1c = f1c;
	}
	public Integer getF1d() {
		return f1d;
	}
	public void setF1d(Integer f1d) {
		this.f1d = f1d;
	}
	

}
