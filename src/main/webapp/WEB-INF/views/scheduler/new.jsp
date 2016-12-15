<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.scheduler.detail.addedit" />
		</div>
		<div class="ibox-content">
			<commons:notification-message />
			<form:form class="form-horizontal" commandName="schedulerDetail"
				method="POST" role="form"
				action="${pageContext.request.contextPath}/web/scheduler/detail/save">

				<form:hidden path="id" />
				<c:set var="isNewRecord" value="${ empty schedulerDetail.id }"/> 
					<div class="form-group <form:errors path="jobName" >has-error</form:errors>">
						<label class="col-sm-2 control-label" for="jobName"> <fmt:message
								key="general.jobName" />
						</label>
						<div class="col-sm-5">
							<form:input path="jobName" id="jobName"  readonly="${ !isNewRecord }" class="form-control"/>
							<form:errors path="jobName" cssClass="help-block text-danger" />
						</div>
					</div>

					<div
						class="form-group <form:errors path="groupJobName" >has-error</form:errors>">
						<label class="col-sm-2 control-label" for="groupJobName"> <fmt:message
								key="general.groupJobName" />
						</label>
						<div class="col-sm-5">
							<form:input path="groupJobName" id="groupJobName" readonly="${ !isNewRecord }" class="form-control"/>
							<form:errors path="groupJobName" cssClass="help-block text-danger" />
						</div>
					</div>

					<div
						class="form-group <form:errors path="triggerName" >has-error</form:errors>">
						<label class="col-sm-2 control-label" for="triggerName"> <fmt:message
								key="general.triggerName" />
						</label>
						<div class="col-sm-5">
							<form:input path="triggerName" id="triggerName" readonly="${ !isNewRecord }" class="form-control"/>
							<form:errors path="triggerName" cssClass="help-block text-danger" />
						</div>
					</div>
				
					<div
						class="form-group <form:errors path="groupTriggerName" >has-error</form:errors>">
						<label class="col-sm-2 control-label" for="groupTriggerName"> <fmt:message
								key="general.groupTriggerName" />
						</label>
						<div class="col-sm-5">
							<form:input path="groupTriggerName" id="groupTriggerName" readonly="${ !isNewRecord }" class="form-control"/>
							<form:errors path="groupTriggerName" cssClass="help-block text-danger" />
						</div>
					</div>
				
					<div
						class="form-group <form:errors path="jobClassName" >has-error</form:errors>">
						<label class="col-sm-2 control-label" for="jobClassName"> <fmt:message
								key="general.jobClassName" />
						</label>
						<div class="col-sm-5">
							<form:input path="jobClassName" id="jobClassName"  readonly="${ !isNewRecord }" class="form-control"/>
							<form:errors path="jobClassName" cssClass="help-block text-danger" />
						</div>
					</div>
				
					<div
						class="form-group <form:errors path="cronExpression" >has-error</form:errors>">
						<label class="col-sm-2 control-label" for="cronExpression"> <fmt:message
								key="general.cronExpression" />
						</label>
						<div class="col-sm-5">
							<form:input path="cronExpression" id="cronExpression" class="form-control"/>
							<form:errors path="cronExpression" cssClass="help-block text-danger" />
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
<c:url var="findKabupatenByProvinsi" value="/web/kabupaten/listByProvinsi" />
<c:url var="findPkmByFilter" value="/web/puskesmas/listByFilter" />

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
	
	$('#provinsi').change(
			function() {
				$.getJSON('${findKabupatenByProvinsi}', {
					provinsi : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">Select Kabupaten/Kota</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].kode + '">'+ data[i].nama+ '</option>';
					}
					html += '</option>';
	 
					$('#kabupaten').html(html);
				});
			});
	
	$('#kabupaten').change(
			function() {
				$.getJSON('${findPkmByFilter}', {
					provinsi : $('#provinsi').val(),
					kabupaten : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">Select Puskesmas</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].kode + '">'+ data[i].nama+ '</option>';
					}
					html += '</option>';
	 
					$('#tenantCode').html(html);
				});
			});
});

function cancel(){
	document.location.href = "${pageContext.request.contextPath}/web/scheduler/detail/list";
}

</script>

<commons:footer />