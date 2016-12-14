package id.kemenkes.sip.ukme.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UKME2")
public class UKME2 implements Serializable {

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
	
	private int a1 = 0;
	private int aa1 = 0;
	private int b1 = 0;
	private int ab1 = 0;
	private int c1 = 0;
	private int ac1 = 0;
	private int d1 = 0;
	private int ad1 = 0;
	private int e1 = 0;
	private int ae1 = 0;
	private int f1 = 0;
	private int af1 = 0;
	private int g1 = 0;
	private int ag1 = 0;
	
	private int a2 = 0;
	private int aa2 = 0;
	private int b2 = 0;
	private int ab2 = 0;
	private int c2 = 0;
	private int ac2 = 0;
	private int d2 = 0;
	private int ad2 = 0;
	private int e2 = 0;
	private int ae2 = 0;
	private int f2 = 0;
	private int af2 = 0;
	
	private int a3 = 0;
	private int aa3 = 0;
	private int b3 = 0;
	private int ab3 = 0;
	private int c3 = 0;
	private int ac3 = 0;
	private int d3 = 0;
	private int ad3 = 0;
	private int e3 = 0;
	private int ae3 = 0;
	private int f3 = 0;
	private int af3 = 0;
	private int g3 = 0;
	private int ag3 = 0;
	private int h3 = 0;
	private int ah3 = 0;
	private int j3 = 0;
	private int aj3 = 0;
	
	private int a4 = 0;
	private int aa4 = 0;
	
