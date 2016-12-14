<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${lt1.id}
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
						<td>${lt1.kodePuskesmas}/ ${lt1.namaPuskesmas}</td>
					</tr>
					<tr>
						<td>Tahun</td>
						<td>${lt1.tahun}</td>
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
					<c:forEach items="${lt1.detail}" var="dtl">
					<tr>
						<td>${dtl.nomor}</td>
						<td>${dtl.jenis_namaruangan}</td>
						<td>${dtl.jenis_alat}</td>
						<td>${dtl.ketersediaan_ada}</td>
						<td>${dtl.ketersediaan_tidakada}</td>
						<td>${dtl.nomor_seri}</td>
						<td>${dtl.merk}</td>
						<td>${dtl.type}</td>
						<td>${dtl.tahun_perolehan}</td>
						<td>${dtl.tahun_operasional}</td>
						<td>${dtl.kondisi_berfungsi}</td>
						<td>${dtl.kondisi_rusak}</td>
						<td>${dtl.tanggal_kalibrasi}</td>
						<td>${dtl.distributor}</td>
						<td>${dtl.harga}</td>
						<td>${dtl.apbn}</td>
						<td>${dtl.apbd1}</td>
						<td>${dtl.apbd2}</td>
						<td>${dtl.hibah}</td>
						<td>${dtl.negara_pembuat}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/lt1/list";
	}
</script>

<commons:footer />