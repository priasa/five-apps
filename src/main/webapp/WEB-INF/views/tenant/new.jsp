<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.tenant.addedit" />
		</div>
		<div class="ibox-content">
			<commons:notification-message />
			<form:form class="form-horizontal" commandName="tenant"
				method="POST" role="form"
				action="${pageContext.request.contextPath}/web/tenant/save/submit">

				<form:hidden path="id" />

				<div class="form-group <form:errors path="name">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="name">
						<fmt:message key="general.name"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<form:input path="name" class="form-control"/>
						<form:errors path="name" cssClass="help-block text-danger"/>
					</div>
				</div>

				<div class="row tableAction">
					<div class="col-sm-offset-2 col-sm-5">
						<button type="submit" class="btn btn-primary btn-sm">
							<fmt:message key="general.submit" />
						</button>
						<button type="button" class="btn btn-warning btn-sm"
							onclick="cancel()">
							<fmt:message key="general.cancel" />
						</button>
					</div>
				</div>

			</form:form>
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
		dateFormat : 'dd/mm/yy',
		maxDate : new Date()
	});
	
});

function cancel(){
	document.location.href = "${pageContext.request.contextPath}/web/tenant/list";
}

</script>

<commons:footer />