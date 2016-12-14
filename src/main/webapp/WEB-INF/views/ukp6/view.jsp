<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukp6.id}
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
						<td>${ukp6.kodePuskesmas}/ ${ukp6.namaPuskesmas}</td>
					</tr>
					<tr>
						<td>Bulan/Tahun</td>
						<td>${ukp6.bulan}/ ${ukp6.tahun}</td>
					</tr>
					<tr>
						<td>Jumlah Puskesmas Pembantu yang Melapor</td>
						<td>${ukp6.pustu_lapor} dari ${ukp6.pustu_total}</td>
					</tr>
					<tr>
						<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
						<td>${ukp6.poskesdes_lapor} dari ${ukp6.poskesdes_total}</td>
					</tr>
					<tr>
						<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
						<td>${ukp6.poskesdes_lapor} dari ${ukp6.poskesdes_total}</td>
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
						<th rowspan="2">Kode Obat</th>
						<th rowspan="2">Nama Obat</th>
						<th rowspan="2">Satuan</th>
						<th rowspan="2">Stok Awal</th>
						<th rowspan="2">Penerimaan</th>
						<th rowspan="2">Persediaan</th>
						<th rowspan="2">Pemakaian</th>
						<th rowspan="2">Stok Akhir</th>
						<th rowspan="2">Stok Optimum</th>
						<th rowspan="2">Permintaan</th>
						<th colspan="6">Pemberian</th>
					</tr>
					<tr>
						<th>APBD I</th>
						<th>APBD II</th>
						<th>DAK</th>
						<th>Program</th>
						<th>Lainnya</th>
						<th>JML</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ukp6.detail}" var="dtl">
					<tr>
						<td>${dtl.nomor}</td>
						<td>${dtl.kode_obat}</td>
						<td>${dtl.nama_obat}</td>
						<td>${dtl.satuan}</td>
						<td>${dtl.stok_awal}</td>
						<td>${dtl.penerimaan}</td>
						<td>${dtl.persedian}</td>
						<td>${dtl.pemakaian}</td>
						<td>${dtl.stok_akhir}</td>
						<td>${dtl.stok_optimum}</td>
						<td>${dtl.permintaan}</td>
						<td>${dtl.apbd1}</td>
						<td>${dtl.apbd2}</td>
						<td>${dtl.dak}</td>
						<td>${dtl.program}</td>
						<td>${dtl.lain_lain}</td>
						<td>${dtl.jumlah_pemberian}</td>
					</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">Jumlah Kunjungan Resep
			<div class="ibox-tools">
				<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
			</div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
				<thead>
					<tr>
						<th colspan="2">Umum</th>
						<th rowspan="2">JKN</th>
						<th rowspan="2">Jumlah</th>
					</tr>
					<tr>
						<th>Bayar</th>
						<th>Tidak</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${ukp6.kunj_umum_bayar}</td>
						<td>${ukp6.kunj_umum_tdk_bayar}</td>
						<td>${ukp6.kunj_jkn}</td>
						<td>${ukp6.kunj_total}</td>
					</tr>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukp6/list";
	}
</script>

<commons:footer />