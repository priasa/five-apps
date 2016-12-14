package id.kemenkes.sip.lt.entity;

import java.io.Serializable;

public class LT2Detail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9150169687931193969L;

	private int nomor = 0;
	private String kode_unit = "";
	private String nik = "";
	private String nip_id = "";
	private String nama = "";
	private String jenis_kelamin = "";
	private String status_kepegawaian = "";
	private String kode_sdmk = "";
	private String tanggal_mulai = "";
	private String tanggal_berakhir = "";
	private String kode_pendidikan = "";
	private String tahun_lulus = "";
	private String riwayat_pelatihan = "";
	private String jabatan = "";
	private String jenjang_jabatan = "";
	private String tahun_jabatan = "";
	private String email = "";
	
	public int getNomor() {
		return nomor;
	}
	public void setNomor(int nomor) {
		this.nomor = nomor;
	}
	public String getKode_unit() {
		return kode_unit;
	}
	public void setKode_unit(String kode_unit) {
		this.kode_unit = kode_unit;
	}
	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getNip_id() {
		return nip_id;
	}
	public void setNip_id(String nip_id) {
		this.nip_id = nip_id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getJenis_kelamin() {
		return jenis_kelamin;
	}
	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}
	public String getStatus_kepegawaian() {
		return status_kepegawaian;
	}
	public void setStatus_kepegawaian(String status_kepegawaian) {
		this.status_kepegawaian = status_kepegawaian;
	}
	public String getKode_sdmk() {
		return kode_sdmk;
	}
	public void setKode_sdmk(String kode_sdmk) {
		this.kode_sdmk = kode_sdmk;
	}
	public String getTanggal_mulai() {
		return tanggal_mulai;
	}
	public void setTanggal_mulai(String tanggal_mulai) {
		this.tanggal_mulai = tanggal_mulai;
	}
	public String getTanggal_berakhir() {
		return tanggal_berakhir;
	}
	public void setTanggal_berakhir(String tanggal_berakhir) {
		this.tanggal_berakhir = tanggal_berakhir;
	}
	public String getKode_pendidikan() {
		return kode_pendidikan;
	}
	public void setKode_pendidikan(String kode_pendidikan) {
		this.kode_pendidikan = kode_pendidikan;
	}
	public String getTahun_lulus() {
		return tahun_lulus;
	}
	public void setTahun_lulus(String tahun_lulus) {
		this.tahun_lulus = tahun_lulus;
	}
	public String getRiwayat_pelatihan() {
		return riwayat_pelatihan;
	}
	public void setRiwayat_pelatihan(String riwayat_pelatihan) {
		this.riwayat_pelatihan = riwayat_pelatihan;
	}
	public String getJabatan() {
		return jabatan;
	}
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public String getJenjang_jabatan() {
		return jenjang_jabatan;
	}
	public void setJenjang_jabatan(String jenjang_jabatan) {
		this.jenjang_jabatan = jenjang_jabatan;
	}
	public String getTahun_jabatan() {
		return tahun_jabatan;
	}
	public void setTahun_jabatan(String tahun_jabatan) {
		this.tahun_jabatan = tahun_jabatan;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
