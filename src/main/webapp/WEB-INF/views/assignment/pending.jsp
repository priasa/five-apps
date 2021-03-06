<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.assignment.pending" />
		</div>
		<div class="ibox-content">
		<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right"> 
					<input type="text"  placeholder="Request No." id="requestNumber" name="requestNumber" class="input-sm form-control inline" value="${requestNumber}" />
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
				</div>
				<br/>
				<display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped"
					requestURI="?" sort="external" partialList="true">
					<display:column media="html" title="<input type='checkbox' id='selectall'/><span class='custom-checkbox'></span>" class="selectAll">
						<input name="id" type="checkbox" value="${bpmAssignment.id}" />
						<span class="custom-checkbox"></span>
					</display:column>
					<display:column titleKey="assignment.requestNumber" sortable="true">
						<c:url var="editUrl" value="/web/assignment/complete/${ bpmAssignment.processId }/${ bpmAssignment.activityId }">
						</c:url>
						<a href="${ editUrl }"><c:out value="${ bpmAssignment.requestNumber }" /></a>
					</display:column>
					<display:column titleKey="assignment.processName" sortable="true">
						<c:out value="${ bpmAssignment.processName }" />
					</display:column>
					<display:column titleKey="assignment.activityName" sortable="true">
						<c:out value="${ bpmAssignment.activityName }" />
					</display:column>
					<display:column titleKey="assignment.eselon1" sortable="true">
						<c:out value="${ bpmAssignment.eselon1 }" />
					</display:column>
					<display:column titleKey="assignment.eselon2" sortable="true">
						<c:out value="${ bpmAssignment.eselon2 }" />
					</display:column>
					<display:column titleKey="assignment.dateCreated" sortable="true">
						<c:out value="${ bpmAssignment.dateCreated }" />
					</display:column>
				</display:table>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">

$(document).ready(function() {
    initSelectAll();
});

function newRecord(){
	document.location.href = "${pageContext.request.contextPath}/web/guest/new";
}

function deleteRecords() {
    if ($("[name=id]:checked").length > 0) {
        if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
            $("#filterForm").attr("method", "POST");
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/user/delete");
            return true;
        }
    }
    return false;
}
</script>
<commons:footer />
<script type="text/javascript">
	$(document).ready(function() {
		$('.datepicker').datetimepicker({
			pickTime : false,
			dateFormat : 'dd/mm/yy'
		});
	});
</script>