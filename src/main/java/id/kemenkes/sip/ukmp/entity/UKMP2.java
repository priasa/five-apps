package id.kemenkes.sip.ukmp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UKMP2")
public class UKMP2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5434409583195780075L;
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

	private int a1 = 0;
	private int b1 = 0;
	private int c1 = 0;
	
	private String d11 = "";
	private int d11a = 0;
	private String d12 = "";
	private int d12a = 0;
	private String d13 = "";
	private int d13a = 0;
	private String d14 = "";
	private int d14a = 0;
	private String d15 = "";
	private int d15a = 0;
	
	private int e1 = 0;
	private int f1 = 0;
	
	private int g11a = 0;
	private int g12a = 0;
	
	private int h11 = 0;
	private int h12 = 0;
	private int h13 = 0;
	private int h14 = 0;
	
	private int i1 = 0;
	
	private int a2 = 0;
	private int b2 = 0;
	private int c2 = 0;
	private int d2 = 0;
	private int e2 = 0;
	private int f2 = 0;
	private int g2 = 0;
	private int h2 = 0;
	
	private int a3 = 0;
	private int a4 = 0;
	
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
	public int getA1() {
		return a1;
	}
	public void setA1(int a1) {
		this.a1 = a1;
	}
	public int getB1() {
		return b1;
	}
	public void setB1(int b1) {
		this.b1 = b1;
	}
	public int getC1() {
		return c1;
	}
	public void setC1(int c1) {
		this.c1 = c1;
	}
	public String getD11() {
		return d11;
	}
	public void setD11(String d11) {
		this.d11 = d11;
	}
	public int getD11a() {
		return d11a;
	}
	public void setD11a(int d11a) {
		this.d11a = d11a;
	}
	public String getD12() {
		return d12;
	}
	public void setD12(String d12) {
		this.d12 = d12;
	}
	public int getD12a() {
		return d12a;
	}
	public void setD12a(int d12a) {
		this.d12a = d12a;
	}
	public String getD13() {
		return d13;
	}
	public void setD13(String d13) {
		this.d13 = d13;
	}
	public int getD13a() {
		return d13a;
	}
	public void setD13a(int d13a) {
		this.d13a = d13a;
	}
	public String getD14() {
		return d14;
	}
	public void setD14(String d14) {
		this.d14 = d14;
	}
	public int getD14a() {
		return d14a;
	}
	public void setD14a(int d14a) {
		this.d14a = d14a;
	}
	public String getD15() {
		return d15;
	}
	public void setD15(String d15) {
		this.d15 = d15;
	}
	public int getD15a() {
		return d15a;
	}
	public void setD15a(int d15a) {
		this.d15a = d15a;
	}
	public int getE1() {
		return e1;
	}
	public void setE1(int e1) {
		this.e1 = e1;
	}
	public int getF1() {
		return f1;
	}
	public void setF1(int f1) {
		this.f1 = f1;
	}
	public int getG11a() {
		return g11a;
	}
	public void setG11a(int g11a) {
		this.g11a = g11a;
	}
	public int getG12a() {
		return g12a;
	}
	public void setG12a(int g12a) {
		this.g12a = g12a;
	}
	public int getH11() {
		return h11;
	}
	public void setH11(int h11) {
		this.h11 = h11;
	}
	public int getH12() {
		return h12;
	}
	public void setH12(int h12) {
		this.h12 = h12;
	}
	public int getH13() {
		return h13;
	}
	public void setH13(int h13) {
		this.h13 = h13;
	}
	public int getH14() {
		return h14;
	}
	public void setH14(int h14) {
		this.h14 = h14;
	}
	public int getI1() {
		return i1;
	}
	public void setI1(int i1) {
		this.i1 = i1;
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
	public int getA3() {
		return a3;
	}
	public void setA3(int a3) {
		this.a3 = a3;
	}
	public int getA4() {
		return a4;
	}
	public void setA4(int a4) {
		this.a4 = a4;
	}
	public Integer getTahun() {
		return tahun;
	}
	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}
	
	
}
