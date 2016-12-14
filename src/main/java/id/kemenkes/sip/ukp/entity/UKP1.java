package id.kemenkes.sip.ukp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UKP1")
public class UKP1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1099580517324163806L;
	
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

	private int a1_baru = 0;
	private int a1_lama = 0;
	private int a2_baru = 0;
	private int a2_lama = 0;
	private int a3_baru = 0;
	private int a3_lama = 0;
	private int a4_baru = 0;
	private int a4_lama = 0;
	private int a5_baru = 0;
	private int a5_lama = 0;
	private int a6_baru = 0;
	private int a6_lama = 0;
	private int a7_baru = 0;
	private int a7_lama = 0;
	private int a8_baru = 0;
	private int a8_lama = 0;

	private int b1_baru = 0;
	private int b1_lama = 0;
	private int b2_baru = 0;
	private int b2_lama = 0;
	private int b3_baru = 0;
	private int b3_lama = 0;
	private int b4_baru = 0;
	private int b4_lama = 0;
	private int b5_baru = 0;
	private int b5_lama = 0;
	private int b6_baru = 0;
	private int b6_lama = 0;
	private int b7_baru = 0;
	private int b7_lama = 0;
	
	private int c1_baru = 0;
	private int c1_lama = 0;
	private int c2_baru = 0;
	private int c2_lama = 0;
	private int c3_baru = 0;
	private int c3_lama = 0;
	
	private int d1_baru = 0;
	private int d1_lama = 0;
	private int d2_baru = 0;
	private int d2_lama = 0;
	private int d3_baru = 0;
	private int d3_lama = 0;
	private int d4_baru = 0;
	private int d4_lama = 0;
	private int d5_baru = 0;
	private int d5_lama = 0;
	private int d6_baru = 0;
	private int d6_lama = 0;
	
	private int e1_baru = 0;
	private int e1_lama = 0;
	private int e2_baru = 0;
	private int e2_lama = 0;
	private int e3_baru = 0;
	private int e3_lama = 0;
	private int e4_baru = 0;
	private int e4_lama = 0;
	private int e5_baru = 0;
	private int e5_lama = 0;
	private int e6_baru = 0;
	private int e6_lama = 0;
	private int e7_baru = 0;
	private int e7_lama = 0;
	private int e8_baru = 0;
	private int e8_lama = 0;
	private int e9_baru = 0;
	private int e9_lama = 0;
	private int e10_baru = 0;
	private int e10_lama = 0;
	private int e11_baru = 0;
	private int e11_lama = 0;
	private int e12_baru = 0;
	private int e12_lama = 0;
	private int e13_baru = 0;
	private int e13_lama = 0;
	private int e14_baru = 0;
	private int e14_lama = 0;
	private int e15_baru = 0;
	private int e15_lama = 0;
	private int e16_baru = 0;
	private int e16_lama = 0;
	private int e17_baru = 0;
	private int e17_lama = 0;
	private int e18_baru = 0;
	private int e18_lama = 0;
	private int e19_baru = 0;
	private int e19_lama = 0;
	private int e20_baru = 0;
	private int e20_lama = 0;
	
	private int f1_baru = 0;
	private int f1_lama = 0;
	private int f2_baru = 0;
	private int f2_lama = 0;
	private int f3_baru = 0;
	private int f3_lama = 0;
	private int f4_baru = 0;
	private int f4_lama = 0;
	private int f5_baru = 0;
	private int f5_lama = 0;
	private int f6_baru = 0;
	private int f6_lama = 0;
	
	private int g1_baru = 0;
	private int g1_lama = 0;
	private int g2_baru = 0;
	private int g2_lama = 0;
	private int g3_baru = 0;
	private int g3_lama = 0;
	private int g4_baru = 0;
	private int g4_lama = 0;
	
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
	public int getA1_baru() {
		return a1_baru;
	}
	public void setA1_baru(int a1_baru) {
		this.a1_baru = a1_baru;
	}
	public int getA1_lama() {
		return a1_lama;
	}
	public void setA1_lama(int a1_lama) {
		this.a1_lama = a1_lama;
	}
	public int getA2_baru() {
		return a2_baru;
	}
	public void setA2_baru(int a2_baru) {
		this.a2_baru = a2_baru;
	}
	public int getA2_lama() {
		return a2_lama;
	}
	public void setA2_lama(int a2_lama) {
		this.a2_lama = a2_lama;
	}
	public int getA3_baru() {
		return a3_baru;
	}
	public void setA3_baru(int a3_baru) {
		this.a3_baru = a3_baru;
	}
	public int getA3_lama() {
		return a3_lama;
	}
	public void setA3_lama(int a3_lama) {
		this.a3_lama = a3_lama;
	}
	public int getA4_baru() {
		return a4_baru;
	}
	public void setA4_baru(int a4_baru) {
		this.a4_baru = a4_baru;
	}
	public int getA4_lama() {
		return a4_lama;
	}
	public void setA4_lama(int a4_lama) {
		this.a4_lama = a4_lama;
	}
	public int getA5_baru() {
		return a5_baru;
	}
	public void setA5_baru(int a5_baru) {
		this.a5_baru = a5_baru;
	}
	public int getA5_lama() {
		return a5_lama;
	}
	public void setA5_lama(int a5_lama) {
		this.a5_lama = a5_lama;
	}
	public int getA6_baru() {
		return a6_baru;
	}
	public void setA6_baru(int a6_baru) {
		this.a6_baru = a6_baru;
	}
	public int getA6_lama() {
		return a6_lama;
	}
	public void setA6_lama(int a6_lama) {
		this.a6_lama = a6_lama;
	}
	public int getA7_baru() {
		return a7_baru;
	}
	public void setA7_baru(int a7_baru) {
		this.a7_baru = a7_baru;
	}
	public int getA7_lama() {
		return a7_lama;
	}
	public void setA7_lama(int a7_lama) {
		this.a7_lama = a7_lama;
	}
	public int getA8_baru() {
		return a8_baru;
	}
	public void setA8_baru(int a8_baru) {
		this.a8_baru = a8_baru;
	}
	public int getA8_lama() {
		return a8_lama;
	}
	public void setA8_lama(int a8_lama) {
		this.a8_lama = a8_lama;
	}
	public int getB1_baru() {
		return b1_baru;
	}
	public void setB1_baru(int b1_baru) {
		this.b1_baru = b1_baru;
	}
	public int getB1_lama() {
		return b1_lama;
	}
	public void setB1_lama(int b1_lama) {
		this.b1_lama = b1_lama;
	}
	public int getB2_baru() {
		return b2_baru;
	}
	public void setB2_baru(int b2_baru) {
		this.b2_baru = b2_baru;
	}
	public int getB2_lama() {
		return b2_lama;
	}
	public void setB2_lama(int b2_lama) {
		this.b2_lama = b2_lama;
	}
	public int getB3_baru() {
		return b3_baru;
	}
	public void setB3_baru(int b3_baru) {
		this.b3_baru = b3_baru;
	}
	public int getB3_lama() {
		return b3_lama;
	}
	public void setB3_lama(int b3_lama) {
		this.b3_lama = b3_lama;
	}
	public int getB4_baru() {
		return b4_baru;
	}
	public void setB4_baru(int b4_baru) {
		this.b4_baru = b4_baru;
	}
	public int getB4_lama() {
		return b4_lama;
	}
	public void setB4_lama(int b4_lama) {
		this.b4_lama = b4_lama;
	}
	public int getB5_baru() {
		return b5_baru;
	}
	public void setB5_baru(int b5_baru) {
		this.b5_baru = b5_baru;
	}
	public int getB5_lama() {
		return b5_lama;
	}
	public void setB5_lama(int b5_lama) {
		this.b5_lama = b5_lama;
	}
	public int getB6_baru() {
		return b6_baru;
	}
	public void setB6_baru(int b6_baru) {
		this.b6_baru = b6_baru;
	}
	public int getB6_lama() {
		return b6_lama;
	}
	public void setB6_lama(int b6_lama) {
		this.b6_lama = b6_lama;
	}
	public int getB7_baru() {
		return b7_baru;
	}
	public void setB7_baru(int b7_baru) {
		this.b7_baru = b7_baru;
	}
	public int getB7_lama() {
		return b7_lama;
	}
	public void setB7_lama(int b7_lama) {
		this.b7_lama = b7_lama;
	}
	public int getC1_baru() {
		return c1_baru;
	}
	public void setC1_baru(int c1_baru) {
		this.c1_baru = c1_baru;
	}
	public int getC1_lama() {
		return c1_lama;
	}
	public void setC1_lama(int c1_lama) {
		this.c1_lama = c1_lama;
	}
	public int getC2_baru() {
		return c2_baru;
	}
	public void setC2_baru(int c2_baru) {
		this.c2_baru = c2_baru;
	}
	public int getC2_lama() {
		return c2_lama;
	}
	public void setC2_lama(int c2_lama) {
		this.c2_lama = c2_lama;
	}
	public int getC3_baru() {
		return c3_baru;
	}
	public void setC3_baru(int c3_baru) {
		this.c3_baru = c3_baru;
	}
	public int getC3_lama() {
		return c3_lama;
	}
	public void setC3_lama(int c3_lama) {
		this.c3_lama = c3_lama;
	}
	public int getD1_baru() {
		return d1_baru;
	}
	public void setD1_baru(int d1_baru) {
		this.d1_baru = d1_baru;
	}
	public int getD1_lama() {
		return d1_lama;
	}
	public void setD1_lama(int d1_lama) {
		this.d1_lama = d1_lama;
	}
	public int getD2_baru() {
		return d2_baru;
	}
	public void setD2_baru(int d2_baru) {
		this.d2_baru = d2_baru;
	}
	public int getD2_lama() {
		return d2_lama;
	}
	public void setD2_lama(int d2_lama) {
		this.d2_lama = d2_lama;
	}
	public int getD3_baru() {
		return d3_baru;
	}
	public void setD3_baru(int d3_baru) {
		this.d3_baru = d3_baru;
	}
	public int getD3_lama() {
		return d3_lama;
	}
	public void setD3_lama(int d3_lama) {
		this.d3_lama = d3_lama;
	}
	public int getD4_baru() {
		return d4_baru;
	}
	public void setD4_baru(int d4_baru) {
		this.d4_baru = d4_baru;
	}
	public int getD4_lama() {
		return d4_lama;
	}
	public void setD4_lama(int d4_lama) {
		this.d4_lama = d4_lama;
	}
	public int getD5_baru() {
		return d5_baru;
	}
	public void setD5_baru(int d5_baru) {
		this.d5_baru = d5_baru;
	}
	public int getD5_lama() {
		return d5_lama;
	}
	public void setD5_lama(int d5_lama) {
		this.d5_lama = d5_lama;
	}
	public int getD6_baru() {
		return d6_baru;
	}
	public void setD6_baru(int d6_baru) {
		this.d6_baru = d6_baru;
	}
	public int getD6_lama() {
		return d6_lama;
	}
	public void setD6_lama(int d6_lama) {
		this.d6_lama = d6_lama;
	}
	public int getE1_baru() {
		return e1_baru;
	}
	public void setE1_baru(int e1_baru) {
		this.e1_baru = e1_baru;
	}
	public int getE1_lama() {
		return e1_lama;
	}
	public void setE1_lama(int e1_lama) {
		this.e1_lama = e1_lama;
	}
	public int getE2_baru() {
		return e2_baru;
	}
	public void setE2_baru(int e2_baru) {
		this.e2_baru = e2_baru;
	}
	public int getE2_lama() {
		return e2_lama;
	}
	public void setE2_lama(int e2_lama) {
		this.e2_lama = e2_lama;
	}
	public int getE3_baru() {
		return e3_baru;
	}
	public void setE3_baru(int e3_baru) {
		this.e3_baru = e3_baru;
	}
	public int getE3_lama() {
		return e3_lama;
	}
	public void setE3_lama(int e3_lama) {
		this.e3_lama = e3_lama;
	}
	public int getE4_baru() {
		return e4_baru;
	}
	public void setE4_baru(int e4_baru) {
		this.e4_baru = e4_baru;
	}
	public int getE4_lama() {
		return e4_lama;
	}
	public void setE4_lama(int e4_lama) {
		this.e4_lama = e4_lama;
	}
	public int getE5_baru() {
		return e5_baru;
	}
	public void setE5_baru(int e5_baru) {
		this.e5_baru = e5_baru;
	}
	public int getE5_lama() {
		return e5_lama;
	}
	public void setE5_lama(int e5_lama) {
		this.e5_lama = e5_lama;
	}
	public int getE6_baru() {
		return e6_baru;
	}
	public void setE6_baru(int e6_baru) {
		this.e6_baru = e6_baru;
	}
	public int getE6_lama() {
		return e6_lama;
	}
	public void setE6_lama(int e6_lama) {
		this.e6_lama = e6_lama;
	}
	public int getE7_baru() {
		return e7_baru;
	}
	public void setE7_baru(int e7_baru) {
		this.e7_baru = e7_baru;
	}
	public int getE7_lama() {
		return e7_lama;
	}
	public void setE7_lama(int e7_lama) {
		this.e7_lama = e7_lama;
	}
	public int getE8_baru() {
		return e8_baru;
	}
	public void setE8_baru(int e8_baru) {
		this.e8_baru = e8_baru;
	}
	public int getE8_lama() {
		return e8_lama;
	}
	public void setE8_lama(int e8_lama) {
		this.e8_lama = e8_lama;
	}
	public int getE9_baru() {
		return e9_baru;
	}
	public void setE9_baru(int e9_baru) {
		this.e9_baru = e9_baru;
	}
	public int getE9_lama() {
		return e9_lama;
	}
	public void setE9_lama(int e9_lama) {
		this.e9_lama = e9_lama;
	}
	public int getE10_baru() {
		return e10_baru;
	}
	public void setE10_baru(int e10_baru) {
		this.e10_baru = e10_baru;
	}
	public int getE10_lama() {
		return e10_lama;
	}
	public void setE10_lama(int e10_lama) {
		this.e10_lama = e10_lama;
	}
	public int getE11_baru() {
		return e11_baru;
	}
	public void setE11_baru(int e11_baru) {
		this.e11_baru = e11_baru;
	}
	public int getE11_lama() {
		return e11_lama;
	}
	public void setE11_lama(int e11_lama) {
		this.e11_lama = e11_lama;
	}
	public int getE12_baru() {
		return e12_baru;
	}
	public void setE12_baru(int e12_baru) {
		this.e12_baru = e12_baru;
	}
	public int getE12_lama() {
		return e12_lama;
	}
	public void setE12_lama(int e12_lama) {
		this.e12_lama = e12_lama;
	}
	public int getE13_baru() {
		return e13_baru;
	}
	public void setE13_baru(int e13_baru) {
		this.e13_baru = e13_baru;
	}
	public int getE13_lama() {
		return e13_lama;
	}
	public void setE13_lama(int e13_lama) {
		this.e13_lama = e13_lama;
	}
	public int getE14_baru() {
		return e14_baru;
	}
	public void setE14_baru(int e14_baru) {
		this.e14_baru = e14_baru;
	}
	public int getE14_lama() {
		return e14_lama;
	}
	public void setE14_lama(int e14_lama) {
		this.e14_lama = e14_lama;
	}
	public int getE15_baru() {
		return e15_baru;
	}
	public void setE15_baru(int e15_baru) {
		this.e15_baru = e15_baru;
	}
	public int getE15_lama() {
		return e15_lama;
	}
	public void setE15_lama(int e15_lama) {
		this.e15_lama = e15_lama;
	}
	public int getE16_baru() {
		return e16_baru;
	}
	public void setE16_baru(int e16_baru) {
		this.e16_baru = e16_baru;
	}
	public int getE16_lama() {
		return e16_lama;
	}
	public void setE16_lama(int e16_lama) {
		this.e16_lama = e16_lama;
	}
	public int getE17_baru() {
		return e17_baru;
	}
	public void setE17_baru(int e17_baru) {
		this.e17_baru = e17_baru;
	}
	public int getE17_lama() {
		return e17_lama;
	}
	public void setE17_lama(int e17_lama) {
		this.e17_lama = e17_lama;
	}
	public int getE18_baru() {
		return e18_baru;
	}
	public void setE18_baru(int e18_baru) {
		this.e18_baru = e18_baru;
	}
	public int getE18_lama() {
		return e18_lama;
	}
	public void setE18_lama(int e18_lama) {
		this.e18_lama = e18_lama;
	}
	public int getE19_baru() {
		return e19_baru;
	}
	public void setE19_baru(int e19_baru) {
		this.e19_baru = e19_baru;
	}
	public int getE19_lama() {
		return e19_lama;
	}
	public void setE19_lama(int e19_lama) {
		this.e19_lama = e19_lama;
	}
	public int getE20_baru() {
		return e20_baru;
	}
	public void setE20_baru(int e20_baru) {
		this.e20_baru = e20_baru;
	}
	public int getE20_lama() {
		return e20_lama;
	}
	public void setE20_lama(int e20_lama) {
		this.e20_lama = e20_lama;
	}
	public int getF1_baru() {
		return f1_baru;
	}
	public void setF1_baru(int f1_baru) {
		this.f1_baru = f1_baru;
	}
	public int getF1_lama() {
		return f1_lama;
	}
	public void setF1_lama(int f1_lama) {
		this.f1_lama = f1_lama;
	}
	public int getF2_baru() {
		return f2_baru;
	}
	public void setF2_baru(int f2_baru) {
		this.f2_baru = f2_baru;
	}
	public int getF2_lama() {
		return f2_lama;
	}
	public void setF2_lama(int f2_lama) {
		this.f2_lama = f2_lama;
	}
	public int getF3_baru() {
		return f3_baru;
	}
	public void setF3_baru(int f3_baru) {
		this.f3_baru = f3_baru;
	}
	public int getF3_lama() {
		return f3_lama;
	}
	public void setF3_lama(int f3_lama) {
		this.f3_lama = f3_lama;
	}
	public int getF4_baru() {
		return f4_baru;
	}
	public void setF4_baru(int f4_baru) {
		this.f4_baru = f4_baru;
	}
	public int getF4_lama() {
		return f4_lama;
	}
	public void setF4_lama(int f4_lama) {
		this.f4_lama = f4_lama;
	}
	public int getF5_baru() {
		return f5_baru;
	}
	public void setF5_baru(int f5_baru) {
		this.f5_baru = f5_baru;
	}
	public int getF5_lama() {
		return f5_lama;
	}
	public void setF5_lama(int f5_lama) {
		this.f5_lama = f5_lama;
	}
	public int getF6_baru() {
		return f6_baru;
	}
	public void setF6_baru(int f6_baru) {
		this.f6_baru = f6_baru;
	}
	public int getF6_lama() {
		return f6_lama;
	}
	public void setF6_lama(int f6_lama) {
		this.f6_lama = f6_lama;
	}
	public int getG1_baru() {
		return g1_baru;
	}
	public void setG1_baru(int g1_baru) {
		this.g1_baru = g1_baru;
	}
	public int getG1_lama() {
		return g1_lama;
	}
	public void setG1_lama(int g1_lama) {
		this.g1_lama = g1_lama;
	}
	public int getG2_baru() {
		return g2_baru;
	}
	public void setG2_baru(int g2_baru) {
		this.g2_baru = g2_baru;
	}
	public int getG2_lama() {
		return g2_lama;
	}
	public void setG2_lama(int g2_lama) {
		this.g2_lama = g2_lama;
	}
	public int getG3_baru() {
		return g3_baru;
	}
	public void setG3_baru(int g3_baru) {
		this.g3_baru = g3_baru;
	}
	public int getG3_lama() {
		return g3_lama;
	}
	public void setG3_lama(int g3_lama) {
		this.g3_lama = g3_lama;
	}
	public int getG4_baru() {
		return g4_baru;
	}
	public void setG4_baru(int g4_baru) {
		this.g4_baru = g4_baru;
	}
	public int getG4_lama() {
		return g4_lama;
	}
	public void setG4_lama(int g4_lama) {
		this.g4_lama = g4_lama;
	}
	public Integer getTahun() {
		return tahun;
	}
	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}
	
	
	
	
}
