<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service Laporan Tahunan 3. Program</h4>
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
											<td>Tahun</td>
											<td>{tahun}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								1. PENDIDIKAN DASAR PELAKSANA PROMOSI KESEHATAN
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
											<td>a. Jumlah SD/sederajat yang memiliki UKS</td>
											<td>{a1}</td>
										</tr>
										<tr>
											<td>b. Jumlah SLTP/sederajat yang memiliki UKS</td>
											<td>{b1}</td>
										</tr>
										<tr>
											<td>c. Jumlah SD/sederajat yang mendapatkan promosi
												kesehatan</td>
											<td>{c1}</td>
										</tr>
										<tr>
											<td>d. Jumlah SLTP/sederajat yang mendapatkan promosi
												kesehatan</td>
											<td>{d1}</td>
										</tr>
										<tr>
											<td>e. Jumlah SLTA/sederajat yang mendapatkan promosi
												kesehatan</td>
											<td>{e1}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								2. PENGENDALIAN FILARIASIS
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
											<td>a. jumlah penderita filariasis kronis terdaftar (per
												desa dan golongan umur)</td>
											<td>{a2}</td>
										</tr>
										<tr>
											<td>b. jumlah penduduk mendapat obat pencegahan massal
												filariasis (per desa)</td>
											<td>{b2}</td>
										</tr>
										<tr>
											<td>c. jumlah penderita filariasis kronis terdaftar</td>
											<td>{c2}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								3. IMUNISASI ANAK SEKOLAH (BIAS)
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
											<td>a. Jumlah anak kelas 1 SD (sederajat) yang
												diimunisasi campak (pada BIAS Campak)</td>
											<td>{a3}</td>
										</tr>
										<tr>
											<td>b. Jumlah anak kelas 1 SD (sederajat) yang
												diimunisasi DT (pada BIAS DT)</td>
											<td>{b3}</td>
										</tr>
										<tr>
											<td>c. Jumlah anak kelas 2 dan 3 SD (sederajat) yang
												diimunisasi Td (pada BIAS Td)</td>
											<td>{c3}</td>
										</tr>
										<tr>
											<td>d. Jumlah Desa/Kelurahan UCI (menurut desa)</td>
											<td>{d3}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								4. KESEHATAN LINGKUNGAN
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th rowspan="2">a. Sarana Air Minum</th>
											<th colspan="6">Jumlah Sarana Menurut Tingkat Risiko
												Pencemaran</th>
										</tr>
										<tr>
											<th>Belum IKL</th>
											<th>Rendah</th>
											<th>Sedang</th>
											<th>Tinggi</th>
											<th>Amat Tinggi</th>
											<th>Sertifikat</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Perpipaan PAM</td>
											<td>{a41_belum}</td>
											<td>{a41_rendah}</td>
											<td>{a41_sedang}</td>
											<td>{a41_tinggi}</td>
											<td>{a41_amat_tinggi}</td>
											<td>{a41_sertifikat}</td>
										</tr>
										<tr>
											<td>2. Perpipaan non PAM (sarana komunal)</td>
											<td>{a42_belum}</td>
											<td>{a42_rendah}</td>
											<td>{a42_sedang}</td>
											<td>{a42_tinggi}</td>
											<td>{a42_amat_tinggi}</td>
											<td>{a42_sertifikat}</td>
										</tr>
										<tr>
											<td>3. Depot Air Minum</td>
											<td>{a43_belum}</td>
											<td>{a43_rendah}</td>
											<td>{a43_sedang}</td>
											<td>{a43_tinggi}</td>
											<td>{a43_amat_tinggi}</td>
											<td>{a43_sertifikat}</td>
										</tr>
										<tr>
											<td>4. Sumur Gali</td>
											<td>{a44_belum}</td>
											<td>{a44_rendah}</td>
											<td>{a44_sedang}</td>
											<td>{a44_tinggi}</td>
											<td>{a44_amat_tinggi}</td>
											<td>{a44_sertifikat}</td>
										</tr>
										<tr>
											<td>5. Penampung Air Hujan</td>
											<td>{a45_belum}</td>
											<td>{a45_rendah}</td>
											<td>{a45_sedang}</td>
											<td>{a45_tinggi}</td>
											<td>{a45_amat_tinggi}</td>
											<td>{a45_sertifikat}</td>
										</tr>
										<tr>
											<td>6. Perlindungan Mata Air</td>
											<td>{a46_belum}</td>
											<td>{a46_rendah}</td>
											<td>{a46_sedang}</td>
											<td>{a46_tinggi}</td>
											<td>{a46_amat_tinggi}</td>
											<td>{a46_sertifikat}</td>
										</tr>
										<tr>
											<td>7. Sumur Bor dengan Pompa</td>
											<td>{a47_belum}</td>
											<td>{a47_rendah}</td>
											<td>{a47_sedang}</td>
											<td>{a47_tinggi}</td>
											<td>{a47_amat_tinggi}</td>
											<td>{a47_sertifikat}</td>
										</tr>
										<tr>
											<td>8. Terminal Air</td>
											<td>{a48_belum}</td>
											<td>{a48_rendah}</td>
											<td>{a48_sedang}</td>
											<td>{a48_tinggi}</td>
											<td>{a48_amat_tinggi}</td>
											<td>{a48_sertifikat}</td>
										</tr>
										<tr>
											<td>9. Mobil Tangki</td>
											<td>{a49_belum}</td>
											<td>{a49_rendah}</td>
											<td>{a49_sedang}</td>
											<td>{a49_tinggi}</td>
											<td>{a49_amat_tinggi}</td>
											<td>{a49_sertifikat}</td>
										</tr>
									</tbody>
								</table>
								<br />
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th rowspan="2">b. Rumah dan Jamban</th>
											<th colspan="4">Jumlah Sarana Menurut Klasifikasi
												Standar Kesehatan</th>
										</tr>
										<tr>
											<th>Belum IKL</th>
											<th>Tdk Memenuhi Syarat</th>
											<th>Memenuhi Syarat</th>
											<th>Sertifikat</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah Rumah</td>
											<td>{b41_belum}</td>
											<td>{b41_tdk_memenuhi}</td>
											<td>{b41_memenuhi}</td>
											<td>{b41_sertifikat}</td>
										</tr>
										<tr>
											<td>2. Jumlah Jamban</td>
											<td>{b42_belum}</td>
											<td>{b42_tdk_memenuhi}</td>
											<td>{b42_memenuhi}</td>
											<td>{b42_sertifikat}</td>
										</tr>
									</tbody>
								</table>
								<br />
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th rowspan="2">c. Jumlah Tempat Pengelolaan Makanan
												(TPM) siap saji terdaftar</th>
											<th colspan="4">Jumlah Sarana Menurut Klasifikasi
												Standar Kesehatan Lingkungan</th>
										</tr>
										<tr>
											<th>Belum IKL</th>
											<th>Tdk Memenuhi Syarat</th>
											<th>Memenuhi Syarat</th>
											<th>Sertifikat</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Rumah makan/restoran</td>
											<td>{c41_belum}</td>
											<td>{c41_tdk_memenuhi}</td>
											<td>{c41_memenuhi}</td>
											<td>{c41_sertifikat}</td>
										</tr>
										<tr>
											<td>2. Jumlah Restoran</td>
											<td>{c42_belum}</td>
											<td>{c42_tdk_memenuhi}</td>
											<td>{c42_memenuhi}</td>
											<td>{c42_sertifikat}</td>
										</tr>
										<tr>
											<td>3. Jasaboga</td>
											<td>{c43_belum}</td>
											<td>{c43_tdk_memenuhi}</td>
											<td>{c43_memenuhi}</td>
											<td>{c43_sertifikat}</td>
										</tr>
										<tr>
											<td>4. Depot Air Minum</td>
											<td>{c44_belum}</td>
											<td>{c44_tdk_memenuhi}</td>
											<td>{c44_memenuhi}</td>
											<td>{c44_sertifikat}</td>
										</tr>
										<tr>
											<td>5. Centra Makanan Jajanan</td>
											<td>{c45_belum}</td>
											<td>{c45_tdk_memenuhi}</td>
											<td>{c45_memenuhi}</td>
											<td>{c45_sertifikat}</td>
										</tr>
										<tr>
											<td>6. Kantin Sekolah</td>
											<td>{c46_belum}</td>
											<td>{c46_tdk_memenuhi}</td>
											<td>{c46_memenuhi}</td>
											<td>{c46_sertifikat}</td>
										</tr>
										<tr>
											<td>7. Jumlah Kantin Institusi</td>
											<td>{c47_belum}</td>
											<td>{c47_tdk_memenuhi}</td>
											<td>{c47_memenuhi}</td>
											<td>{c47_sertifikat}</td>
										</tr>
										<tr>
											<td>8. Jumlah pedagang kaki lima pangan siap saji
												(kuliner)</td>
											<td>{c48_belum}</td>
											<td>{c48_tdk_memenuhi}</td>
											<td>{c48_memenuhi}</td>
											<td>{c48_sertifikat}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>d. Jumlah Tempat Penampungan Sampah Sementara</td>
											<td>{d4_belum}</td>
											<td>{d4_tdk_memenuhi}</td>
											<td>{d4_memenuhi}</td>
											<td>{d4_sertifikat}</td>
										</tr>
									</tbody>
								</table>
								<br />
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th rowspan="2">e. Jumlah TTU yang terdaftar</th>
											<th colspan="4">Jumlah Sarana Menurut Klasifikasi
												Standar Kesehatan Lingkungan</th>
										</tr>
										<tr>
											<th>Belum IKL</th>
											<th>Tdk Memenuhi Syarat</th>
											<th>Memenuhi Syarat</th>
											<th>Sertifikat</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Sarana pendidikan (sekolah, pesantren)</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>a. Jumlah Sekolah</td>
											<td>{e41a_belum}</td>
											<td>{e41a_tdk_memenuhi}</td>
											<td>{e41a_memenuhi}</td>
											<td>{e41a_sertifikat}</td>
										</tr>
										<tr>
											<td>b. Jumlah Pondok Pesantren</td>
											<td>{e41b_belum}</td>
											<td>{e41b_tdk_memenuhi}</td>
											<td>{e41b_memenuhi}</td>
											<td>{e41b_sertifikat}</td>
										</tr>
										<tr>
											<td>2. Pasar</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>a. Pasar Tradisional</td>
											<td>{e42a_belum}</td>
											<td>{e42a_tdk_memenuhi}</td>
											<td>{e42a_memenuhi}</td>
											<td>{e42a_sertifikat}</td>
										</tr>
										<tr>
											<td>b. Pasar Modern</td>
											<td>{e42b_belum}</td>
											<td>{e42b_tdk_memenuhi}</td>
											<td>{e42b_memenuhi}</td>
											<td>{e42b_sertifikat}</td>
										</tr>
										<tr>
											<td>3. Jumlah Fasilitas pelayanan kesehatan (RS,
												Puskesmas, Puskesmas pembantu, dsb)</td>
											<td>{e43_belum}</td>
											<td>{e43_tdk_memenuhi}</td>
											<td>{e43_memenuhi}</td>
											<td>{e43_sertifikat}</td>
										</tr>
										<tr>
											<td>4. Tempat Ibadah</td>
											<td>{e44_belum}</td>
											<td>{e44_tdk_memenuhi}</td>
											<td>{e44_memenuhi}</td>
											<td>{e44_sertifikat}</td>
										</tr>
										<tr>
											<td>5. Hotel (Hotel Berbintang dan Non)</td>
											<td>{e45_belum}</td>
											<td>{e45_tdk_memenuhi}</td>
											<td>{e45_memenuhi}</td>
											<td>{e45_sertifikat}</td>
										</tr>
										<tr>
											<td>6. Terminal Kendaraan Umum dan Stasiun</td>
											<td>{e46_belum}</td>
											<td>{e46_tdk_memenuhi}</td>
											<td>{e46_memenuhi}</td>
											<td>{e46_sertifikat}</td>
										</tr>
										<tr>
											<td>7. Tempat Rekreasi, Hiburan dan Wisata</td>
											<td>{e47_belum}</td>
											<td>{e47_tdk_memenuhi}</td>
											<td>{e47_memenuhi}</td>
											<td>{e47_sertifikat}</td>
										</tr>
										<tr>
											<td>8. Lembaga Permasyarakatan dan Rumah Tahanan</td>
											<td>{e48_belum}</td>
											<td>{e48_tdk_memenuhi}</td>
											<td>{e48_memenuhi}</td>
											<td>{e48_sertifikat}</td>
										</tr>
										<tr>
											<td>9. Sarana Transportasi Darat</td>
											<td>{e49_belum}</td>
											<td>{e49_tdk_memenuhi}</td>
											<td>{e49_memenuhi}</td>
											<td>{e49_sertifikat}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								5. PROGRAM PELAYANAN KESEHATAN TRADISIONAL DAN KOMPLEMENTER
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
											<td>a. Jumlah tenaga Penyehat Tradisional (Hattra) di
												wilayah Puskesmas terdaftar (STPT)</td>
											<td>{a5}</td>
										</tr>
										<tr>
											<td>b. Jumlah posyandu yang melaksanakan asuhan Mandiri
												Kesehatan Tradisional</td>
											<td>{b5}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								6. PELAKSANAAN K3 DI LINGKUNGAN PUSKESMAS
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>(1)YA (2)TIDAK</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>a. Terdapat kebijakan tertulis pelaksanaan K3 di
												Lingkungan Sekolah</td>
											<td>{a6}</td>
										</tr>
										<tr>
											<td>b. Tim K3 di Puskesmas (SK Kepala Puskesmas)</td>
											<td>{b6}</td>
										</tr>
										<tr>
											<td>c. Penerapan Kewaspadaan Standar di Lingkungan
												Puskesmas</td>
											<td>{c6}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>

					</div>
					<div id="tab-url" class="tab-pane">
						<div class="ibox">
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
											<td><strong>{URL}</strong>/sip/rest/lt3/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/lt3/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
												src="${ pageContext.request.contextPath }/images/url_lt3.png" /></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-ct" class="tab-pane">
						<div class="ibox">
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
							<div class="ibox-content">
								<pre id="requestJsonFormat"></pre>
							</div>
						</div>
					</div>
					<div id="tab-response" class="tab-pane">
						<div class="ibox">
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