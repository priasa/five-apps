<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukme3a.id}
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>Puskesmas</td>
								<td>${ukme3a.kodePuskesmas} / ${ukme3a.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Desa</td>
								<td>${ukme3a.desa}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukme3a.bulan} / ${ukme3a.tahun}</td>
							</tr>
							<tr>
								<td>Jumlah Puskesmas Pembantu yang Melapor</td>
								<td>${ukme3a.pustu_lapor} dari ${ukme3a.pustu_total}</td>
							</tr>
							<tr>
								<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
								<td>${ukme3a.poskesdes_lapor} dari ${ukme3a.poskesdes_total}</td>
							</tr>
					</tbody>
			</table>
			<div class="row tableAction">
					<div class="col-sm-8">
						<button type="button" class="btn btn-success btn-sm" onclick="cancel()">
							<fmt:message key="general.back" />
						</button>
					</div>
				</div>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">PROGRAM GIZI
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>Jumlah ibu hamil terdaftar bulan ini</td>
								<td>${ukme3a.a1a}</td>
								<td>${ukme3a.a1b}</td>
							</tr>
							<tr>
								<td>Jumlah Ibu hamil dapat tablet tambah darah minimal 90 tablet</td>
								<td>${ukme3a.a2a}</td>
								<td>${ukme3a.a2b}</td>
							</tr>
							<tr>
								<td>Jumlah ibu hamil anemia</td>
								<td>${ukme3a.a3a}</td>
								<td>${ukme3a.a3b}</td>
							</tr>
							<tr>
								<td>Jumlah Ibu Nifas dapat Vit. A dosis tinggi (2 kapsul)</td>
								<td>${ukme3a.a4a}</td>
								<td>${ukme3a.a4b}</td>
							</tr>
							<tr>
								<td>Jumlah Ibu Hamil KEK</td>
								<td>${ukme3a.a5a}</td>
								<td>${ukme3a.a5b}</td>
							</tr>
							<tr>
								<td>Jumlah Ibu Hamil KEK dapat PMT Ibu Bumil</td>
								<td>${ukme3a.a6a}</td>
								<td>${ukme3a.a6b}</td>
							</tr>
							<tr>
								<td>Jumlah Bayi 6-11 bulan mendapat Vit. A (100.000 IU)</td>
								<td>${ukme3a.a7a}</td>
								<td>${ukme3a.a7b}</td>
							</tr>
							<tr>
								<td>Jumlah bayi mendapat ASI ekslusif</td>
								<td>${ukme3a.a8a}</td>
								<td>${ukme3a.a8b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita (terdaftar bulan ini)</td>
								<td>${ukme3a.a9a}</td>
								<td>${ukme3a.a9b}</td>
							</tr>
							<tr>
								<td>Jumlah anak Balita dapat Vit. A dosis tinggi (200.000 IU)</td>
								<td>${ukme3a.a10a}</td>
								<td>${ukme3a.a10b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita punya Buku KIA (terdaftar bulan ini)</td>
								<td>${ukme3a.a11a}</td>
								<td>${ukme3a.a11b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita ditimbang (D)</td>
								<td>${ukme3a.a12a}</td>
								<td>${ukme3a.a12b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita ditimbang yang naik berat badannya (N)</td>
								<td>${ukme3a.a13a}</td>
								<td>${ukme3a.a13b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita ditimbang yang tidak naik berat badannya (T)</td>
								<td>${ukme3a.a14a}</td>
								<td>${ukme3a.a14b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita ditimbang yang tidak naik berat badannya 2 kali berturut-turut (2T)</td>
								<td>${ukme3a.a15a}</td>
								<td>${ukme3a.a15b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita di bawah garis merah (BGM)</td>
								<td>${ukme3a.a16a}</td>
								<td>${ukme3a.a16b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita kurus</td>
								<td>${ukme3a.a17a}</td>
								<td>${ukme3a.a17b}</td>
							</tr>
							<tr>
								<td>Jumlah Balita kurus mendapat makanan tambahan (PMT)</td>
								<td>${ukme3a.a18a}</td>
								<td>${ukme3a.a18b}</td>
							</tr>
							<tr>
								<td>Jumlah kasus Balita gizi buruk</td>
								<td>${ukme3a.a19a}</td>
								<td>${ukme3a.a19b}</td>
							</tr>
							<tr>
								<td>Jumlah Bayi dengan berat badan lahir rendah (BBLR)</td>
								<td>${ukme3a.a20a}</td>
								<td>${ukme3a.a20b}</td>
							</tr>
							<tr>
								<td>Jumlah bayi baru lahir mendapat Inisiasi menyusu dini (IMD)</td>
								<td>${ukme3a.a21a}</td>
								<td>${ukme3a.a21b}</td>
							</tr>
							<tr>
								<td>Jumlah remaja putri yang telah mendapat tablet tambah darah dalam bulan ini (TTD)</td>
								<td>${ukme3a.a22a}</td>
								<td>${ukme3a.a22b}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">PROGRAM KESEHATAN IBU
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah kunjungan KA Ibu Hamil</td>
								<td>${ukme3a.b1a}</td>
								<td>${ukme3a.b1b}</td>
							</tr>
							<tr>
								<td>2. Jumlah kunjungan K1 ibu hamil</td>
								<td>${ukme3a.b2a}</td>
								<td>${ukme3a.b2b}</td>
							</tr>
							<tr>
								<td>3. Jumlah kunjungan K4 ibu hamil</td>
								<td>${ukme3a.b3a}</td>
								<td>${ukme3a.b3b}</td>
							</tr>
							<tr>
								<td>4. Jumlah ibu nifas yang mendapat pelayanan nifas lengkap (KF3)</td>
								<td>${ukme3a.b4a}</td>
								<td>${ukme3a.b4b}</td>
							</tr>
							<tr>
								<td>5. Jumlah kunjungan ibu hamil dengan faktor risiko (umur &lt;20 th atau &gt;35th;  paritas &gt;4;  jarak kehamilan &lt;2 th; LiLA &lt;23,5 cm dan TB &lt;145cm)</td>
								<td>${ukme3a.b5a}</td>
								<td>${ukme3a.b5b}</td>
							</tr>
							<tr>
								<td>6. Jumlah ibu hamil risiko tinggi (perdarahan, infeksi, abortus, keracunan kehamilan, partus lama) yang ditangani </td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>a.	Jumlah ibu hamil mengalami perdarahan</td>
								<td>${ukme3a.b6aa}</td>
								<td>${ukme3a.b6ab}</td>
							</tr>
							<tr>
								<td>b.	Jumlah ibu hamil dengan malaria </td>
								<td>${ukme3a.b6ba}</td>
								<td>${ukme3a.b6bb}</td>
							</tr>
							<tr>
								<td>c.	Jumlah ibu hamil dengan TB</td>
								<td>${ukme3a.b6ca}</td>
								<td>${ukme3a.b6cb}</td>
							</tr>
							<tr>
								<td>d.	Jumlah ibu hamil dengan sifilis positif (laboratorium)</td>
								<td>${ukme3a.b6da}</td>
								<td>${ukme3a.b6db}</td>
							</tr>
							<tr>
								<td>e.	Jumlah ibu hamil dengan HIV positif </td>
								<td>${ukme3a.b6ea}</td>
								<td>${ukme3a.b6eb}</td>
							</tr>
							<tr>
								<td>f.	Jumlah ibu hamil dengan infeksi lainnya</td>
								<td>${ukme3a.b6fa}</td>
								<td>${ukme3a.b6fb}</td>
							</tr>
							<tr>
								<td>g.	Jumlah keguguran</td>
								<td>${ukme3a.b6ga}</td>
								<td>${ukme3a.b6gb}</td>
							</tr>
							<tr>
								<td>h.	Jumlah ibu hamil dengan hipertensi  </td>
								<td>${ukme3a.b6ha}</td>
								<td>${ukme3a.b6hb}</td>
							</tr>
							<tr>
								<td>i.	Jumlah ibu hamil preeklamsi </td>
								<td>${ukme3a.b6ia}</td>
								<td>${ukme3a.b6ib}</td>
							</tr>
							<tr>
								<td>j.	Jumlah ibu hamil dengan eklamsia (keracunan kehamilan) </td>
								<td>${ukme3a.b6ja}</td>
								<td>${ukme3a.b6jb}</td>
							</tr>
							<tr>
								<td>k.	Jumlah ibu melahirkan dengan partus </td>
								<td>${ukme3a.b6ka}</td>
								<td>${ukme3a.b6kb}</td>
							</tr>
							<tr>
								<td>7. Jumlah ibu hamil, Ibu Bersalin, dan Ibu Nifas  risiko tinggi (perdarahan, infeksi, abortus, keracunan kehamilan, partus lama)  yang dirujuk ke RS</td>
								<td>${ukme3a.b7a}</td>
								<td>${ukme3a.b7b}</td>
							</tr>
							<tr>
								<td>8. Jumlah ibu hamil yang mengikuti kelas ibu hamil</td>
								<td>${ukme3a.b8a}</td>
								<td>${ukme3a.b8b}</td>
							</tr>
							<tr>
								<td>9. Jumlah ibu bersalin ditolong tenaga kesehatan (bidan/dokter)</td>
								<td>${ukme3a.b9a}</td>
								<td>${ukme3a.b9b}</td>
							</tr>
							<tr>
								<td>10. Jumlah ibu bersalin di fasilitas pelayanan kesehatan </td>
								<td>${ukme3a.b10a}</td>
								<td>${ukme3a.b10b}</td>
							</tr>
							<tr>
								<td>11. Jumlah ibu bersalin dan nifas  dengan risiko ditangani (perdarahan dan infeksi)</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>a.	Jumlah ibu bersalin dan nifas dengan  pendarahan</td>
								<td>${ukme3a.b11aa}</td>
								<td>${ukme3a.b11ab}</td>
							</tr>
							<tr>
								<td>b.	Jumlah ibu bersalin dan nifas dengan infeksi </td>
								<td>${ukme3a.b11ba}</td>
								<td>${ukme3a.b11bb}</td>
							</tr>
							<tr>
								<td>12. Jumlah ibu bersalin dan nifas dengan risiko dirujuk ke RS</td>
								<td>${ukme3a.b12a}</td>
								<td>${ukme3a.b12b}</td>
							</tr> 
							<tr>
								<td>13. Jumlah peserta KB aktif (baru/aktif)</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>a.	IUD</td>
								<td>${ukme3a.b13aa}</td>
								<td>${ukme3a.b13ab}</td>
							</tr>
							<tr>
								<td>b.	Implan</td>
								<td>${ukme3a.b13ba}</td>
								<td>${ukme3a.b13bb}</td>
							</tr>
							<tr>
								<td>c.	Tubektomi</td>
								<td>${ukme3a.b13ca}</td>
								<td>${ukme3a.b13cb}</td>
							</tr>
							<tr>
								<td>d.	Vasektomi</td>
								<td>${ukme3a.b13da}</td>
								<td>${ukme3a.b13db}</td>
							</tr>
							<tr>
								<td>e.	Suntik</td>
								<td>${ukme3a.b13ea}</td>
								<td>${ukme3a.b13eb}</td>
							</tr>
							<tr>
								<td>f.	Pil</td>
								<td>${ukme3a.b13fa}</td>
								<td>${ukme3a.b13fb}</td>
							</tr>
							<tr>
								<td>g.	Kondom</td>
								<td>${ukme3a.b13ga}</td>
								<td>${ukme3a.b13gb}</td>
							</tr>
							<tr>
								<td>14. Jumlah Peserta KB Pasca Persalinan (permetode kontrasepsi)</td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>a.	IUD</td>
								<td>${ukme3a.b14aa}</td>
								<td>${ukme3a.b14ab}</td>
							</tr>
							<tr>
								<td>b.	Implan</td>
								<td>${ukme3a.b14ba}</td>
								<td>${ukme3a.b14bb}</td>
							</tr>
							<tr>
								<td>c.	Tubektomi</td>
								<td>${ukme3a.b14ca}</td>
								<td>${ukme3a.b14cb}</td>
							</tr>
							<tr>
								<td>d.	Vasektomi</td>
								<td>${ukme3a.b14da}</td>
								<td>${ukme3a.b14db}</td>
							</tr>
							<tr>
								<td>e.	Suntik</td>
								<td>${ukme3a.b14ea}</td>
								<td>${ukme3a.b14eb}</td>
							</tr>
							<tr>
								<td>f.	Pil</td>
								<td>${ukme3a.b14fa}</td>
								<td>${ukme3a.b14fb}</td>
							</tr>
							<tr>
								<td>g.	Kondom</td>
								<td>${ukme3a.b14ga}</td>
								<td>${ukme3a.b14gb}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">PROGRAM KESEHATAN ANAK
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah Kunjungan Neonatal Pertama (KN1)</td>
								<td>${ukme3a.c1a}</td>
								<td>${ukme3a.c1b}</td>
							</tr>
							<tr>
								<td>2. Jumlah Kunjungan Neonatal Lengkap (KN lengkap)</td>
								<td>${ukme3a.c2a}</td>
								<td>${ukme3a.c2b}</td>
							</tr>
							<tr>
								<td>3. Jumlah neonatus dengan komplikasi yang ditangani </td>
								<td>${ukme3a.c3a}</td>
								<td>${ukme3a.c3b}</td>
							</tr>
							<tr>
								<td>4. Jumlah neonatus yang mendapat pelayanan skrining hipotiroid kongenital (SHK)</td>
								<td>${ukme3a.c4a}</td>
								<td>${ukme3a.c4b}</td>
							</tr>
							<tr>
								<td>5. Jumlah Balita yang telah mendapatkan pelayanan stimulasi deteksi dan intervensi dini tumbuh kembang (SDIDTK) sebanyak 2 kali dalam tahun ini.</td>
								<td>${ukme3a.c5a}</td>
								<td>${ukme3a.c5b}</td>
							</tr>
							<tr>
								<td>6. Jumlah anak prasekolah yang mendapatkan pelayanan SDIDTK sebanyak 2 kali dalam kurun 1 tahun</td>
								<td>${ukme3a.c6a}</td>
								<td>${ukme3a.c6b}</td>
							</tr>
							<tr>
								<td>7. Jumlah remaja (10-18 tahun) yang mendapatkan konseling kasus baru remaja oleh tenaga kesehatan</td>
								<td>${ukme3a.c7a}</td>
								<td>${ukme3a.c7b}</td>
							</tr>
							<tr>
								<td>8. Jumlah anak dan remaja (umur &lt;20 tahun) dengan disabilitas yang ditangani </td>
								<td>${ukme3a.c8a}</td>
								<td>${ukme3a.c8b}</td>
							</tr>
							<tr>
								<td>9. Jumlah kasus korban kekerasan anak (0-18 tahun) yang mendapatkan pelayanan kesehatan (pelayanan medis, visum, pelayanan konseling)</td>
								<td>${ukme3a.c9a}</td>
								<td>${ukme3a.c9b}</td>
							</tr>
							<tr>
								<td>10. Jumlah kasus korban kekerasan yang dirujuk (medis, psikososial, hukum)</td>
								<td>${ukme3a.c10a}</td>
								<td>${ukme3a.c10b}</td>
							</tr>
					</tbody>
			</table>
		</div>	
	</div>
</div>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui-1.11.0.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.datepicker').datetimepicker({
			pickTime : false,
			dateFormat : 'dd/mm/yy',
			minDate : new Date()
		});
	});

	function cancel() {
		document.location.href = "${pageContext.request.contextPath}/web/ukme3a/list";
	}
</script>

<commons:footer />