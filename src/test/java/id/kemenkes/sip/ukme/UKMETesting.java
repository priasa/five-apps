package id.kemenkes.sip.ukme;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import id.kemenkes.sip.lt.entity.LT1;
import id.kemenkes.sip.lt.entity.LT1Detail;
import id.kemenkes.sip.lt.entity.LT2;
import id.kemenkes.sip.lt.entity.LT2Detail;
import id.kemenkes.sip.lt.entity.LT3;
import id.kemenkes.sip.pelayanan.entity.PelayananEntity;
import id.kemenkes.sip.ukp.entity.UKP6;
import id.kemenkes.sip.ukp.entity.UKP6Detail;

public class UKMETesting {

	public static void main (String[]args) {
		PelayananEntity pelayananEntity = new PelayananEntity();
		pelayananEntity.setKodePuskesmas("P140101102");
		pelayananEntity.setNamaPuskesmas("BANGKINANG KOTA");
		pelayananEntity.setProvinsi(14);
		pelayananEntity.setKotaKabupaten(1401);
		pelayananEntity.setBulan(11);
		pelayananEntity.setTahun(2016);
		
		pelayananEntity.setSubmittedDate(null);
		pelayananEntity.setNama("nama 01");
		pelayananEntity.setNik_kk("1122334455667788");
		pelayananEntity.setTanggal_kunjungan("04/11/2016");
		pelayananEntity.setNomor_bpjs("BPJS 01");
		pelayananEntity.setKode_diagnosa1("ICD 01");
		pelayananEntity.setKode_diagnosa2("ICD 02");
		pelayananEntity.setKode_diagnosa3("ICD 03");
		pelayananEntity.setKeluhan("Keluhan 01");
		
		pelayananEntity.setSistole(0);
		pelayananEntity.setSistole(0);
		pelayananEntity.setCatatan("Catatan 01");
		pelayananEntity.setPemeriksaan_fisikLain("fisik 01");
		pelayananEntity.setTindakan("Tindakan 01");
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(pelayananEntity));
		
		int a =3;
		long b = 34;
		System.out.println(String.format("%.2f", (float)a/b*100));
		
	}
}
