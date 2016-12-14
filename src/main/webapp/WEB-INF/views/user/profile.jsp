<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.user.profile" />
		</div>
		<div class="ibox-content">
			<commons:notification-message/>
			<div class="row">
				<form:form class="form-horizontal" commandName="userProfileDTO"
					method="POST"
					action="${pageContext.request.contextPath}/web/profile">

					<form:hidden path="id" />
					<form:hidden path="username" />
					
					<div
						class="form-group <form:errors path="username" cssClass="error">error</form:errors>">
						<label class="col-sm-2 col-sm-2 control-label" for="username">
							<fmt:message key="general.username" />
						</label>
						<div class="col-sm-5 form-control-label">
							<c:out value="${ userProfileDTO.username }" />
						</div>
					</div>
					<div
						class="form-group <form:errors path="firstname" cssClass="error">error</form:errors>">
						<label class="col-sm-2 col-sm-2 control-label" for=firstname>
							<fmt:message key="user.firstname" /> <span class="mandatory"><fmt:message
									key="general.mandatory" /></span>
						</label>
						<div class="col-sm-5">
							<form:input path="firstname" class="form-control" />
							<form:errors path="firstname" cssClass="help-inline text-danger" />
						</div>
					</div>
					<div
						class="form-group <form:errors path="lastname" cssClass="error">error</form:errors>">
						<label class="col-sm-2 col-sm-2 control-label" for=lastname>
							<fmt:message key="user.lastname" /> <span class="mandatory"><fmt:message
									key="general.mandatory" /></span>
						</label>
						<div class="col-sm-5">
							<form:input path="lastname" class="form-control" />
							<form:errors path="lastname" cssClass="help-inline text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label" for="nickname">
							<fmt:message key="user.nickname" />
						</label>
						<div class="col-sm-5">
							<form:input path="nickname" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label" for="address">
							<fmt:message key="user.address" />
						</label>
						<div class="col-sm-5">
							<form:textarea path="address" class="form-control" rows="5" />
						</div>
					</div>
					<div
						class="form-group <form:errors path="password" cssClass="error">error</form:errors>">
						<label class="col-sm-2 col-sm-2 control-label" for="password">
							<fmt:message key="user.password" />
						</label>
						<div class="col-sm-5">
							<form:password path="password" class="form-control" />
							<form:errors path="password" cssClass="help-inline text-danger" />
						</div>
					</div>

					<div
						class="form-group <form:errors path="retypePassword" cssClass="error">error</form:errors>">
						<label class="col-sm-2 col-sm-2 control-label"
							for="retypePassword"> <fmt:message
								key="user.retypePassword" />
						</label>
						<div class="col-sm-5">
							<form:password path="retypePassword" class="form-control" />
							<form:errors path="retypePassword" cssClass="help-inline text-danger" />
						</div>
					</div>
					<div class="row tableAction">
						<div class="col-sm-offset-2 col-sm-5">
							<button type="submit" class="btn btn-primary btn-sm">
								<fmt:message key="general.submit" />
							</button>
							<button type="button" class="btn btn-warning btn-sm" onclick="cancel()">
								<fmt:message key="general.back" />
							</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.datepicker').datetimepicker({
			pickTime : false,
			dateFormat : 'dd/mm/yy'
		});
	});

	function cancel() {
		document.location.href = "${pageContext.request.contextPath}/web";
	}
	function logoutOnDevice() {
		document.location.href = "${pageContext.request.contextPath}/web/logoutOnDevice/${userProfileDTO.username}";
	}
</script>

<commons:footer />