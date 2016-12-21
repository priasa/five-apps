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

<title>F I V E.</title>
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

<link
	href="${pageContext.request.contextPath}/css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/plugins/dataTables/dataTables.responsive.css"
	rel="stylesheet">


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

					<sec:authorize
						access="hasAnyRole('ROLE_SCHEDULER_VIEW', 'ROLE_SCHEDULER_ADD_EDIT', 'ROLE_SCHEDULER_DELETE')">
						<c:if test="${isLogin }">
							<li
								class="<c:if test="${fn:contains(menu, 'scheduler')}">in active</c:if>">
								<a href="#"> <i class="fa fa-calendar"></i> <span
									class="nav-label">Scheduler</span> <span class="fa arrow"></span>
							</a>
								<ul
									class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'admin.')}">in active</c:if>"
									aria-expanded="true" style="">
									<li
										<c:if test="${menu eq 'scheduler.detail'}">class="active"</c:if>>
										<a
										href="${ pageContext.request.contextPath }/web/scheduler/detail/list">Detail</a>
									</li>
									<li
										<c:if test="${menu eq 'scheduler.log'}">class="active"</c:if>>
										<a
										href="${ pageContext.request.contextPath }/web/scheduler/log/list">log</a>
									</li>

								</ul>
							</li>
						</c:if>
					</sec:authorize>
					<sec:authorize
						access="hasAnyRole('ROLE_TWITTER_VIEW', 'ROLE_TWITTER_DATA_ADD_EDIT', 'ROLE_TWITTER_DATA_DELETE')">
						<c:if test="${isLogin }">
							<li 
								class="<c:if test="${fn:contains(menu, 'twitter')}">in active</c:if>">
								<a href="#"> 
									<i class="fa fa-twitter"></i> 
									<span class="nav-label">Twitter</span> 
									<span class="fa arrow"></span>
								</a>
								<ul
									class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'twitter.stream')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'twitter.stream'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/twitter/stream/list">Stream</a>
									</li>
								</ul>
							</li>
						</c:if>
					</sec:authorize>
					<sec:authorize
						access="hasAnyRole('ROLE_MASTER_DATA_VIEW', 'ROLE_MASTER_DATA_ADD_EDIT', 'ROLE_MASTER_DATA_DELETE')">
						<c:if test="${isLogin }">
							<li
								class="<c:if test="${fn:contains(menu, 'masterdata')}">in active</c:if>">
								<a href="#"> 
									<i class="fa fa-gears"></i> 
									<span class="nav-label">Master Data</span> 
									<span class="fa arrow"></span>
								</a>
								<ul
									class="nav nav-second-level collapse <c:if test="${fn:contains(menu, 'masterdata')}">in active</c:if>"
									aria-expanded="true" style="">
									<li <c:if test="${menu eq 'masterdata'}">class="active"</c:if>>
										<a href="${pageContext.request.contextPath}/web/masterdata/mdList">Master Data Listing</a>
									</li>
								</ul>
							</li>
						</c:if>
					</sec:authorize>
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
						<li><span class="m-r-sm text-muted welcome-message">F
								I V E.</span></li>
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