<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service UKME 1. Promosi Kesehatan</h4>
			<div class="tabs-container">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#tab-form">Form</a></li>
					<li><a data-toggle="tab" href="#tab-url">URL</a></li>
					<li><a data-toggle="tab" href="#tab-ct">Method dan Content Type</a></li>
					<li><a data-toggle="tab" href="#tab-request">Contoh Request atau PayLoad</a></li>
					<li><a data-toggle="tab" href="#tab-response">Contoh Response</a></li>
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
								A. Promosi Kesehatan Umum
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
											<td>1. Jumlah kegiatan Penyuluhan di Puskesmas dan
												jaringannya semua topik</td>
											<td></td>
										</tr>
										<tr>
											<td>a. Jumlah penyuluhan individu</td>
											<td>{a1a}</td>
										</tr>
										<tr>
											<td>b. Jumlah kunjungan rumah</td>
											<td>{a1b}</td>
										</tr>
										<tr>
											<td>c. Jumlah penyuluhan kelompok</td>
											<td>{a1c}</td>
										</tr>
										<tr>
											<td>d. Jumlah penyuluhan individu, kunjungan rumah dan
												penyuluhan kelompok</td>
											<td>{a1d}</td>
										</tr>
										<tr>
											<td>2. Jumlah kegiatan advokasi di tingkat desa/kelurahan
												dan kecamatan bidang kesehatan</td>
											<td>{a2}</td>
										</tr>
										<tr>
											<td>3. Jumlah kegiatan penggalangan kemitraan dengan dunia
												usaha dan lintas sektor tingkat desa/kelurahan dan kecamatan
												bidang kesehatan</td>
											<td>{a3}</td>
										</tr>
										<tr>
											<td>4. Jumlah kegiatan pembinaan UKBM atau kelompok
												masyarakat</td>
											<td>{a4}</td>
										</tr>
										<tr>
											<td>8. Jumlah jenis media yang digunakan dalam penyebaran
												informasi</td>
											<td>{a8}</td>
										</tr>
										<tr>
											<td>9. Pelaksanaan Promosi Kesehatan di Puskesmas
												(Ya/Tidak)</td>
											<td>{a9}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								B. Promosi Kesehatan Penyakit Menular
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
											<td>1. Jumlah kegiatan Penyuluhan di Puskesmas dan
												jaringannyatopik diare</td>
											<td>{b1}</td>
										</tr>
										<tr>
											<td>2. Jumlah kegiatan Penyuluhan di Puskesmas dan
												jaringannyatopik tifoid</td>
											<td>{b2}</td>
										</tr>
										<tr>
											<td>3. Jumlah kegiatan Penyuluhan di Puskesmas dan
												jaringannyatopik hepatitis</td>
											<td>{b3}</td>
										</tr>
										<tr>
											<td>4. Jumlah kegiatan Penyuluhan di Puskesmas dan
												jaringannyatopik HIV/AIDS</td>
											<td>{b4}</td>
										</tr>
										<tr>
											<td>5. Jumlah SLTP/SLTA yang terlaksana pelayanan
												konseling/penyuluhan individu kesehatan remaja (HIV/AIDS)</td>
											<td>{b5}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								C. Promosi Kesehatan Lingkungan
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
											<td>1. Jumlah klien/pasien/perseorangan mendapat
												konseling/penyuluhan kesehatan lingkungan di rumahnya (luar
												gedung)</td>
											<td>{c1}</td>
										</tr>
										<tr>
											<td>2. Jumlah klien/pasien/perseorangan mendapat konseling
												kesehatan/penyuluhan lingkungan di klinik sanitasi (dalam
												gedung)</td>
											<td>{c2}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								D. Promosi Kesehatan KIA, termasuk remaja
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
											<td>1. Jumlah Sekolah terlaksana kegiatan KIE/penyuluhan
												kesehatan remaja oleh tenaga kesehatan</td>
											<td>{d1}</td>
										</tr>
										<tr>
											<td>2. Jumlah kelompok remaja diluar sekolah (karang
												taruna, remaja mesjid, gereja, pura, wihara, dll) yang
												mendapatkan KIE/penyuluhan kesehatan remaja</td>
											<td>{d2}</td>
										</tr>
										<tr>
											<td>3. Jumlah remaja mendapatkan konseling oleh tenaga
												kesehatan</td>
											<td>{d3}</td>
										</tr>
										<tr>
											<td>4. Jumlah remaja mendapat KIE/penyuluhan kesehatan
												reproduksi</td>
											<td>{d4}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								E. Promosi Kesehatan Pelayanan Kesehatan
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
											<td>1. Jumlah SD/MI melaksanakan sikat gigi bersama</td>
											<td>{e1}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								F. PTM
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
											<td>1. Jumlah penduduk mengikuti konseling /penyuluhan
												kesehatan perorangan sesuai topik :</td>
											<td></td>
										</tr>
										<tr>
											<td>a. Diet</td>
											<td>{f1a}</td>
										</tr>
										<tr>
											<td>b. Berhenti Merokok</td>
											<td>{f1b}</td>
										</tr>
										<tr>
											<td>c. Potensi Cedera</td>
											<td>{f1c}</td>
										</tr>
										<tr>
											<td>d. IVA-SADANIS</td>
											<td>{f1d}</td>
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
											<td><strong>{URL}</strong>/sip/rest/ukme1/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/ukme1/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
										</tr>
										<tr>
											<td></td>
											<td><p><strong>*URL</strong> dan <strong>TOKEN</strong> akan diberikan oleh Pusdatin Kementerian Kesehatan</p></td>
										</tr>
										<tr>
											<td></td>
											<td><img width="90%" src="${ pageContext.request.contextPath }/images/url_ukme1.png"/></td>
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
											<td>Method </td>
											<td>POST</td>
										</tr>
										<tr>
											<td>Content-Type </td>
											<td>application/json</td>
										</tr>
										<tr>
											<td></td>
											<td><img width="90%" src="${ pageContext.request.contextPath }/images/ct_ukme1.png"/></td>
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