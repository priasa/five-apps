package id.kemenkes.sip.ukp.entity;

import java.io.Serializable;

public class UKP5Detail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6632238312028419742L;
	
	private String nomor = "";
	private String tanggal = "";
	private String nik_nkk = "";
	private String nama = "";
	private String kepala_keluarga = "";
	private String alamat_lengkap = "";
	private String tanggal_lahir = "";
	private String jenis_kelamin = "";
	private String tanggal_meninggal = "";
	private String lokasi_meninggal = "";
	private String sebab_langsung = "";
	private String sebab_dasar = "";
	private String penyakit_penyerta = "";
	
	public String getNomor() {
		return nomor;
	}
	public void setNomor(String nomor) {
		this.nomor = nomor;
	}
	public String getNik_nkk() {
		return nik_nkk;
	}
	public void setNik_nkk(String nik_nkk) {
		this.nik_nkk = nik_nkk;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getKepala_keluarga() {
		return kepala_keluarga;
	}
	public void setKepala_keluarga(String kepala_keluarga) {
		this.kepala_keluarga = kepala_keluarga;
	}
	public String getAlamat_lengkap() {
		return alamat_lengkap;
	}
	public void setAlamat_lengkap(String alamat_lengkap) {
		this.alamat_lengkap = alamat_lengkap;
	}
	public String getJenis_kelamin() {
		return jenis_kelamin;
	}
	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}
	public String getLokasi_meninggal() {
		return lokasi_meninggal;
	}
	public void setLokasi_meninggal(String lokasi_meninggal) {
		this.lokasi_meninggal = lokasi_meninggal;
	}
	public String getSebab_langsung() {
		return sebab_langsung;
	}
	public void setSebab_langsung(String sebab_langsung) {
		this.sebab_langsung = sebab_langsung;
	}
	public String getSebab_dasar() {
		return sebab_dasar;
	}
	public void setSebab_dasar(String sebab_dasar) {
		this.sebab_dasar = sebab_dasar;
	}
	public String getPenyakit_penyerta() {
		return penyakit_penyerta;
	}
	public void setPenyakit_penyerta(String penyakit_penyerta) {
		this.penyakit_penyerta = penyakit_penyerta;
	}
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	public String getTanggal_lahir() {
		return tanggal_lahir;
	}
	public void setTanggal_lahir(String tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}
	public String getTanggal_meninggal() {
		return tanggal_meninggal;
	}
	public void setTanggal_meninggal(String tanggal_meninggal) {
		this.tanggal_meninggal = tanggal_meninggal;
	}
	
}
