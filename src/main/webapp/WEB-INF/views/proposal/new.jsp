<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<form:form class="form-horizontal" commandName="proposalEntity"
		method="POST"
		action="${pageContext.request.contextPath}/web/proposal/save/submit"
		enctype="multipart/form-data">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<fmt:message key="header.proposal.addedit" />
			</div>
			<div class="ibox-content">
				<commons:notification-message />
				<form:hidden path="id" />
				<form:hidden path="requestNumber" />
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
					class="form-group <form:errors path="unitEselon1" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="unitEselon1">
						<fmt:message key="general.unitEselon1" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:select path="unitEselon1" class="form-control">
							<form:options items="${ eselon1 }" itemLabel="name" itemValue="id" />
						</form:select>
						<form:errors path="unitEselon1" cssClass="help-block text-danger" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="description" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="description">
						<fmt:message key="general.description" /> <span class="mandatory"><fmt:message
								key="general.mandatory" /></span>
					</label>
					<div class="col-sm-8 form-control-label">
						<form:textarea path="description" class="form-control" rows="5" />
						<form:errors path="description" cssClass="help-block text-danger" />
					</div>
				</div>

				<div class="row tableAction">
					<div class="col-sm-offset-2 col-sm-8">
						<sec:authorize access="hasAnyRole('ROLE_PROPOSAL_ADD_EDIT')">
							<button type="submit" class="btn btn-primary btn-sm">
								<fmt:message key="general.submit" />
							</button>
						</sec:authorize>
						<button type="button" class="btn btn-warning btn-sm"
							onclick="cancel()">
							<fmt:message key="general.cancel" />
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
						<fmt:message key="general.name" /> <span class="mandatory"><fmt:message
								key="general.mandatory" /></span>
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="name" class="form-control" />
						<form:errors path="name" cssClass="help-block text-danger" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="ssn" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="ssn"> <fmt:message
							key="general.ssn" /> <span class="mandatory"><fmt:message
								key="general.mandatory" /></span>
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="ssn" class="form-control" />
						<form:errors path="ssn" cssClass="help-block text-danger" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="address" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="address">
						<fmt:message key="general.address" /> <span class="mandatory"><fmt:message
								key="general.mandatory" /></span>
					</label>
					<div class="col-sm-8 form-control-label">
						<form:textarea path="address" class="form-control" rows="5" />
						<form:errors path="address" cssClass="help-block text-danger" />
					</div>
				</div>

				<div class="form-group <form:errors path="email" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="email">
						<fmt:message key="general.email" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="email" class="form-control" />
						<form:errors path="email" cssClass="help-block text-danger" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="phone" cssClass="error">error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="phone">
						<fmt:message key="general.phone" />
					</label>
					<div class="col-sm-8 form-control-label">
						<form:input path="phone" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label"> <fmt:message
							key="general.image" />
					</label>
					<div class="col-sm-8">
						<img src="data:image/jpeg;base64,${proposalEntity.idCardImage}"
							onerror="this.src='${pageContext.request.contextPath}/images/image-not-found.jpg'"
							width="15%" height="15%" /><br />
					</div>
				</div>
				
				<div class="row tableAction">
					<div class="col-sm-offset-2 col-sm-8">
						<sec:authorize access="hasAnyRole('ROLE_PROPOSAL_ADD_EDIT')">
							<button type="submit" class="btn btn-primary btn-sm">
								<fmt:message key="general.submit" />
							</button>
						</sec:authorize>
						<button type="button" class="btn btn-warning btn-sm"
							onclick="cancel()">
							<fmt:message key="general.cancel" />
						</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
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
		document.location.href = "${pageContext.request.contextPath}/web/proposal/list";
	}
</script>

<commons:footer />