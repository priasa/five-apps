package id.kemenkes.sip.laporan.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_laporan")
public class LaporanEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2329810961854141787L;
	
	@Id
	private String kode;
	private String nama;
	
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
	
	
}
