<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service UKP 1. Pelayanan Puskesmas</h4>
			<div class="tabs-container">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#tab-form">Form</a></li>
					<li><a data-toggle="tab" href="#tab-url">URL</a></li>
					<li><a data-toggle="tab" href="#tab-ct">Method dan Content
							Type</a></li>
					<li><a data-toggle="tab" href="#tab-request">Contoh
							Request atau PayLoad</a></li>
					<li><a data-toggle="tab" href="#tab-response">Contoh
							Response</a></li>
				</ul>
				<div class="tab-content">
					<div id="tab-form" class="tab-pane active">
						<div class="ibox">
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
											<td>{kodePuskesmas}/ {namaPuskesmas}</td>
										</tr>
										<tr>
											<td>Provinsi</td>
											<td>{provinsi}</td>
										</tr>
										<tr>
											<td>Kota atau Kabupaten</td>
											<td>{kotaKabupaten}</td>
										</tr>
										<tr>
											<td>Bulan/Tahun</td>
											<td>{bulan}/ {tahun}</td>
										</tr>
										<tr>
											<td>Jumlah Puskesmas Pembantu yang Melapor</td>
											<td>{pustu_lapor} dari {pustu_total}</td>
										</tr>
										<tr>
											<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
											<td>{poskesdes_lapor} dari {poskesdes_total}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								I. KUNJUNGAN PUSKESMAS
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{a1_baru}</td>
											<td>{a1_lama}</td>
										</tr>
										<tr>
											<td>2. Jumlah kunjungan dengan kartu sehat</td>
											<td>{a2_baru}</td>
											<td>{a2_lama}</td>
										</tr>
										<tr>
											<td>3. Jumlah kunjungan peserta JKN</td>
											<td>{a3_baru}</td>
											<td>{a3_lama}</td>
										</tr>
										<tr>
											<td>4. Jumlah kunjungan peserta asuransi kesehatan
												lainnya</td>
											<td>{a4_baru}</td>
											<td>{a4_lama}</td>
										</tr>
										<tr>
											<td>5. Jumlah kasus yang dirujuk ke fasilitas pelayanan
												kesehatan sekunder</td>
											<td>{a5_baru}</td>
											<td>{a5_lama}</td>
										</tr>
										<tr>
											<td>6. Jumlah kasus penyakit tidak menular dirujuk
												fasilitas pelayanan sekunder</td>
											<td>{a6_baru}</td>
											<td>{a6_lama}</td>
										</tr>
										<tr>
											<td>7. Jumlah kasus yang dirujuk balik dari fasilitas
												pelayanan kesehatan sekunder</td>
											<td>{a7_baru}</td>
											<td>{a7_lama}</td>
										</tr>
										<tr>
											<td>8. Jumlah rujukan dari Posbindu PTM ke Puskesmas</td>
											<td>{a8_baru}</td>
											<td>{a8_lama}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								II. RAWAT TINGGAL
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{b1_baru}</td>
											<td>{b1_lama}</td>
										</tr>
										<tr>
											<td>2. Jumlah ibu hamil, melahirkan, nifas dengan
												gangguan kesehatan dirawat inap</td>
											<td>{b2_baru}</td>
											<td>{b2_lama}</td>
										</tr>
										<tr>
											<td>3. Jumlah anak berumur &lt;5 th sakit dirawat inap</td>
											<td>{b3_baru}</td>
											<td>{b3_lama}</td>
										</tr>
										<tr>
											<td>4. Jumlah penderita cedera/kecelakaan dirawat inap</td>
											<td>{b4_baru}</td>
											<td>{b4_lama}</td>
										</tr>
										<tr>
											<td>5. Jumlah penderita penyakit tidak menular dirawat
												inap</td>
											<td>{b5_baru}</td>
											<td>{b5_lama}</td>
										</tr>
										<tr>
											<td>6. Jumlah penderita yang keluar sembuh dari rawat
												inap Puskesmas</td>
											<td>{b6_baru}</td>
											<td>{b6_lama}</td>
										</tr>
										<tr>
											<td>7. Jumlah hari rawat semua penderita rawat inap</td>
											<td>{b7_baru}</td>
											<td>{b7_lama}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								III. KEBIDANAN
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{c1_baru}</td>
											<td>{c1_lama}</td>
										</tr>
										<tr>
											<td>2. Jumlah ibu dan bayi yang di rawat gabung</td>
											<td>{c2_baru}</td>
											<td>{c2_lama}</td>
										</tr>
										<tr>
											<td>3. Jumlah kegiatan diskusi refleksi kasus kebidanan
												di Puskesmas</td>
											<td>{c3_baru}</td>
											<td>{c3_lama}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								IV. FISIOTERAPI
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>1. Jumlah kunjungan fisioterapi kasus
												muskuloskeletal</td>
											<td>{d1_baru}</td>
											<td>{d1_lama}</td>
										</tr>
										<tr>
											<td>2. Jumlah kunjungan fisioterapi kasus neurologi</td>
											<td>{d2_baru}</td>
											<td>{d2_lama}</td>
										</tr>
										<tr>
											<td>3. Jumlah kunjungan fisioterapi kasus
												kardiorespirasi</td>
											<td>{d3_baru}</td>
											<td>{d3_lama}</td>
										</tr>
										<tr>
											<td>4. Jumlah kunjungan fisioterapi kasus tumbuh kembang
												anak</td>
											<td>{d4_baru}</td>
											<td>{d4_lama}</td>
										</tr>
										<tr>
											<td>5. Jumlah kunjungan fisioterapi kasus lain-lain</td>
											<td>{d5_baru}</td>
											<td>{d5_lama}</td>
										</tr>
										<tr>
											<td>6. Jumlah kegiatan promotif dan preventif
												fisioterapi pada kelompok</td>
											<td>{d6_baru}</td>
											<td>{d6_lama}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								V. PELAYANAN MEDIK DASAR KESEHATAN GIGI
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{e1_baru}</td>
											<td>{e1_lama}</td>
										</tr>
										<tr>
											<td>2. Jumlah penambalan gigi sulung</td>
											<td>{e2_baru}</td>
											<td>{e2_lama}</td>
										</tr>
										<tr>
											<td>3. Jumlah pencabutan gigi tetap</td>
											<td>{e3_baru}</td>
											<td>{e3_lama}</td>
										</tr>
										<tr>
											<td>4. Jumlah pencabutan gigi sulung</td>
											<td>{e4_baru}</td>
											<td>{e4_lama}</td>
										</tr>
										<tr>
											<td>5. Jumlah pembersihan karang gigi</td>
											<td>{e5_baru}</td>
											<td>{e5_lama}</td>
										</tr>
										<tr>
											<td>6. Jumlah premedikasi/pengobatan</td>
											<td>{e6_baru}</td>
											<td>{e6_lama}</td>
										</tr>
										<tr>
											<td>7. Jumlah pelayanan rujukan gigi</td>
											<td>{e7_baru}</td>
											<td>{e7_lama}</td>
										</tr>
										<tr>
											<td>8. Jumlah SD/MI dilaksanakan pemeriksaan kesehatan
												gigi dan mulut</td>
											<td>{e8_baru}</td>
											<td>{e8_lama}</td>
										</tr>
										<tr>
											<td>9. Jumlah murid SD/MI perlu perawatan kesehatan gigi</td>
											<td>{e9_baru}</td>
											<td>{e9_lama}</td>
										</tr>
										<tr>
											<td>10. Jumlah murid SD yang mendapat perawatan
												kesehatan gigi</td>
											<td>{e10_baru}</td>
											<td>{e10_lama}</td>
										</tr>
										<tr>
											<td>11. Jumlah SD/MI yang melaksanakan sikat gigi
												bersama</td>
											<td>{e11_baru}</td>
											<td>{e11_lama}</td>
										</tr>
										<tr>
											<td>12. Jumlah desa/kelurahan dengan UKGM</td>
											<td>{e12_baru}</td>
											<td>{e12_lama}</td>
										</tr>
										<tr>
											<td>13. Jumlah pemasangan gigi tiruan</td>
											<td>{e13_baru}</td>
											<td>{e13_lama}</td>
										</tr>
										<tr>
											<td>14. Jumlah ibu hamil yang mendapatkan perawatan gigi
											</td>
											<td>{e14_baru}</td>
											<td>{e14_lama}</td>
										</tr>
										<tr>
											<td>16. Jumlah TK/PAUD yang dilakukan penjaringan</td>
											<td>{e16_baru}</td>
											<td>{e16_lama}</td>
										</tr>
										<tr>
											<td>17. Jumlah SD/MI yang dilakukan pemeriksaan indeks
												karies</td>
											<td>{e17_baru}</td>
											<td>{e17_lama}</td>
										</tr>
										<tr>
											<td>18. Jumlah TK/PAUD yang dilakukan pemeriksaan indeks
												karies</td>
											<td>{e18_baru}</td>
											<td>{e18_lama}</td>
										</tr>
										<tr>
											<td>19. Jumlah SD/MI yang melakukan topikal aplikasi
												flour</td>
											<td>{e19_baru}</td>
											<td>{e19_lama}</td>
										</tr>
										<tr>
											<td>20. Jumlah TK/PAUD yang dilakukan pemeriksaan
												berkala</td>
											<td>{e20_baru}</td>
											<td>{e20_lama}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								VI. PELAYANAN LABORATORIUM
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{f1_baru}</td>
											<td>{f1_lama}</td>
										</tr>
										<tr>
											<td>2. Jumlah pemeriksaan kimia klinik</td>
											<td>{f2_baru}</td>
											<td>{f2_lama}</td>
										</tr>
										<tr>
											<td>3. Jumlah pemeriksaan urinalisa</td>
											<td>{f3_baru}</td>
											<td>{f3_lama}</td>
										</tr>
										<tr>
											<td>4. Jumlah pemeriksaan mikrobiologi dan parasitologi</td>
											<td>{f4_baru}</td>
											<td>{f4_lama}</td>
										</tr>
										<tr>
											<td>5. Jumlah pemeriksaan imunologi</td>
											<td>{f5_baru}</td>
											<td>{f5_lama}</td>
										</tr>
										<tr>
											<td>6. Jumlah pemeriksaan tinja</td>
											<td>{f6_baru}</td>
											<td>{f6_lama}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								VIII. PELAYANAN FARMASI
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>{g1_baru}</td>
											<td>{g1_lama}</td>
										</tr>
										<tr>
											<td>2. Jumlah resep dari rawat inap</td>
											<td>{g2_baru}</td>
											<td>{g2_lama}</td>
										</tr>
										<tr>
											<td>3. Jumlah konseling obat</td>
											<td>{g3_baru}</td>
											<td>{g3_lama}</td>
										</tr>
										<tr>
											<td>4. Jumlah pemberian informasi obat</td>
											<td>{g4_baru}</td>
											<td>{g4_lama}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-url" class="tab-pane">
						<div class="ibox">
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
											<td>Format</td>
											<td><strong>{URL}</strong>/sip/rest/ukp1/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/ukp1/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
										</tr>
										<tr>
											<td></td>
											<td><p>
													<strong>*URL</strong> dan <strong>TOKEN</strong> akan
													diberikan oleh Pusdatin Kementerian Kesehatan
												</p></td>
										</tr>
										<tr>
											<td></td>
											<td><img width="90%"
												src="${ pageContext.request.contextPath }/images/url_ukp1.png" /></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-ct" class="tab-pane">
						<div class="ibox">
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
											<td>Method</td>
											<td>POST</td>
										</tr>
										<tr>
											<td>Content-Type</td>
											<td>application/json</td>
										</tr>
										<tr>
											<td></td>
											<td><img width="90%"
												src="${ pageContext.request.contextPath }/images/ct_ukme1.png" /></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-request" class="tab-pane">
						<div class="ibox">
							<div class="ibox-content">
								<pre id="requestJsonFormat"></pre>
							</div>
						</div>
					</div>
					<div id="tab-response" class="tab-pane">
						<div class="ibox">
							<div class="ibox-content">
								<pre id="responseJsonFormat"></pre>
							</div>
						</div>
					</div>
				</div>

			</div>
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
		document.getElementById("requestJsonFormat").innerHTML = JSON.stringify(${requestJsonFormat}, undefined, 2);
		document.getElementById("responseJsonFormat").innerHTML = JSON.stringify(${responseJsonFormat}, undefined, 2);

	});

	function cancel() {
		document.location.href = "${pageContext.request.contextPath}/web/ukme1/list";
	}
</script>

<commons:footer />