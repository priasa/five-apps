<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<form:form class="form-horizontal" commandName="proposalEntity"
		method="POST"
		action="${pageContext.request.contextPath}/web/proposal/send/${processId}/${activityId}"
		enctype="multipart/form-data">

		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<fmt:message key="header.proposal.view" />
			</div>
			<div class="ibox-content">
				<commons:notification-message />

				<form:hidden path="id" />
				<form:hidden path="idCardImage" />

				<div
					class="form-group <form:errors path="requestNumber" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="requestNumber">
						<fmt:message key="general.requestNumber" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="requestNumber" class="form-control"
							readonly="true" disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="latestState" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="latestState">
						<fmt:message key="general.latestState" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="latestState" class="form-control"
							readonly="true" disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="unitEselon1" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="unitEselon1">
						<fmt:message key="general.unitEselon1" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="nameEselon1" class="form-control" readonly="true" disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="unitEselon2" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="unitEselon2">
						<fmt:message key="general.unitEselon2" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="nameEselon2" class="form-control" readonly="true" disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="description" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="description">
						<fmt:message key="general.description" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:textarea path="description" class="form-control" rows="10"
							readonly="true" disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="dueDate" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="dueDate">
						<fmt:message key="general.dueDate" /> <span class="mandatory"><fmt:message
								key="general.mandatory" /></span>
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="dueDate" class="datepicker form-control"
							data-date-format="DD/MM/YYYY" readonly="true" disabled="true" />
						<form:errors path="dueDate" cssClass="help-block text-danger" />
					</div>
				</div>


				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label"> <fmt:message
							key="general.document" />
					</label>
					<div class="col-sm-8">
						<div class="form-control">
							<a
								href="${pageContext.request.contextPath}/web/proposal/document/${proposalEntity.id}">${proposalEntity.proposalFilename}</a>
						</div>
					</div>
				</div>

				<div
					class="form-group <form:errors path="comment" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="comment">
						<fmt:message key="general.comment" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:textarea path="comment" class="form-control" rows="10"
							readonly="true" disabled="true" />
					</div>
				</div>

				<div class="row tableAction">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="button" class="btn btn-warning btn-sm"
							onclick="cancel()">
							<fmt:message key="general.back" />
						</button>
					</div>
				</div>


			</div>
		</div>

		<div class="ibox float-e-margins">
			<div class="ibox-title"></div>
			<div class="ibox-content">
				<div
					class="form-group <form:errors path="name" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="name">
						<fmt:message key="general.name" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="name" class="form-control" readonly="true"
							disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="ssn" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="ssn"> <fmt:message
							key="general.ssn" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="ssn" class="form-control" readonly="true"
							disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="address" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="address">
						<fmt:message key="general.address" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:textarea path="address" class="form-control" rows="5"
							readonly="true" disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="email" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="email">
						<fmt:message key="general.email" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="email" class="form-control" readonly="true"
							disabled="true" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="phone" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="phone">
						<fmt:message key="general.phone" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="phone" class="form-control" readonly="true"
							disabled="true" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label"> <fmt:message
							key="general.image" />
					</label>
					<div class="col-sm-8">
						<div class="thumbnail">
							<img
								src="${pageContext.request.contextPath}/web/proposal/images/${proposalEntity.id}"
								onerror="this.src='${pageContext.request.contextPath}/images/image-not-found.jpg'"
								width="15%" height="15%"><br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.proposal.monitoring" />
		</div>
		<div class="ibox-content">
			<div>
				<table id="dTable"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th class="control-label"><fmt:message key="general.id" /></th>
							<th class="control-label"><fmt:message key="general.name" /></th>
							<th class="control-label"><fmt:message key="general.state" /></th>
							<th class="control-label"><fmt:message
									key="general.assignee" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${activities}" var="act">
							<tr>
								<td><c:out value="${act.id}" /></td>
								<td><c:out value="${act.name}" /></td>
								<td><c:out value="${act.state}" /></td>
								<td><c:out value="${act.assignee}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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
		document.location.href = "${pageContext.request.contextPath}/web/proposal/list?requestNumber=${requestNumber}";
	}
</script>

<commons:footer />