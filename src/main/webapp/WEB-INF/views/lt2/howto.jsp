<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service Laporan Tahunan 2. Sumber
				Daya Manusia</h4>
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
								<table id="dTable" class="table table-striped" style="font-size: 43%;">
									<thead>
										<tr>
											<th>No.</th>
											<th>Kode Unit</th>
											<th>NIK</th>
											<th>NIP/ID</th>
											<th>Nama</th>
											<th>L/P</th>
											<th>Status Kepegawaian</th>
											<th>Kode SDMK</th>
											<th>Mulai</th>
											<th>Berakhir</th>
											<th>Kode Pendidikan</th>
											<th>Tahun Lulus</th>
											<th>Riwayat Pelatihan</th>
											<th>Jabatan (struktural/fungsional)</th>
											<th>Jenjang Jabatan</th>
											<th>Tahun Jabatan</th>
											<th>Email</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="{detail}" var="dtl">
											<tr>
												<td>{nomor}</td>
												<td>{kode_unit}</td>
												<td>{nik}</td>
												<td>{nip_id}</td>
												<td>{nama}</td>
												<td>{jenis_kelamin}</td>
												<td>{status_kepegawaian}</td>
												<td>{kode_sdmk}</td>
												<td>{tanggal_mulai}</td>
												<td>{tanggal_berakhir}</td>
												<td>{kode_pendidikan}</td>
												<td>{tahun_lulus}</td>
												<td>{riwayat_pelatihan}</td>
												<td>{jabatan}</td>
												<td>{jenjang_jabatan}</td>
												<td>{tahun_jabatan}</td>
												<td>{email}</td>
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
											<td><strong>{URL}</strong>/sip/rest/lt2/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/lt2/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
												src="${ pageContext.request.contextPath }/images/url_lt2.png" /></td>
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