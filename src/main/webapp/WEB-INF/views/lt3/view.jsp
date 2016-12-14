<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${lt3.id}
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
								<td>${lt3.kodePuskesmas} / ${lt3.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Tahun</td>
								<td>${lt3.tahun}</td>
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
		<div class="ibox-title">1. PENDIDIKAN DASAR PELAKSANA PROMOSI KESEHATAN
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
								<td>a.	Jumlah SD/sederajat yang memiliki UKS</td>
								<td>${lt3.a1}</td>
							</tr>
							<tr>
								<td>b.	Jumlah SLTP/sederajat yang memiliki UKS</td>
								<td>${lt3.b1}</td>
							</tr>
							<tr>
								<td>c.	Jumlah SD/sederajat yang  mendapatkan promosi kesehatan</td>
								<td>${lt3.c1}</td>
							</tr>
							<tr>
								<td>d.	Jumlah SLTP/sederajat yang mendapatkan promosi kesehatan </td>
								<td>${lt3.d1}</td>
							</tr>
							<tr>
								<td>e.	Jumlah SLTA/sederajat yang  mendapatkan promosi kesehatan</td>
								<td>${lt3.e1}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">2. PENGENDALIAN FILARIASIS
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
								<td>a.	jumlah penderita filariasis kronis terdaftar (per desa dan golongan umur)</td>
								<td>${lt3.a2}</td>
							</tr>
							<tr>
								<td>b.	jumlah penduduk mendapat obat pencegahan massal filariasis (per desa)</td>
								<td>${lt3.b2}</td>
							</tr>
							<tr>
								<td>c.	jumlah penderita filariasis kronis terdaftar</td>
								<td>${lt3.c2}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">3. IMUNISASI ANAK SEKOLAH (BIAS) 
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
								<td>a.	Jumlah anak kelas 1 SD (sederajat) yang diimunisasi campak (pada BIAS Campak)</td>
								<td>${lt3.a3}</td>
							</tr>
							<tr>
								<td>b.	Jumlah anak kelas 1 SD (sederajat) yang diimunisasi DT (pada BIAS DT)</td>
								<td>${lt3.b3}</td>
							</tr>
							<tr>
								<td>c.	Jumlah anak kelas 2 dan 3 SD (sederajat) yang diimunisasi Td (pada BIAS Td)</td>
								<td>${lt3.c3}</td>
							</tr>
							<tr>
								<td>d.	Jumlah Desa/Kelurahan UCI (menurut desa)</td>
								<td>${lt3.d3}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">4. KESEHATAN LINGKUNGAN 
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th rowspan="2">a.	Sarana Air Minum</th>
							<th colspan="6">Jumlah Sarana Menurut Tingkat Risiko Pencemaran</th>
						</tr>
						<tr>
							<th>Belum IKL</th>
							<th>Rendah</th>
							<th>Sedang</th>
							<th>Tinggi</th>
							<th>Amat Tinggi</th>
							<th>Sertifikat</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1.	Perpipaan PAM</td>
								<td>${lt3.a41_belum}</td>
								<td>${lt3.a41_rendah}</td>
								<td>${lt3.a41_sedang}</td>
								<td>${lt3.a41_tinggi}</td>
								<td>${lt3.a41_amat_tinggi}</td>
								<td>${lt3.a41_sertifikat}</td>
							</tr>
							<tr>
								<td>2.	Perpipaan non PAM (sarana komunal)</td>
								<td>${lt3.a42_belum}</td>
								<td>${lt3.a42_rendah}</td>
								<td>${lt3.a42_sedang}</td>
								<td>${lt3.a42_tinggi}</td>
								<td>${lt3.a42_amat_tinggi}</td>
								<td>${lt3.a42_sertifikat}</td>
							</tr>
							<tr>
								<td>3.	Depot Air Minum</td>
								<td>${lt3.a43_belum}</td>
								<td>${lt3.a43_rendah}</td>
								<td>${lt3.a43_sedang}</td>
								<td>${lt3.a43_tinggi}</td>
								<td>${lt3.a43_amat_tinggi}</td>
								<td>${lt3.a43_sertifikat}</td>
							</tr>
							<tr>
								<td>4.	Sumur Gali</td>
								<td>${lt3.a44_belum}</td>
								<td>${lt3.a44_rendah}</td>
								<td>${lt3.a44_sedang}</td>
								<td>${lt3.a44_tinggi}</td>
								<td>${lt3.a44_amat_tinggi}</td>
								<td>${lt3.a44_sertifikat}</td>
							</tr>
							<tr>
								<td>5.	Penampung Air Hujan</td>
								<td>${lt3.a45_belum}</td>
								<td>${lt3.a45_rendah}</td>
								<td>${lt3.a45_sedang}</td>
								<td>${lt3.a45_tinggi}</td>
								<td>${lt3.a45_amat_tinggi}</td>
								<td>${lt3.a45_sertifikat}</td>
							</tr>
							<tr>
								<td>6.	Perlindungan Mata Air</td>
								<td>${lt3.a46_belum}</td>
								<td>${lt3.a46_rendah}</td>
								<td>${lt3.a46_sedang}</td>
								<td>${lt3.a46_tinggi}</td>
								<td>${lt3.a46_amat_tinggi}</td>
								<td>${lt3.a46_sertifikat}</td>
							</tr>
							<tr>
								<td>7.	Sumur Bor dengan Pompa</td>
								<td>${lt3.a47_belum}</td>
								<td>${lt3.a47_rendah}</td>
								<td>${lt3.a47_sedang}</td>
								<td>${lt3.a47_tinggi}</td>
								<td>${lt3.a47_amat_tinggi}</td>
								<td>${lt3.a47_sertifikat}</td>
							</tr>
							<tr>
								<td>8.	Terminal Air</td>
								<td>${lt3.a48_belum}</td>
								<td>${lt3.a48_rendah}</td>
								<td>${lt3.a48_sedang}</td>
								<td>${lt3.a48_tinggi}</td>
								<td>${lt3.a48_amat_tinggi}</td>
								<td>${lt3.a48_sertifikat}</td>
							</tr>
							<tr>
								<td>9.	Mobil Tangki</td>
								<td>${lt3.a49_belum}</td>
								<td>${lt3.a49_rendah}</td>
								<td>${lt3.a49_sedang}</td>
								<td>${lt3.a49_tinggi}</td>
								<td>${lt3.a49_amat_tinggi}</td>
								<td>${lt3.a49_sertifikat}</td>
							</tr>
					</tbody>
			</table>
			<br/>
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th rowspan="2">b.	Rumah dan Jamban</th>
							<th colspan="4">Jumlah Sarana Menurut Klasifikasi Standar Kesehatan</th>
						</tr>
						<tr>
							<th>Belum IKL</th>
							<th>Tdk Memenuhi Syarat</th>
							<th>Memenuhi Syarat</th>
							<th>Sertifikat</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1.	Jumlah Rumah</td>
								<td>${lt3.b41_belum}</td>
								<td>${lt3.b41_tdk_memenuhi}</td>
								<td>${lt3.b41_memenuhi}</td>
								<td>${lt3.b41_sertifikat}</td>
							</tr>
							<tr>
								<td>2.	Jumlah Jamban</td>
								<td>${lt3.b42_belum}</td>
								<td>${lt3.b42_tdk_memenuhi}</td>
								<td>${lt3.b42_memenuhi}</td>
								<td>${lt3.b42_sertifikat}</td>
							</tr>
					</tbody>
			</table>
			<br/>
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th rowspan="2">c.	Jumlah Tempat Pengelolaan Makanan (TPM) siap saji terdaftar</th>
							<th colspan="4">Jumlah Sarana Menurut Klasifikasi Standar Kesehatan Lingkungan</th>
						</tr>
						<tr>
							<th>Belum IKL</th>
							<th>Tdk Memenuhi Syarat</th>
							<th>Memenuhi Syarat</th>
							<th>Sertifikat</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1.	Rumah makan/restoran</td>
								<td>${lt3.c41_belum}</td>
								<td>${lt3.c41_tdk_memenuhi}</td>
								<td>${lt3.c41_memenuhi}</td>
								<td>${lt3.c41_sertifikat}</td>
							</tr>
							<tr>
								<td>2.	Jumlah Restoran</td>
								<td>${lt3.c42_belum}</td>
								<td>${lt3.c42_tdk_memenuhi}</td>
								<td>${lt3.c42_memenuhi}</td>
								<td>${lt3.c42_sertifikat}</td>
							</tr>
							<tr>
								<td>3.	Jasaboga</td>
								<td>${lt3.c43_belum}</td>
								<td>${lt3.c43_tdk_memenuhi}</td>
								<td>${lt3.c43_memenuhi}</td>
								<td>${lt3.c43_sertifikat}</td>
							</tr>
							<tr>
								<td>4.	Depot Air Minum</td>
								<td>${lt3.c44_belum}</td>
								<td>${lt3.c44_tdk_memenuhi}</td>
								<td>${lt3.c44_memenuhi}</td>
								<td>${lt3.c44_sertifikat}</td>
							</tr>
							<tr>
								<td>5.	Centra Makanan Jajanan</td>
								<td>${lt3.c45_belum}</td>
								<td>${lt3.c45_tdk_memenuhi}</td>
								<td>${lt3.c45_memenuhi}</td>
								<td>${lt3.c45_sertifikat}</td>
							</tr>
							<tr>
								<td>6.	Kantin Sekolah</td>
								<td>${lt3.c46_belum}</td>
								<td>${lt3.c46_tdk_memenuhi}</td>
								<td>${lt3.c46_memenuhi}</td>
								<td>${lt3.c46_sertifikat}</td>
							</tr>
							<tr>
								<td>7.	Jumlah Kantin Institusi</td>
								<td>${lt3.c47_belum}</td>
								<td>${lt3.c47_tdk_memenuhi}</td>
								<td>${lt3.c47_memenuhi}</td>
								<td>${lt3.c47_sertifikat}</td>
							</tr>
							<tr>
								<td>8.	Jumlah pedagang kaki lima pangan siap saji (kuliner)</td>
								<td>${lt3.c48_belum}</td>
								<td>${lt3.c48_tdk_memenuhi}</td>
								<td>${lt3.c48_memenuhi}</td>
								<td>${lt3.c48_sertifikat}</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>d.	Jumlah Tempat Penampungan Sampah Sementara</td>
								<td>${lt3.d4_belum}</td>
								<td>${lt3.d4_tdk_memenuhi}</td>
								<td>${lt3.d4_memenuhi}</td>
								<td>${lt3.d4_sertifikat}</td>
							</tr>
					</tbody>
			</table>
			<br/>
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th rowspan="2">e.	Jumlah TTU yang terdaftar</th>
							<th colspan="4">Jumlah Sarana Menurut Klasifikasi Standar Kesehatan Lingkungan</th>
						</tr>
						<tr>
							<th>Belum IKL</th>
							<th>Tdk Memenuhi Syarat</th>
							<th>Memenuhi Syarat</th>
							<th>Sertifikat</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>1.	Sarana pendidikan (sekolah, pesantren)</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>a.	Jumlah Sekolah</td>
								<td>${lt3.e41a_belum}</td>
								<td>${lt3.e41a_tdk_memenuhi}</td>
								<td>${lt3.e41a_memenuhi}</td>
								<td>${lt3.e41a_sertifikat}</td>
							</tr>
							<tr>
								<td>b.	Jumlah Pondok Pesantren</td>
								<td>${lt3.e41b_belum}</td>
								<td>${lt3.e41b_tdk_memenuhi}</td>
								<td>${lt3.e41b_memenuhi}</td>
								<td>${lt3.e41b_sertifikat}</td>
							</tr>
							<tr>
								<td>2.	Pasar</td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>a.	Pasar Tradisional</td>
								<td>${lt3.e42a_belum}</td>
								<td>${lt3.e42a_tdk_memenuhi}</td>
								<td>${lt3.e42a_memenuhi}</td>
								<td>${lt3.e42a_sertifikat}</td>
							</tr>
							<tr>
								<td>b.	Pasar Modern</td>
								<td>${lt3.e42b_belum}</td>
								<td>${lt3.e42b_tdk_memenuhi}</td>
								<td>${lt3.e42b_memenuhi}</td>
								<td>${lt3.e42b_sertifikat}</td>
							</tr>
							<tr>
								<td>3.	Jumlah Fasilitas pelayanan kesehatan (RS, Puskesmas, Puskesmas pembantu, dsb)</td>
								<td>${lt3.e43_belum}</td>
								<td>${lt3.e43_tdk_memenuhi}</td>
								<td>${lt3.e43_memenuhi}</td>
								<td>${lt3.e43_sertifikat}</td>
							</tr>
							<tr>
								<td>4.	Tempat Ibadah</td>
								<td>${lt3.e44_belum}</td>
								<td>${lt3.e44_tdk_memenuhi}</td>
								<td>${lt3.e44_memenuhi}</td>
								<td>${lt3.e44_sertifikat}</td>
							</tr>
							<tr>
								<td>5.	Hotel (Hotel Berbintang dan Non)</td>
								<td>${lt3.e45_belum}</td>
								<td>${lt3.e45_tdk_memenuhi}</td>
								<td>${lt3.e45_memenuhi}</td>
								<td>${lt3.e45_sertifikat}</td>
							</tr>
							<tr>
								<td>6.	Terminal Kendaraan Umum dan Stasiun</td>
								<td>${lt3.e46_belum}</td>
								<td>${lt3.e46_tdk_memenuhi}</td>
								<td>${lt3.e46_memenuhi}</td>
								<td>${lt3.e46_sertifikat}</td>
							</tr>
							<tr>
								<td>7.	Tempat Rekreasi, Hiburan dan Wisata</td>
								<td>${lt3.e47_belum}</td>
								<td>${lt3.e47_tdk_memenuhi}</td>
								<td>${lt3.e47_memenuhi}</td>
								<td>${lt3.e47_sertifikat}</td>
							</tr>
							<tr>
								<td>8.	Lembaga Permasyarakatan dan Rumah Tahanan</td>
								<td>${lt3.e48_belum}</td>
								<td>${lt3.e48_tdk_memenuhi}</td>
								<td>${lt3.e48_memenuhi}</td>
								<td>${lt3.e48_sertifikat}</td>
							</tr>
							<tr>
								<td>9.	Sarana Transportasi Darat</td>
								<td>${lt3.e49_belum}</td>
								<td>${lt3.e49_tdk_memenuhi}</td>
								<td>${lt3.e49_memenuhi}</td>
								<td>${lt3.e49_sertifikat}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">5. PROGRAM PELAYANAN KESEHATAN TRADISIONAL DAN KOMPLEMENTER
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
								<td>a.	Jumlah tenaga Penyehat Tradisional (Hattra) di wilayah Puskesmas terdaftar (STPT)</td>
								<td>${lt3.a5}</td>
							</tr>
							<tr>
								<td>b.	Jumlah posyandu yang melaksanakan asuhan Mandiri Kesehatan Tradisional</td>
								<td>${lt3.b5}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">6. PELAKSANAAN K3 DI LINGKUNGAN PUSKESMAS
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>(1)YA (2)TIDAK</th>
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>a.	Terdapat kebijakan tertulis pelaksanaan K3 di Lingkungan Sekolah</td>
								<td>${lt3.a6}</td>
							</tr>
							<tr>
								<td>b.	Tim K3 di Puskesmas (SK Kepala Puskesmas)</td>
								<td>${lt3.b6}</td>
							</tr>
							<tr>
								<td>c.	Penerapan Kewaspadaan Standar di Lingkungan Puskesmas</td>
								<td>${lt3.c6}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/lt3/list";
	}
</script>

<commons:footer />