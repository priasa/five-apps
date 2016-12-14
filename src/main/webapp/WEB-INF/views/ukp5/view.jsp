<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukp5.id}
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
						<td>${ukp5.kodePuskesmas}/ ${ukp5.namaPuskesmas}</td>
					</tr>
					<tr>
						<td>Bulan/Tahun</td>
						<td>${ukp5.bulan}/ ${ukp5.tahun}</td>
					</tr>
					<tr>
						<td>Jumlah Puskesmas Pembantu yang Melapor</td>
						<td>${ukp5.pustu_lapor} dari ${ukp5.pustu_total}</td>
					</tr>
					<tr>
						<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
						<td>${ukp5.poskesdes_lapor} dari ${ukp5.poskesdes_total}</td>
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
			<table id="dTable" class="table table-striped" style="font-size: 10px;">
				<thead>
					<tr>
						<th>No.</th>
						<th>Tanggal</th>
						<th>NIK/NKK</th>
						<th>Nama</th>
						<th>Kepala Keluarga</th>
						<th>Alamat Lengkap</th>
						<th>Tanggal Lahir</th>
						<th>L/P</th>
						<th>Tanggal Meninggal</th>
						<th>Lokasi Meninggal</th>
						<th>Sebab Langsung (kode)</th>
						<th>Sebab Dasar (kode)</th>
						<th>Penyakit Penyerta* (kode)</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ukp5.detail}" var="dtl">
					<tr>
						<td>${dtl.nomor}</td>
						<td>${dtl.tanggal}</td>
						<td>${dtl.nik_nkk}</td>
						<td>${dtl.nama}</td>
						<td>${dtl.kepala_keluarga}</td>
						<td>${dtl.alamat_lengkap}</td>
						<td>${dtl.tanggal_lahir}</td>
						<td>${dtl.jenis_kelamin}</td>
						<td>${dtl.tanggal_meninggal}</td>
						<td>${dtl.lokasi_meninggal}</td>
						<td>${dtl.sebab_langsung}</td>
						<td>${dtl.sebab_dasar}</td>
						<td>${dtl.penyakit_penyerta}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukp5/list";
	}
</script>

<commons:footer />