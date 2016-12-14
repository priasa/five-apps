<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service UKME 7. Perkesmas</h4>
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
								1. PERKESMAS Individu
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th>Kegiatan</th>
											<th>Data</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>a. Jumlah individu yang mendapatkan asuhan
												keperawatan di rawat jalan</td>
											<td>{a1a}</td>
										</tr>
										<tr>
											<td>b. Jumlah individu yang mendapatkan asuhan
												keperawatan di gawat darurat</td>
											<td>{a1b}</td>
										</tr>
										<tr>
											<td>c. Jumlah individu yang mendapatkan asuhan
												keperawatan di rawat inap</td>
											<td>{a1c}</td>
										</tr>
										<tr>
											<td>d. Jumlah individu yang mendapatkan asuhan
												keperawatan di one day care</td>
											<td>{a1d}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								2. PERKESMAS Keluarga
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th>Kegiatan</th>
											<th>Binaan Baru</th>
											<th>Binaan Lanjutan</th>
											<th>Binaan Lepas</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>a. Sasaran, target dan Cakupan :</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>1. Jumlah Sasaran</td>
											<td>{b2a1_baru}</td>
											<td>{b2a1_lanjutan}</td>
											<td>{b2a1_lepas}</td>
											<td>{b2a1_total}</td>
										</tr>
										<tr>
											<td>2. Jumlah Target</td>
											<td>{b2a2_baru}</td>
											<td>{b2a2_lanjutan}</td>
											<td>{b2a2_lepas}</td>
											<td>{b2a2_total}</td>
										</tr>
										<tr>
											<td>3. Jumlah Sasaran</td>
											<td>{b2a3_baru}</td>
											<td>{b2a3_lanjutan}</td>
											<td>{b2a3_lepas}</td>
											<td>{b2a3_total}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>b. Pelaksaan Bina Keluarga (PERKESMAS) :</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>1. Jumlah keluarga binaan</td>
											<td>{b2b1_baru}</td>
											<td>{b2b1_lanjutan}</td>
											<td>{b2b1_lepas}</td>
											<td>{b2b1_total}</td>
										</tr>
										<tr>
											<td>2. Jumlah kunjungan bina keluarga</td>
											<td>{b2b2_baru}</td>
											<td>{b2b2_lanjutan}</td>
											<td>{b2b2_lepas}</td>
											<td>{b2b2_total}</td>
										</tr>
										<tr>
											<td>3a. Jumlah kasus baru ditemukan pada keluarga binaan</td>
											<td>{b2b3a_baru}</td>
											<td>{b2b3a_lanjutan}</td>
											<td>{b2b3a_lepas}</td>
											<td>{b2b3a_total}</td>
										</tr>
										<tr>
											<td>3b. Jumlah kasus Maternal Risti/Rawan Kesehatan</td>
											<td>{b2b3b_baru}</td>
											<td>{b2b3b_lanjutan}</td>
											<td>{b2b3b_lepas}</td>
											<td>{b2b3b_total}</td>
										</tr>
										<tr>
											<td>3c. Jumlah kasus Anak Risti/Rawan Kesehatan</td>
											<td>{b2b3c_baru}</td>
											<td>{b2b3c_lanjutan}</td>
											<td>{b2b3c_lepas}</td>
											<td>{b2b3c_total}</td>
										</tr>
										<tr>
											<td>3d. Jumlah kasus Gizi</td>
											<td>{b2b3d_baru}</td>
											<td>{b2b3d_lanjutan}</td>
											<td>{b2b3d_lepas}</td>
											<td>{b2b3d_total}</td>
										</tr>
										<tr>
											<td>3e. Jumlah kasus Penyakit Menular</td>
											<td>{b2b3e_baru}</td>
											<td>{b2b3e_lanjutan}</td>
											<td>{b2b3e_lepas}</td>
											<td>{b2b3e_total}</td>
										</tr>
										<tr>
											<td>3f. Jumlah kasus Penyakit Tidak Menular</td>
											<td>{b2b3f_baru}</td>
											<td>{b2b3f_lanjutan}</td>
											<td>{b2b3f_lepas}</td>
											<td>{b2b3f_total}</td>
										</tr>
										<tr>
											<td>3g. Jumlah kasus lainnya</td>
											<td>{b2b3g_baru}</td>
											<td>{b2b3g_lanjutan}</td>
											<td>{b2b3g_lepas}</td>
											<td>{b2b3g_total}</td>
										</tr>
										<tr>
											<td>4. Jumlah Keluarga Risti/ Rawan Kesehatan yang
												mendapatkan asuhan keperawatan keluarga (home care)</td>
											<td>{b2b4_baru}</td>
											<td>{b2b4_lanjutan}</td>
											<td>{b2b4_lepas}</td>
											<td>{b2b4_total}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td><b>KM I</b></td>
											<td><b>KM II</b></td>
											<td><b>KM III</b></td>
											<td><b>KM IV</b></td>
										</tr>
										<tr>
											<td>c. Keluarga menurut tingkat kemandirian keluarga
												bulan ini</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>1. Jumlah keluarga pada awal pelaksanaan bina
												keluarga (Bina Baru)</td>
											<td>{b2c1_km1}</td>
											<td>{b2c1_km2}</td>
											<td>{b2c1_km3}</td>
											<td>{b2c1_km4}</td>
										</tr>
										<tr>
											<td>2. Jumlah keluarga pada akhir pelaksanaan bina
												keluarga</td>
											<td>{b2c2_km1}</td>
											<td>{b2c2_km2}</td>
											<td>{b2c2_km3}</td>
											<td>{b2c2_km4}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								3. PERKESMAS Kelompok
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th>Kegiatan</th>
											<th>Binaan Baru</th>
											<th>Binaan Lanjutan</th>
											<th>Binaan Lepas</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>a. Jumlah kelompok binaan</td>
											<td>{c3a_baru}</td>
											<td>{c3a_lanjutan}</td>
											<td>{c3a_lepas}</td>
											<td>{c3a_total}</td>
										</tr>
										<tr>
											<td>b. Jumlah kelompok swabantu</td>
											<td>{c3b_baru}</td>
											<td>{c3b_lanjutan}</td>
											<td>{c3b_lepas}</td>
											<td>{c3b_total}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>c. Jumlah kunjungan ke kelompok binaan menurut jenis
												kelompok</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>1. Jumlah kunjungan kelompok Balita</td>
											<td>{c3c1_baru}</td>
											<td>{c3c1_lanjutan}</td>
											<td>{c3c1_lepas}</td>
											<td>{c3c1_total}</td>
										</tr>
										<tr>
											<td>2. Jumlah kunjungan kelompok Anak Sekolah</td>
											<td>{c3c2_baru}</td>
											<td>{c3c2_lanjutan}</td>
											<td>{c3c2_lepas}</td>
											<td>{c3c2_total}</td>
										</tr>
										<tr>
											<td>3. Jumlah kunjungan kelompok Maternitas</td>
											<td>{c3c3_baru}</td>
											<td>{c3c3_lanjutan}</td>
											<td>{c3c3_lepas}</td>
											<td>{c3c3_total}</td>
										</tr>
										<tr>
											<td>4. Jumlah kunjungan kelompok Calon Jamaah Haji</td>
											<td>{c3c4_baru}</td>
											<td>{c3c4_lanjutan}</td>
											<td>{c3c4_lepas}</td>
											<td>{c3c4_total}</td>
										</tr>
										<tr>
											<td>5. Jumlah kunjungan kelompok Usia Lanjut</td>
											<td>{c3c5_baru}</td>
											<td>{c3c5_lanjutan}</td>
											<td>{c3c5_lepas}</td>
											<td>{c3c5_total}</td>
										</tr>
										<tr>
											<td>6. Jumlah kunjungan kelompok Penyakit Menular</td>
											<td>{c3c6_baru}</td>
											<td>{c3c6_lanjutan}</td>
											<td>{c3c6_lepas}</td>
											<td>{c3c6_total}</td>
										</tr>
										<tr>
											<td>7. Jumlah kunjungan kelompok Penyakit Tidak Menular</td>
											<td>{c3c7_baru}</td>
											<td>{c3c7_lanjutan}</td>
											<td>{c3c7_lepas}</td>
											<td>{c3c7_total}</td>
										</tr>
										<tr>
											<td>8. Jumlah kunjungan kelompok swabantu</td>
											<td>{c3c8_baru}</td>
											<td>{c3c8_lanjutan}</td>
											<td>{c3c8_lepas}</td>
											<td>{c3c8_total}</td>
										</tr>
										<tr>
											<td>9. Jumlah kelompok binaan lainnya</td>
											<td>{c3c9_baru}</td>
											<td>{c3c9_lanjutan}</td>
											<td>{c3c9_lepas}</td>
											<td>{c3c9_total}</td>
										</tr>
										<tr>
											<td>d. Jumlah kunjungan bina semua kelompok</td>
											<td>{c3d_baru}</td>
											<td>{c3d_lanjutan}</td>
											<td>{c3d_lepas}</td>
											<td>{c3d_total}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								4. PERKESMAS Daerah Rawan Kesehatan
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th>Kegiatan</th>
											<th>Binaan Baru</th>
											<th>Binaan Lanjutan</th>
											<th>Binaan Lepas</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>a. Jumlah daerah binaan</td>
											<td>{d4a_baru}</td>
											<td>{d4a_lanjutan}</td>
											<td>{d4a_lepas}</td>
											<td>{d4a_total}</td>
										</tr>
										<tr>
											<td>b. Jumlah kunjungan daerah binaan</td>
											<td>{d4b_baru}</td>
											<td>{d4b_lanjutan}</td>
											<td>{d4b_lepas}</td>
											<td>{d4b_total}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								5. PERKESMAS khusus
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th>Kegiatan</th>
											<th>Data</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>a. Jumlah care giver yang dipersiapkan oleh tim
												PERKESMAS dalam bulan ini</td>
											<td>{e5a}</td>
										</tr>
										<tr>
											<td>b. Jumlah care giver yang terlibat dalam pelayanan
												PERKESMAS dalam bulan ini</td>
											<td>{e5b}</td>
										</tr>
										<tr>
											<td>c. Jumlah care giver yang dipersiapkan oleh tim
												PERKESMAS dalam bulan ini</td>
											<td>{e5c}</td>
										</tr>
										<tr>
											<td>d. Jumlah care giver yang terlibat dalam pelayanan
												PERKESMAS dalam bulan ini</td>
											<td>{e5d}</td>
										</tr>
										<tr>
											<td>e. Jumlah pelaksanaan kegiatan diskusi refleksi
												kasus (DRK) oleh perawat dalam bulan ini</td>
											<td>{e5e}</td>
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
											<td><strong>{URL}</strong>/sip/rest/ukme7/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/ukme7/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
												src="${ pageContext.request.contextPath }/images/url_ukme7.png" /></td>
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