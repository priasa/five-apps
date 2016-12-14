<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukp4.id}
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
						<td>${ukp4.kodePuskesmas}/ ${ukp4.namaPuskesmas}</td>
					</tr>
					<tr>
						<td>Bulan/Tahun</td>
						<td>${ukp4.bulan}/ ${ukp4.tahun}</td>
					</tr>
					<tr>
						<td>Jumlah Puskesmas Pembantu yang Melapor</td>
						<td>${ukp4.pustu_lapor} dari ${ukp4.pustu_total}</td>
					</tr>
					<tr>
						<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
						<td>${ukp4.poskesdes_lapor} dari ${ukp4.poskesdes_total}</td>
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
			<table id="dTable" class="table table-striped">
				<thead>
					<tr>
						<th>No.</th>
						<th>Jenis Penyakit</th>
						<th>ICD X</th>
						<th>JUMLAH KASUS BARU</th>
						<th>JUMLAH KASUS LAMA</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ukp4.detail}" var="dtl">
					<tr>
						<td>${dtl.nomor}</td>
						<td>${dtl.jenis_penyakit}</td>
						<td>${dtl.icdx}</td>
						<td>${dtl.jumlah_baru}</td>
						<td>${dtl.jumlah_lama}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukp4/list";
	}
</script>

<commons:footer />