package id.kemenkes.sip.provinsi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_provinsi")
public class ProvinsiEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6812838213967532298L;

	@Id
	private Integer kode;
	private String nama;
	
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
	
	
}
