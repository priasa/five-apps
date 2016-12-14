<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukp3.id}
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
						<td>${ukp3.kodePuskesmas}/ ${ukp3.namaPuskesmas}</td>
					</tr>
					<tr>
						<td>Bulan/Tahun</td>
						<td>${ukp3.bulan}/ ${ukp3.tahun}</td>
					</tr>
					<tr>
						<td>Jumlah Puskesmas Pembantu yang Melapor</td>
						<td>${ukp3.pustu_lapor} dari ${ukp3.pustu_total}</td>
					</tr>
					<tr>
						<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
						<td>${ukp3.poskesdes_lapor} dari ${ukp3.poskesdes_total}</td>
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
						<th rowspan="2">No.</th>
						<th rowspan="2">Jenis Penyakit</th>
						<th rowspan="2">ICD X</th>
						<th colspan="13">JUMLAH KASUS BARU (Umur dan Jenis Kelamin)</th>
						<th colspan="3">JUMLAH KASUS LAMA</th>
					</tr>
					<tr>
						<th>0-4 THN</th>
						<th>5-6 THN</th>
						<th>7-11 THN</th>
						<th>12 THN</th>
						<th>13-14 THN</th>
						<th>15-18 THN</th>
						<th>19-34 THN</th>
						<th>35-44 THN</th>
						<th>45-64 THN</th>
						<th>&gt;65 THN</th>
						<th>L</th>
						<th>P</th>
						<th>JML</th>
						<th>L</th>
						<th>P</th>
						<th>JML</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ukp3.detail}" var="dtl">
					<tr>
						<td>${dtl.nomor}</td>
						<td>${dtl.jenis_penyakit}</td>
						<td>${dtl.icdx}</td>
						<td>${dtl.u1_baru}</td>
						<td>${dtl.u2_baru}</td>
						<td>${dtl.u3_baru}</td>
						<td>${dtl.u4_baru}</td>
						<td>${dtl.u5_baru}</td>
						<td>${dtl.u6_baru}</td>
						<td>${dtl.u7_baru}</td>
						<td>${dtl.u8_baru}</td>
						<td>${dtl.u9_baru}</td>
						<td>${dtl.u10_baru}</td>
						<td>${dtl.l_baru}</td>
						<td>${dtl.p_baru}</td>
						<td>${dtl.j_baru}</td>
						<td>${dtl.l_lama}</td>
						<td>${dtl.p_lama}</td>
						<td>${dtl.j_lama}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukp3/list";
	}
</script>

<commons:footer />