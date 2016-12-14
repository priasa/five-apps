<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service UKME 5. Penyakit Menular</h4>
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
											<td>Puskesmas</td>
											<td>{kodePuskesmas}/{namaPuskesmas}</td>
										</tr>
										<tr>
											<td>Bulan/Tahun</td>
											<td>{bulan}/{tahun}</td>
										</tr>
										<tr>
											<td>Provinsi</td>
											<td>{provinsi}</td>
										</tr>
										<tr>
											<td>Kota atau Kabupaten</td>
											<td>{kotaKabupaten}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								A. MALARIA (Jumlah Suspek malaria ditemukan)
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah suspek malaria diperiksa mikroskopis/RDT</td>
											<td>{a1}</td>
										</tr>
										<tr>
											<td>2. Jumlah malaria positif (sama dengan jumlah
												malaria positif pada Laporan Bulanan Data Kesakitan)</td>
											<td>{a2}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>Jumlah malaria positif Plasmodium falsiparum</td>
											<td></td>
										</tr>
										<tr>
											<td>3. Malaria positif indigenous</td>
											<td>{a3}</td>
										</tr>
										<tr>
											<td>4. Malaria positif import</td>
											<td>{a4}</td>
										</tr>
										<tr>
											<td>5. Jumlah malaria positif diobati standar</td>
											<td>{a5}</td>
										</tr>
										<tr>
											<td>6. Jumlah kelambu berinsektisida yang dibagikan</td>
											<td>{a6}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								B. DBD (Demam Berdarah Dengue)
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah kelurahan/desa berisiko penularan DBD (ada
												kelompok/cluster dalam 3 tahun terakhir - laporan tahunan)</td>
											<td>{b1}</td>
										</tr>
										<tr>
											<td>2. Jumlah kelurahan/desa berisiko penularan DBD
												diperiksa jentik</td>
											<td>{b2}</td>
										</tr>
										<tr>
											<td>3. Jumlah kelurahan/desa berisiko penularan DBD
												bebas jentik (ada jentik &lt;5 rmh/bangunan)</td>
											<td>{b3}</td>
										</tr>
										<tr>
											<td>4. Jumlah fogging fokus</td>
											<td>{b4}</td>
										</tr>
										<tr>
											<td>5. Jumlah kelurahan/desa yang dilakukan larvasidasi</td>
											<td>{b5}</td>
										</tr>
										<tr>
											<td>6. Jumlah kelurahan/desa yang dilakukan PSN 3M Plus</td>
											<td>{b6}</td>
										</tr>
										<tr>
											<td>7. Jumlah sekolah diperiksa jentik</td>
											<td>{b7}</td>
										</tr>
										<tr>
											<td>8. Jumlah sekolah diperiksa dan bebas dari jentik</td>
											<td>{b8}</td>
										</tr>
										<tr>
											<td>9. Jumlah RS/Puskesmas/klinik diperiksa jentik</td>
											<td>{b9}</td>
										</tr>
										<tr>
											<td>10. Jumlah RS/Puskesmas/klinik diperiksa dan bebas
												dari jentik</td>
											<td>{b10}</td>
										</tr>
										<tr>
											<td>11. Jumlah tempat-tempat umum diperiksa jentik</td>
											<td>{b11}</td>
										</tr>
										<tr>
											<td>12. Jumlah tempat - tempat umum diperiksa dan bebas
												jentik</td>
											<td>{b12}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								C. KECACINGAN
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah anak umur 1-12 tahun yang diperiksa cacing
												pada tinjanya</td>
											<td>{c1}</td>
										</tr>
										<tr>
											<td>2. Jumlah anak umur 1-12 tahun yang ditemukan
												positif telur cacing pada pemeriksaan tinjanya</td>
											<td>{c2}</td>
										</tr>
										<tr>
											<td>3. Jumlah anak umur 1-12 tahun yang minum obat
												cacing (Albendazole)</td>
											<td>{c3}</td>
										</tr>
										<tr>
											<td>4. Jumlah SD/MI yang anak didiknya mendapat obat
												cacing (Albendazole) I</td>
											<td>{c4}</td>
										</tr>
										<tr>
											<td>5. Jumlah ibu hamil dites cacing tinjanya</td>
											<td>{c5}</td>
										</tr>
										<tr>
											<td>6. Jumlah ibu hamil kecacingan ditangani (mendapat
												albendazole) (baru/ulang)</td>
											<td>{c6}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								D. RABIES
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah kasus Gigitan Hewan Penular Rabies (GHPR)</td>
											<td>{d1}</td>
										</tr>
										<tr>
											<td>2. Jumlah kasus GHPR yang mendapatkan Vaksin Anti
												Rabies (VAR) atau Serum Anti Rabies (SAR)</td>
											<td>{d2}</td>
										</tr>
										<tr>
											<td>3. Jumlah kasus Rabies (Kasus Lyssa)</td>
											<td>{d3}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								E. DIARE
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah Penderita diare pada bayi dapat oralit</td>
											<td>{e1}</td>
										</tr>
										<tr>
											<td>2. Jumlah Penderita diare pada bayi dapat Zink</td>
											<td>{e2}</td>
										</tr>
										<tr>
											<td>3. Jumlah Penderita diare pada bayi dapat oralit dan
												Zink</td>
											<td>{e3}</td>
										</tr>
										<tr>
											<td>4. Jumlah Penderita diare pada bayi dapat Infus</td>
											<td>{e4}</td>
										</tr>
										<tr>
											<td>5. Jumlah Penderita diare pada anak balita dapat
												oralit</td>
											<td>{e5}</td>
										</tr>
										<tr>
											<td>6. Jumlah Penderita diare pada anak balita Zink</td>
											<td>{e6}</td>
										</tr>
										<tr>
											<td>7. Jumlah Penderita diare pada anak balita dapat
												oralit dan Zink</td>
											<td>{e7}</td>
										</tr>
										<tr>
											<td>8. Jumlah Penderita diare pada anak balita dapat
												Infus</td>
											<td>{e8}</td>
										</tr>
										<tr>
											<td>9. Jumlah Penderita diare umur &gt;5 tahun dapat
												oralit</td>
											<td>{e9}</td>
										</tr>
										<tr>
											<td>10. Jumlah Penderita diare umur &gt;5 tahun dapat
												infus</td>
											<td>{e10}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								F. HEPATITIS
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah kasus suspek hepatitis yang dirujuk</td>
											<td>{f1}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								G. TB PARU
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah pasien TB paru terkonfirmasi bakteriologis
												(BTA/biakan/tes cepat) baru diobati</td>
											<td>{g1}</td>
										</tr>
										<tr>
											<td>2. Jumlah pasien TB paru terdiagnosis klinis (paru
												BTA negatif, rontgen positif) yang diobati</td>
											<td>{g2}</td>
										</tr>
										<tr>
											<td>3. Jumlah pasien TB anak yang diobati</td>
											<td>{g3}</td>
										</tr>
										<tr>
											<td>4. Jumlah pasien TB paru terkonfirmasi bakteriologis
												baru yang sembuh</td>
											<td>{g4}</td>
										</tr>
										<tr>
											<td>5. Jumlah pasien TB paru terkonfirmasi bakteriologis
												baru yang mendapat pengobatan lengkap</td>
											<td>{g5}</td>
										</tr>
										<tr>
											<td>6. Jumlah pasien TB paru terdiagnosis klinis (paru
												BTA negatif, rontgen positif) baru yang mendapat pengobatan
												lengkap</td>
											<td>{g6}</td>
										</tr>
										<tr>
											<td>7. Jumlah pasien TB kambuh</td>
											<td>{g7}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								I. K U S T A
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah penderita kusta (MB dan PB) baru dengan
												cacat tingkat 0</td>
											<td>{i1}</td>
										</tr>
										<tr>
											<td>2. Jumlah penderita kusta (MB dan PB) baru dengan
												cacat tingkat 1</td>
											<td>{i2}</td>
										</tr>
										<tr>
											<td>3. Jumlah penderita kusta (MB dan PB) baru dengan
												cacat tingkat 2</td>
											<td>{i3}</td>
										</tr>
										<tr>
											<td>4. Jumlah kasus indeks (MB dan PB) yang 20 orang
												kontaknya dilakukan pemeriksaan kusta</td>
											<td>{i4}</td>
										</tr>
										<tr>
											<td>5. Jumlah penderita kusta (PB dan MB) lama masih
												dalam pengobatan MDT</td>
											<td>{i5}</td>
										</tr>
										<tr>
											<td>6. Jumlah penderita kusta baru (MB) yang telah
												menyelesaikan pengobatan (RFT)</td>
											<td>{i6}</td>
										</tr>
										<tr>
											<td>7. Jumlah penderita kusta baru (PB) yang telah
												menyelesaikan pengobatan (RFT)</td>
											<td>{i7}</td>
										</tr>
										<tr>
											<td>8. Jumlah penderita kusta (PB) dinyatakan default</td>
											<td>{i8}</td>
										</tr>
										<tr>
											<td>9. Jumlah penderita kusta (MB) dinyatakan default</td>
											<td>{i9}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								J. FRAMBUSIA
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Jumlah penderita frambusia suspek</td>
											<td></td>
										</tr>
										<tr>
											<td>1. Jumlah penderita frambusia suspek diperiksa
												serologi (pemeriksaan cepat/RDT)</td>
											<td>{j1}</td>
										</tr>
										<tr>
											<td>Jumlah penderita frambusia konfirmasi (RDT +) (sama
												dengan laporan bulanan kesakitan)</td>
											<td></td>
										</tr>
										<tr>
											<td>Jumlah penderita frambusia probable</td>
											<td></td>
										</tr>
										<tr>
											<td>2. Jumlah SD/MI diperiksa frambusia</td>
											<td>{j2}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								K. HIV - AIDS
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah orang dites HIV</td>
											<td>{k1}</td>
										</tr>
										<tr>
											<td>2. Jumlah orang dengan HIV positif</td>
											<td>{k2}</td>
										</tr>
										<tr>
											<td>3. Jumlah ibu hamil dites HIV</td>
											<td>{k3}</td>
										</tr>
										<tr>
											<td>4. Jumlah ibu hamil dengan HIV positif</td>
											<td>{k4}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								L. PENYAKIT KELAMIN
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah orang dengan sifilis</td>
											<td>{l1}</td>
										</tr>
										<tr>
											<td>2. Jumlah orang dengan gram positif</td>
											<td>{l2}</td>
										</tr>
										<tr>
											<td>3. Jumlah ibu hamil dites sifilis</td>
											<td>{l3}</td>
										</tr>
										<tr>
											<td>4. Jumlah ibu hamil dengan sifilis positif</td>
											<td>{l4}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								M. ISPA
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>Jumlah</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah kunjungan Balita batuk atau kesukaran
												bernapas</td>
											<td>{m1}</td>
										</tr>
										<tr>
											<td>2. Jumlah Balita batuk atau kesukaran bernafas yang
												dihitung napas atau dilihat ada tidaknya tarikan dindng dada
												kedalam</td>
											<td>{m2}</td>
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
											<td><strong>{URL}</strong>/sip/rest/ukme5/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/ukme5/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
												src="${ pageContext.request.contextPath }/images/url_ukme5.png" /></td>
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