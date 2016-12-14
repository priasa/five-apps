<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<h4>Tata Cara Penggunaan Web Service UKME 6. Penyakit Tidak
				Menular</h4>
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
											<td>Puskesmas</td>
											<td>{kodePuskesmas}/{namaPuskesmas}</td>
										</tr>
										<tr>
											<td>Bulan/Tahun</td>
											<td>{bulan}/{tahun}</td>
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
								A. Deteksi Dini Kanker Leher Rahim dan Payudara
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>1. Jumlah perempuan 30-50 tahun yang diperiksa
												IVA-SADANIS (pemeriksaan payudara klinis)</td>
											<td>{a1}</td>
										</tr>
										<tr>
											<td>2. Persentase cakupan perempuan 30-50 tahun yang
												diperiksa IVA-SADANIS</td>
											<td>{a2}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>3. Jumlah perempuan usia 30-50 tahun dengan :</td>
											<td></td>
										</tr>
										<tr>
											<td>a. IVA positif</td>
											<td>{a3a}</td>
										</tr>
										<tr>
											<td>b. dicurigai kanker serviks</td>
											<td>{a3b}</td>
										</tr>
										<tr>
											<td>c. kelainan kinekologi lain</td>
											<td>{a3c}</td>
										</tr>
										<tr>
											<td>d. pap smear positif</td>
											<td>{a3d}</td>
										</tr>
										<tr>
											<td>e. IVA positif yang sudah dikrioterapi</td>
											<td>{a3f}</td>
										</tr>
										<tr>
											<td>f. benjolan payudara</td>
											<td>{a3f}</td>
										</tr>
										<tr>
											<td>g. dicurigai kanker payudara</td>
											<td>{a3g}</td>
										</tr>
										<tr>
											<td>h. kelainan payudara lainnya</td>
											<td>{a3h}</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
						<div class="ibox">
							<div class="ibox-title">
								B. Pemeriksaan Faktor Risiko PTM
								<div class="ibox-tools">
									<a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
								</div>
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
											<td>1. Jumlah penduduk berusia &#8805;15 tahun melakukan
												pemeriksaan di Posbindu PTM</td>
											<td>{b1}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>2. Jumlah penduduk berusia &#8805;15 tahun melakukan
												pemeriksaan di Posbindu PTM dengan masalah kesehatan :</td>
											<td></td>
										</tr>
										<tr>
											<td>a. merokok</td>
											<td>{b2a}</td>
										</tr>
										<tr>
											<td>b. kurang mengkonsumsi buah dan sayur</td>
											<td>{b2b}</td>
										</tr>
										<tr>
											<td>c. kurang melakukan aktivitas fisik</td>
											<td>{b2c}</td>
										</tr>
										<tr>
											<td>d. mengkonsumi alkohol</td>
											<td>{b2d}</td>
										</tr>
										<tr>
											<td>e. obesitas</td>
											<td>{b2e}</td>
										</tr>
										<tr>
											<td>f. obesitas sentral</td>
											<td>{b2f}</td>
										</tr>
										<tr>
											<td>g. menderita tekanan darah tinggi</td>
											<td>{b2g}</td>
										</tr>
										<tr>
											<td>h. hiperglikemia</td>
											<td>{b2h}</td>
										</tr>
										<tr>
											<td>i. hiperkolesterolemia</td>
											<td>{b2i}</td>
										</tr>
										<tr>
											<td>j. hipertrigliserida</td>
											<td>{b2j}</td>
										</tr>
										<tr>
											<td>k. dislipidemia</td>
											<td>{b2k}</td>
										</tr>
										<tr>
											<td>l. fungsi paru paru tidak normal</td>
											<td>{b2l}</td>
										</tr>
										<tr>
											<td>m. positif alkohol dalam pernafasan</td>
											<td>{b2m}</td>
										</tr>
										<tr>
											<td>n. positif amfetamin dalam urine</td>
											<td>{b2n}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>3. Gangguan PTM dengan penyakit penyerta Lain</td>
											<td></td>
										</tr>
										<tr>
											<td>a. Diabetes melitus dengan TB</td>
											<td>{b3a}</td>
										</tr>
										<tr>
											<td>b. Diabetes melitus gestasional</td>
											<td>{b3b}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>4. Jumlah penduduk mengikuti konseling kesehatan :</td>
											<td></td>
										</tr>
										<tr>
											<td>a. mengikuti konseling diet</td>
											<td>{b4a}</td>
										</tr>
										<tr>
											<td>b. mengikuti konseling berhenti merokok</td>
											<td>{b4b}</td>
										</tr>
										<tr>
											<td>c. mengikuti konseling potensi cedera</td>
											<td>{b4c}</td>
										</tr>
										<tr>
											<td>d. mengikuti konseling IVA-SADANIS</td>
											<td>{b4d}</td>
										</tr>
										<tr>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td>5. Jumlah SLTP/SLTA yang melaksanakan CERDIK (Cek
												rutin kondisi kesehatan, Enyahkan asap rokok, Rajin
												aktifitas fisik, Diet sehat gizi seimbang, Istirahat cukup,
												Kelola stress) di sekolah</td>
											<td>{b5}</td>
										</tr>
										<tr>
											<td>6. Jumlah Pengemudi yang dilakukan pemeriksaan
												faktor risiko kesehatan pengemudi di terminal dalam wilayah
											</td>
											<td>{b6}</td>
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
											<td><strong>{URL}</strong>/sip/rest/ukme6/<strong>{TOKEN}</strong>/save</td>
										</tr>
										<tr>
											<td>Contoh</td>
											<td><strong>http://192.168.90.65:8181/kemenkes</strong>/sip/rest/ukme6/<strong>20baeff1-9717-4822-ae14-c3134bc4487e</strong>/save</td>
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
												src="${ pageContext.request.contextPath }/images/url_ukme6.png" /></td>
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