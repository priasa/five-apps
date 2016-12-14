package id.kemenkes.sip.icd.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bpjs_icd")
public class BpjsIcdEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -421040791863249231L;

	@Id
	@Column(name="kdDiag")
	private String kodeDiagnosa;
	
	@Column(name="nmDiag")
	private String namaDiagnosa;
	
	@Column(name="nonSpesialistik")
	private int nonSpesialistik;

	public String getKodeDiagnosa() {
		return kodeDiagnosa;
	}

	public void setKodeDiagnosa(String kodeDiagnosa) {
		this.kodeDiagnosa = kodeDiagnosa;
	}

	public String getNamaDiagnosa() {
		return namaDiagnosa;
	}

	public void setNamaDiagnosa(String namaDiagnosa) {
		this.namaDiagnosa = namaDiagnosa;
	}

	public int getNonSpesialistik() {
		return nonSpesialistik;
	}

	public void setNonSpesialistik(int nonSpesialistik) {
		this.nonSpesialistik = nonSpesialistik;
	}

	
	
}
