package id.kemenkes.sip.ukme.entity;

import java.io.Serializable;

public class UKME4DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5764523098826662445L;
	
	private String kodePuskesmas = "";
	private String namaPuskesmas = "";
	private Integer provinsi = 0;
	private Integer kotaKabupaten = 0;
	private Integer bulan = 0;
	private Integer tahun = 0;

	private int nomor;
	private String desa;
	
	private int pustu_total = 0;
	private int pustu_lapor = 0;
	private int poskesdes_total = 0;
	private int poskesdes_lapor = 0;
	
	private int l_sb = 0;
	private int p_sb = 0;
	private int j_sb = 0;
	
	private int l_hbo = 0;
	private int p_hbo = 0;
	private int j_hbo = 0;
	
	private int l_bcg = 0;
	private int p_bcg = 0;
	private int j_bcg = 0;
	
	private int l_polio1 = 0;
	private int p_polio1 = 0;
	private int j_polio1 = 0;
	
	private int l_dpt1 = 0;
	private int p_dpt1 = 0;
	private int j_dpt1 = 0;
	
	private int l_polio2 = 0;
	private int p_polio2 = 0;
	private int j_polio2 = 0;
	
	private int l_dpt2 = 0;
	private int p_dpt2 = 0;
	private int j_dpt2 = 0;
	
	private int l_polio3 = 0;
	private int p_polio3 = 0;
	private int j_polio3 = 0;
	
	private int l_ipv = 0;
	private int p_ipv = 0;
	private int j_ipv = 0;
	
	private int l_dpt3 = 0;
	private int p_dpt3 = 0;
	private int j_dpt3 = 0;
	
	private int l_polio4 = 0;
	private int p_polio4 = 0;
	private int j_polio4 = 0;
	
	private int l_campak = 0;
	private int p_campak = 0;
	private int j_campak = 0;
	
	private int l_imunlengkap = 0;
	private int p_imunlengkap = 0;
	private int j_imunlengkap = 0;
	
	private int l_batita = 0;
	private int p_batita = 0;
	private int j_batita = 0;
	
	private int l_batita_dpt1 = 0;
	private int p_batita_dpt1 = 0;
	private int j_batita_dpt1 = 0;
	
	private int l_batita_campak = 0;
	private int p_batita_campak = 0;
	private int j_batita_campak = 0;
	
	private int sasaran_wus = 0;
	private int wus_tt1 = 0;
	private int wus_tt2 = 0;
	private int wus_tt3 = 0;
	private int wus_tt4 = 0;
	private int wus_tt5 = 0;

	public int getWus_tt5() {
		return wus_tt5;
	}
	public void setWus_tt5(int wus_tt5) {
		this.wus_tt5 = wus_tt5;
	}
	public String getKodePuskesmas() {
		return kodePuskesmas;
	}
	public void setKodePuskesmas(String kodePuskesmas) {
		this.kodePuskesmas = kodePuskesmas;
	}
	public String getNamaPuskesmas() {
		return namaPuskesmas;
	}
	public void setNamaPuskesmas(String namaPuskesmas) {
		this.namaPuskesmas = namaPuskesmas;
	}
	public Integer getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(Integer provinsi) {
		this.provinsi = provinsi;
	}
	public Integer getKotaKabupaten() {
		return kotaKabupaten;
	}
	public void setKotaKabupaten(Integer kotaKabupaten) {
		this.kotaKabupaten = kotaKabupaten;
	}
	public Integer getBulan() {
		return bulan;
	}
	public void setBulan(Integer bulan) {
		this.bulan = bulan;
	}
	public Integer getTahun() {
		return tahun;
	}
	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}
	public int getNomor() {
		return nomor;
	}
	public void setNomor(int nomor) {
		this.nomor = nomor;
	}
	public String getDesa() {
		return desa;
	}
	public void setDesa(String desa) {
		this.desa = desa;
	}
	public int getL_sb() {
		return l_sb;
	}
	public void setL_sb(int l_sb) {
		this.l_sb = l_sb;
	}
	public int getP_sb() {
		return p_sb;
	}
	public void setP_sb(int p_sb) {
		this.p_sb = p_sb;
	}
	public int getJ_sb() {
		return j_sb;
	}
	public void setJ_sb(int j_sb) {
		this.j_sb = j_sb;
	}
	public int getL_bcg() {
		return l_bcg;
	}
	public void setL_bcg(int l_bcg) {
		this.l_bcg = l_bcg;
	}
	public int getP_bcg() {
		return p_bcg;
	}
	public void setP_bcg(int p_bcg) {
		this.p_bcg = p_bcg;
	}
	public int getJ_bcg() {
		return j_bcg;
	}
	public void setJ_bcg(int j_bcg) {
		this.j_bcg = j_bcg;
	}
	public int getL_polio1() {
		return l_polio1;
	}
	public void setL_polio1(int l_polio1) {
		this.l_polio1 = l_polio1;
	}
	public int getP_polio1() {
		return p_polio1;
	}
	public void setP_polio1(int p_polio1) {
		this.p_polio1 = p_polio1;
	}
	public int getJ_polio1() {
		return j_polio1;
	}
	public void setJ_polio1(int j_polio1) {
		this.j_polio1 = j_polio1;
	}
	public int getL_dpt1() {
		return l_dpt1;
	}
	public void setL_dpt1(int l_dpt1) {
		this.l_dpt1 = l_dpt1;
	}
	public int getP_dpt1() {
		return p_dpt1;
	}
	public void setP_dpt1(int p_dpt1) {
		this.p_dpt1 = p_dpt1;
	}
	public int getJ_dpt1() {
		return j_dpt1;
	}
	public void setJ_dpt1(int j_dpt1) {
		this.j_dpt1 = j_dpt1;
	}
	public int getL_polio2() {
		return l_polio2;
	}
	public void setL_polio2(int l_polio2) {
		this.l_polio2 = l_polio2;
	}
	public int getP_polio2() {
		return p_polio2;
	}
	public void setP_polio2(int p_polio2) {
		this.p_polio2 = p_polio2;
	}
	public int getJ_polio2() {
		return j_polio2;
	}
	public void setJ_polio2(int j_polio2) {
		this.j_polio2 = j_polio2;
	}
	public int getL_dpt2() {
		return l_dpt2;
	}
	public void setL_dpt2(int l_dpt2) {
		this.l_dpt2 = l_dpt2;
	}
	public int getP_dpt2() {
		return p_dpt2;
	}
	public void setP_dpt2(int p_dpt2) {
		this.p_dpt2 = p_dpt2;
	}
	public int getJ_dpt2() {
		return j_dpt2;
	}
	public void setJ_dpt2(int j_dpt2) {
		this.j_dpt2 = j_dpt2;
	}
	public int getL_polio3() {
		return l_polio3;
	}
	public void setL_polio3(int l_polio3) {
		this.l_polio3 = l_polio3;
	}
	public int getP_polio3() {
		return p_polio3;
	}
	public void setP_polio3(int p_polio3) {
		this.p_polio3 = p_polio3;
	}
	public int getJ_polio3() {
		return j_polio3;
	}
	public void setJ_polio3(int j_polio3) {
		this.j_polio3 = j_polio3;
	}
	public int getL_ipv() {
		return l_ipv;
	}
	public void setL_ipv(int l_ipv) {
		this.l_ipv = l_ipv;
	}
	public int getP_ipv() {
		return p_ipv;
	}
	public void setP_ipv(int p_ipv) {
		this.p_ipv = p_ipv;
	}
	public int getJ_ipv() {
		return j_ipv;
	}
	public void setJ_ipv(int j_ipv) {
		this.j_ipv = j_ipv;
	}
	public int getL_dpt3() {
		return l_dpt3;
	}
	public void setL_dpt3(int l_dpt3) {
		this.l_dpt3 = l_dpt3;
	}
	public int getP_dpt3() {
		return p_dpt3;
	}
	public void setP_dpt3(int p_dpt3) {
		this.p_dpt3 = p_dpt3;
	}
	public int getJ_dpt3() {
		return j_dpt3;
	}
	public void setJ_dpt3(int j_dpt3) {
		this.j_dpt3 = j_dpt3;
	}
	public int getL_polio4() {
		return l_polio4;
	}
	public void setL_polio4(int l_polio4) {
		this.l_polio4 = l_polio4;
	}
	public int getP_polio4() {
		return p_polio4;
	}
	public void setP_polio4(int p_polio4) {
		this.p_polio4 = p_polio4;
	}
	public int getJ_polio4() {
		return j_polio4;
	}
	public void setJ_polio4(int j_polio4) {
		this.j_polio4 = j_polio4;
	}
	public int getL_campak() {
		return l_campak;
	}
	public void setL_campak(int l_campak) {
		this.l_campak = l_campak;
	}
	public int getP_campak() {
		return p_campak;
	}
	public void setP_campak(int p_campak) {
		this.p_campak = p_campak;
	}
	public int getJ_campak() {
		return j_campak;
	}
	public void setJ_campak(int j_campak) {
		this.j_campak = j_campak;
	}
	public int getL_imunlengkap() {
		return l_imunlengkap;
	}
	public void setL_imunlengkap(int l_imunlengkap) {
		this.l_imunlengkap = l_imunlengkap;
	}
	public int getP_imunlengkap() {
		return p_imunlengkap;
	}
	public void setP_imunlengkap(int p_imunlengkap) {
		this.p_imunlengkap = p_imunlengkap;
	}
	public int getJ_imunlengkap() {
		return j_imunlengkap;
	}
	public void setJ_imunlengkap(int j_imunlengkap) {
		this.j_imunlengkap = j_imunlengkap;
	}
	public int getL_batita() {
		return l_batita;
	}
	public void setL_batita(int l_batita) {
		this.l_batita = l_batita;
	}
	public int getP_batita() {
		return p_batita;
	}
	public void setP_batita(int p_batita) {
		this.p_batita = p_batita;
	}
	public int getJ_batita() {
		return j_batita;
	}
	public void setJ_batita(int j_batita) {
		this.j_batita = j_batita;
	}
	public int getL_batita_dpt1() {
		return l_batita_dpt1;
	}
	public void setL_batita_dpt1(int l_batita_dpt1) {
		this.l_batita_dpt1 = l_batita_dpt1;
	}
	public int getP_batita_dpt1() {
		return p_batita_dpt1;
	}
	public void setP_batita_dpt1(int p_batita_dpt1) {
		this.p_batita_dpt1 = p_batita_dpt1;
	}
	public int getJ_batita_dpt1() {
		return j_batita_dpt1;
	}
	public void setJ_batita_dpt1(int j_batita_dpt1) {
		this.j_batita_dpt1 = j_batita_dpt1;
	}
	public int getL_batita_campak() {
		return l_batita_campak;
	}
	public void setL_batita_campak(int l_batita_campak) {
		this.l_batita_campak = l_batita_campak;
	}
	public int getP_batita_campak() {
		return p_batita_campak;
	}
	public void setP_batita_campak(int p_batita_campak) {
		this.p_batita_campak = p_batita_campak;
	}
	public int getJ_batita_campak() {
		return j_batita_campak;
	}
	public void setJ_batita_campak(int j_batita_campak) {
		this.j_batita_campak = j_batita_campak;
	}
	public int getSasaran_wus() {
		return sasaran_wus;
	}
	public void setSasaran_wus(int sasaran_wus) {
		this.sasaran_wus = sasaran_wus;
	}
	public int getWus_tt1() {
		return wus_tt1;
	}
	public void setWus_tt1(int wus_tt1) {
		this.wus_tt1 = wus_tt1;
	}
	public int getWus_tt2() {
		return wus_tt2;
	}
	public void setWus_tt2(int wus_tt2) {
		this.wus_tt2 = wus_tt2;
	}
	public int getWus_tt3() {
		return wus_tt3;
	}
	public void setWus_tt3(int wus_tt3) {
		this.wus_tt3 = wus_tt3;
	}
	public int getWus_tt4() {
		return wus_tt4;
	}
	public void setWus_tt4(int wus_tt4) {
		this.wus_tt4 = wus_tt4;
	}
	public int getPustu_total() {
		return pustu_total;
	}
	public void setPustu_total(int pustu_total) {
		this.pustu_total = pustu_total;
	}
	public int getPustu_lapor() {
		return pustu_lapor;
	}
	public void setPustu_lapor(int pustu_lapor) {
		this.pustu_lapor = pustu_lapor;
	}
	public int getPoskesdes_total() {
		return poskesdes_total;
	}
	public void setPoskesdes_total(int poskesdes_total) {
		this.poskesdes_total = poskesdes_total;
	}
	public int getPoskesdes_lapor() {
		return poskesdes_lapor;
	}
	public void setPoskesdes_lapor(int poskesdes_lapor) {
		this.poskesdes_lapor = poskesdes_lapor;
	}
	public int getL_hbo() {
		return l_hbo;
	}
	public void setL_hbo(int l_hbo) {
		this.l_hbo = l_hbo;
	}
	public int getP_hbo() {
		return p_hbo;
	}
	public void setP_hbo(int p_hbo) {
		this.p_hbo = p_hbo;
	}
	public int getJ_hbo() {
		return j_hbo;
	}
	public void setJ_hbo(int j_hbo) {
		this.j_hbo = j_hbo;
	}

	
}
