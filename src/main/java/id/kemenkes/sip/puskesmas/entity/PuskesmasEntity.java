package id.kemenkes.sip.puskesmas.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_puskesmas")
public class PuskesmasEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1400263255223959046L;

	@Id
	private String kode;
	private String nama;
	private Integer kabupaten;
	private Integer provinsi;
	
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Integer getKabupaten() {
		return kabupaten;
	}
	public void setKabupaten(Integer kabupaten) {
		this.kabupaten = kabupaten;
	}
	public Integer getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(Integer provinsi) {
		this.provinsi = provinsi;
	}
	
	
}
