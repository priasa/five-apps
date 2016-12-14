<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service Laporan Tahunan 1.
				Ketersediaan Alat</h4>
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
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
							</div>
							<div class="ibox-content">
								<table id="dTable" class="table table-striped"
									style="font-size: 43%;">
									<thead>
										<tr>
											<th rowspan="2">No.</th>
											<th rowspan="2">Jenis / Nama Ruangan</th>
											<th rowspan="2">Jenis Alat</th>
											<th colspan="2">Ketersediaan</th>
											<th rowspan="2">No.Seri</th>
											<th rowspan="2">Merk</th>
											<th rowspan="2">Type</th>
											<th colspan="2">Tahun</th>
											<th colspan="2">Kondisi</th>
											<th rowspan="2">Tgl Kalibrasi</th>
											<th rowspan="2">Distibutor</th>
											<th rowspan="2">Harga Alat</th>
											<th colspan="4">Sumber Dana</th>
											<th rowspan="2">Negara Pembuat</th>
										</tr>
										<tr>
											<th>Ada</th>
											<th>Tidak Ada</th>
											<th>Perolehan</th>
											<th>Operasional</th>
											<th>Berfungsi</th>
											<th>Rusak</th>
											<th>APBN</th>
											<th>APBD I</th>
											<th>APBD II</th>
											<th>Hibah</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="{detail}" var="dtl">
											<tr>
												<td>{nomor}</td>
												<td>{jenis_namaruangan}</td>
												<td>{jenis_alat}</td>
												<td>{ketersediaan_ada}</td>
												<td>{ketersediaan_tidakada}</td>
												<td>{nomor_seri}</td>
												<td>{merk}</td>
												<td>{type}</td>
												<td>{tahun_perolehan}</td>
												<td>{tahun_operasional}</td>
												<td>{kondisi_berfungsi}</td>
												<td>{kondisi_rusak}</td>
												<td>{tanggal_kalibrasi}</td>
												<td>{distributor}</td>
												<td>{harga}</td>
												<td>{apbn}</td>
												<td>{apbd1}</td>
												<td>{apbd2}</td>
												<td>{hibah}</td>
												<td>{negara_pembuat}</td>
											</tr>
										</c:forEach>
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
											<td><strong>{URL}</strong>/sip/rest/lt1/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/lt1/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
												src="${ pageContext.request.contextPath }/images/url_lt1.png" /></td>
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