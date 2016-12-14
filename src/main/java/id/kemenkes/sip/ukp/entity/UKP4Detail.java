package id.kemenkes.sip.ukp.entity;

import java.io.Serializable;

public class UKP4Detail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4656855757208021532L;
	
	private int nomor = 0;
	private String jenis_penyakit = "";
	private String icdx = "";
	private int jumlah_baru = 0;
	private int jumlah_lama = 0;
	
	public int getNomor() {
		return nomor;
	}
	public void setNomor(int nomor) {
		this.nomor = nomor;
	}
	public String getJenis_penyakit() {
		return jenis_penyakit;
	}
	public void setJenis_penyakit(String jenis_penyakit) {
		this.jenis_penyakit = jenis_penyakit;
	}
	public String getIcdx() {
		return icdx;
	}
	public void setIcdx(String icdx) {
		this.icdx = icdx;
	}
	public int getJumlah_baru() {
		return jumlah_baru;
	}
	public void setJumlah_baru(int jumlah_baru) {
		this.jumlah_baru = jumlah_baru;
	}
	public int getJumlah_lama() {
		return jumlah_lama;
	}
	public void setJumlah_lama(int jumlah_lama) {
		this.jumlah_lama = jumlah_lama;
	}

	
}
