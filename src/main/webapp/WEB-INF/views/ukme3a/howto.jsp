<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service UKME 3A. Gizi, Kesehatan Ibu dan Anak</h4>
			<div class="tabs-container">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#tab-form">Form</a></li>
					<li><a data-toggle="tab" href="#tab-url">URL</a></li>
					<li><a data-toggle="tab" href="#tab-ct">Method dan Content
							Type</a></li>
					<li><a data-toggle="tab" href="#tab-request">Contoh
							Request atau PayLoad</a></li>
					<li><a data-toggle="tab" href="#tab-response">Contoh
							Response</a></li>
				</ul>
				<div class="tab-content">
					<div id="tab-form" class="tab-pane active">
						<div class="ibox">
							<div class="ibox-title">{id}
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{kodePuskesmas}/ {namaPuskesmas}</td>
										</tr>
										<tr>
											<td>Provinsi</td>
											<td>{provinsi}</td>
										</tr>
										<tr>
											<td>Kota atau Kabupaten</td>
											<td>{kotaKabupaten}</td>
										</tr>
										<tr>
											<td>Desa</td>
											<td>{desa}</td>
										</tr>
										<tr>
											<td>Bulan/Tahun</td>
											<td>{bulan}/ {tahun}</td>
										</tr>
										<tr>
											<td>Jumlah Puskesmas Pembantu yang Melapor</td>
											<td>{pustu_lapor}dari {pustu_total}</td>
										</tr>
										<tr>
											<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
											<td>{poskesdes_lapor}dari
												{poskesdes_total}</td>
										</tr>
									</tbody>
								</table>
								
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								PROGRAM GIZI
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{a1a}</td>
											<td>{a1b}</td>
										</tr>
										<tr>
											<td>Jumlah Ibu hamil dapat tablet tambah darah minimal
												90 tablet</td>
											<td>{a2a}</td>
											<td>{a2b}</td>
										</tr>
										<tr>
											<td>Jumlah ibu hamil anemia</td>
											<td>{a3a}</td>
											<td>{a3b}</td>
										</tr>
										<tr>
											<td>Jumlah Ibu Nifas dapat Vit. A dosis tinggi (2
												kapsul)</td>
											<td>{a4a}</td>
											<td>{a4b}</td>
										</tr>
										<tr>
											<td>Jumlah Ibu Hamil KEK</td>
											<td>{a5a}</td>
											<td>{a5b}</td>
										</tr>
										<tr>
											<td>Jumlah Ibu Hamil KEK dapat PMT Ibu Bumil</td>
											<td>{a6a}</td>
											<td>{a6b}</td>
										</tr>
										<tr>
											<td>Jumlah Bayi 6-11 bulan mendapat Vit. A (100.000 IU)</td>
											<td>{a7a}</td>
											<td>{a7b}</td>
										</tr>
										<tr>
											<td>Jumlah bayi mendapat ASI ekslusif</td>
											<td>{a8a}</td>
											<td>{a8b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita (terdaftar bulan ini)</td>
											<td>{a9a}</td>
											<td>{a9b}</td>
										</tr>
										<tr>
											<td>Jumlah anak Balita dapat Vit. A dosis tinggi
												(200.000 IU)</td>
											<td>{a10a}</td>
											<td>{a10b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita punya Buku KIA (terdaftar bulan ini)</td>
											<td>{a11a}</td>
											<td>{a11b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita ditimbang (D)</td>
											<td>{a12a}</td>
											<td>{a12b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita ditimbang yang naik berat badannya (N)</td>
											<td>{a13a}</td>
											<td>{a13b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita ditimbang yang tidak naik berat
												badannya (T)</td>
											<td>{a14a}</td>
											<td>{a14b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita ditimbang yang tidak naik berat
												badannya 2 kali berturut-turut (2T)</td>
											<td>{a15a}</td>
											<td>{a15b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita di bawah garis merah (BGM)</td>
											<td>{a16a}</td>
											<td>{a16b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita kurus</td>
											<td>{a17a}</td>
											<td>{a17b}</td>
										</tr>
										<tr>
											<td>Jumlah Balita kurus mendapat makanan tambahan (PMT)</td>
											<td>{a18a}</td>
											<td>{a18b}</td>
										</tr>
										<tr>
											<td>Jumlah kasus Balita gizi buruk</td>
											<td>{a19a}</td>
											<td>{a19b}</td>
										</tr>
										<tr>
											<td>Jumlah Bayi dengan berat badan lahir rendah (BBLR)</td>
											<td>{a20a}</td>
											<td>{a20b}</td>
										</tr>
										<tr>
											<td>Jumlah bayi baru lahir mendapat Inisiasi menyusu
												dini (IMD)</td>
											<td>{a21a}</td>
											<td>{a21b}</td>
										</tr>
										<tr>
											<td>Jumlah remaja putri yang telah mendapat tablet
												tambah darah dalam bulan ini (TTD)</td>
											<td>{a22a}</td>
											<td>{a22b}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								PROGRAM KESEHATAN IBU
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{b1a}</td>
											<td>{b1b}</td>
										</tr>
										<tr>
											<td>2. Jumlah kunjungan K1 ibu hamil</td>
											<td>{b2a}</td>
											<td>{b2b}</td>
										</tr>
										<tr>
											<td>3. Jumlah kunjungan K4 ibu hamil</td>
											<td>{b3a}</td>
											<td>{b3b}</td>
										</tr>
										<tr>
											<td>4. Jumlah ibu nifas yang mendapat pelayanan nifas
												lengkap (KF3)</td>
											<td>{b4a}</td>
											<td>{b4b}</td>
										</tr>
										<tr>
											<td>5. Jumlah kunjungan ibu hamil dengan faktor risiko
												(umur &lt;20 th atau &gt;35th; paritas &gt;4; jarak
												kehamilan &lt;2 th; LiLA &lt;23,5 cm dan TB &lt;145cm)</td>
											<td>{b5a}</td>
											<td>{b5b}</td>
										</tr>
										<tr>
											<td>6. Jumlah ibu hamil risiko tinggi (perdarahan,
												infeksi, abortus, keracunan kehamilan, partus lama) yang
												ditangani</td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>a. Jumlah ibu hamil mengalami perdarahan</td>
											<td>{b6aa}</td>
											<td>{b6ab}</td>
										</tr>
										<tr>
											<td>b. Jumlah ibu hamil dengan malaria</td>
											<td>{b6ba}</td>
											<td>{b6bb}</td>
										</tr>
										<tr>
											<td>c. Jumlah ibu hamil dengan TB</td>
											<td>{b6ca}</td>
											<td>{b6cb}</td>
										</tr>
										<tr>
											<td>d. Jumlah ibu hamil dengan sifilis positif
												(laboratorium)</td>
											<td>{b6da}</td>
											<td>{b6db}</td>
										</tr>
										<tr>
											<td>e. Jumlah ibu hamil dengan HIV positif</td>
											<td>{b6ea}</td>
											<td>{b6eb}</td>
										</tr>
										<tr>
											<td>f. Jumlah ibu hamil dengan infeksi lainnya</td>
											<td>{b6fa}</td>
											<td>{b6fb}</td>
										</tr>
										<tr>
											<td>g. Jumlah keguguran</td>
											<td>{b6ga}</td>
											<td>{b6gb}</td>
										</tr>
										<tr>
											<td>h. Jumlah ibu hamil dengan hipertensi</td>
											<td>{b6ha}</td>
											<td>{b6hb}</td>
										</tr>
										<tr>
											<td>i. Jumlah ibu hamil preeklamsi</td>
											<td>{b6ia}</td>
											<td>{b6ib}</td>
										</tr>
										<tr>
											<td>j. Jumlah ibu hamil dengan eklamsia (keracunan
												kehamilan)</td>
											<td>{b6ja}</td>
											<td>{b6jb}</td>
										</tr>
										<tr>
											<td>k. Jumlah ibu melahirkan dengan partus</td>
											<td>{b6ka}</td>
											<td>{b6kb}</td>
										</tr>
										<tr>
											<td>7. Jumlah ibu hamil, Ibu Bersalin, dan Ibu Nifas
												risiko tinggi (perdarahan, infeksi, abortus, keracunan
												kehamilan, partus lama) yang dirujuk ke RS</td>
											<td>{b7a}</td>
											<td>{b7b}</td>
										</tr>
										<tr>
											<td>8. Jumlah ibu hamil yang mengikuti kelas ibu hamil</td>
											<td>{b8a}</td>
											<td>{b8b}</td>
										</tr>
										<tr>
											<td>9. Jumlah ibu bersalin ditolong tenaga kesehatan
												(bidan/dokter)</td>
											<td>{b9a}</td>
											<td>{b9b}</td>
										</tr>
										<tr>
											<td>10. Jumlah ibu bersalin di fasilitas pelayanan
												kesehatan</td>
											<td>{b10a}</td>
											<td>{b10b}</td>
										</tr>
										<tr>
											<td>11. Jumlah ibu bersalin dan nifas dengan risiko
												ditangani (perdarahan dan infeksi)</td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>a. Jumlah ibu bersalin dan nifas dengan pendarahan</td>
											<td>{b11aa}</td>
											<td>{b11ab}</td>
										</tr>
										<tr>
											<td>b. Jumlah ibu bersalin dan nifas dengan infeksi</td>
											<td>{b11ba}</td>
											<td>{b11bb}</td>
										</tr>
										<tr>
											<td>12. Jumlah ibu bersalin dan nifas dengan risiko
												dirujuk ke RS</td>
											<td>{b12a}</td>
											<td>{b12b}</td>
										</tr>
										<tr>
											<td>13. Jumlah peserta KB aktif (baru/aktif)</td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>a. IUD</td>
											<td>{b13aa}</td>
											<td>{b13ab}</td>
										</tr>
										<tr>
											<td>b. Implan</td>
											<td>{b13ba}</td>
											<td>{b13bb}</td>
										</tr>
										<tr>
											<td>c. Tubektomi</td>
											<td>{b13ca}</td>
											<td>{b13cb}</td>
										</tr>
										<tr>
											<td>d. Vasektomi</td>
											<td>{b13da}</td>
											<td>{b13db}</td>
										</tr>
										<tr>
											<td>e. Suntik</td>
											<td>{b13ea}</td>
											<td>{b13eb}</td>
										</tr>
										<tr>
											<td>f. Pil</td>
											<td>{b13fa}</td>
											<td>{b13fb}</td>
										</tr>
										<tr>
											<td>g. Kondom</td>
											<td>{b13ga}</td>
											<td>{b13gb}</td>
										</tr>
										<tr>
											<td>14. Jumlah Peserta KB Pasca Persalinan (permetode
												kontrasepsi)</td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>a. IUD</td>
											<td>{b14aa}</td>
											<td>{b14ab}</td>
										</tr>
										<tr>
											<td>b. Implan</td>
											<td>{b14ba}</td>
											<td>{b14bb}</td>
										</tr>
										<tr>
											<td>c. Tubektomi</td>
											<td>{b14ca}</td>
											<td>{b14cb}</td>
										</tr>
										<tr>
											<td>d. Vasektomi</td>
											<td>{b14da}</td>
											<td>{b14db}</td>
										</tr>
										<tr>
											<td>e. Suntik</td>
											<td>{b14ea}</td>
											<td>{b14eb}</td>
										</tr>
										<tr>
											<td>f. Pil</td>
											<td>{b14fa}</td>
											<td>{b14fb}</td>
										</tr>
										<tr>
											<td>g. Kondom</td>
											<td>{b14ga}</td>
											<td>{b14gb}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								PROGRAM KESEHATAN ANAK
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{c1a}</td>
											<td>{c1b}</td>
										</tr>
										<tr>
											<td>2. Jumlah Kunjungan Neonatal Lengkap (KN lengkap)</td>
											<td>{c2a}</td>
											<td>{c2b}</td>
										</tr>
										<tr>
											<td>3. Jumlah neonatus dengan komplikasi yang ditangani
											</td>
											<td>{c3a}</td>
											<td>{c3b}</td>
										</tr>
										<tr>
											<td>4. Jumlah neonatus yang mendapat pelayanan skrining
												hipotiroid kongenital (SHK)</td>
											<td>{c4a}</td>
											<td>{c4b}</td>
										</tr>
										<tr>
											<td>5. Jumlah Balita yang telah mendapatkan pelayanan
												stimulasi deteksi dan intervensi dini tumbuh kembang
												(SDIDTK) sebanyak 2 kali dalam tahun ini.</td>
											<td>{c5a}</td>
											<td>{c5b}</td>
										</tr>
										<tr>
											<td>6. Jumlah anak prasekolah yang mendapatkan pelayanan
												SDIDTK sebanyak 2 kali dalam kurun 1 tahun</td>
											<td>{c6a}</td>
											<td>{c6b}</td>
										</tr>
										<tr>
											<td>7. Jumlah remaja (10-18 tahun) yang mendapatkan
												konseling kasus baru remaja oleh tenaga kesehatan</td>
											<td>{c7a}</td>
											<td>{c7b}</td>
										</tr>
										<tr>
											<td>8. Jumlah anak dan remaja (umur &lt;20 tahun) dengan
												disabilitas yang ditangani</td>
											<td>{c8a}</td>
											<td>{c8b}</td>
										</tr>
										<tr>
											<td>9. Jumlah kasus korban kekerasan anak (0-18 tahun)
												yang mendapatkan pelayanan kesehatan (pelayanan medis,
												visum, pelayanan konseling)</td>
											<td>{c9a}</td>
											<td>{c9b}</td>
										</tr>
										<tr>
											<td>10. Jumlah kasus korban kekerasan yang dirujuk
												(medis, psikososial, hukum)</td>
											<td>{c10a}</td>
											<td>{c10b}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>

					</div>
					<div id="tab-url" class="tab-pane">
						<div class="ibox">
							<div class="ibox-title"></div>
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
											<td>Format</td>
											<td><strong>{URL}</strong>/sip/rest/ukme3a/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/ukme3a/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
										</tr>
										<tr>
											<td></td>
											<td><p>
													<strong>*URL</strong> dan <strong>TOKEN</strong> akan
													diberikan oleh Pusdatin Kementerian Kesehatan
												</p></td>
										</tr>
										<tr>
											<td></td>
											<td><img width="90%"
												src="${ pageContext.request.contextPath }/images/url_ukme3a.png" /></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-ct" class="tab-pane">
						<div class="ibox">
							<div class="ibox-title"></div>
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
											<td>Method</td>
											<td>POST</td>
										</tr>
										<tr>
											<td>Content-Type</td>
											<td>application/json</td>
										</tr>
										<tr>
											<td></td>
											<td><img width="90%"
												src="${ pageContext.request.contextPath }/images/ct_ukme1.png" /></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-request" class="tab-pane">
						<div class="ibox">
							<div class="ibox-title"></div>
							<div class="ibox-content">
								<pre id="requestJsonFormat"></pre>
							</div>
						</div>
					</div>
					<div id="tab-response" class="tab-pane">
						<div class="ibox">
							<div class="ibox-title"></div>
							<div class="ibox-content">
								<pre id="responseJsonFormat"></pre>
							</div>
						</div>
					</div>
				</div>

			</div>
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
		document.getElementById("requestJsonFormat").innerHTML = JSON.stringify(${requestJsonFormat}, undefined, 2);
		document.getElementById("responseJsonFormat").innerHTML = JSON.stringify(${responseJsonFormat}, undefined, 2);

	});

	function cancel() {
		document.location.href = "${pageContext.request.contextPath}/web/ukme1/list";
	}
</script>

<commons:footer />