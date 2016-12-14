<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukp1.id}
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
								<td>${ukp1.kodePuskesmas} / ${ukp1.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukp1.bulan} / ${ukp1.tahun}</td>
							</tr>
							<tr>
								<td>Jumlah Puskesmas Pembantu yang Melapor</td>
								<td>${ukp1.pustu_lapor} dari ${ukp1.pustu_total}</td>
							</tr>
							<tr>
								<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
								<td>${ukp1.poskesdes_lapor} dari ${ukp1.poskesdes_total}</td>
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
		<div class="ibox-title">I. KUNJUNGAN PUSKESMAS
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah kunjungan Puskesmas (baru dan Lama)</td>
								<td>${ukp1.a1_baru}</td>
								<td>${ukp1.a1_lama}</td>
							</tr>
							<tr>
								<td>2. Jumlah kunjungan dengan kartu sehat</td>
								<td>${ukp1.a2_baru}</td>
								<td>${ukp1.a2_lama}</td>
							</tr>
							<tr>
								<td>3. Jumlah kunjungan peserta JKN</td>
								<td>${ukp1.a3_baru}</td>
								<td>${ukp1.a3_lama}</td>
							</tr>
							<tr>
								<td>4. Jumlah kunjungan peserta asuransi kesehatan lainnya</td>
								<td>${ukp1.a4_baru}</td>
								<td>${ukp1.a4_lama}</td>
							</tr>
							<tr>
								<td>5. Jumlah kasus yang dirujuk ke fasilitas pelayanan kesehatan sekunder</td>
								<td>${ukp1.a5_baru}</td>
								<td>${ukp1.a5_lama}</td>
							</tr>
							<tr>
								<td>6. Jumlah kasus penyakit tidak menular dirujuk fasilitas pelayanan sekunder</td>
								<td>${ukp1.a6_baru}</td>
								<td>${ukp1.a6_lama}</td>
							</tr>
							<tr>
								<td>7. Jumlah kasus yang dirujuk balik dari fasilitas pelayanan kesehatan sekunder</td>
								<td>${ukp1.a7_baru}</td>
								<td>${ukp1.a7_lama}</td>
							</tr>
							<tr>
								<td>8. Jumlah rujukan dari Posbindu PTM ke Puskesmas</td>
								<td>${ukp1.a8_baru}</td>
								<td>${ukp1.a8_lama}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">II. RAWAT TINGGAL
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah penderita rawat inap</td>
								<td>${ukp1.b1_baru}</td>
								<td>${ukp1.b1_lama}</td>
							</tr>
							<tr>
								<td>2. Jumlah ibu hamil, melahirkan, nifas dengan gangguan kesehatan dirawat inap</td>
								<td>${ukp1.b2_baru}</td>
								<td>${ukp1.b2_lama}</td>
							</tr>
							<tr>
								<td>3. Jumlah anak berumur &lt;5 th sakit dirawat inap</td>
								<td>${ukp1.b3_baru}</td>
								<td>${ukp1.b3_lama}</td>
							</tr>
							<tr>
								<td>4. Jumlah penderita cedera/kecelakaan dirawat inap</td>
								<td>${ukp1.b4_baru}</td>
								<td>${ukp1.b4_lama}</td>
							</tr>
							<tr>
								<td>5. Jumlah penderita penyakit tidak menular dirawat inap</td>
								<td>${ukp1.b5_baru}</td>
								<td>${ukp1.b5_lama}</td>
							</tr>
							<tr>
								<td>6. Jumlah penderita yang keluar sembuh dari rawat inap Puskesmas</td>
								<td>${ukp1.b6_baru}</td>
								<td>${ukp1.b6_lama}</td>
							</tr>
							<tr>
								<td>7. Jumlah hari rawat semua penderita rawat inap</td>
								<td>${ukp1.b7_baru}</td>
								<td>${ukp1.b7_lama}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	
	<div class="ibox">
		<div class="ibox-title">III. KEBIDANAN
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah persalinan di tolong bidan</td>
								<td>${ukp1.c1_baru}</td>
								<td>${ukp1.c1_lama}</td>
							</tr>
							<tr>
								<td>2. Jumlah ibu dan bayi yang di rawat gabung</td>
								<td>${ukp1.c2_baru}</td>
								<td>${ukp1.c2_lama}</td>
							</tr>
							<tr>
								<td>3. Jumlah kegiatan diskusi refleksi kasus kebidanan di Puskesmas</td>
								<td>${ukp1.c3_baru}</td>
								<td>${ukp1.c3_lama}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	
	<div class="ibox">
		<div class="ibox-title">IV. FISIOTERAPI
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah kunjungan fisioterapi kasus muskuloskeletal</td>
								<td>${ukp1.d1_baru}</td>
								<td>${ukp1.d1_lama}</td>
							</tr>
							<tr>
								<td>2. Jumlah kunjungan fisioterapi kasus neurologi</td>
								<td>${ukp1.d2_baru}</td>
								<td>${ukp1.d2_lama}</td>
							</tr>
							<tr>
								<td>3. Jumlah kunjungan fisioterapi kasus kardiorespirasi</td>
								<td>${ukp1.d3_baru}</td>
								<td>${ukp1.d3_lama}</td>
							</tr>
							<tr>
								<td>4. Jumlah kunjungan fisioterapi kasus tumbuh kembang anak</td>
								<td>${ukp1.d4_baru}</td>
								<td>${ukp1.d4_lama}</td>
							</tr>
							<tr>
								<td>5. Jumlah kunjungan fisioterapi kasus lain-lain</td>
								<td>${ukp1.d5_baru}</td>
								<td>${ukp1.d5_lama}</td>
							</tr>
							<tr>
								<td>6. Jumlah kegiatan promotif dan preventif fisioterapi pada kelompok</td>
								<td>${ukp1.d6_baru}</td>
								<td>${ukp1.d6_lama}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	
	<div class="ibox">
		<div class="ibox-title">V. PELAYANAN MEDIK DASAR KESEHATAN GIGI
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah penambalan gigi tetap</td>
								<td>${ukp1.e1_baru}</td>
								<td>${ukp1.e1_lama}</td>
							</tr>
							<tr>
								<td>2. Jumlah penambalan gigi sulung</td>
								<td>${ukp1.e2_baru}</td>
								<td>${ukp1.e2_lama}</td>
							</tr>
							<tr>
								<td>3. Jumlah pencabutan gigi tetap</td>
								<td>${ukp1.e3_baru}</td>
								<td>${ukp1.e3_lama}</td>
							</tr>
							<tr>
								<td>4. Jumlah pencabutan gigi sulung</td>
								<td>${ukp1.e4_baru}</td>
								<td>${ukp1.e4_lama}</td>
							</tr>
							<tr>
								<td>5. Jumlah pembersihan karang gigi</td>
								<td>${ukp1.e5_baru}</td>
								<td>${ukp1.e5_lama}</td>
							</tr>
							<tr>
								<td>6. Jumlah premedikasi/pengobatan</td>
								<td>${ukp1.e6_baru}</td>
								<td>${ukp1.e6_lama}</td>
							</tr>
							<tr>
								<td>7. Jumlah pelayanan rujukan gigi</td>
								<td>${ukp1.e7_baru}</td>
								<td>${ukp1.e7_lama}</td>
							</tr>
							<tr>
								<td>8. Jumlah SD/MI dilaksanakan pemeriksaan kesehatan gigi dan mulut</td>
								<td>${ukp1.e8_baru}</td>
								<td>${ukp1.e8_lama}</td>
							</tr>
							<tr>
								<td>9. Jumlah murid SD/MI perlu perawatan kesehatan gigi</td>
								<td>${ukp1.e9_baru}</td>
								<td>${ukp1.e9_lama}</td>
							</tr>
							<tr>
								<td>10. Jumlah murid SD yang mendapat perawatan kesehatan gigi</td>
								<td>${ukp1.e10_baru}</td>
								<td>${ukp1.e10_lama}</td>
							</tr>
							<tr>
								<td>11. Jumlah SD/MI yang melaksanakan sikat gigi bersama</td>
								<td>${ukp1.e11_baru}</td>
								<td>${ukp1.e11_lama}</td>
							</tr>
							<tr>
								<td>12. Jumlah desa/kelurahan dengan UKGM</td>
								<td>${ukp1.e12_baru}</td>
								<td>${ukp1.e12_lama}</td>
							</tr>
							<tr>
								<td>13. Jumlah pemasangan gigi tiruan</td>
								<td>${ukp1.e13_baru}</td>
								<td>${ukp1.e13_lama}</td>
							</tr>
							<tr>
								<td>14. Jumlah ibu hamil yang mendapatkan perawatan gigi </td>
								<td>${ukp1.e14_baru}</td>
								<td>${ukp1.e14_lama}</td>
							</tr>
							<tr>
								<td>16. Jumlah TK/PAUD yang dilakukan penjaringan</td>
								<td>${ukp1.e16_baru}</td>
								<td>${ukp1.e16_lama}</td>
							</tr>
							<tr>
								<td>17. Jumlah SD/MI yang dilakukan pemeriksaan indeks karies</td>
								<td>${ukp1.e17_baru}</td>
								<td>${ukp1.e17_lama}</td>
							</tr>
							<tr>
								<td>18. Jumlah TK/PAUD yang  dilakukan pemeriksaan indeks karies</td>
								<td>${ukp1.e18_baru}</td>
								<td>${ukp1.e18_lama}</td>
							</tr>
							<tr>
								<td>19. Jumlah SD/MI yang melakukan topikal aplikasi flour</td>
								<td>${ukp1.e19_baru}</td>
								<td>${ukp1.e19_lama}</td>
							</tr>
							<tr>
								<td>20. Jumlah TK/PAUD yang dilakukan pemeriksaan berkala</td>
								<td>${ukp1.e20_baru}</td>
								<td>${ukp1.e20_lama}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	
	<div class="ibox">
		<div class="ibox-title">VI. PELAYANAN LABORATORIUM    
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah pemeriksaan hematologi</td>
								<td>${ukp1.f1_baru}</td>
								<td>${ukp1.f1_lama}</td>
							</tr>
							<tr>
								<td>2. Jumlah pemeriksaan kimia klinik</td>
								<td>${ukp1.f2_baru}</td>
								<td>${ukp1.f2_lama}</td>
							</tr>
							<tr>
								<td>3. Jumlah pemeriksaan urinalisa</td>
								<td>${ukp1.f3_baru}</td>
								<td>${ukp1.f3_lama}</td>
							</tr>
							<tr>
								<td>4. Jumlah pemeriksaan mikrobiologi dan parasitologi</td>
								<td>${ukp1.f4_baru}</td>
								<td>${ukp1.f4_lama}</td>
							</tr>
							<tr>
								<td>5. Jumlah pemeriksaan imunologi</td>
								<td>${ukp1.f5_baru}</td>
								<td>${ukp1.f5_lama}</td>
							</tr>
							<tr>
								<td>6. Jumlah pemeriksaan tinja</td>
								<td>${ukp1.f6_baru}</td>
								<td>${ukp1.f6_lama}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	
	<div class="ibox">
		<div class="ibox-title">VIII. PELAYANAN FARMASI    
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>Baru</th>
							<th>Lama</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1. Jumlah resep dari rawat jalan</td>
								<td>${ukp1.g1_baru}</td>
								<td>${ukp1.g1_lama}</td>
							</tr>
							<tr>
								<td>2. Jumlah resep dari rawat inap</td>
								<td>${ukp1.g2_baru}</td>
								<td>${ukp1.g2_lama}</td>
							</tr>
							<tr>
								<td>3. Jumlah konseling obat</td>
								<td>${ukp1.g3_baru}</td>
								<td>${ukp1.g3_lama}</td>
							</tr>
							<tr>
								<td>4. Jumlah pemberian informasi obat</td>
								<td>${ukp1.g4_baru}</td>
								<td>${ukp1.g4_lama}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukp1/list";
	}
</script>

<commons:footer />