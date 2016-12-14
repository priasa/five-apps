<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukme1.id}
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
								<td>${ukme1.kodePuskesmas} / ${ukme1.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukme1.bulan} / ${ukme1.tahun}</td>
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
		<div class="ibox-title">A. Promosi Kesehatan Umum
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
								<td>1. Jumlah kegiatan Penyuluhan di Puskesmas dan jaringannya semua topik</td>
								<td></td>
							</tr>
							<tr>
								<td>a. Jumlah penyuluhan individu</td>
								<td>${ukme1.a1a}</td>
							</tr>
							<tr>
								<td>b. Jumlah kunjungan rumah</td>
								<td>${ukme1.a1b}</td>
							</tr>
							<tr>
								<td>c. Jumlah penyuluhan kelompok</td>
								<td>${ukme1.a1c}</td>
							</tr>
							<tr>
								<td>d. Jumlah penyuluhan individu, kunjungan rumah dan penyuluhan kelompok</td>
								<td>${ukme1.a1d}</td>
							</tr>
							<tr>
								<td>2. Jumlah kegiatan advokasi di tingkat desa/kelurahan dan kecamatan bidang kesehatan</td>
								<td>${ukme1.a2}</td>
							</tr>
							<tr>
								<td>3. Jumlah kegiatan penggalangan kemitraan dengan dunia usaha dan lintas sektor tingkat desa/kelurahan dan kecamatan bidang kesehatan</td>
								<td>${ukme1.a3}</td>
							</tr>
							<tr>
								<td>4. Jumlah kegiatan pembinaan UKBM atau kelompok masyarakat</td>
								<td>${ukme1.a4}</td>
							</tr>
							<tr>
								<td>8. Jumlah jenis media yang digunakan dalam penyebaran informasi</td>
								<td>${ukme1.a8}</td>
							</tr>
							<tr>
								<td>9. Pelaksanaan Promosi Kesehatan di Puskesmas (Ya/Tidak)</td>
								<td>${ukme1.a9}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">B. Promosi Kesehatan Penyakit Menular
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
								<td>1. Jumlah kegiatan Penyuluhan di Puskesmas dan jaringannyatopik diare</td>
								<td>${ukme1.b1}</td>
							</tr>
							<tr>
								<td>2. Jumlah kegiatan Penyuluhan di Puskesmas dan jaringannyatopik tifoid</td>
								<td>${ukme1.b2}</td>
							</tr>
							<tr>
								<td>3. Jumlah kegiatan Penyuluhan di Puskesmas dan jaringannyatopik hepatitis</td>
								<td>${ukme1.b3}</td>
							</tr>
							<tr>
								<td>4. Jumlah kegiatan Penyuluhan di Puskesmas dan jaringannyatopik HIV/AIDS</td>
								<td>${ukme1.b4}</td>
							</tr>
							<tr>
								<td>5. Jumlah SLTP/SLTA yang terlaksana pelayanan konseling/penyuluhan individu kesehatan remaja (HIV/AIDS)</td>
								<td>${ukme1.b5}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">C. Promosi Kesehatan Lingkungan
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
								<td>1. Jumlah klien/pasien/perseorangan mendapat konseling/penyuluhan kesehatan lingkungan di rumahnya (luar gedung)</td>
								<td>${ukme1.c1}</td>
							</tr>
							<tr>
								<td>2. Jumlah klien/pasien/perseorangan mendapat konseling kesehatan/penyuluhan lingkungan di klinik sanitasi (dalam gedung)</td>
								<td>${ukme1.c2}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">D. Promosi Kesehatan KIA, termasuk remaja
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
								<td>1. Jumlah Sekolah terlaksana kegiatan KIE/penyuluhan kesehatan remaja oleh tenaga kesehatan</td>
								<td>${ukme1.d1}</td>
							</tr>
							<tr>
								<td>2. Jumlah kelompok remaja diluar sekolah (karang taruna, remaja mesjid, gereja, pura, wihara, dll) yang mendapatkan KIE/penyuluhan kesehatan remaja</td>
								<td>${ukme1.d2}</td>
							</tr>
							<tr>
								<td>3. Jumlah remaja mendapatkan konseling oleh tenaga kesehatan</td>
								<td>${ukme1.d3}</td>
							</tr>
							<tr>
								<td>4. Jumlah remaja mendapat KIE/penyuluhan kesehatan reproduksi</td>
								<td>${ukme1.d4}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">E. Promosi Kesehatan Pelayanan Kesehatan
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
								<td>1. Jumlah SD/MI melaksanakan sikat gigi bersama</td>
								<td>${ukme1.e1}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">F. PTM
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
								<td>1. Jumlah penduduk mengikuti konseling /penyuluhan kesehatan perorangan sesuai topik :</td>
								<td></td>
							</tr>
							<tr>
								<td>a. Diet</td>
								<td>${ukme1.f1a}</td>
							</tr>
							<tr>
								<td>b. Berhenti Merokok</td>
								<td>${ukme1.f1b}</td>
							</tr>
							<tr>
								<td>c. Potensi Cedera</td>
								<td>${ukme1.f1c}</td>
							</tr>
							<tr>
								<td>d. IVA-SADANIS</td>
								<td>${ukme1.f1d}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukme1/list";
	}
</script>

<commons:footer />