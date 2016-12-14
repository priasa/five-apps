package id.kemenkes.sip.ukp.entity;

import java.io.Serializable;

public class UKP6Detail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2652775637267404458L;

	private String nomor = "";
	private String kode_obat = "";
	private String nama_obat ="";
	private String satuan = "";
	private Double stok_awal = 0d;
	private Double penerimaan = 0d;
	private Double persedian = 0d;
	private Double pemakaian = 0d;
	private Double stok_akhir = 0d;
	private Double stok_optimum = 0d;
	private Double permintaan = 0d;
	
	private Double apbd1 = 0d;
	private Double apbd2 = 0d;
	private Double dak = 0d;
	private Double program = 0d;
	private Double lain_lain = 0d;
	private Double jumlah_pemberian = 0d;
	
	public String getNomor() {
		return nomor;
	}
	public void setNomor(String nomor) {
		this.nomor = nomor;
	}
	public String getKode_obat() {
		return kode_obat;
	}
	public void setKode_obat(String kode_obat) {
		this.kode_obat = kode_obat;
	}
	public String getNama_obat() {
		return nama_obat;
	}
	public void setNama_obat(String nama_obat) {
		this.nama_obat = nama_obat;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	public Double getStok_awal() {
		return stok_awal;
	}
	public void setStok_awal(Double stok_awal) {
		this.stok_awal = stok_awal;
	}
	public Double getPenerimaan() {
		return penerimaan;
	}
	public void setPenerimaan(Double penerimaan) {
		this.penerimaan = penerimaan;
	}
	public Double getPersedian() {
		return persedian;
	}
	public void setPersedian(Double persedian) {
		this.persedian = persedian;
	}
	public Double getPemakaian() {
		return pemakaian;
	}
	public void setPemakaian(Double pemakaian) {
		this.pemakaian = pemakaian;
	}
	public Double getStok_akhir() {
		return stok_akhir;
	}
	public void setStok_akhir(Double stok_akhir) {
		this.stok_akhir = stok_akhir;
	}
	public Double getStok_optimum() {
		return stok_optimum;
	}
	public void setStok_optimum(Double stok_optimum) {
		this.stok_optimum = stok_optimum;
	}
	public Double getPermintaan() {
		return permintaan;
	}
	public void setPermintaan(Double permintaan) {
		this.permintaan = permintaan;
	}
	public Double getApbd1() {
		return apbd1;
	}
	public void setApbd1(Double apbd1) {
		this.apbd1 = apbd1;
	}
	public Double getApbd2() {
		return apbd2;
	}
	public void setApbd2(Double apbd2) {
		this.apbd2 = apbd2;
	}
	public Double getDak() {
		return dak;
	}
	public void setDak(Double dak) {
		this.dak = dak;
	}
	public Double getProgram() {
		return program;
	}
	public void setProgram(Double program) {
		this.program = program;
	}
	public Double getLain_lain() {
		return lain_lain;
	}
	public void setLain_lain(Double lain_lain) {
		this.lain_lain = lain_lain;
	}
	public Double getJumlah_pemberian() {
		return jumlah_pemberian;
	}
	public void setJumlah_pemberian(Double jumlah_pemberian) {
		this.jumlah_pemberian = jumlah_pemberian;
	}
	
}
