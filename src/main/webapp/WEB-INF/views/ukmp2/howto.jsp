<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service UKMP 2. Kesehatan Kerja,
				Olahraga dan Tradkom</h4>
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
											<td>Nomor</td>
											<td>{nomor}</td>
										</tr>
										<tr>
											<td>Bulan/Tahun</td>
											<td>{bulan}/ {tahun}</td>
										</tr>
										<tr>
											<td>Jumlah Puskesmas Pembantu yang Melapor</td>
											<td>{pustu_lapor} dari {pustu_total}</td>
										</tr>
										<tr>
											<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
											<td>{poskesdes_lapor} dari {poskesdes_total}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								1. Pelayanan kesehatan kerja dasar yang dilaksanakan di internal
								dan eksternal Puskesmas
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
											<td>a. Jumlah kelompok kerja yang dibina</td>
											<td>{a1}</td>
										</tr>
										<tr>
											<td>b. Jumlah tempat kerja yang diperiksa dan
												teridentifikasi potensi bahaya</td>
											<td>{b1}</td>
										</tr>
										<tr>
											<td>c. Jumlah tempat kerja yang dibina</td>
											<td>{c1}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>d. Jumlah kasus penyakit pada pekerja :</td>
											<td></td>
										</tr>
										<tr>
											<td>1. {d11}</td>
											<td>{d11a}</td>
										</tr>
										<tr>
											<td>2. {d12}</td>
											<td>{d12a}</td>
										</tr>
										<tr>
											<td>3. {d13}</td>
											<td>{d13a}</td>
										</tr>
										<tr>
											<td>4. {d14}</td>
											<td>{d14a}</td>
										</tr>
										<tr>
											<td>5. {d15}</td>
											<td>{d15a}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>e. Jumlah kasus penyakit akibat kerja pada pekerja</td>
											<td>{e1}</td>
										</tr>
										<tr>
											<td>f. Jumlah kasus kecelakaan akibat kerja pada pekerja</td>
											<td>{f1}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>g. Jumlah Pekerja yang mendapatkan pelayanan
												berdasarkan jenis pekerjaan (jenis pekerjaan berupa
												penggolongan konstruksi, pertambangan, manufaktur, faskes,
												pertanian, perikanan dan jasa/ atau berdasarkan faktor
												risiko) :</td>
											<td></td>
										</tr>
										<tr>
											<td>1. Konstruksi</td>
											<td>{g11a}</td>
										</tr>
										<tr>
											<td>2. Pertambangan</td>
											<td>{g12a}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>h. Jumlah pekerja yang mendapatkan pelayanan
												promotif , preventif dan/atau rehabilitatif berdasarkan
												jenis pelayanan :</td>
											<td></td>
										</tr>
										<tr>
											<td>1. Promotif</td>
											<td>{h11}</td>
										</tr>
										<tr>
											<td>2. Preventif</td>
											<td>{h12}</td>
										</tr>
										<tr>
											<td>3. Kuratif</td>
											<td>{h13}</td>
										</tr>
										<tr>
											<td>4. Rehabilitatif</td>
											<td>{h14}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>i. Penerapan kewaspadaan standar di lingkungan
												Puskesmas</td>
											<td>{i1}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>

						<div class="ibox">
							<div class="ibox-title">
								2. Kesehatan Olahraga
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
											<td>a. Jumlah kelompok olahraga terdaftar di Puskesmas
												pada bulan ini</td>
											<td>{a2}</td>
										</tr>
										<tr>
											<td>b. Jumlah kelompok olahraga yang dibina Puskesmas</td>
											<td>{b2}</td>
										</tr>
										<tr>
											<td>c. Jumlah kelompok olahraga yang diperiksa kesehatan
												anggotanya</td>
											<td>{c2}</td>
										</tr>
										<tr>
											<td>d. Jumlah kelompok olahraga yang dilakukan
												penyuluhan</td>
											<td>{d2}</td>
										</tr>
										<tr>
											<td>e. Jumlah orang yang mendapatkan konsultasi
												kesehatan olahraga</td>
											<td>{e2}</td>
										</tr>
										<tr>
											<td>f. Jumlah orang yang diukur tingkat kebugaran
												jasmani</td>
											<td>{f2}</td>
										</tr>
										<tr>
											<td>g. Jumlah orang yang mendapatkan penanganan cedera
												olahraga akut</td>
											<td>{g2}</td>
										</tr>
										<tr>
											<td>h. Jumlah atlet yang dilayani kesehatan pada even
												olahraga</td>
											<td>{h2}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>

						<div class="ibox">
							<div class="ibox-title">
								3. POS KK
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
											<td>1. Jumlah POS UKK yang dibina Puskesmas bulan ini</td>
											<td>{a3}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								4. Program Pelayanan Kesehatan Tradisonal dan Komplementer
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
											<td>1. Jumlah kunjungan kasus dengan pelayanan akupresur
												di Puskesmas</td>
											<td>{a4}</td>
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
											<td><strong>{URL}</strong>/sip/rest/ukmp2/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/ukmp2/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
												src="${ pageContext.request.contextPath }/images/url_ukmp2.png" /></td>
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