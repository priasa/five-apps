<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="row white-bg">
	<div class="col-lg-12">
		<div class="wrapper wrapper-content">
			<div class="row  border-bottom white-bg dashboard-header">
				<h2>Selamat Datang di Interoperability - SIP.</h2>
				<h5>Berikut ini adalah web service yang tersedia :</h5>
				<div class="col-sm-4">
					<br />
					<h3>LAP.TAHUNAN</h3>
					<ul class="list-group clear-list m-t">
						<li class="list-group-item fist-item"><span
							class="label label-success">1&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/lt1/howto">Ketersediaan
								Alat</a></li>
						<li class="list-group-item"><span class="label label-info">2&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/lt2/howto">Sumber
								Daya Manusia</a></li>
						<li class="list-group-item"><span class="label label-primary">3&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/lt3/howto">Program</a>
						</li>
					</ul>
					<br />
					<h3>UKMP</h3>
					<ul class="list-group clear-list m-t">
						<li class="list-group-item fist-item"><span
							class="label label-danger">1&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukmp2/howto">Kesehatan
								Kerja, Olah Raga, dan Tradkom</a></li>
					</ul>
					<br />
					<h3>PELAYANAN dan ICD/DIAGNOSA</h3>
					<ul class="list-group clear-list m-t">
						<li class="list-group-item fist-item"><span
							class="label label-default">1&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/pelayanan/howto">Pelayanan</a>
						</li>
						<li class="list-group-item"><span class="label label-success">2&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/icd/howto">ICD/Diagnosa</a>
						</li>

					</ul>
				</div>
				<div class="col-sm-4">
					<br />
					<h3>UKP</h3>
					<ul class="list-group clear-list m-t">
						<li class="list-group-item fist-item"><span
							class="label label-success">1&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukp1/howto">Pelayanan
								Puskesmas</a></li>
						<li class="list-group-item"><span class="label label-info">2&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukp2/howto">Kesakitan
								Umum</a></li>
						<li class="list-group-item"><span class="label label-primary">3&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukp3/howto">Kesakitan
								Gigi dan Mulut</a></li>
						<li class="list-group-item"><span class="label label-danger">4&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukp4/howto">Kesakitan
								Terbanyak</a></li>
						<li class="list-group-item"><span class="label label-warning">5&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukp5/howto">Kejadian
								Kematian</a></li>
						<li class="list-group-item"><span class="label label-default">6&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukp6/howto">LPLPO</a>
						</li>
					</ul>
					<br />
					<h3>DATA PENDUKUNG</h3>
					<ul class="list-group clear-list m-t">
						<li class="list-group-item fist-item"><span
							class="label label-success">1&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/provinsi/howto">Provinsi</a>
						</li>
						<li class="list-group-item"><span class="label label-info">2&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/kabupaten/howto">Kabupaten / Kota</a>
						</li>
					</ul>
				</div>
				<div class="col-sm-4">
					<br />
					<h3>UKME</h3>
					<ul class="list-group clear-list m-t">
						<li class="list-group-item fist-item"><span
							class="label label-success">1&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukme1/howto">Promosi
								Kesehatan</a></li>
						<li class="list-group-item"><span class="label label-info">2&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukme2/howto">Kesehatan
								Lingkungan</a></li>
						<li class="list-group-item"><span class="label label-primary">3A</span><a
							href="${pageContext.request.contextPath}/web/ukme3a/howto">Gizi,
								Kesehatan Ibu dan Anak</a></li>
						<li class="list-group-item"><span class="label label-danger">3B</span><a
							href="${pageContext.request.contextPath}/web/ukme3b/howto">Program
								UKS</a></li>
						<li class="list-group-item"><span class="label label-warning">4&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukme4/howto">Imunisasi</a>
						</li>
						<li class="list-group-item"><span class="label label-default">5&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukme5/howto">Penyakit
								Menular</a></li>
						<li class="list-group-item"><span class="label label-success">6&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukme6/howto">Penyakit
								Tidak Menular</a></li>
						<li class="list-group-item"><span class="label label-info">7&nbsp;</span><a
							href="${pageContext.request.contextPath}/web/ukme7/howto">Perkesmas</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row border-bottom white-bg dashboard-header">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					
				</div>
			</div>
			<div class="row"></div>
		</div>
	</div>
</div>
<commons:footer />