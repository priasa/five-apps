<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukme3b.id}
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
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
								<td>${ukme3b.kodePuskesmas} / ${ukme3b.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Sekolah</td>
								<td>${ukme3b.sekolah}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukme3b.bulan} / ${ukme3b.tahun}</td>
							</tr>
							<tr>
								<td>Jumlah Puskesmas Pembantu yang Melapor</td>
								<td>${ukme3b.pustu_lapor} dari ${ukme3b.pustu_total}</td>
							</tr>
							<tr>
								<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
								<td>${ukme3b.poskesdes_lapor} dari ${ukme3b.poskesdes_total}</td>
							</tr>
							
					</tbody>
			</table>
			<div class="row tableAction">
					<div class="col-sm-8">
						<button type="button" class="btn btn-success btn-sm" onclick="cancel()">
							<fmt:message key="general.back" />
						</button>
					</div>
				</div>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">PROGRAM USAHA KESEHATAN SEKOLAH
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
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
								<td>1. Jumlah murid  baru kelas 1, kelas 7 dan kelas 10 serta SLB  yang dilakukan penjaringan kesehatan  (Y/T)</td>
								<td>${ukme3b.a1}</td>
							</tr>
							<tr>
								<td>2. Jumlah murid kelas 1, kelas 7, kelas 10 dan SLB mengalami masalah kesehatan (hasil penjaringan kesehatan)</td>
								<td></td>
							</tr>
							<tr>
								<td>a.	Masalah kegemukan</td>
								<td>${ukme3b.a2}</td>
							</tr>
							<tr>
								<td>b.	Masalah gizi kurang</td>
								<td>${ukme3b.b2}</td>
							</tr>
							<tr>
								<td>c.	Gangguan penglihatan</td>
								<td>${ukme3b.c2}</td>
							</tr>
							<tr>
								<td>d.	Gangguan pendengaran</td>
								<td>${ukme3b.d2}</td>
							</tr>
							<tr>
								<td>e.	Gangguan gigi dan mulut</td>
								<td>${ukme3b.e2}</td>
							</tr>
							<tr>
								<td>f.	Stunting</td>
								<td>${ukme3b.f2}</td>
							</tr>
							<tr>
								<td>g.	Dugaan anemia</td>
								<td>${ukme3b.g2}</td>
							</tr>
							<tr>
								<td>h.	Masalah kesehatan reproduksi</td>
								<td>${ukme3b.h2}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukme3b/list";
	}
</script>

<commons:footer />