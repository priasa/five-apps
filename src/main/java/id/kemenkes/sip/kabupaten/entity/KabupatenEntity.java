package id.kemenkes.sip.kabupaten.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_kabupaten")
public class KabupatenEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6812838213967532298L;

	@Id
	private Integer kode;
	private String nama;
	private Integer provinsi;
	
	public Integer getKode() {
		return kode;
	}
	public void setKode(Integer kode) {
		this.kode = kode;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Integer getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(Integer provinsi) {
		this.provinsi = provinsi;
	}
	
	
}
