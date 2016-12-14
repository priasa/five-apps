<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${lt2.id}
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
						<td>${lt2.kodePuskesmas}/ ${lt2.namaPuskesmas}</td>
					</tr>
					<tr>
						<td>Tahun</td>
						<td>${lt2.tahun}</td>
					</tr>
				</tbody>
			</table>
			<div class="row tableAction">
				<div class="col-sm-8">
					<button type="button" class="btn btn-success btn-sm"
						onclick="cancel()">
						<fmt:message key="general.back" />
					</button>
				</div>
			</div>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">
			<div class="ibox-tools">
				<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
			</div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped" style="font-size: 8px;">
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
					<c:forEach items="${lt2.detail}" var="dtl">
					<tr>
						<td>${dtl.nomor}</td>
						<td>${dtl.kode_unit}</td>
						<td>${dtl.nik}</td>
						<td>${dtl.nip_id}</td>
						<td>${dtl.nama}</td>
						<td>${dtl.jenis_kelamin}</td>
						<td>${dtl.status_kepegawaian}</td>
						<td>${dtl.kode_sdmk}</td>
						<td>${dtl.tanggal_mulai}</td>
						<td>${dtl.tanggal_berakhir}</td>
						<td>${dtl.kode_pendidikan}</td>
						<td>${dtl.tahun_lulus}</td>
						<td>${dtl.riwayat_pelatihan}</td>
						<td>${dtl.jabatan}</td>
						<td>${dtl.jenjang_jabatan}</td>
						<td>${dtl.tahun_jabatan}</td>
						<td>${dtl.email}</td>
					</tr>
					</c:forEach>	
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
		document.location.href = "${pageContext.request.contextPath}/web/lt2/list";
	}
</script>

<commons:footer />