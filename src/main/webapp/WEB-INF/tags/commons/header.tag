<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico">
<link rel="icon" href="${pageContext.request.contextPath}/favicon.ico"
	type="image/x-icon">

<title>INTEROPERABILITY - SIP.</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<style type="text/css">
.jqstooltip {
	position: absolute;
	left: 0px;
	top: 0px;
	visibility: hidden;
	background: rgb(0, 0, 0) transparent;
	background-color: rgba(0, 0, 0, 0.6);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000,
		endColorstr=#99000000);
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";
	color: white;
	font: 10px arial, san serif;
	text-align: left;
	white-space: nowrap;
	padding: 5px;
	border: 1px solid white;
	z-index: 10000;
}

.jqsfield {
	color: white;
	font: 10px arial, san serif;
	text-align: left;
}
</style>
<!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pace.css">-->
<!-- form builder -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui.min.css">
	
<link href="${pageContext.request.contextPath}/css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/plugins/dataTables/dataTables.responsive.css" rel="stylesheet">

 
<!-- Jquery -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/local.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/moment.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>
	
	

</head>
</head>
<sec:authorize access="isAuthenticated()" var="isLogin" />
<body class="pace-done skin-1">
	<div id="wrapper">
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul id="side-menu" class="nav">
					<li class="nav-header">
						<div class="dropdown profile-element">

							<span> <img alt="image" class="img-circle"
								src="${ pageContext.request.contextPath }/images/imageedit_1_7208937812.png">
							</span>
							<c:if test="${ isLogin }">
								<a data-toggle="dropdown" class="dropdown-toggle" href="#"
									aria-expanded="true"> <span class="clear"> <span
										class="block m-t-xs"> <b><c:out
													value="${ pageContext['request'].userPrincipal.principal.fullname }" /></b>
											<b class="caret"></b> <br />
									</span>
								</span>
								</a>
								<ul class="dropdown-menu animated fadeInRight m-t-xs">
									<li><a
										href="${ pageContext.request.contextPath }/web/profile">Profile</a></li>
									<li><a
										href="${pageContext.request.contextPath}/web/logout">Logout</a></li>
								</ul>
							</c:if>
						</div>
						<div class="logo-element">SIP</div>
					</li>
					<li></li>
					<li><a href="${pageContext.request.contextPath}"> <i
							class="fa fa-home"></i> <span class="nav-label">Home</span>
					</a></li>
					
					<li class="<c:if test="${fn:contains(menu, 'howto')}">in active</c:if>">
						<a href="#"> 
							<i class="fa fa-plug"></i> 
							<span class="nav-label">Manual Web Service</span> 
							<span class="fa arrow"></span>
						</a>
						<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'howto.ukme')}">in active</c:if>" aria-expanded="true" style="">
							<li
								class="<c:if test="${fn:contains(menu, 'howto.ukme')}">in active</c:if>">
								<a href="#"><span class="nav-label">UKME</span> <span class="fa arrow"></span>
								</a>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukme1')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukme1'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukme1/howto">Promosi
											Kesehatan</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukme2')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukme2'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukme2/howto">Kesehatan
											Lingkungan</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukme3a')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukme3a'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukme3a/howto">Gizi,
											Kesehatan Ibu Anak</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukme3b')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukme3b'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukme3b/howto">Program
											UKS</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukme4')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukme4'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukme4/howto">Imunisasi</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukme5')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukme5'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukme5/howto">Penyakit
											Menular</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukme6')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukme6'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukme6/howto">Penyakit
											Tidak Menular</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukme7')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukme7'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukme7/howto">Perkesmas</a>
									</li>
								</ul>
							</li>
						</ul>
						<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'howto.ukmp')}">in active</c:if>" aria-expanded="true" style="">
							<li class="<c:if test="${fn:contains(menu, 'howto.ukmp')}">in active</c:if>">
								<a href="#"><span class="nav-label">UKMP</span> <span class="fa arrow"></span>
								</a>
								<ul class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukmp2')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukmp2'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukmp2/howto">Kesehatan Kerja, Olah Raga, dan Tradkom</a>
									</li>
								</ul>
							</li>
						</ul>
						<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'howto.ukp')}">in active</c:if>" aria-expanded="true" style="">
							<li
								class="<c:if test="${fn:contains(menu, 'howto.ukp')}">in active</c:if>">
								<a href="#"> <span class="nav-label">UKP</span> <span class="fa arrow"></span>
								</a>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukp1')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukp1'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukp1/howto">Pelayanan Puskesmas</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukp2')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukp2'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukp2/howto">Kesakitan Umum</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukp3')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukp3'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukp3/howto">Kesakitan Gigi dan Mulut</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukp4')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukp4'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukp4/howto">Kesakitan Terbanyak</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukp5')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukp5'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukp5/howto">Kejadian Kematian</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.ukp6')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.ukp6'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/ukp6/howto">LPLPO</a>
									</li>
								</ul>
							</li>
						</ul>
						<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'howto.lt')}">in active</c:if>" aria-expanded="true" style="">
							<li
								class="<c:if test="${fn:contains(menu, 'howto.lt')}">in active</c:if>">
								<a href="#"><span class="nav-label">TAHUNAN</span> <span class="fa arrow"></span>
								</a>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.lt1')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.lt1'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/lt1/howto">Ketersediaan Alat</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.lt2')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.lt2'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/lt2/howto">Sumber Daya Manusia</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.lt3')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.lt3'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/lt3/howto">Program</a>
									</li>
								</ul>
							</li>
						</ul>
						<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'howto.pelayanan')  || fn:contains(menu, 'howto.icd')}">in active</c:if>" aria-expanded="true" style="">
							<li
								class="<c:if test="${fn:contains(menu, 'howto.pelayanan')  || fn:contains(menu, 'howto.icd')}">in active</c:if>">
								<a href="#"><span class="nav-label">Pelayanan & ICD</span> <span class="fa arrow"></span>
								</a>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.pelayanan')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.pelayanan'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/pelayanan/howto">Pelayanan</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.icd')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.icd'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/icd/howto">ICD</a>
									</li>
								</ul>
							</li>
						</ul>
						<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'howto.provinsi')  || fn:contains(menu, 'howto.kabupaten')}">in active</c:if>" aria-expanded="true" style="">
							<li
								class="<c:if test="${fn:contains(menu, 'howto.provinsi')  || fn:contains(menu, 'howto.kabupaten')}">in active</c:if>">
								<a href="#"><span class="nav-label">Data Pendukung</span> <span class="fa arrow"></span>
								</a>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.provinsi')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.provinsi'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/provinsi/howto">Provinsi</a>
									</li>
								</ul>
								<ul
									class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'howto.kabupaten')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'howto.kabupaten'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/kabupaten/howto">Kabupaten/Kota</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<c:if test="${isLogin }">
						<li class="<c:if test="${fn:contains(menu, 'report')}">in active</c:if>">
							<a href="#"> 
								<i class="fa fa-book"></i> 
								<span class="nav-label">Laporan</span> 
								<span class="fa arrow"></span>
							</a>	
							<sec:authorize access="hasAnyRole('ROLE_UKME_VIEW', 'ROLE_UKME_ADD_EDIT', 'ROLE_UKME_DELETE')">
								<c:if test="${isLogin }">
									<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'report.ukme')}">in active</c:if>" aria-expanded="true" style="">
										<li class="<c:if test="${fn:contains(menu, 'report.ukme')}">in active</c:if>">
											<a href="#"><span class="nav-label">UKME</span><span class="fa arrow"></span>
											</a>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukme1')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukme1'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukme1/list">Promosi
														Kesehatan</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukme2')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukme2'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukme2/list">Kesehatan
														Lingkungan</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukme3a')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukme3a'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukme3a/list">Gizi,
														Kesehatan Ibu Anak</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukme3b')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukme3b'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukme3b/list">Program
														UKS</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukme4')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukme4'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukme4/list">Imunisasi</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukme5')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukme5'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukme5/list">Penyakit
														Menular</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukme6')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukme6'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukme6/list">Penyakit
														Tidak Menular</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukme7')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukme7'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukme7/list">Perkesmas</a></li>
											</ul>
										</li>
									</ul>
								</c:if>
							</sec:authorize>
							<sec:authorize access="hasAnyRole('ROLE_UKMP_VIEW', 'ROLE_UKMP_ADD_EDIT', 'ROLE_UKMP_DELETE')">
								<c:if test="${isLogin }">
									<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'report.ukmp')}">in active</c:if>" aria-expanded="true" style="">
										<li
											class="<c:if test="${fn:contains(menu, 'report.ukmp')}">in active</c:if>">
											<a href="#"><span class="nav-label">UKMP</span> <span class="fa arrow"></span></a>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukmp2')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.ukmp2'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukmp2/list">Kesehatan
														Kerja, Olahraga dan Tradkom</a></li>
											</ul>
			
										</li>
									</ul>
								</c:if>
							</sec:authorize>
							<sec:authorize access="hasAnyRole('ROLE_UKP_VIEW', 'ROLE_UKP_ADD_EDIT', 'ROLE_UKP_DELETE')">
								<c:if test="${isLogin }">
									<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'report.ukp')}">in active</c:if>" aria-expanded="true" style="">
										<li
											class="<c:if test="${fn:contains(menu, 'report.ukp')}">in active</c:if>">
											<a href="#"><span class="nav-label">UKP</span> <span class="fa arrow"></span>
										</a>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukp1')}">in active</c:if>"
												aria-expanded="true" style="">
												<li <c:if test="${menu eq 'report.ukp1'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukp1/list">Pelayanan
														Puskesmas</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukp2')}">in active</c:if>"
												aria-expanded="true" style="">
												<li <c:if test="${menu eq 'report.ukp2'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukp2/list">Kesakitan
														Umum</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukp3')}">in active</c:if>"
												aria-expanded="true" style="">
												<li <c:if test="${menu eq 'report.ukp3'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukp3/list">Kesehatan
														Gigi dan Mulut</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukp4')}">in active</c:if>"
												aria-expanded="true" style="">
												<li <c:if test="${menu eq 'report.ukp4'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukp4/list">Kesakitan
														Terbanyak</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukp5')}">in active</c:if>"
												aria-expanded="true" style="">
												<li <c:if test="${menu eq 'report.ukp5'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukp5/list">Kejadian
														Kematian</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.ukp6')}">in active</c:if>"
												aria-expanded="true" style="">
												<li <c:if test="${menu eq 'report.ukp6'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/ukp6/list">LPLPO</a></li>
											</ul>
										</li>
									</ul>	
								</c:if>
							</sec:authorize>
							<sec:authorize access="hasAnyRole('ROLE_LT_VIEW', 'ROLE_LT_ADD_EDIT', 'ROLE_LT_DELETE')">
								<c:if test="${isLogin }">
									<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'report.lt')}">in active</c:if>" aria-expanded="true" style="">
										<li
											class="<c:if test="${fn:contains(menu, 'report.lt')}">in active</c:if>">
											<a href="#"><span class="nav-label">TAHUNAN</span> <span class="fa arrow"></span>
										</a>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.lt1')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.lt1'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/lt1/list">Ketersediaan Alat</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.lt2')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.lt2'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/lt2/list">Sumber Daya Manusia</a></li>
											</ul>
											<ul
												class="nav nav-third-level collapse <c:if test="${fn:contains(menu, 'report.lt3')}">in active</c:if>"
												aria-expanded="true" style="">
												<li
													<c:if test="${menu eq 'report.lt3'}">class="active"</c:if>><a
													href="${pageContext.request.contextPath}/web/lt3/list">Program</a></li>
											</ul>
										</li>
									</ul>
								</c:if>
							</sec:authorize>
							<sec:authorize access="hasAnyRole('ROLE_LAYANAN_VIEW', 'ROLE_LAYANAN_ADD_EDIT', 'ROLE_LAYANAN_DELETE')">
								<ul class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'report.pelayanan')}">in active</c:if>" aria-expanded="true" style="">
									<li
										<c:if test="${menu eq 'report.pelayanan'}">class="active"</c:if>><a href="${pageContext.request.contextPath}/web/pelayanan/list">PELAYANAN</a>
									</li>
								</ul>
							</sec:authorize>
						</li>
						
						</c:if>
						
						<sec:authorize
							access="hasAnyRole('ROLE_USER_VIEW', 'ROLE_USER_ADD_EDIT', 'ROLE_USER_DELETE', 'ROLE_GROUP_VIEW', 'ROLE_GROUP_ADD_EDIT', 'ROLE_GROUP_DELETE', 'ROLE_TENANT_VIEW', 'ROLE_TENANT_ADD_EDIT', 'ROLE_TENANT_DELETE')">
							<c:if test="${isLogin }">
								<li
									class="<c:if test="${fn:contains(menu, 'admin')}">in active</c:if>">
									<a href="#"> <i class="fa fa-users"></i> <span
										class="nav-label">Administration</span> <span class="fa arrow"></span>
								</a>
									<ul
										class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'admin.')}">in active</c:if>"
										aria-expanded="true" style="">
										<sec:authorize
											access="hasAnyRole('ROLE_USER_VIEW', 'ROLE_USER_ADD_EDIT', 'ROLE_USER_DELETE')">
											<li <c:if test="${menu eq 'admin.user'}">class="active"</c:if>><a
												href="${ pageContext.request.contextPath }/web/user/list">User</a></li>
										</sec:authorize>
										<sec:authorize
											access="hasAnyRole('ROLE_GROUP_VIEW', 'ROLE_GROUP_ADD_EDIT', 'ROLE_GROUP_DELETE')">
											<li
												<c:if test="${menu eq 'admin.group'}">class="active"</c:if>><a
												href="${ pageContext.request.contextPath }/web/group/list">Group</a></li>
										</sec:authorize>
										<sec:authorize
											access="hasAnyRole('ROLE_TENANT_VIEW', 'ROLE_TENANT_ADD_EDIT', 'ROLE_TENANT_DELETE')">
											<li
												<c:if test="${menu eq 'admin.tenant'}">class="active"</c:if>><a
												href="${ pageContext.request.contextPath }/web/tenant/list">Tenant</a></li>
										</sec:authorize>
									</ul>
								</li>
						</c:if>
					</sec:authorize>
				</ul>
			</div>
		</nav>
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top white-bg" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a href="#"
							class="navbar-minimalize minimalize-styl-2 btn btn-primary "><i
							class="fa fa-bars"></i> </a>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li><span class="m-r-sm text-muted welcome-message">INTEROPERABILITY - SIP.</span></li>
						<c:if test="${ isLogin }">
							<li><a href="${pageContext.request.contextPath}/web/logout"><i
									class="fa fa-sign-out"></i>Log out</a></li>
						</c:if>
						<c:if test="${!isLogin }">
							<li><a href="${ pageContext.request.contextPath }/web/login"><span
									class="fa fa-sign-in"></span>&nbsp;&nbsp;Login</a></li>
						</c:if>
					</ul>
				</nav>
			</div>