	private int a5 = 0;
	private int a6 = 0;
	private int a7 = 0;
	private int a8 = 0;
	private int a9 = 0;
	
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
	public int getA1() {
		return a1;
	}
	public void setA1(int a1) {
		this.a1 = a1;
	}
	public int getAa1() {
		return aa1;
	}
	public void setAa1(int aa1) {
		this.aa1 = aa1;
	}
	public int getB1() {
		return b1;
	}
	public void setB1(int b1) {
		this.b1 = b1;
	}
	public int getAb1() {
		return ab1;
	}
	public void setAb1(int ab1) {
		this.ab1 = ab1;
	}
	public int getC1() {
		return c1;
	}
	public void setC1(int c1) {
		this.c1 = c1;
	}
	public int getAc1() {
		return ac1;
	}
	public void setAc1(int ac1) {
		this.ac1 = ac1;
	}
	public int getD1() {
		return d1;
	}
	public void setD1(int d1) {
		this.d1 = d1;
	}
	public int getAd1() {
		return ad1;
	}
	public void setAd1(int ad1) {
		this.ad1 = ad1;
	}
	public int getE1() {
		return e1;
	}
	public void setE1(int e1) {
		this.e1 = e1;
	}
	public int getAe1() {
		return ae1;
	}
	public void setAe1(int ae1) {
		this.ae1 = ae1;
	}
	public int getF1() {
		return f1;
	}
	public void setF1(int f1) {
		this.f1 = f1;
	}
	public int getAf1() {
		return af1;
	}
	public void setAf1(int af1) {
		this.af1 = af1;
	}
	public int getG1() {
		return g1;
	}
	public void setG1(int g1) {
		this.g1 = g1;
	}
	public int getAg1() {
		return ag1;
	}
	public void setAg1(int ag1) {
		this.ag1 = ag1;
	}
	public int getA2() {
		return a2;
	}
	public void setA2(int a2) {
		this.a2 = a2;
	}
	public int getAa2() {
		return aa2;
	}
	public void setAa2(int aa2) {
		this.aa2 = aa2;
	}
	public int getB2() {
		return b2;
	}
	public void setB2(int b2) {
		this.b2 = b2;
	}
	public int getAb2() {
		return ab2;
	}
	public void setAb2(int ab2) {
		this.ab2 = ab2;
	}
	public int getC2() {
		return c2;
	}
	public void setC2(int c2) {
		this.c2 = c2;
	}
	public int getAc2() {
		return ac2;
	}
	public void setAc2(int ac2) {
		this.ac2 = ac2;
	}
	public int getD2() {
		return d2;
	}
	public void setD2(int d2) {
		this.d2 = d2;
	}
	public int getAd2() {
		return ad2;
	}
	public void setAd2(int ad2) {
		this.ad2 = ad2;
	}
	public int getE2() {
		return e2;
	}
	public void setE2(int e2) {
		this.e2 = e2;
	}
	public int getAe2() {
		return ae2;
	}
	public void setAe2(int ae2) {
		this.ae2 = ae2;
	}
	public int getF2() {
		return f2;
	}
	public void setF2(int f2) {
		this.f2 = f2;
	}
	public int getAf2() {
		return af2;
	}
	public void setAf2(int af2) {
		this.af2 = af2;
	}
	public int getA3() {
		return a3;
	}
	public void setA3(int a3) {
		this.a3 = a3;
	}
	public int getAa3() {
		return aa3;
	}
	public void setAa3(int aa3) {
		this.aa3 = aa3;
	}
	public int getB3() {
		return b3;
	}
	public void setB3(int b3) {
		this.b3 = b3;
	}
	public int getAb3() {
		return ab3;
	}
	public void setAb3(int ab3) {
		this.ab3 = ab3;
	}
	public int getC3() {
		return c3;
	}
	public void setC3(int c3) {
		this.c3 = c3;
	}
	public int getAc3() {
		return ac3;
	}
	public void setAc3(int ac3) {
		this.ac3 = ac3;
	}
	public int getD3() {
		return d3;
	}
	public void setD3(int d3) {
		this.d3 = d3;
	}
	public int getAd3() {
		return ad3;
	}
	public void setAd3(int ad3) {
		this.ad3 = ad3;
	}
	public int getE3() {
		return e3;
	}
	public void setE3(int e3) {
		this.e3 = e3;
	}
	public int getAe3() {
		return ae3;
	}
	public void setAe3(int ae3) {
		this.ae3 = ae3;
	}
	public int getF3() {
		return f3;
	}
	public void setF3(int f3) {
		this.f3 = f3;
	}
	public int getAf3() {
		return af3;
	}
	public void setAf3(int af3) {
		this.af3 = af3;
	}
	public int getG3() {
		return g3;
	}
	public void setG3(int g3) {
		this.g3 = g3;
	}
	public int getAg3() {
		return ag3;
	}
	public void setAg3(int ag3) {
		this.ag3 = ag3;
	}
	public int getH3() {
		return h3;
	}
	public void setH3(int h3) {
		this.h3 = h3;
	}
	public int getAh3() {
		return ah3;
	}
	public void setAh3(int ah3) {
		this.ah3 = ah3;
	}
	public int getJ3() {
		return j3;
	}
	public void setJ3(int j3) {
		this.j3 = j3;
	}
	public int getAj3() {
		return aj3;
	}
	public void setAj3(int aj3) {
		this.aj3 = aj3;
	}
	public int getA4() {
		return a4;
	}
	public void setA4(int a4) {
		this.a4 = a4;
	}
	public int getAa4() {
		return aa4;
	}
	public void setAa4(int aa4) {
		this.aa4 = aa4;
	}
	public int getA5() {
		return a5;
	}
	public void setA5(int a5) {
		this.a5 = a5;
	}
	public int getA6() {
		return a6;
	}
	public void setA6(int a6) {
		this.a6 = a6;
	}
	public int getA7() {
		return a7;
	}
	public void setA7(int a7) {
		this.a7 = a7;
	}
	public int getA8() {
		return a8;
	}
	public void setA8(int a8) {
		this.a8 = a8;
	}
	public int getA9() {
		return a9;
	}
	public void setA9(int a9) {
		this.a9 = a9;
	}
	
}
