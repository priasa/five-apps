<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox">
		<div class="ibox-title">${ukme4.id}
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
								<td>${ukme4.kodePuskesmas} / ${ukme4.namaPuskesmas}</td>
							</tr>
							<tr>
								<td>Nomor</td>
								<td>${ukme4.nomor}</td>
							</tr>
							<tr>
								<td>Desa</td>
								<td>${ukme4.desa}</td>
							</tr>
							<tr>
								<td>Bulan/Tahun</td>
								<td>${ukme4.bulan} / ${ukme4.tahun}</td>
							</tr>
							<tr>
								<td>Jumlah Puskesmas Pembantu yang Melapor</td>
								<td>${ukme4.pustu_lapor} dari ${ukme4.pustu_total}</td>
							</tr>
							<tr>
								<td>Jumlah Poskesdes/Bidan di Desa yang Melapor</td>
								<td>${ukme4.poskesdes_lapor} dari ${ukme4.poskesdes_total}</td>
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
		<div class="ibox-title">DATA DETAIL IMUNISASI
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>L</th>
							<th>P</th>
							<th>Jumlah</th>	
						</tr>
					</thead>
					<tbody>
							<tr>
								<td>Sasaran Bayi</td>
								<td>${ukme4.l_sb}</td>
								<td>${ukme4.p_sb}</td>
								<td>${ukme4.j_sb}</td>
							</tr>
							<tr>
								<td>Sasaran Batita</td>
								<td>${ukme4.l_batita}</td>
								<td>${ukme4.p_batita}</td>
								<td>${ukme4.j_batita}</td>
							</tr>
							<tr>
								<td>Sasaran WUS</td>
								<td></td>
								<td></td>
								<td>${ukme4.sasaran_wus}</td>
							</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">Hasil Imunisasi Bayi (0-11 Bulan)
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>L</th>
							<th>P</th>
							<th>Jumlah</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>HB0 &lt;7HARI</td>
							<td>${ukme4.l_hbo}</td>
							<td>${ukme4.p_hbo}</td>
							<td>${ukme4.j_hbo}</td>
						</tr>
						<tr>
							<td>BCG</td>
							<td>${ukme4.l_bcg}</td>
							<td>${ukme4.p_bcg}</td>
							<td>${ukme4.j_bcg}</td>
						</tr>
						<tr>
							<td>POLIO 1</td>
							<td>${ukme4.l_polio1}</td>
							<td>${ukme4.p_polio1}</td>
							<td>${ukme4.j_polio1}</td>
						</tr>
						<tr>
							<td>DPT-HB-HiB 1</td>
							<td>${ukme4.l_dpt1}</td>
							<td>${ukme4.p_dpt1}</td>
							<td>${ukme4.j_dpt1}</td>
						</tr>
						<tr>
							<td>POLIO 2</td>
							<td>${ukme4.l_polio2}</td>
							<td>${ukme4.p_polio2}</td>
							<td>${ukme4.j_polio2}</td>
						</tr>
						<tr>
							<td>DPT-HB-HiB 2</td>
							<td>${ukme4.l_dpt2}</td>
							<td>${ukme4.p_dpt2}</td>
							<td>${ukme4.j_dpt2}</td>
						</tr>
						<tr>
							<td>POLIO 3</td>
							<td>${ukme4.l_polio3}</td>
							<td>${ukme4.p_polio3}</td>
							<td>${ukme4.j_polio3}</td>
						</tr>
						<tr>
							<td>IPV</td>
							<td>${ukme4.l_ipv}</td>
							<td>${ukme4.p_ipv}</td>
							<td>${ukme4.j_ipv}</td>
						</tr>
						<tr>
							<td>DPT-HB-HiB 3</td>
							<td>${ukme4.l_dpt3}</td>
							<td>${ukme4.p_dpt3}</td>
							<td>${ukme4.j_dpt3}</td>
						</tr>
						<tr>
							<td>POLIO 4</td>
							<td>${ukme4.l_polio4}</td>
							<td>${ukme4.p_polio4}</td>
							<td>${ukme4.j_polio4}</td>
						</tr>
						<tr>
							<td>Campak</td>
							<td>${ukme4.l_campak}</td>
							<td>${ukme4.p_campak}</td>
							<td>${ukme4.j_campak}</td>
						</tr>
						<tr>
							<td>Imunisasi Lengkap</td>
							<td>${ukme4.l_imunlengkap}</td>
							<td>${ukme4.p_imunlengkap}</td>
							<td>${ukme4.j_imunlengkap}</td>
						</tr>
					</tbody>
			</table>
		</div>
	</div>
	
	<div class="ibox">
		<div class="ibox-title">Hasil Imunisasi Lanjutan Batita
			<div class="ibox-tools"><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></div>
		</div>
		<div class="ibox-content">
			<table id="dTable" class="table table-striped">
					<thead>
						<tr>
							<th></th>
							<th>L</th>
							<th>P</th>
							<th>Jumlah</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>DPT-HB-HiB</td>
							<td>${ukme4.l_batita_dpt1}</td>
							<td>${ukme4.p_batita_dpt1}</td>
							<td>${ukme4.j_batita_dpt1}</td>
						</tr>
						<tr>
							<td>Campak</td>
							<td>${ukme4.l_batita_campak}</td>
							<td>${ukme4.p_batita_campak}</td>
							<td>${ukme4.j_batita_campak}</td>
						</tr>
					</tbody>
			</table>
		</div>
	</div>
	<div class="ibox">
		<div class="ibox-title">Hasil Imunisasi Lanjutan TT Pada WUS
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
							<td>TT 1</td>
							<td>${ukme4.wus_tt1}</td>
						</tr>
						<tr>
							<td>TT 2</td>
							<td>${ukme4.wus_tt2}</td>
						</tr>
						<tr>
							<td>TT 3</td>
							<td>${ukme4.wus_tt3}</td>
						</tr>
						<tr>
							<td>TT 4</td>
							<td>${ukme4.wus_tt4}</td>
						</tr>
						<tr>
							<td>TT 5</td>
							<td>${ukme4.wus_tt5}</td>
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
		document.location.href = "${pageContext.request.contextPath}/web/ukme4/list";
	}
</script>

<commons:footer />