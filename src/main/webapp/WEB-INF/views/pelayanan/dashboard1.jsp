<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<form id="filterForm" method="GET" action="?" class="form-inline">
		<div class="row">
			<div class="col-md-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h4>DASHBOARD</h4>
					</div>
					<div class="ibox-content">
						<div class="form-group pull-right">
							PILIH LAPORAN&nbsp;:&nbsp; <select id="laporan" name="laporan"
								class="input-sm form-control inline">
								<c:forEach var="lprn" items="${ laporanList }">
									<option value="${ lprn.kode }"
										<c:if test="${laporan == lprn.kode}">selected="selected"</c:if>>${ lprn.nama }</option>
								</c:forEach>
							</select> &nbsp;TAHUN&nbsp;:&nbsp; <select id="tahun" name="tahun"
								class="input-sm form-control inline">
								<c:forEach var="thn" items="${ tahunList }">
									<option value="${ thn }"
										<c:if test="${tahun == thn}">selected="selected"</c:if>>${ thn }</option>
								</c:forEach>
							</select> <input type="submit" class="btn btn-primary btn-sm"
								value="<fmt:message key='general.search' />" />
						</div>
						<br /> <br />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<span class="label label-success pull-right"
							style="font-size: 14px;">&nbsp;${ tahun }&nbsp;</span>
						<h4>${ namaLaporan }</h4>
					</div>
					<div class="ibox-content">
						<h1 class="no-margins ">${totalData}</h1>
						JUMLAH DATA MASUK
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<span class="label label-info pull-right" style="font-size: 14px;">&nbsp;${ persenProvinsi }&nbsp;%&nbsp;</span>
						<h4>PROVINSI</h4>
					</div>
					<div class="ibox-content">
						<h1 class="no-margins ">${totalProvinsi}</h1>
						JUMLAH PROVINSI
						<div class="stat-percent font-bold text-info">${totalProvinsi}&nbsp;dari&nbsp;${nProvinsi}</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<span class="label label-primary pull-right"
							style="font-size: 14px;">&nbsp;${ persenKotaKabupaten }&nbsp;%&nbsp;</span>
						<h4>KOTA/KABUPATEN</h4>
					</div>
					<div class="ibox-content">
						<h1 class="no-margins ">${totalKotaKabupaten}</h1>
						JUMLAH KOTA/KABUPATEN
						<div class="stat-percent font-bold text-navy">${totalKotaKabupaten}&nbsp;dari&nbsp;${nKotaKabupaten}</div>
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<span class="label label-danger pull-right"
							style="font-size: 14px;">&nbsp;${ persenPuskesmas }&nbsp;%&nbsp;</span>
						<h4>PUSKESMAS</h4>
					</div>
					<div class="ibox-content">
						<h1 class="no-margins ">${totalPuskesmas}</h1>
						JUMLAH PUSKESMAS
						<div class="stat-percent font-bold text-danger">${totalPuskesmas}&nbsp;dari&nbsp;${nPuskesmas}</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h4>GRAFIK PER BULAN</h4>
					</div>
					<div class="ibox-content">
						<div class="row">
							<div class="col-sm-7">
								<canvas id="lineChart" ></canvas>
							</div>
							<div class="col-sm-5">
								<table id="dTable" class="table table-striped table-bordered table-hover  dataTables-example" style="font-size: 10px;">
									<thead>
										<tr>
											<th>Bulan</th>
											<th>Total Data</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${bulanListData}" var="bl">
											<tr>
												<td>
													<c:choose>
													    <c:when test="${bl.bulan == 1}">
													       Januari
													    </c:when>
													    <c:when test="${bl.bulan == 2}">
													       Februari
													    </c:when>
													    <c:when test="${bl.bulan == 3}">
													       Maret
													    </c:when>
													    <c:when test="${bl.bulan == 4}">
													       April
													    </c:when>
													    <c:when test="${bl.bulan == 5}">
													       Mei
													    </c:when>
													    <c:when test="${bl.bulan == 6}">
													       Juni
													    </c:when>
													    <c:when test="${bl.bulan == 7}">
													       Juli
													    </c:when>
													    <c:when test="${bl.bulan == 8}">
													       Agustus
													    </c:when>
													    <c:when test="${bl.bulan == 9}">
													       September
													    </c:when>
													    <c:when test="${bl.bulan == 10}">
													       Oktober
													    </c:when>
													    <c:when test="${bl.bulan == 11}">
													       November
													    </c:when>
													    <c:when test="${bl.bulan == 12}">
													       Desember
													    </c:when>
													    <c:otherwise>
													        NONE.
													    </c:otherwise>
													</c:choose>
												</td>
												<td>${bl.totalData}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h4>GRAFIK PER PROVINSI</h4>
					</div>
					<div class="ibox-content">
						<div class="row">
							<div class="col-sm-7">
								<canvas id="barChart" style="font-size: 10px;"></canvas>
							</div>
							<div class="col-sm-5">
								<table id="dTable"
									class="table table-striped table-bordered table-hover dataTables-example dataTable dtr-inline" style="font-size: 10px;">
									<thead>
										<tr>
											<th>Provinsi</th>
											<th>Total Data</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${provinsiData}" var="pd">
											<tr>
												<td>${pd.provinsiEntity.nama}</td>
												<td>${pd.totalData}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		initSelectAll();
	});

	function deleteRecords() {
		if ($("[name=id]:checked").length > 0) {
			if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
				$("#filterForm").attr("method", "POST");
				$("#filterForm")
						.attr("action",
								"${pageContext.request.contextPath}/web/pelayanan/delete");
				return true;
			}
		}
		return false;
	}
