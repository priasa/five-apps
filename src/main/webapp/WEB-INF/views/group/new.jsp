<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.group.addedit" /> 
		</div>
		<div class="ibox-content">
			<commons:notification-message/>
			<form:form class="form-horizontal" commandName="groupDTO" method="POST"
				action="${pageContext.request.contextPath}/web/group/save/submit">
				
				<form:hidden path="id"/>
				<form:hidden path="defaultAdminGroup"/>
				
				<div class="form-group <form:errors path="name">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="name">
						<fmt:message key="general.name"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<c:choose>
							<c:when test="${ groupForm.defaultAdminGroup }">
								<form:input path="name" disabled="true" class="form-control"/>
								<form:hidden path="name" />
							</c:when>
							<c:otherwise>
								<form:input path="name" class="form-control"/>
							</c:otherwise>
						</c:choose>
						<form:errors path="name" cssClass="help-block text-danger"/>
					</div>
				</div>
				<c:forEach var="roleEntry" items="${ roleMap }">
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label" for="entryKey">
							<span class="text-danger">
								<c:out value="${ roleEntry.key }" />
							</span>
						</label>
						<c:forEach var="permission" items="${ roleEntry.value }">
							<label class="col-sm-2 checkbox inline" style="padding-left: 50px"> 
								<c:set var="checkboxSelect" value="" /> 
									<c:if test="${ existingRoleMap[permission] }">
										<c:set var="checkboxSelect" value="checked" />
									</c:if> 
									<fmt:message var="permissionLabel" key="group.permission.${permission}" /> 
									<input type="checkbox" name="permission" value="${ permission }" <c:out value='${ checkboxSelect }'/> /><span class='custom-checkbox'></span>
									<c:out value="${ permissionLabel }" />
							</label>
						</c:forEach>
					</div>

				</c:forEach>

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

<script type="text/javascript">

function cancel(){
	document.location.href = "${pageContext.request.contextPath}/web/group/list";
}

</script>

<commons:footer />