<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${pelayananEntity.id}
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
						<td>${pelayananEntity.kodePuskesmas}/ ${pelayananEntity.namaPuskesmas}</td>
					</tr>
					<tr>
						<td>Tahun</td>
						<td>${pelayananEntity.tahun}</td>
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
						<th>Item</th>
						<th>Value</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Kode/Nama Puskesmas</td>
						<td>${pelayananEntity.kodePuskesmas}/${pelayananEntity.namaPuskesmas}</td>
					</tr>
					<tr>
						<td>Provinsi/Kota Kabupaten</td>
						<td>${pelayananEntity.provinsi}/${pelayananEntity.kotaKabupaten}</td>
					</tr>
					<tr>
						<td>Bulan/Tahun</td>
						<td>${pelayananEntity.bulan}/${pelayananEntity.tahun}</td>
					</tr>
					<tr>
						<td>Nama</td>
						<td>${pelayananEntity.nama}</td>
					</tr>
					<tr>
						<td>NIK/KK</td>
						<td>${pelayananEntity.nik_kk}</td>
					</tr>
					<tr>
						<td>Tanggal Kunjungan</td>
						<td>${pelayananEntity.tanggal_kunjungan}</td>
					</tr>
					<tr>
						<td>No.BPJS</td>
						<td>${pelayananEntity.nomor_bpjs}</td>
					</tr>
					<tr>
						<td>Diagnosa 1</td>
						<td>${pelayananEntity.kode_diagnosa1}</td>
					</tr>
					<tr>
						<td>Diagnosa 2</td>
						<td>${pelayananEntity.kode_diagnosa2}</td>
					</tr>
					<tr>
						<td>Diagnosa 3</td>
						<td>${pelayananEntity.kode_diagnosa3}</td>
					</tr>
					<tr>
						<td>Sistole</td>
						<td>${pelayananEntity.sistole}</td>
					</tr>
					<tr>
						<td>Diastole</td>
						<td>${pelayananEntity.diastole}</td>
					</tr>
					<tr>
						<td>Berat Badan</td>
						<td>${pelayananEntity.berat_badan}</td>
					</tr>
					<tr>
						<td>Tinggi Badan</td>
						<td>${pelayananEntity.tinggi_badan}</td>
					</tr>
					<tr>
						<td>Respiration Rate</td>
						<td>${pelayananEntity.resp_rate}</td>
					</tr>
					<tr>
						<td>Heart Rate</td>
						<td>${pelayananEntity.heart_rate}</td>
					</tr>
					<tr>
						<td>Catatan</td>
						<td>${pelayananEntity.catatan}</td>
					</tr>
					<tr>
						<td>Rujuk Balik</td>
						<td>${pelayananEntity.rujuk_balik}</td>
					</tr>
					<tr>
						<td>Pemeriksaan Fisik Lain</td>
						<td>${pelayananEntity.pemeriksaan_fisikLain}</td>
					</tr>
					<tr>
						<td>Tindakan</td>
						<td>${pelayananEntity.tindakan}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/pelayanan/list";
	}
</script>

<commons:footer />