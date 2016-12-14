<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukmp2.id}
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
							<tbody>
							<tr>
								<td>Puskesmas</td>
								<td>${ukmp2.kodePuskesmas} / ${ukmp2.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukmp2.bulan} / ${ukmp2.tahun}</td>
							</tr>
							<tr>
								<td>Jumlah Puskesmas Pembantu yang Melapor</td>
								<td>${ukmp2.pustu_lapor} dari ${ukmp2.pustu_total}</td>
							</tr>
							<tr>
								<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
								<td>${ukmp2.poskesdes_lapor} dari ${ukmp2.poskesdes_total}</td>
							</tr>
					</tbody>
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
		<div class="ibox-title">1. Pelayanan kesehatan kerja dasar yang dilaksanakan di internal dan eksternal Puskesmas
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
								<td>a. Jumlah kelompok kerja yang dibina</td>
								<td>${ukmp2.a1}</td>
							</tr>
							<tr>
								<td>b. Jumlah tempat kerja yang diperiksa dan teridentifikasi potensi bahaya</td>
								<td>${ukmp2.b1}</td>
							</tr>
							<tr>
								<td>c. Jumlah tempat kerja yang dibina</td>
								<td>${ukmp2.c1}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>d. Jumlah kasus penyakit pada pekerja :</td>
								<td></td>
							</tr>
							<tr>
								<td>1. ${ukmp2.d11}</td>
								<td>${ukmp2.d11a}</td>
							</tr>
							<tr>
								<td>2. ${ukmp2.d12}</td>
								<td>${ukmp2.d12a}</td>
							</tr>
							<tr>
								<td>3. ${ukmp2.d13}</td>
								<td>${ukmp2.d13a}</td>
							</tr>
							<tr>
								<td>4. ${ukmp2.d14}</td>
								<td>${ukmp2.d14a}</td>
							</tr>
							<tr>
								<td>5. ${ukmp2.d15}</td>
								<td>${ukmp2.d15a}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>e. Jumlah kasus penyakit akibat kerja pada pekerja</td>
								<td>${ukmp2.e1}</td>
							</tr>
							<tr>
								<td>f. Jumlah kasus kecelakaan akibat kerja pada pekerja</td>
								<td>${ukmp2.f1}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>g. Jumlah Pekerja yang mendapatkan pelayanan berdasarkan jenis pekerjaan (jenis pekerjaan berupa penggolongan konstruksi, pertambangan, manufaktur, faskes, pertanian, perikanan dan jasa/ atau berdasarkan faktor risiko) :</td>
								<td></td>
							</tr>
							<tr>
								<td>1. Konstruksi</td>
								<td>${ukmp2.g11a}</td>
							</tr>
							<tr>
								<td>2. Pertambangan</td>
								<td>${ukmp2.g12a}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>h. Jumlah pekerja yang mendapatkan pelayanan promotif , preventif dan/atau rehabilitatif berdasarkan jenis pelayanan :</td>
								<td></td>
							</tr>
							<tr>
								<td>1. Promotif</td>
								<td>${ukmp2.h11}</td>
							</tr>
							<tr>
								<td>2. Preventif</td>
								<td>${ukmp2.h12}</td>
							</tr>
							<tr>
								<td>3. Kuratif</td>
								<td>${ukmp2.h13}</td>
							</tr>
							<tr>
								<td>4. Rehabilitatif</td>
								<td>${ukmp2.h14}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>i. Penerapan kewaspadaan standar di lingkungan Puskesmas</td>
								<td>${ukmp2.i1}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	
	<div class="ibox">
		<div class="ibox-title">2. Kesehatan Olahraga
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
								<td>a. Jumlah kelompok olahraga terdaftar di Puskesmas pada bulan ini</td>
								<td>${ukmp2.a2}</td>
							</tr>
							<tr>
								<td>b. Jumlah kelompok olahraga yang dibina Puskesmas</td>
								<td>${ukmp2.b2}</td>
							</tr>
							<tr>
								<td>c. Jumlah kelompok olahraga yang diperiksa kesehatan anggotanya</td>
								<td>${ukmp2.c2}</td>
							</tr>
							<tr>
								<td>d. Jumlah kelompok olahraga yang dilakukan penyuluhan</td>
								<td>${ukmp2.d2}</td>
							</tr>
							<tr>
								<td>e. Jumlah orang yang mendapatkan konsultasi kesehatan olahraga</td>
								<td>${ukmp2.e2}</td>
							</tr>
							<tr>
								<td>f. Jumlah orang yang diukur tingkat kebugaran jasmani</td>
								<td>${ukmp2.f2}</td>
							</tr>
							<tr>
								<td>g. Jumlah orang yang mendapatkan penanganan cedera olahraga akut</td>
								<td>${ukmp2.g2}</td>
							</tr>
							<tr>
								<td>h. Jumlah atlet yang dilayani kesehatan pada even olahraga</td>
								<td>${ukmp2.h2}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	
	<div class="ibox">
		<div class="ibox-title">3. POS KK
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
								<td>1. Jumlah POS UKK yang dibina Puskesmas bulan ini</td>
								<td>${ukmp2.a3}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">4. Program Pelayanan Kesehatan Tradisonal dan Komplementer
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
								<td>1. Jumlah kunjungan kasus dengan pelayanan akupresur di Puskesmas</td>
								<td>${ukmp2.a4}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukmp2/list";
	}
</script>

<commons:footer />