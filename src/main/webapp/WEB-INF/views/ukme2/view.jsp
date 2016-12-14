<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukme2.id}
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
								<td>${ukme2.kodePuskesmas} / ${ukme2.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukme2.bulan} / ${ukme2.tahun}</td>
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
		<div class="ibox-title">
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
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
								<td>1. Jumlah sarana air minum yang dilakukan inspeksi kesehatan lingkungan:</td>
								<td>Berisiko Rendah/Sedang</td>
								<td>Berisiko Tinggi/Amat Tinggi</td>
							</tr>
							<tr>
								<td>a. Jumlah sarana perpipaan perusahaan air minum</td>
								<td>${ukme2.a1}</td>
								<td>${ukme2.aa1}</td>
							</tr>
							<tr>
								<td>b. Jumlah sarana air minum perpipaan non perusahaan air minum (sarana komunal)</td>
								<td>${ukme2.b1}</td>
								<td>${ukme2.ab1}</td>
							</tr>
							<tr>
								<td>c. Jumlah sumur gali</td>
								<td>${ukme2.c1}</td>
								<td>${ukme2.ac1}</td>
							</tr>
							<tr>
								<td>d. Jumlah penampungan air hujan</td>
								<td>${ukme2.d1}</td>
								<td>${ukme2.ad1}</td>
							</tr>
							<tr>
								<td>e. Jumlah perlindungan mata air</td>
								<td>${ukme2.e1}</td>
								<td>${ukme2.ae1}</td>
							</tr>
							<tr>
								<td>f. Jumlah sumur bor dengan pompa</td>
								<td>${ukme2.f1}</td>
								<td>${ukme2.af1}</td>
							</tr>
							<tr>
								<td>g. Jumlah terminal air dan tangki air</td>
								<td>${ukme2.g1}</td>
								<td>${ukme2.ag1}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>2. Jumlah tempat pengelolaan makanan (TPM) yang dilakukan inspeksi kesehatan lingkungan:</td>
								<td>Memenuhi Syarat</td>
								<td>Tidak Memenuhi Syarat</td>
							</tr>
							<tr>
								<td>a. Jumlah rumah makan/restoran</td>
								<td>${ukme2.a2}</td>
								<td>${ukme2.aa2}</td>
							</tr>
							<tr>
								<td>b. Jumlah jasaboga</td>
								<td>${ukme2.b2}</td>
								<td>${ukme2.ab2}</td>
							</tr>
							<tr>
								<td>c. Jumlah depot air minum</td>
								<td>${ukme2.c2}</td>
								<td>${ukme2.ac2}</td>
							</tr>
							<tr>
								<td>d. Jumlah sentra makanan jajanan</td>
								<td>${ukme2.d2}</td>
								<td>${ukme2.ad2}</td>
							</tr>
							<tr>
								<td>e. Jumlah kantin sekolah</td>
								<td>${ukme2.e2}</td>
								<td>${ukme2.ae2}</td>
							</tr>
							<tr>
								<td>f. Jumlah kantin institusi</td>
								<td>${ukme2.f2}</td>
								<td>${ukme2.af2}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>3. Jumlah tempat-tempat umum (TTU) yang dilakukan inspeksi kesehatan lingkungan:</td>
								<td>Memenuhi Syarat</td>
								<td>Tidak Memenuhi Syarat</td>
							</tr>
							<tr>
								<td>a. Jumlah sekolah</td>
								<td>${ukme2.a3}</td>
								<td>${ukme2.aa3}</td>
							</tr>
							<tr>
								<td>b. Jumlah pondok pesantren</td>
								<td>${ukme2.b3}</td>
								<td>${ukme2.ab3}</td>
							</tr>
							<tr>
								<td>c. Jumlah pasar rakyat/tradisional</td>
								<td>${ukme2.c3}</td>
								<td>${ukme2.ac3}</td>
							</tr>
							<tr>
								<td>d. Jumlah fasilitas pelayanan kesehatan tingkat pertama/primer (Puskesmas, Puskesmas Pembantu dan balai pengobatan)</td>
								<td>${ukme2.d3}</td>
								<td>${ukme2.ad3}</td>
							</tr>
							<tr>
								<td>e. Jumlah tempat ibadah</td>
								<td>${ukme2.e3}</td>
								<td>${ukme2.ae3}</td>
							</tr>
							<tr>
								<td>f. Jumlah hotel</td>
								<td>${ukme2.f3}</td>
								<td>${ukme2.af3}</td>
							</tr>
							<tr>
								<td>g. Jumlah terminal/stasiun</td>
								<td>${ukme2.g3}</td>
								<td>${ukme2.ag3}</td>
							</tr>
							<tr>
								<td>h. Jumlah tempat rekreasi, hiburan, wisata</td>
								<td>${ukme2.h3}</td>
								<td>${ukme2.ah3}</td>
							</tr>
							<tr>
								<td>j. Jumlah lembaga pemasyrakatan/rumah tahanan</td>
								<td>${ukme2.j3}</td>
								<td>${ukme2.aj3}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>4. Jumlah rumah dilakukan inspeksi kesehatan lingkungan dan  memenuhi syarat kesehatan</td>
								<td>${ukme2.a4}</td>
								<td>${ukme2.aa4}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>5. Jumlah pasien/klien mendapatkan pelayanan konseling kesehatan lingkungan setiap hari kerja Puskesmas</td>
								<td>${ukme2.a5}</td>
								<td></td>
							</tr>
							<tr>
								<td>6. Jumlah desa/kelurahan yang melaksanakan sanitasi total berbasis masyarakat (STBM)</td>
								<td>${ukme2.a6}</td>
								<td></td>
							</tr>
							<tr>
								<td>7. Jumlah desa/kelurahan bebas dari buang air besar sembarangan (open defecation free/ODF)</td>
								<td>${ukme2.a7}</td>
								<td></td>
							</tr>
							<tr>
								<td>8. Sekolah yang melakukan deteksi dini tifoid bagi para penjamah makanan yg berjualan di sekolah </td>
								<td>${ukme2.a8}</td>
								<td></td>
							</tr>
							<tr>
								<td>9. Sekolah yang menerapkan kawasan tanpa rokok (KTR) </td>
								<td>${ukme2.a9}</td>
								<td></td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukme2/list";
	}
</script>

<commons:footer />