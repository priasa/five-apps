<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service UKME 2. Kesehatan Lingkungan</h4>
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
							<div class="ibox-title">
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
											<td>{kodePuskesmas}/ {namaPuskesmas}</td>
										</tr>
										<tr>
											<td>Bulan/Tahun</td>
											<td>{bulan}/ {tahun}</td>
										</tr>
										<tr>
											<td>Provinsi</td>
											<td>{provinsi}</td>
										</tr>
										<tr>
											<td>Kota atau Kabupaten</td>
											<td>{kotaKabupaten}</td>
										</tr>
									</tbody>
								</table>
								
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
											<th></th>
											<th></th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1. Jumlah sarana air minum yang dilakukan inspeksi
												kesehatan lingkungan:</td>
											<td>Berisiko Rendah/Sedang</td>
											<td>Berisiko Tinggi/Amat Tinggi</td>
										</tr>
										<tr>
											<td>a. Jumlah sarana perpipaan perusahaan air minum</td>
											<td>{a1}</td>
											<td>{aa1}</td>
										</tr>
										<tr>
											<td>b. Jumlah sarana air minum perpipaan non perusahaan
												air minum (sarana komunal)</td>
											<td>{b1}</td>
											<td>{ab1}</td>
										</tr>
										<tr>
											<td>c. Jumlah sumur gali</td>
											<td>{c1}</td>
											<td>{ac1}</td>
										</tr>
										<tr>
											<td>d. Jumlah penampungan air hujan</td>
											<td>{d1}</td>
											<td>{ad1}</td>
										</tr>
										<tr>
											<td>e. Jumlah perlindungan mata air</td>
											<td>{e1}</td>
											<td>{ae1}</td>
										</tr>
										<tr>
											<td>f. Jumlah sumur bor dengan pompa</td>
											<td>{f1}</td>
											<td>{af1}</td>
										</tr>
										<tr>
											<td>g. Jumlah terminal air dan tangki air</td>
											<td>{g1}</td>
											<td>{ag1}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>2. Jumlah tempat pengelolaan makanan (TPM) yang
												dilakukan inspeksi kesehatan lingkungan:</td>
											<td>Memenuhi Syarat</td>
											<td>Tidak Memenuhi Syarat</td>
										</tr>
										<tr>
											<td>a. Jumlah rumah makan/restoran</td>
											<td>{a2}</td>
											<td>{aa2}</td>
										</tr>
										<tr>
											<td>b. Jumlah jasaboga</td>
											<td>{b2}</td>
											<td>{ab2}</td>
										</tr>
										<tr>
											<td>c. Jumlah depot air minum</td>
											<td>{c2}</td>
											<td>{ac2}</td>
										</tr>
										<tr>
											<td>d. Jumlah sentra makanan jajanan</td>
											<td>{d2}</td>
											<td>{ad2}</td>
										</tr>
										<tr>
											<td>e. Jumlah kantin sekolah</td>
											<td>{e2}</td>
											<td>{ae2}</td>
										</tr>
										<tr>
											<td>f. Jumlah kantin institusi</td>
											<td>{f2}</td>
											<td>{af2}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>3. Jumlah tempat-tempat umum (TTU) yang dilakukan
												inspeksi kesehatan lingkungan:</td>
											<td>Memenuhi Syarat</td>
											<td>Tidak Memenuhi Syarat</td>
										</tr>
										<tr>
											<td>a. Jumlah sekolah</td>
											<td>{a3}</td>
											<td>{aa3}</td>
										</tr>
										<tr>
											<td>b. Jumlah pondok pesantren</td>
											<td>{b3}</td>
											<td>{ab3}</td>
										</tr>
										<tr>
											<td>c. Jumlah pasar rakyat/tradisional</td>
											<td>{c3}</td>
											<td>{ac3}</td>
										</tr>
										<tr>
											<td>d. Jumlah fasilitas pelayanan kesehatan tingkat
												pertama/primer (Puskesmas, Puskesmas Pembantu dan balai
												pengobatan)</td>
											<td>{d3}</td>
											<td>{ad3}</td>
										</tr>
										<tr>
											<td>e. Jumlah tempat ibadah</td>
											<td>{e3}</td>
											<td>{ae3}</td>
										</tr>
										<tr>
											<td>f. Jumlah hotel</td>
											<td>{f3}</td>
											<td>{af3}</td>
										</tr>
										<tr>
											<td>g. Jumlah terminal/stasiun</td>
											<td>{g3}</td>
											<td>{ag3}</td>
										</tr>
										<tr>
											<td>h. Jumlah tempat rekreasi, hiburan, wisata</td>
											<td>{h3}</td>
											<td>{ah3}</td>
										</tr>
										<tr>
											<td>j. Jumlah lembaga pemasyrakatan/rumah tahanan</td>
											<td>{j3}</td>
											<td>{aj3}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>4. Jumlah rumah dilakukan inspeksi kesehatan
												lingkungan dan memenuhi syarat kesehatan</td>
											<td>{a4}</td>
											<td>{aa4}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>5. Jumlah pasien/klien mendapatkan pelayanan
												konseling kesehatan lingkungan setiap hari kerja Puskesmas</td>
											<td>{a5}</td>
											<td></td>
										</tr>
										<tr>
											<td>6. Jumlah desa/kelurahan yang melaksanakan sanitasi
												total berbasis masyarakat (STBM)</td>
											<td>{a6}</td>
											<td></td>
										</tr>
										<tr>
											<td>7. Jumlah desa/kelurahan bebas dari buang air besar
												sembarangan (open defecation free/ODF)</td>
											<td>{a7}</td>
											<td></td>
										</tr>
										<tr>
											<td>8. Sekolah yang melakukan deteksi dini tifoid bagi
												para penjamah makanan yg berjualan di sekolah</td>
											<td>{a8}</td>
											<td></td>
										</tr>
										<tr>
											<td>9. Sekolah yang menerapkan kawasan tanpa rokok (KTR)
											</td>
											<td>{a9}</td>
											<td></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-url" class="tab-pane">
						<div class="ibox">
							<div class="ibox-title"></div>
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
											<td><strong>{URL}</strong>/sip/rest/ukme2/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/ukme2/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
											<td><img width="90%" src="${ pageContext.request.contextPath }/images/url_ukme2.png" /></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-ct" class="tab-pane">
						<div class="ibox">
							<div class="ibox-title"></div>
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
											<td><img width="90%" src="${ pageContext.request.contextPath }/images/ct_ukme1.png" /></td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div id="tab-request" class="tab-pane">
						<div class="ibox">
							<div class="ibox-title"></div>
							<div class="ibox-content">
								<pre id="requestJsonFormat"></pre>
							</div>
						</div>
					</div>
					<div id="tab-response" class="tab-pane">
						<div class="ibox">
							<div class="ibox-title"></div>
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