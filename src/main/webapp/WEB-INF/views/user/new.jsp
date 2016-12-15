<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.user.addedit" /> 
		</div>
		<div class="ibox-content">
			<commons:notification-message/>
			<form:form class="form-horizontal" commandName="userDTO" method="POST" role="form"
				action="${pageContext.request.contextPath}/web/user/save/submit">
				
				<form:hidden path="id"/>
				<form:hidden path="edit"/>
				
				<div class="form-group <form:errors path="username">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="username">
						<fmt:message key="general.username"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<c:set var="changeUsername" value="${ empty userDTO.id }"/> 
						<form:input path="username" readonly="${ !changeUsername }" class="form-control"/>
						<form:errors path="username" cssClass="help-block text-danger"/>
					</div>
				</div>
				<div class="form-group <form:errors path="password" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="password">
						<fmt:message key="user.password" />
					</label>
					<div class="col-sm-5">
						<form:password path="password" class="form-control" />
						<form:errors path="password" cssClass="help-inline text-danger" />
					</div>
				</div>
				<div class="form-group <form:errors path="retypePassword" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="retypePassword"> 
						<fmt:message key="user.retypePassword" />
					</label>
					<div class="col-sm-5">
						<form:password path="retypePassword" class="form-control" />
						<form:errors path="retypePassword" cssClass="help-inline text-danger" />
					</div>
				</div>
				<div class="form-group <form:errors path="firstname">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for=firstname>
						<fmt:message key="user.firstname"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<form:input path="firstname" class="form-control"/>
						<form:errors path="firstname" cssClass="help-block text-danger"/>
					</div>
				</div>
				<div class="form-group <form:errors path="lastname" >has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for=lastname>
						<fmt:message key="user.lastname"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<form:input path="lastname" class="form-control"/>
						<form:errors path="lastname" cssClass="help-block text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label" for="nickname">
						<fmt:message key="user.nickname"/>
					</label>
					<div class="col-sm-5">
						<form:input path="nickname" class="form-control"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label" for="address">
						<fmt:message key="user.address"/>
					</label>
					<div class="col-sm-5">
						<form:textarea path="address" rows="5" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group <form:errors path="groupId" >has-error</form:errors>">
					<label class="col-sm-2 control-label" for="groupId">
						<fmt:message key="user.group"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<form:select path="groupId" class="form-control">
							<form:option value=""></form:option>
							<form:options items="${ allGroupList }" itemLabel="name" itemValue="id"/>
						</form:select>
						<form:errors path="groupId" cssClass="help-block text-danger"/>
					</div>
				</div>
				<div class="form-group <form:errors path="status" >has-error</form:errors>">
					<label class="col-sm-2 control-label" for="status">
						<fmt:message key="user.status"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<form:select path="status" class="form-control">
							<form:option value="">Select Status</form:option>
							<c:forEach var="tempStatus" items="${ userStatusList }">
								<fmt:message key="user.status.${ tempStatus.value }" var="statusLabel"/>
								<form:option value="${ tempStatus.value }" ><c:out value="${ statusLabel }"/></form:option>
							</c:forEach>
						</form:select>
						<form:errors path="status" cssClass="help-block text-danger"/>
					</div>
				</div>
				<div class="row tableAction">
					<div class="col-sm-offset-2 col-sm-5">
						<button type="submit" class="btn btn-primary btn-sm"><fmt:message key="general.submit"/></button>
						<button type="button" class="btn btn-warning btn-sm" onclick="cancel()"><fmt:message key="general.cancel"/></button>
					</div>
				</div>
			
			</form:form>
		</div>
	</div>
</div>
<c:url var="findJobsByDepartment" value="/web/user/jobs" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.11.0.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$('.datepicker').datetimepicker({
		pickTime : false,
		dateFormat : 'dd/mm/yy',
		maxDate : new Date()
	});
	
	/* alert($('#jobId').val());
	if($('#departmentId').val() != '') {
			$.getJSON('${findJobsByDepartment}', {
				departmentId : $('#departmentId').val(),
				ajax : 'true'
			}, function(data) {
				var html = '<option value="">Select Job</option>';
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i].id + '">'
							+ data[i].jobCode +" | " + data[i].jobName+ '</option>';
				}
				html += '</option>';
 
				$('#jobId').html(html);
			});
		
	} */
	
	$('#departmentId').change(
			function() {
				$.getJSON('${findJobsByDepartment}', {
					departmentId : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">Select Job</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].id + '">'
								+ data[i].jobCode +" | " + data[i].jobName+ '</option>';
					}
					html += '</option>';
	 
					$('#jobId').html(html);
				});
			});
});

function cancel(){
	document.location.href = "${pageContext.request.contextPath}/web/user/list";
}

</script>

<commons:footer />