</script>
<commons:footer />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/plugins/dataTables/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/plugins/dataTables/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/plugins/dataTables/dataTables.responsive.js"></script>
<script type="text/javascript" 
	src="${pageContext.request.contextPath}/js/plugins/chartJs/Chart.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.dataTables-example').dataTable({
			responsive : true
		});
		$('.datepicker').datetimepicker({
			pickTime : false,
			dateFormat : 'dd/mm/yy'
		});
	});
	
	$(function () {
		
	    var lineData = {
	        labels: ["Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"],
	        datasets: [
	            {
	                label: "DATA PER BULAN",
	                fillColor: "rgba(26,179,148,0.5)",
	                strokeColor: "rgba(26,179,148,0.7)",
	                pointColor: "rgba(26,179,148,1)",
	                pointStrokeColor: "#fff",
	                pointHighlightFill: "#fff",
	                pointHighlightStroke: "rgba(26,179,148,1)",
	                data: eval(${bulanData})
	            }
	        ]
	    };

	    var lineOptions = {
	        scaleShowGridLines: false,
	        scaleGridLineColor: "rgba(0,0,0,.05)",
	        scaleGridLineWidth: 1,
	        bezierCurve: true,
	        bezierCurveTension: 0.4,
	        pointDot: true,
	        pointDotRadius: 4,
	        pointDotStrokeWidth: 1,
	        pointHitDetectionRadius: 20,
	        datasetStroke: true,
	        datasetStrokeWidth: 2,
	        datasetFill: true,
	        responsive: true,
	    };


	    var ctx = document.getElementById("lineChart").getContext("2d");
	    var myNewChart = new Chart(ctx).Line(lineData, lineOptions);
	    
	    var barData = {
	            labels: eval(${provinsiNameList}),
	            datasets: [
	                {
	                    label: "DATA PER PROVINSI",
	                    fillColor: "rgba(28, 132, 198, 0.5)",
	                    strokeColor: "rgba(28, 132, 198, 0.8)",
	                    highlightFill: "rgba(28, 132, 198, 0.75)",
	                    highlightStroke: "rgba(28, 132, 198, 1)",
	                    data: eval(${provinsiDataList})
	                }
	            ]
	        };

	        var barOptions = {
	            scaleBeginAtZero: true,
	            scaleShowGridLines: true,
	            scaleGridLineColor: "#dedede",
	            scaleGridLineWidth: 1,
	            barShowStroke: true,
	            barStrokeWidth: 2,
	            barValueSpacing: 5,
	            barDatasetSpacing: 1,
	            responsive: true,
	        }


	        var ctx = document.getElementById("barChart").getContext("2d");
	        var myNewChart = new Chart(ctx).Bar(barData, barOptions);
	});
</script>