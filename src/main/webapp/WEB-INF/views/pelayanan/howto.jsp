<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service Input Pelayanan</h4>
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
											<td>{kodePuskesmas}/
												{namaPuskesmas}</td>
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
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped">
									<thead>
										<tr>
											<th>Item</th>
											<th>Value</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>Kode/Nama Puskesmas</td>
											<td>{kodePuskesmas}/{namaPuskesmas}</td>
										</tr>
										<tr>
											<td>Provinsi/Kota Kabupaten</td>
											<td>{provinsi}/{kotaKabupaten}</td>
										</tr>
										<tr>
											<td>Bulan/Tahun</td>
											<td>{bulan}/{tahun}</td>
										</tr>
										<tr>
											<td>Nama</td>
											<td>{nama}</td>
										</tr>
										<tr>
											<td>NIK/KK</td>
											<td>{nik_kk}</td>
										</tr>
										<tr>
											<td>Tanggal Kunjungan</td>
											<td>{tanggal_kunjungan}</td>
										</tr>
										<tr>
											<td>No.BPJS</td>
											<td>{nomor_bpjs}</td>
										</tr>
										<tr>
											<td>Diagnosa 1</td>
											<td>{kode_diagnosa1}</td>
										</tr>
										<tr>
											<td>Diagnosa 2</td>
											<td>{kode_diagnosa2}</td>
										</tr>
										<tr>
											<td>Diagnosa 3</td>
											<td>{kode_diagnosa3}</td>
										</tr>
										<tr>
											<td>Sistole</td>
											<td>{sistole}</td>
										</tr>
										<tr>
											<td>Diastole</td>
											<td>{diastole}</td>
										</tr>
										<tr>
											<td>Berat Badan</td>
											<td>{berat_badan}</td>
										</tr>
										<tr>
											<td>Tinggi Badan</td>
											<td>{tinggi_badan}</td>
										</tr>
										<tr>
											<td>Respiration Rate</td>
											<td>{resp_rate}</td>
										</tr>
										<tr>
											<td>Heart Rate</td>
											<td>{heart_rate}</td>
										</tr>
										<tr>
											<td>Catatan</td>
											<td>{catatan}</td>
										</tr>
										<tr>
											<td>Rujuk Balik</td>
											<td>{rujuk_balik}</td>
										</tr>
										<tr>
											<td>Pemeriksaan Fisik Lain</td>
											<td>{pemeriksaan_fisikLain}</td>
										</tr>
										<tr>
											<td>Tindakan</td>
											<td>{tindakan}</td>
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
											<td><strong>{URL}</strong>/sip/rest/pelayanan/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/pelayanan/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
												src="${ pageContext.request.contextPath }/images/url_pelayanan.png" /></td>
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