<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<div class="ibox">
				<div class="ibox-title">${ukme5.id}
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
								<td>${ukme5.kodePuskesmas}/ ${ukme5.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukme5.bulan}/ ${ukme5.tahun}</td>
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
					A. MALARIA (Jumlah Suspek malaria ditemukan)
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
								<td>1. Jumlah suspek malaria diperiksa mikroskopis/RDT</td>
								<td>${ukme5.a1}</td>
							</tr>
							<tr>
								<td>2. Jumlah malaria positif (sama dengan jumlah malaria
									positif pada Laporan Bulanan Data Kesakitan)</td>
								<td>${ukme5.a2}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>Jumlah malaria positif Plasmodium falsiparum</td>
								<td></td>
							</tr>
							<tr>
								<td>3. Malaria positif indigenous</td>
								<td>${ukme5.a3}</td>
							</tr>
							<tr>
								<td>4. Malaria positif import</td>
								<td>${ukme5.a4}</td>
							</tr>
							<tr>
								<td>5. Jumlah malaria positif diobati standar</td>
								<td>${ukme5.a5}</td>
							</tr>
							<tr>
								<td>6. Jumlah kelambu berinsektisida yang dibagikan</td>
								<td>${ukme5.a6}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					B. DBD (Demam Berdarah Dengue)
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
								<td>1. Jumlah kelurahan/desa berisiko penularan DBD (ada
									kelompok/cluster dalam 3 tahun terakhir - laporan tahunan)</td>
								<td>${ukme5.b1}</td>
							</tr>
							<tr>
								<td>2. Jumlah kelurahan/desa berisiko penularan DBD
									diperiksa jentik</td>
								<td>${ukme5.b2}</td>
							</tr>
							<tr>
								<td>3. Jumlah kelurahan/desa berisiko penularan DBD bebas
									jentik (ada jentik &lt;5 rmh/bangunan)</td>
								<td>${ukme5.b3}</td>
							</tr>
							<tr>
								<td>4. Jumlah fogging fokus</td>
								<td>${ukme5.b4}</td>
							</tr>
							<tr>
								<td>5. Jumlah kelurahan/desa yang dilakukan larvasidasi</td>
								<td>${ukme5.b5}</td>
							</tr>
							<tr>
								<td>6. Jumlah kelurahan/desa yang dilakukan PSN 3M Plus</td>
								<td>${ukme5.b6}</td>
							</tr>
							<tr>
								<td>7. Jumlah sekolah diperiksa jentik</td>
								<td>${ukme5.b7}</td>
							</tr>
							<tr>
								<td>8. Jumlah sekolah diperiksa dan bebas dari jentik</td>
								<td>${ukme5.b8}</td>
							</tr>
							<tr>
								<td>9. Jumlah RS/Puskesmas/klinik diperiksa jentik</td>
								<td>${ukme5.b9}</td>
							</tr>
							<tr>
								<td>10. Jumlah RS/Puskesmas/klinik diperiksa dan bebas dari
									jentik</td>
								<td>${ukme5.b10}</td>
							</tr>
							<tr>
								<td>11. Jumlah tempat-tempat umum diperiksa jentik</td>
								<td>${ukme5.b11}</td>
							</tr>
							<tr>
								<td>12. Jumlah tempat - tempat umum diperiksa dan bebas
									jentik</td>
								<td>${ukme5.b12}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					C. KECACINGAN
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
								<td>1. Jumlah anak umur 1-12 tahun yang diperiksa cacing
									pada tinjanya</td>
								<td>${ukme5.c1}</td>
							</tr>
							<tr>
								<td>2. Jumlah anak umur 1-12 tahun yang ditemukan positif
									telur cacing pada pemeriksaan tinjanya</td>
								<td>${ukme5.c2}</td>
							</tr>
							<tr>
								<td>3. Jumlah anak umur 1-12 tahun yang minum obat cacing
									(Albendazole)</td>
								<td>${ukme5.c3}</td>
							</tr>
							<tr>
								<td>4. Jumlah SD/MI yang anak didiknya mendapat obat cacing
									(Albendazole) I</td>
								<td>${ukme5.c4}</td>
							</tr>
							<tr>
								<td>5. Jumlah ibu hamil dites cacing tinjanya</td>
								<td>${ukme5.c5}</td>
							</tr>
							<tr>
								<td>6. Jumlah ibu hamil kecacingan ditangani (mendapat
									albendazole) (baru/ulang)</td>
								<td>${ukme5.c6}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					D. RABIES
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
								<td>1. Jumlah kasus Gigitan Hewan Penular Rabies (GHPR)</td>
								<td>${ukme5.d1}</td>
							</tr>
							<tr>
								<td>2. Jumlah kasus GHPR yang mendapatkan Vaksin Anti
									Rabies (VAR) atau Serum Anti Rabies (SAR)</td>
								<td>${ukme5.d2}</td>
							</tr>
							<tr>
								<td>3. Jumlah kasus Rabies (Kasus Lyssa)</td>
								<td>${ukme5.d3}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					E. DIARE
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
								<td>1. Jumlah Penderita diare pada bayi dapat oralit</td>
								<td>${ukme5.e1}</td>
							</tr>
							<tr>
								<td>2. Jumlah Penderita diare pada bayi dapat Zink</td>
								<td>${ukme5.e2}</td>
							</tr>
							<tr>
								<td>3. Jumlah Penderita diare pada bayi dapat oralit dan
									Zink</td>
								<td>${ukme5.e3}</td>
							</tr>
							<tr>
								<td>4. Jumlah Penderita diare pada bayi dapat Infus</td>
								<td>${ukme5.e4}</td>
							</tr>
							<tr>
								<td>5. Jumlah Penderita diare pada anak balita dapat oralit</td>
								<td>${ukme5.e5}</td>
							</tr>
							<tr>
								<td>6. Jumlah Penderita diare pada anak balita Zink</td>
								<td>${ukme5.e6}</td>
							</tr>
							<tr>
								<td>7. Jumlah Penderita diare pada anak balita dapat oralit
									dan Zink</td>
								<td>${ukme5.e7}</td>
							</tr>
							<tr>
								<td>8. Jumlah Penderita diare pada anak balita dapat Infus</td>
								<td>${ukme5.e8}</td>
							</tr>
							<tr>
								<td>9. Jumlah Penderita diare umur &gt;5 tahun dapat oralit</td>
								<td>${ukme5.e9}</td>
							</tr>
							<tr>
								<td>10. Jumlah Penderita diare umur &gt;5 tahun dapat infus</td>
								<td>${ukme5.e10}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					F. HEPATITIS
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
								<td>1. Jumlah kasus suspek hepatitis yang dirujuk</td>
								<td>${ukme5.f1}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					G. TB PARU
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
								<td>1. Jumlah pasien TB paru terkonfirmasi bakteriologis
									(BTA/biakan/tes cepat) baru diobati</td>
								<td>${ukme5.g1}</td>
							</tr>
							<tr>
								<td>2. Jumlah pasien TB paru terdiagnosis klinis (paru BTA
									negatif, rontgen positif) yang diobati</td>
								<td>${ukme5.g2}</td>
							</tr>
							<tr>
								<td>3. Jumlah pasien TB anak yang diobati</td>
								<td>${ukme5.g3}</td>
							</tr>
							<tr>
								<td>4. Jumlah pasien TB paru terkonfirmasi bakteriologis
									baru yang sembuh</td>
								<td>${ukme5.g4}</td>
							</tr>
							<tr>
								<td>5. Jumlah pasien TB paru terkonfirmasi bakteriologis
									baru yang mendapat pengobatan lengkap</td>
								<td>${ukme5.g5}</td>
							</tr>
							<tr>
								<td>6. Jumlah pasien TB paru terdiagnosis klinis (paru BTA
									negatif, rontgen positif) baru yang mendapat pengobatan lengkap</td>
								<td>${ukme5.g6}</td>
							</tr>
							<tr>
								<td>7. Jumlah pasien TB kambuh</td>
								<td>${ukme5.g7}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					I. K U S T A
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
								<td>1. Jumlah penderita kusta (MB dan PB) baru dengan cacat
									tingkat 0</td>
								<td>${ukme5.i1}</td>
							</tr>
							<tr>
								<td>2. Jumlah penderita kusta (MB dan PB) baru dengan cacat
									tingkat 1</td>
								<td>${ukme5.i2}</td>
							</tr>
							<tr>
								<td>3. Jumlah penderita kusta (MB dan PB) baru dengan cacat
									tingkat 2</td>
								<td>${ukme5.i3}</td>
							</tr>
							<tr>
								<td>4. Jumlah kasus indeks (MB dan PB) yang 20 orang
									kontaknya dilakukan pemeriksaan kusta</td>
								<td>${ukme5.i4}</td>
							</tr>
							<tr>
								<td>5. Jumlah penderita kusta (PB dan MB) lama masih dalam
									pengobatan MDT</td>
								<td>${ukme5.i5}</td>
							</tr>
							<tr>
								<td>6. Jumlah penderita kusta baru (MB) yang telah
									menyelesaikan pengobatan (RFT)</td>
								<td>${ukme5.i6}</td>
							</tr>
							<tr>
								<td>7. Jumlah penderita kusta baru (PB) yang telah
									menyelesaikan pengobatan (RFT)</td>
								<td>${ukme5.i7}</td>
							</tr>
							<tr>
								<td>8. Jumlah penderita kusta (PB) dinyatakan default</td>
								<td>${ukme5.i8}</td>
							</tr>
							<tr>
								<td>9. Jumlah penderita kusta (MB) dinyatakan default</td>
								<td>${ukme5.i9}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					J. FRAMBUSIA
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
								<td>Jumlah penderita frambusia suspek</td>
								<td></td>
							</tr>
							<tr>
								<td>1. Jumlah penderita frambusia suspek diperiksa serologi
									(pemeriksaan cepat/RDT)</td>
								<td>${ukme5.j1}</td>
							</tr>
							<tr>
								<td>Jumlah penderita frambusia konfirmasi (RDT +) (sama
									dengan laporan bulanan kesakitan)</td>
								<td></td>
							</tr>
							<tr>
								<td>Jumlah penderita frambusia probable</td>
								<td></td>
							</tr>
							<tr>
								<td>2. Jumlah SD/MI diperiksa frambusia</td>
								<td>${ukme5.j2}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					K. HIV - AIDS
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
								<td>1. Jumlah orang dites HIV</td>
								<td>${ukme5.k1}</td>
							</tr>
							<tr>
								<td>2. Jumlah orang dengan HIV positif</td>
								<td>${ukme5.k2}</td>
							</tr>
							<tr>
								<td>3. Jumlah ibu hamil dites HIV</td>
								<td>${ukme5.k3}</td>
							</tr>
							<tr>
								<td>4. Jumlah ibu hamil dengan HIV positif</td>
								<td>${ukme5.k4}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					L. PENYAKIT KELAMIN
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
								<td>1. Jumlah orang dengan sifilis</td>
								<td>${ukme5.l1}</td>
							</tr>
							<tr>
								<td>2. Jumlah orang dengan gram positif</td>
								<td>${ukme5.l2}</td>
							</tr>
							<tr>
								<td>3. Jumlah ibu hamil dites sifilis</td>
								<td>${ukme5.l3}</td>
							</tr>
							<tr>
								<td>4. Jumlah ibu hamil dengan sifilis positif</td>
								<td>${ukme5.l4}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="ibox">
				<div class="ibox-title">
					M. ISPA
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
								<td>1. Jumlah kunjungan Balita batuk atau kesukaran
									bernapas</td>
								<td>${ukme5.m1}</td>
							</tr>
							<tr>
								<td>2. Jumlah Balita batuk atau kesukaran bernafas yang
									dihitung napas atau dilihat ada tidaknya tarikan dindng dada
									kedalam</td>
								<td>${ukme5.m2}</td>
							</tr>
						</tbody>
					</table>
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
	});

	function cancel() {
		document.location.href = "${pageContext.request.contextPath}/web/ukme5/list";
	}
</script>

<commons:footer />