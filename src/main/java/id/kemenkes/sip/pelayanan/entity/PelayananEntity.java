package id.kemenkes.sip.pelayanan.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PELAYANAN")
public class PelayananEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4096891428855451977L;

	@Id
	private String id;
	private Date submittedDate = new Date();
	
	private String kodePuskesmas = "";
	private String namaPuskesmas = "";
	private Integer provinsi = 0;
	private Integer kotaKabupaten = 0;
	private Integer bulan = 0;
	private Integer tahun = 0;
	
	private String nama = "";
	private String nik_kk = "";
	private String tanggal_kunjungan = "";
	private String nomor_bpjs = "";
	
	private String kode_diagnosa1 = "";
	private String kode_diagnosa2 = "";
	private String kode_diagnosa3 = "";

	private String keluhan = "";
	
	private int sistole = 0;
	private int diastole = 0;
	private double berat_badan = 0;
	private int tinggi_badan = 0;
	private double resp_rate = 0;
	private double heart_rate = 0;
	private String catatan = "";
	private int rujuk_balik = 0;
	
	private String pemeriksaan_fisikLain = "";
	private String tindakan = "";
	
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
	public Integer getKotaKabupaten() {
		return kotaKabupaten;
	}
	public void setKotaKabupaten(Integer kotaKabupaten) {
		this.kotaKabupaten = kotaKabupaten;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getNik_kk() {
		return nik_kk;
	}
	public void setNik_kk(String nik_kk) {
		this.nik_kk = nik_kk;
	}
	public String getTanggal_kunjungan() {
		return tanggal_kunjungan;
	}
	public void setTanggal_kunjungan(String tanggal_kunjungan) {
		this.tanggal_kunjungan = tanggal_kunjungan;
	}
	public String getNomor_bpjs() {
		return nomor_bpjs;
	}
	public void setNomor_bpjs(String nomor_bpjs) {
		this.nomor_bpjs = nomor_bpjs;
	}
	public String getKode_diagnosa1() {
		return kode_diagnosa1;
	}
	public void setKode_diagnosa1(String kode_diagnosa1) {
		this.kode_diagnosa1 = kode_diagnosa1;
	}
	public String getKode_diagnosa2() {
		return kode_diagnosa2;
	}
	public void setKode_diagnosa2(String kode_diagnosa2) {
		this.kode_diagnosa2 = kode_diagnosa2;
	}
	public String getKode_diagnosa3() {
		return kode_diagnosa3;
	}
	public void setKode_diagnosa3(String kode_diagnosa3) {
		this.kode_diagnosa3 = kode_diagnosa3;
	}
	public String getKeluhan() {
		return keluhan;
	}
	public void setKeluhan(String keluhan) {
		this.keluhan = keluhan;
	}
	public int getSistole() {
		return sistole;
	}
	public void setSistole(int sistole) {
		this.sistole = sistole;
	}
	public int getDiastole() {
		return diastole;
	}
	public void setDiastole(int diastole) {
		this.diastole = diastole;
	}
	public double getBerat_badan() {
		return berat_badan;
	}
	public void setBerat_badan(double berat_badan) {
		this.berat_badan = berat_badan;
	}
	public int getTinggi_badan() {
		return tinggi_badan;
	}
	public void setTinggi_badan(int tinggi_badan) {
		this.tinggi_badan = tinggi_badan;
	}
	public double getResp_rate() {
		return resp_rate;
	}
	public void setResp_rate(double resp_rate) {
		this.resp_rate = resp_rate;
	}
	public double getHeart_rate() {
		return heart_rate;
	}
	public void setHeart_rate(double heart_rate) {
		this.heart_rate = heart_rate;
	}
	public String getCatatan() {
		return catatan;
	}
	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}
	public int getRujuk_balik() {
		return rujuk_balik;
	}
	public void setRujuk_balik(int rujuk_balik) {
		this.rujuk_balik = rujuk_balik;
	}
	public String getPemeriksaan_fisikLain() {
		return pemeriksaan_fisikLain;
	}
	public void setPemeriksaan_fisikLain(String pemeriksaan_fisikLain) {
		this.pemeriksaan_fisikLain = pemeriksaan_fisikLain;
	}
	public String getTindakan() {
		return tindakan;
	}
	public void setTindakan(String tindakan) {
		this.tindakan = tindakan;
	}
	
}
