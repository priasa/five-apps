package id.kemenkes.sip.lt.entity;

import java.io.Serializable;

public class LT1Detail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2655322717140864457L;

	private int nomor = 0;
	private String jenis_namaruangan = "";
	private String jenis_alat = "";
	private int ketersediaan_ada = 0;
	private int ketersediaan_tidakada = 0;
	private String nomor_seri = "";
	private String merk = "";
	private String type = "";
	private String tahun_perolehan = "";
	private String tahun_operasional = "";
	private int kondisi_rusak = 0;
	private int kondisi_berfungsi = 0;
	private String tanggal_kalibrasi = "";
	private String distributor = "";
	private Double harga = 0d;
	private Double apbn = 0d;
	private Double apbd1 = 0d;
	private Double apbd2 = 0d;
	private Double hibah = 0d;
	private String negara_pembuat = "";
	
	public int getNomor() {
		return nomor;
	}
	public void setNomor(int nomor) {
		this.nomor = nomor;
	}
	public String getJenis_namaruangan() {
		return jenis_namaruangan;
	}
	public void setJenis_namaruangan(String jenis_namaruangan) {
		this.jenis_namaruangan = jenis_namaruangan;
	}
	public String getJenis_alat() {
		return jenis_alat;
	}
	public void setJenis_alat(String jenis_alat) {
		this.jenis_alat = jenis_alat;
	}
	public int getKetersediaan_ada() {
		return ketersediaan_ada;
	}
	public void setKetersediaan_ada(int ketersediaan_ada) {
		this.ketersediaan_ada = ketersediaan_ada;
	}
	public int getKetersediaan_tidakada() {
		return ketersediaan_tidakada;
	}
	public void setKetersediaan_tidakada(int ketersediaan_tidakada) {
		this.ketersediaan_tidakada = ketersediaan_tidakada;
	}
	public String getNomor_seri() {
		return nomor_seri;
	}
	public void setNomor_seri(String nomor_seri) {
		this.nomor_seri = nomor_seri;
	}
	public String getMerk() {
		return merk;
	}
	public void setMerk(String merk) {
		this.merk = merk;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTahun_perolehan() {
		return tahun_perolehan;
	}
	public void setTahun_perolehan(String tahun_perolehan) {
		this.tahun_perolehan = tahun_perolehan;
	}
	public String getTahun_operasional() {
		return tahun_operasional;
	}
	public void setTahun_operasional(String tahun_operasional) {
		this.tahun_operasional = tahun_operasional;
	}
	public int getKondisi_rusak() {
		return kondisi_rusak;
	}
	public void setKondisi_rusak(int kondisi_rusak) {
		this.kondisi_rusak = kondisi_rusak;
	}
	public int getKondisi_berfungsi() {
		return kondisi_berfungsi;
	}
	public void setKondisi_berfungsi(int kondisi_berfungsi) {
		this.kondisi_berfungsi = kondisi_berfungsi;
	}
	public String getTanggal_kalibrasi() {
		return tanggal_kalibrasi;
	}
	public void setTanggal_kalibrasi(String tanggal_kalibrasi) {
		this.tanggal_kalibrasi = tanggal_kalibrasi;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	public Double getHarga() {
		return harga;
	}
	public void setHarga(Double harga) {
		this.harga = harga;
	}
	public Double getApbn() {
		return apbn;
	}
	public void setApbn(Double apbn) {
		this.apbn = apbn;
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
	public Double getHibah() {
		return hibah;
	}
	public void setHibah(Double hibah) {
		this.hibah = hibah;
	}
	public String getNegara_pembuat() {
		return negara_pembuat;
	}
	public void setNegara_pembuat(String negara_pembuat) {
		this.negara_pembuat = negara_pembuat;
	}

}
