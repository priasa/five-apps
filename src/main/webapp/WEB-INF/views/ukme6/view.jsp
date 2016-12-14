<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">$${ukme6.id}
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
								<td>${ukme6.kodePuskesmas} / ${ukme6.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukme6.bulan} / ${ukme6.tahun}</td>
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
		<div class="ibox-title">A. Deteksi Dini Kanker Leher Rahim dan Payudara
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
								<td>1. Jumlah perempuan 30-50 tahun yang diperiksa IVA-SADANIS  (pemeriksaan payudara klinis)</td>
								<td>${ukme6.a1}</td>
							</tr>
							<tr>
								<td>2. Persentase cakupan perempuan 30-50 tahun yang diperiksa IVA-SADANIS</td>
								<td>${ukme6.a2}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>3. Jumlah perempuan usia 30-50 tahun dengan : </td>
								<td></td>
							</tr>
							<tr>
								<td>a. IVA positif</td>
								<td>${ukme6.a3a}</td>
							</tr>
							<tr>
								<td>b. dicurigai kanker serviks</td>
								<td>${ukme6.a3b}</td>
							</tr>
							<tr>
								<td>c. kelainan kinekologi lain</td>
								<td>${ukme6.a3c}</td>
							</tr>
							<tr>
								<td>d. pap smear positif</td>
								<td>${ukme6.a3d}</td>
							</tr>
							<tr>
								<td>e. IVA positif yang sudah dikrioterapi</td>
								<td>${ukme6.a3f}</td>
							</tr>
							<tr>
								<td>f. benjolan payudara</td>
								<td>${ukme6.a3f}</td>
							</tr>
							<tr>
								<td>g. dicurigai kanker payudara</td>
								<td>${ukme6.a3g}</td>
							</tr>
							<tr>
								<td>h. kelainan payudara lainnya</td>
								<td>${ukme6.a3h}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">B. Pemeriksaan Faktor Risiko PTM
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
								<td>1. Jumlah penduduk berusia &#8805;15 tahun melakukan pemeriksaan di Posbindu PTM</td>
								<td>${ukme6.b1}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>2. Jumlah penduduk berusia &#8805;15 tahun melakukan pemeriksaan di Posbindu PTM dengan masalah kesehatan :</td>
								<td></td>
							</tr>
							<tr>
								<td>a. merokok</td>
								<td>${ukme6.b2a}</td>
							</tr>
							<tr>
								<td>b. kurang mengkonsumsi buah dan sayur</td>
								<td>${ukme6.b2b}</td>
							</tr>
							<tr>
								<td>c. kurang melakukan aktivitas fisik</td>
								<td>${ukme6.b2c}</td>
							</tr>
							<tr>
								<td>d. mengkonsumi alkohol</td>
								<td>${ukme6.b2d}</td>
							</tr>
							<tr>
								<td>e. obesitas</td>
								<td>${ukme6.b2e}</td>
							</tr>
							<tr>
								<td>f. obesitas sentral</td>
								<td>${ukme6.b2f}</td>
							</tr>
							<tr>
								<td>g. menderita tekanan darah tinggi</td>
								<td>${ukme6.b2g}</td>
							</tr>
							<tr>
								<td>h. hiperglikemia</td>
								<td>${ukme6.b2h}</td>
							</tr>
							<tr>
								<td>i. hiperkolesterolemia</td>
								<td>${ukme6.b2i}</td>
							</tr>
							<tr>
								<td>j. hipertrigliserida</td>
								<td>${ukme6.b2j}</td>
							</tr>
							<tr>
								<td>k. dislipidemia</td>
								<td>${ukme6.b2k}</td>
							</tr>
							<tr>
								<td>l. fungsi paru paru tidak normal</td>
								<td>${ukme6.b2l}</td>
							</tr>
							<tr>
								<td>m. positif alkohol dalam pernafasan</td>
								<td>${ukme6.b2m}</td>
							</tr>
							<tr>
								<td>n. positif amfetamin dalam urine</td>
								<td>${ukme6.b2n}</td>
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
								<td>${ukme6.b3a}</td>
							</tr>
							<tr>
								<td>b. Diabetes melitus gestasional</td>
								<td>${ukme6.b3b}</td>
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
								<td>${ukme6.b4a}</td>
							</tr>
							<tr>
								<td>b. mengikuti konseling berhenti merokok</td>
								<td>${ukme6.b4b}</td>
							</tr>
							<tr>
								<td>c. mengikuti konseling potensi cedera</td>
								<td>${ukme6.b4c}</td>
							</tr>
							<tr>
								<td>d. mengikuti konseling IVA-SADANIS</td>
								<td>${ukme6.b4d}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>5. Jumlah SLTP/SLTA yang melaksanakan CERDIK (Cek rutin kondisi kesehatan, Enyahkan asap rokok, Rajin aktifitas fisik, Diet sehat gizi seimbang, Istirahat cukup, Kelola stress) di sekolah</td>
								<td>${ukme6.b5}</td>
							</tr>
							<tr>
								<td>6. Jumlah Pengemudi yang dilakukan pemeriksaan faktor risiko kesehatan pengemudi di terminal dalam wilayah </td>
								<td>${ukme6.b6}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukme6/list";
	}
</script>

<commons:footer />