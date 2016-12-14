package id.kemenkes.sip.lt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "LT3")
public class LT3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6842893609059275858L;

	@Id
	private String id;
	private Date submittedDate = new Date();
	
	private String kodePuskesmas = "";
	private String namaPuskesmas = "";
	private Integer provinsi = 0;
	private Integer kotaKabupaten = 0;
	private Integer tahun = 0;
	
	private int a1 = 0;
	private int b1 = 0;
	private int c1 = 0;
	private int d1 = 0;
	private int e1 = 0;
	
	private int a2 = 0;
	private int b2 = 0;
	private int c2 = 0;
	
	private int a3 = 0;
	private int b3 = 0;
	private int c3 = 0;
	private int d3 = 0;
	
	private int a41_belum = 0;
	private int a41_rendah = 0;
	private int a41_sedang = 0;
	private int a41_tinggi = 0;
	private int a41_amat_tinggi = 0;
	private int a41_sertifikat = 0;
	
	private int a42_belum = 0;
	private int a42_rendah = 0;
	private int a42_sedang = 0;
	private int a42_tinggi = 0;
	private int a42_amat_tinggi = 0;
	private int a42_sertifikat = 0;
	
	private int a43_belum = 0;
	private int a43_rendah = 0;
	private int a43_sedang = 0;
	private int a43_tinggi = 0;
	private int a43_amat_tinggi = 0;
	private int a43_sertifikat = 0;
	
	private int a44_belum = 0;
	private int a44_rendah = 0;
	private int a44_sedang = 0;
	private int a44_tinggi = 0;
	private int a44_amat_tinggi = 0;
	private int a44_sertifikat = 0;
	
	private int a45_belum = 0;
	private int a45_rendah = 0;
	private int a45_sedang = 0;
	private int a45_tinggi = 0;
	private int a45_amat_tinggi = 0;
	private int a45_sertifikat = 0;
	
	private int a46_belum = 0;
	private int a46_rendah = 0;
	private int a46_sedang = 0;
	private int a46_tinggi = 0;
	private int a46_amat_tinggi = 0;
	private int a46_sertifikat = 0;
	
	private int a47_belum = 0;
	private int a47_rendah = 0;
	private int a47_sedang = 0;
	private int a47_tinggi = 0;
	private int a47_amat_tinggi = 0;
	private int a47_sertifikat = 0;
	
	private int a48_belum = 0;
	private int a48_rendah = 0;
	private int a48_sedang = 0;
	private int a48_tinggi = 0;
	private int a48_amat_tinggi = 0;
	private int a48_sertifikat = 0;
	
	private int a49_belum = 0;
	private int a49_rendah = 0;
	private int a49_sedang = 0;
	private int a49_tinggi = 0;
	private int a49_amat_tinggi = 0;
	private int a49_sertifikat = 0;
		
	private int b41_belum = 0;
	private int b41_tdk_memenuhi = 0;
	private int b41_memenuhi = 0;
	private int b41_sertifikat = 0;
	
	private int b42_belum = 0;
	private int b42_tdk_memenuhi = 0;
	private int b42_memenuhi = 0;
	private int b42_sertifikat = 0;
			
	private int c41_belum = 0;
	private int c41_tdk_memenuhi = 0;
	private int c41_memenuhi = 0;
	private int c41_sertifikat = 0;
	
	private int c42_belum = 0;
	private int c42_tdk_memenuhi = 0;
	private int c42_memenuhi = 0;
	private int c42_sertifikat = 0;
	
	private int c43_belum = 0;
	private int c43_tdk_memenuhi = 0;
	private int c43_memenuhi = 0;
	private int c43_sertifikat = 0;
	
	private int c44_belum = 0;
	private int c44_tdk_memenuhi = 0;
	private int c44_memenuhi = 0;
	private int c44_sertifikat = 0;

	private int c45_belum = 0;
	private int c45_tdk_memenuhi = 0;
	private int c45_memenuhi = 0;
	private int c45_sertifikat = 0;

	private int c46_belum = 0;
	private int c46_tdk_memenuhi = 0;
	private int c46_memenuhi = 0;
	private int c46_sertifikat = 0;

	private int c47_belum = 0;
	private int c47_tdk_memenuhi = 0;
	private int c47_memenuhi = 0;
	private int c47_sertifikat = 0;
	
	private int c48_belum = 0;
	private int c48_tdk_memenuhi = 0;
	private int c48_memenuhi = 0;
	private int c48_sertifikat = 0;
	
	private int d4_belum = 0;
	private int d4_tdk_memenuhi = 0;
	private int d4_memenuhi = 0;
	private int d4_sertifikat = 0;
		
	private int e41a_belum = 0;
	private int e41a_tdk_memenuhi = 0;
	private int e41a_memenuhi = 0;
	private int e41a_sertifikat = 0;
	
	private int e41b_belum = 0;
	private int e41b_tdk_memenuhi = 0;
	private int e41b_memenuhi = 0;
	private int e41b_sertifikat = 0;
	
	private int e42a_belum = 0;
	private int e42a_tdk_memenuhi = 0;
	private int e42a_memenuhi = 0;
	private int e42a_sertifikat = 0;
	
	private int e42b_belum = 0;
	private int e42b_tdk_memenuhi = 0;
	private int e42b_memenuhi = 0;
	private int e42b_sertifikat = 0;
	
	private int e43_belum = 0;
	private int e43_tdk_memenuhi = 0;
	private int e43_memenuhi = 0;
	private int e43_sertifikat = 0;
	
	private int e44_belum = 0;
	private int e44_tdk_memenuhi = 0;
	private int e44_memenuhi = 0;
	private int e44_sertifikat = 0;
	
	private int e45_belum = 0;
	private int e45_tdk_memenuhi = 0;
	private int e45_memenuhi = 0;
	private int e45_sertifikat = 0;
	
	private int e46_belum = 0;
	private int e46_tdk_memenuhi = 0;
	private int e46_memenuhi = 0;
	private int e46_sertifikat = 0;
	
	private int e47_belum = 0;
	private int e47_tdk_memenuhi = 0;
	private int e47_memenuhi = 0;
	private int e47_sertifikat = 0;
	
	private int e48_belum = 0;
	private int e48_tdk_memenuhi = 0;
	private int e48_memenuhi = 0;
	private int e48_sertifikat = 0;
	
	private int e49_belum = 0;
	private int e49_tdk_memenuhi = 0;
	private int e49_memenuhi = 0;
	private int e49_sertifikat = 0;

	private int a5 = 0;
	private int b5 = 0;
	
	private int a6 = 0;
	private int b6 = 0;
	private int c6 = 0;
	
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
	public int getD1() {
		return d1;
	}
	public void setD1(int d1) {
		this.d1 = d1;
	}
	public int getE1() {
		return e1;
	}
	public void setE1(int e1) {
		this.e1 = e1;
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
	public int getA3() {
		return a3;
	}
	public void setA3(int a3) {
		this.a3 = a3;
	}
	public int getB3() {
		return b3;
	}
	public void setB3(int b3) {
		this.b3 = b3;
	}
	public int getC3() {
		return c3;
	}
	public void setC3(int c3) {
		this.c3 = c3;
	}
	public int getD3() {
		return d3;
	}
	public void setD3(int d3) {
		this.d3 = d3;
	}
	public int getA41_belum() {
		return a41_belum;
	}
	public void setA41_belum(int a41_belum) {
		this.a41_belum = a41_belum;
	}
	public int getA41_rendah() {
		return a41_rendah;
	}
	public void setA41_rendah(int a41_rendah) {
		this.a41_rendah = a41_rendah;
	}
	public int getA41_sedang() {
		return a41_sedang;
	}
	public void setA41_sedang(int a41_sedang) {
		this.a41_sedang = a41_sedang;
	}
	public int getA41_tinggi() {
		return a41_tinggi;
	}
	public void setA41_tinggi(int a41_tinggi) {
		this.a41_tinggi = a41_tinggi;
	}
	public int getA41_amat_tinggi() {
		return a41_amat_tinggi;
	}
	public void setA41_amat_tinggi(int a41_amat_tinggi) {
		this.a41_amat_tinggi = a41_amat_tinggi;
	}
	public int getA41_sertifikat() {
		return a41_sertifikat;
	}
	public void setA41_sertifikat(int a41_sertifikat) {
		this.a41_sertifikat = a41_sertifikat;
	}
	public int getA42_belum() {
		return a42_belum;
	}
	public void setA42_belum(int a42_belum) {
		this.a42_belum = a42_belum;
	}
	public int getA42_rendah() {
		return a42_rendah;
	}
	public void setA42_rendah(int a42_rendah) {
		this.a42_rendah = a42_rendah;
	}
	public int getA42_sedang() {
		return a42_sedang;
	}
	public void setA42_sedang(int a42_sedang) {
		this.a42_sedang = a42_sedang;
	}
	public int getA42_tinggi() {
		return a42_tinggi;
	}
	public void setA42_tinggi(int a42_tinggi) {
		this.a42_tinggi = a42_tinggi;
	}
	public int getA42_amat_tinggi() {
		return a42_amat_tinggi;
	}
	public void setA42_amat_tinggi(int a42_amat_tinggi) {
		this.a42_amat_tinggi = a42_amat_tinggi;
	}
	public int getA42_sertifikat() {
		return a42_sertifikat;
	}
	public void setA42_sertifikat(int a42_sertifikat) {
		this.a42_sertifikat = a42_sertifikat;
	}
	public int getA43_belum() {
		return a43_belum;
	}
	public void setA43_belum(int a43_belum) {
		this.a43_belum = a43_belum;
	}
	public int getA43_rendah() {
		return a43_rendah;
	}
	public void setA43_rendah(int a43_rendah) {
		this.a43_rendah = a43_rendah;
	}
	public int getA43_sedang() {
		return a43_sedang;
	}
	public void setA43_sedang(int a43_sedang) {
		this.a43_sedang = a43_sedang;
	}
	public int getA43_tinggi() {
		return a43_tinggi;
	}
	public void setA43_tinggi(int a43_tinggi) {
		this.a43_tinggi = a43_tinggi;
	}
	public int getA43_amat_tinggi() {
		return a43_amat_tinggi;
	}
	public void setA43_amat_tinggi(int a43_amat_tinggi) {
		this.a43_amat_tinggi = a43_amat_tinggi;
	}
	public int getA43_sertifikat() {
		return a43_sertifikat;
	}
	public void setA43_sertifikat(int a43_sertifikat) {
		this.a43_sertifikat = a43_sertifikat;
	}
	public int getA44_belum() {
		return a44_belum;
	}
	public void setA44_belum(int a44_belum) {
		this.a44_belum = a44_belum;
	}
	public int getA44_rendah() {
		return a44_rendah;
	}
	public void setA44_rendah(int a44_rendah) {
		this.a44_rendah = a44_rendah;
	}
	public int getA44_sedang() {
		return a44_sedang;
	}
	public void setA44_sedang(int a44_sedang) {
		this.a44_sedang = a44_sedang;
	}
	public int getA44_tinggi() {
		return a44_tinggi;
	}
	public void setA44_tinggi(int a44_tinggi) {
		this.a44_tinggi = a44_tinggi;
	}
	public int getA44_amat_tinggi() {
		return a44_amat_tinggi;
	}
	public void setA44_amat_tinggi(int a44_amat_tinggi) {
		this.a44_amat_tinggi = a44_amat_tinggi;
	}
	public int getA44_sertifikat() {
		return a44_sertifikat;
	}
	public void setA44_sertifikat(int a44_sertifikat) {
		this.a44_sertifikat = a44_sertifikat;
	}
	public int getA45_belum() {
		return a45_belum;
	}
	public void setA45_belum(int a45_belum) {
		this.a45_belum = a45_belum;
	}
	public int getA45_rendah() {
		return a45_rendah;
	}
	public void setA45_rendah(int a45_rendah) {
		this.a45_rendah = a45_rendah;
	}
	public int getA45_sedang() {
		return a45_sedang;
	}
	public void setA45_sedang(int a45_sedang) {
		this.a45_sedang = a45_sedang;
	}
	public int getA45_tinggi() {
		return a45_tinggi;
	}
	public void setA45_tinggi(int a45_tinggi) {
		this.a45_tinggi = a45_tinggi;
	}
	public int getA45_amat_tinggi() {
		return a45_amat_tinggi;
	}
	public void setA45_amat_tinggi(int a45_amat_tinggi) {
		this.a45_amat_tinggi = a45_amat_tinggi;
	}
	public int getA45_sertifikat() {
		return a45_sertifikat;
	}
	public void setA45_sertifikat(int a45_sertifikat) {
		this.a45_sertifikat = a45_sertifikat;
	}
	public int getA46_belum() {
		return a46_belum;
	}
	public void setA46_belum(int a46_belum) {
		this.a46_belum = a46_belum;
	}
	public int getA46_rendah() {
		return a46_rendah;
	}
	public void setA46_rendah(int a46_rendah) {
		this.a46_rendah = a46_rendah;
	}
	public int getA46_sedang() {
		return a46_sedang;
	}
	public void setA46_sedang(int a46_sedang) {
		this.a46_sedang = a46_sedang;
	}
	public int getA46_tinggi() {
		return a46_tinggi;
	}
	public void setA46_tinggi(int a46_tinggi) {
		this.a46_tinggi = a46_tinggi;
	}
	public int getA46_amat_tinggi() {
		return a46_amat_tinggi;
	}
	public void setA46_amat_tinggi(int a46_amat_tinggi) {
		this.a46_amat_tinggi = a46_amat_tinggi;
	}
	public int getA46_sertifikat() {
		return a46_sertifikat;
	}
	public void setA46_sertifikat(int a46_sertifikat) {
		this.a46_sertifikat = a46_sertifikat;
	}
	public int getA47_belum() {
		return a47_belum;
	}
	public void setA47_belum(int a47_belum) {
		this.a47_belum = a47_belum;
	}
	public int getA47_rendah() {
		return a47_rendah;
	}
	public void setA47_rendah(int a47_rendah) {
		this.a47_rendah = a47_rendah;
	}
	public int getA47_sedang() {
		return a47_sedang;
	}
	public void setA47_sedang(int a47_sedang) {
		this.a47_sedang = a47_sedang;
	}
	public int getA47_tinggi() {
		return a47_tinggi;
	}
	public void setA47_tinggi(int a47_tinggi) {
		this.a47_tinggi = a47_tinggi;
	}
	public int getA47_amat_tinggi() {
		return a47_amat_tinggi;
	}
	public void setA47_amat_tinggi(int a47_amat_tinggi) {
		this.a47_amat_tinggi = a47_amat_tinggi;
	}
	public int getA47_sertifikat() {
		return a47_sertifikat;
	}
	public void setA47_sertifikat(int a47_sertifikat) {
		this.a47_sertifikat = a47_sertifikat;
	}
	public int getA48_belum() {
		return a48_belum;
	}
	public void setA48_belum(int a48_belum) {
		this.a48_belum = a48_belum;
	}
	public int getA48_rendah() {
		return a48_rendah;
	}
	public void setA48_rendah(int a48_rendah) {
		this.a48_rendah = a48_rendah;
	}
	public int getA48_sedang() {
		return a48_sedang;
	}
	public void setA48_sedang(int a48_sedang) {
		this.a48_sedang = a48_sedang;
	}
	public int getA48_tinggi() {
		return a48_tinggi;
	}
	public void setA48_tinggi(int a48_tinggi) {
		this.a48_tinggi = a48_tinggi;
	}
	public int getA48_amat_tinggi() {
		return a48_amat_tinggi;
	}
	public void setA48_amat_tinggi(int a48_amat_tinggi) {
		this.a48_amat_tinggi = a48_amat_tinggi;
	}
	public int getA48_sertifikat() {
		return a48_sertifikat;
	}
	public void setA48_sertifikat(int a48_sertifikat) {
		this.a48_sertifikat = a48_sertifikat;
	}
	public int getA49_belum() {
		return a49_belum;
	}
	public void setA49_belum(int a49_belum) {
		this.a49_belum = a49_belum;
	}
	public int getA49_rendah() {
		return a49_rendah;
	}
	public void setA49_rendah(int a49_rendah) {
		this.a49_rendah = a49_rendah;
	}
	public int getA49_sedang() {
		return a49_sedang;
	}
	public void setA49_sedang(int a49_sedang) {
		this.a49_sedang = a49_sedang;
	}
	public int getA49_tinggi() {
		return a49_tinggi;
	}
	public void setA49_tinggi(int a49_tinggi) {
		this.a49_tinggi = a49_tinggi;
	}
	public int getA49_amat_tinggi() {
		return a49_amat_tinggi;
	}
	public void setA49_amat_tinggi(int a49_amat_tinggi) {
		this.a49_amat_tinggi = a49_amat_tinggi;
	}
	public int getA49_sertifikat() {
		return a49_sertifikat;
	}
	public void setA49_sertifikat(int a49_sertifikat) {
		this.a49_sertifikat = a49_sertifikat;
	}
	public int getB41_belum() {
		return b41_belum;
	}
	public void setB41_belum(int b41_belum) {
		this.b41_belum = b41_belum;
	}
	public int getB41_tdk_memenuhi() {
		return b41_tdk_memenuhi;
	}
	public void setB41_tdk_memenuhi(int b41_tdk_memenuhi) {
		this.b41_tdk_memenuhi = b41_tdk_memenuhi;
	}
	public int getB41_memenuhi() {
		return b41_memenuhi;
	}
	public void setB41_memenuhi(int b41_memenuhi) {
		this.b41_memenuhi = b41_memenuhi;
	}
	public int getB41_sertifikat() {
		return b41_sertifikat;
	}
	public void setB41_sertifikat(int b41_sertifikat) {
		this.b41_sertifikat = b41_sertifikat;
	}
	public int getB42_belum() {
		return b42_belum;
	}
	public void setB42_belum(int b42_belum) {
		this.b42_belum = b42_belum;
	}
	public int getB42_tdk_memenuhi() {
		return b42_tdk_memenuhi;
	}
	public void setB42_tdk_memenuhi(int b42_tdk_memenuhi) {
		this.b42_tdk_memenuhi = b42_tdk_memenuhi;
	}
	public int getB42_memenuhi() {
		return b42_memenuhi;
	}
	public void setB42_memenuhi(int b42_memenuhi) {
		this.b42_memenuhi = b42_memenuhi;
	}
	public int getB42_sertifikat() {
		return b42_sertifikat;
	}
	public void setB42_sertifikat(int b42_sertifikat) {
		this.b42_sertifikat = b42_sertifikat;
	}
	public int getC41_belum() {
		return c41_belum;
	}
	public void setC41_belum(int c41_belum) {
		this.c41_belum = c41_belum;
	}
	public int getC41_tdk_memenuhi() {
		return c41_tdk_memenuhi;
	}
	public void setC41_tdk_memenuhi(int c41_tdk_memenuhi) {
		this.c41_tdk_memenuhi = c41_tdk_memenuhi;
	}
	public int getC41_memenuhi() {
		return c41_memenuhi;
	}
	public void setC41_memenuhi(int c41_memenuhi) {
		this.c41_memenuhi = c41_memenuhi;
	}
	public int getC41_sertifikat() {
		return c41_sertifikat;
	}
	public void setC41_sertifikat(int c41_sertifikat) {
		this.c41_sertifikat = c41_sertifikat;
	}
	public int getC42_belum() {
		return c42_belum;
	}
	public void setC42_belum(int c42_belum) {
		this.c42_belum = c42_belum;
	}
	public int getC42_tdk_memenuhi() {
		return c42_tdk_memenuhi;
	}
	public void setC42_tdk_memenuhi(int c42_tdk_memenuhi) {
		this.c42_tdk_memenuhi = c42_tdk_memenuhi;
	}
	public int getC42_memenuhi() {
		return c42_memenuhi;
	}
	public void setC42_memenuhi(int c42_memenuhi) {
		this.c42_memenuhi = c42_memenuhi;
	}
	public int getC42_sertifikat() {
		return c42_sertifikat;
	}
	public void setC42_sertifikat(int c42_sertifikat) {
		this.c42_sertifikat = c42_sertifikat;
	}
	public int getC43_belum() {
		return c43_belum;
	}
	public void setC43_belum(int c43_belum) {
		this.c43_belum = c43_belum;
	}
	public int getC43_tdk_memenuhi() {
		return c43_tdk_memenuhi;
	}
	public void setC43_tdk_memenuhi(int c43_tdk_memenuhi) {
		this.c43_tdk_memenuhi = c43_tdk_memenuhi;
	}
	public int getC43_memenuhi() {
		return c43_memenuhi;
	}
	public void setC43_memenuhi(int c43_memenuhi) {
		this.c43_memenuhi = c43_memenuhi;
	}
	public int getC43_sertifikat() {
		return c43_sertifikat;
	}
	public void setC43_sertifikat(int c43_sertifikat) {
		this.c43_sertifikat = c43_sertifikat;
	}
	public int getC44_belum() {
		return c44_belum;
	}
	public void setC44_belum(int c44_belum) {
		this.c44_belum = c44_belum;
	}
	public int getC44_tdk_memenuhi() {
		return c44_tdk_memenuhi;
	}
	public void setC44_tdk_memenuhi(int c44_tdk_memenuhi) {
		this.c44_tdk_memenuhi = c44_tdk_memenuhi;
	}
	public int getC44_memenuhi() {
		return c44_memenuhi;
	}
	public void setC44_memenuhi(int c44_memenuhi) {
		this.c44_memenuhi = c44_memenuhi;
	}
	public int getC44_sertifikat() {
		return c44_sertifikat;
	}
	public void setC44_sertifikat(int c44_sertifikat) {
		this.c44_sertifikat = c44_sertifikat;
	}
	public int getC45_belum() {
		return c45_belum;
	}
	public void setC45_belum(int c45_belum) {
		this.c45_belum = c45_belum;
	}
	public int getC45_tdk_memenuhi() {
		return c45_tdk_memenuhi;
	}
	public void setC45_tdk_memenuhi(int c45_tdk_memenuhi) {
		this.c45_tdk_memenuhi = c45_tdk_memenuhi;
	}
	public int getC45_memenuhi() {
		return c45_memenuhi;
	}
	public void setC45_memenuhi(int c45_memenuhi) {
		this.c45_memenuhi = c45_memenuhi;
	}
	public int getC45_sertifikat() {
		return c45_sertifikat;
	}
	public void setC45_sertifikat(int c45_sertifikat) {
		this.c45_sertifikat = c45_sertifikat;
	}
	public int getC46_belum() {
		return c46_belum;
	}
	public void setC46_belum(int c46_belum) {
		this.c46_belum = c46_belum;
	}
	public int getC46_tdk_memenuhi() {
		return c46_tdk_memenuhi;
	}
	public void setC46_tdk_memenuhi(int c46_tdk_memenuhi) {
		this.c46_tdk_memenuhi = c46_tdk_memenuhi;
	}
	public int getC46_memenuhi() {
		return c46_memenuhi;
	}
	public void setC46_memenuhi(int c46_memenuhi) {
		this.c46_memenuhi = c46_memenuhi;
	}
	public int getC46_sertifikat() {
		return c46_sertifikat;
	}
	public void setC46_sertifikat(int c46_sertifikat) {
		this.c46_sertifikat = c46_sertifikat;
	}
	public int getC47_belum() {
		return c47_belum;
	}
	public void setC47_belum(int c47_belum) {
		this.c47_belum = c47_belum;
	}
	public int getC47_tdk_memenuhi() {
		return c47_tdk_memenuhi;
	}
	public void setC47_tdk_memenuhi(int c47_tdk_memenuhi) {
		this.c47_tdk_memenuhi = c47_tdk_memenuhi;
	}
	public int getC47_memenuhi() {
		return c47_memenuhi;
	}
	public void setC47_memenuhi(int c47_memenuhi) {
		this.c47_memenuhi = c47_memenuhi;
	}
	public int getC47_sertifikat() {
		return c47_sertifikat;
	}
	public void setC47_sertifikat(int c47_sertifikat) {
		this.c47_sertifikat = c47_sertifikat;
	}
	public int getC48_belum() {
		return c48_belum;
	}
	public void setC48_belum(int c48_belum) {
		this.c48_belum = c48_belum;
	}
	public int getC48_tdk_memenuhi() {
		return c48_tdk_memenuhi;
	}
	public void setC48_tdk_memenuhi(int c48_tdk_memenuhi) {
		this.c48_tdk_memenuhi = c48_tdk_memenuhi;
	}
	public int getC48_memenuhi() {
		return c48_memenuhi;
	}
	public void setC48_memenuhi(int c48_memenuhi) {
		this.c48_memenuhi = c48_memenuhi;
	}
	public int getC48_sertifikat() {
		return c48_sertifikat;
	}
	public void setC48_sertifikat(int c48_sertifikat) {
		this.c48_sertifikat = c48_sertifikat;
	}
	public int getD4_belum() {
		return d4_belum;
	}
	public void setD4_belum(int d4_belum) {
		this.d4_belum = d4_belum;
	}
	public int getD4_tdk_memenuhi() {
		return d4_tdk_memenuhi;
	}
	public void setD4_tdk_memenuhi(int d4_tdk_memenuhi) {
		this.d4_tdk_memenuhi = d4_tdk_memenuhi;
	}
	public int getD4_memenuhi() {
		return d4_memenuhi;
	}
	public void setD4_memenuhi(int d4_memenuhi) {
		this.d4_memenuhi = d4_memenuhi;
	}
	public int getD4_sertifikat() {
		return d4_sertifikat;
	}
	public void setD4_sertifikat(int d4_sertifikat) {
		this.d4_sertifikat = d4_sertifikat;
	}
	public int getE41a_belum() {
		return e41a_belum;
	}
	public void setE41a_belum(int e41a_belum) {
		this.e41a_belum = e41a_belum;
	}
	public int getE41a_tdk_memenuhi() {
		return e41a_tdk_memenuhi;
	}
	public void setE41a_tdk_memenuhi(int e41a_tdk_memenuhi) {
		this.e41a_tdk_memenuhi = e41a_tdk_memenuhi;
	}
	public int getE41a_memenuhi() {
		return e41a_memenuhi;
	}
	public void setE41a_memenuhi(int e41a_memenuhi) {
		this.e41a_memenuhi = e41a_memenuhi;
	}
	public int getE41a_sertifikat() {
		return e41a_sertifikat;
	}
	public void setE41a_sertifikat(int e41a_sertifikat) {
		this.e41a_sertifikat = e41a_sertifikat;
	}
	public int getE41b_belum() {
		return e41b_belum;
	}
	public void setE41b_belum(int e41b_belum) {
		this.e41b_belum = e41b_belum;
	}
	public int getE41b_tdk_memenuhi() {
		return e41b_tdk_memenuhi;
	}
	public void setE41b_tdk_memenuhi(int e41b_tdk_memenuhi) {
		this.e41b_tdk_memenuhi = e41b_tdk_memenuhi;
	}
	public int getE41b_memenuhi() {
		return e41b_memenuhi;
	}
	public void setE41b_memenuhi(int e41b_memenuhi) {
		this.e41b_memenuhi = e41b_memenuhi;
	}
	public int getE41b_sertifikat() {
		return e41b_sertifikat;
	}
	public void setE41b_sertifikat(int e41b_sertifikat) {
		this.e41b_sertifikat = e41b_sertifikat;
	}
	public int getE42a_belum() {
		return e42a_belum;
	}
	public void setE42a_belum(int e42a_belum) {
		this.e42a_belum = e42a_belum;
	}
	public int getE42a_tdk_memenuhi() {
		return e42a_tdk_memenuhi;
	}
	public void setE42a_tdk_memenuhi(int e42a_tdk_memenuhi) {
		this.e42a_tdk_memenuhi = e42a_tdk_memenuhi;
	}
	public int getE42a_memenuhi() {
		return e42a_memenuhi;
	}
	public void setE42a_memenuhi(int e42a_memenuhi) {
		this.e42a_memenuhi = e42a_memenuhi;
	}
	public int getE42a_sertifikat() {
		return e42a_sertifikat;
	}
	public void setE42a_sertifikat(int e42a_sertifikat) {
		this.e42a_sertifikat = e42a_sertifikat;
	}
	public int getE42b_belum() {
		return e42b_belum;
	}
	public void setE42b_belum(int e42b_belum) {
		this.e42b_belum = e42b_belum;
	}
	public int getE42b_tdk_memenuhi() {
		return e42b_tdk_memenuhi;
	}
	public void setE42b_tdk_memenuhi(int e42b_tdk_memenuhi) {
		this.e42b_tdk_memenuhi = e42b_tdk_memenuhi;
	}
	public int getE42b_memenuhi() {
		return e42b_memenuhi;
	}
	public void setE42b_memenuhi(int e42b_memenuhi) {
		this.e42b_memenuhi = e42b_memenuhi;
	}
	public int getE42b_sertifikat() {
		return e42b_sertifikat;
	}
	public void setE42b_sertifikat(int e42b_sertifikat) {
		this.e42b_sertifikat = e42b_sertifikat;
	}
	public int getE43_belum() {
		return e43_belum;
	}
	public void setE43_belum(int e43_belum) {
		this.e43_belum = e43_belum;
	}
	public int getE43_tdk_memenuhi() {
		return e43_tdk_memenuhi;
	}
	public void setE43_tdk_memenuhi(int e43_tdk_memenuhi) {
		this.e43_tdk_memenuhi = e43_tdk_memenuhi;
	}
	public int getE43_memenuhi() {
		return e43_memenuhi;
	}
	public void setE43_memenuhi(int e43_memenuhi) {
		this.e43_memenuhi = e43_memenuhi;
	}
	public int getE43_sertifikat() {
		return e43_sertifikat;
	}
	public void setE43_sertifikat(int e43_sertifikat) {
		this.e43_sertifikat = e43_sertifikat;
	}
	public int getE44_belum() {
		return e44_belum;
	}
	public void setE44_belum(int e44_belum) {
		this.e44_belum = e44_belum;
	}
	public int getE44_tdk_memenuhi() {
		return e44_tdk_memenuhi;
	}
	public void setE44_tdk_memenuhi(int e44_tdk_memenuhi) {
		this.e44_tdk_memenuhi = e44_tdk_memenuhi;
	}
	public int getE44_memenuhi() {
		return e44_memenuhi;
	}
	public void setE44_memenuhi(int e44_memenuhi) {
		this.e44_memenuhi = e44_memenuhi;
	}
	public int getE44_sertifikat() {
		return e44_sertifikat;
	}
	public void setE44_sertifikat(int e44_sertifikat) {
		this.e44_sertifikat = e44_sertifikat;
	}
	public int getE45_belum() {
		return e45_belum;
	}
	public void setE45_belum(int e45_belum) {
		this.e45_belum = e45_belum;
	}
	public int getE45_tdk_memenuhi() {
		return e45_tdk_memenuhi;
	}
	public void setE45_tdk_memenuhi(int e45_tdk_memenuhi) {
		this.e45_tdk_memenuhi = e45_tdk_memenuhi;
	}
	public int getE45_memenuhi() {
		return e45_memenuhi;
	}
	public void setE45_memenuhi(int e45_memenuhi) {
		this.e45_memenuhi = e45_memenuhi;
	}
	public int getE45_sertifikat() {
		return e45_sertifikat;
	}
	public void setE45_sertifikat(int e45_sertifikat) {
		this.e45_sertifikat = e45_sertifikat;
	}
	public int getE46_belum() {
		return e46_belum;
	}
	public void setE46_belum(int e46_belum) {
		this.e46_belum = e46_belum;
	}
	public int getE46_tdk_memenuhi() {
		return e46_tdk_memenuhi;
	}
	public void setE46_tdk_memenuhi(int e46_tdk_memenuhi) {
		this.e46_tdk_memenuhi = e46_tdk_memenuhi;
	}
	public int getE46_memenuhi() {
		return e46_memenuhi;
	}
	public void setE46_memenuhi(int e46_memenuhi) {
		this.e46_memenuhi = e46_memenuhi;
	}
	public int getE46_sertifikat() {
		return e46_sertifikat;
	}
	public void setE46_sertifikat(int e46_sertifikat) {
		this.e46_sertifikat = e46_sertifikat;
	}
	public int getE47_belum() {
		return e47_belum;
	}
	public void setE47_belum(int e47_belum) {
		this.e47_belum = e47_belum;
	}
	public int getE47_tdk_memenuhi() {
		return e47_tdk_memenuhi;
	}
	public void setE47_tdk_memenuhi(int e47_tdk_memenuhi) {
		this.e47_tdk_memenuhi = e47_tdk_memenuhi;
	}
	public int getE47_memenuhi() {
		return e47_memenuhi;
	}
	public void setE47_memenuhi(int e47_memenuhi) {
		this.e47_memenuhi = e47_memenuhi;
	}
	public int getE47_sertifikat() {
		return e47_sertifikat;
	}
	public void setE47_sertifikat(int e47_sertifikat) {
		this.e47_sertifikat = e47_sertifikat;
	}
	public int getE48_belum() {
		return e48_belum;
	}
	public void setE48_belum(int e48_belum) {
		this.e48_belum = e48_belum;
	}
	public int getE48_tdk_memenuhi() {
		return e48_tdk_memenuhi;
	}
	public void setE48_tdk_memenuhi(int e48_tdk_memenuhi) {
		this.e48_tdk_memenuhi = e48_tdk_memenuhi;
	}
	public int getE48_memenuhi() {
		return e48_memenuhi;
	}
	public void setE48_memenuhi(int e48_memenuhi) {
		this.e48_memenuhi = e48_memenuhi;
	}
	public int getE48_sertifikat() {
		return e48_sertifikat;
	}
	public void setE48_sertifikat(int e48_sertifikat) {
		this.e48_sertifikat = e48_sertifikat;
	}
	public int getE49_belum() {
		return e49_belum;
	}
	public void setE49_belum(int e49_belum) {
		this.e49_belum = e49_belum;
	}
	public int getE49_tdk_memenuhi() {
		return e49_tdk_memenuhi;
	}
	public void setE49_tdk_memenuhi(int e49_tdk_memenuhi) {
		this.e49_tdk_memenuhi = e49_tdk_memenuhi;
	}
	public int getE49_memenuhi() {
		return e49_memenuhi;
	}
	public void setE49_memenuhi(int e49_memenuhi) {
		this.e49_memenuhi = e49_memenuhi;
	}
	public int getE49_sertifikat() {
		return e49_sertifikat;
	}
	public void setE49_sertifikat(int e49_sertifikat) {
		this.e49_sertifikat = e49_sertifikat;
	}
	public int getA5() {
		return a5;
	}
	public void setA5(int a5) {
		this.a5 = a5;
	}
	public int getB5() {
		return b5;
	}
	public void setB5(int b5) {
		this.b5 = b5;
	}
	public int getA6() {
		return a6;
	}
	public void setA6(int a6) {
		this.a6 = a6;
	}
	public int getB6() {
		return b6;
	}
	public void setB6(int b6) {
		this.b6 = b6;
	}
	public int getC6() {
		return c6;
	}
	public void setC6(int c6) {
		this.c6 = c6;
	}
	
}
