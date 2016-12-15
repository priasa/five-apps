<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.scheduler.log.listing" />
		</div>
		<div class="ibox-content">
		<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right"> 
					<input type="text"  placeholder="Job Name" id="jobName" name="jobName" class="input-sm form-control inline" value="${jobName}" />
					<input type="text"  placeholder="Class Name" id="jobClassName" name="jobClassName" class="input-sm form-control inline" value="${jobClassName}" />
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
				</div>
				<div class="row tableAction">
				</div>
				<br/>
				<display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped"
					requestURI="?" sort="external" partialList="true">
					<display:column media="html" title="<input type='checkbox' id='selectall'/><span class='custom-checkbox'></span>" class="selectAll">
						<input name="id" type="checkbox" value="${schedulerLog.id}" />
						<span class="custom-checkbox"></span>
					</display:column>
					<display:column titleKey="general.job" sortable="true">
						<c:out value="${ schedulerLog.jobName }" />
					</display:column>
					<display:column titleKey="general.jobClassName" sortable="false">
						<c:out value="${ schedulerLog.jobClassName }" /></b>
					</display:column>
					<display:column titleKey="general.status" sortable="false">
						<c:out value="${ schedulerLog.jobStatus.code }" /></b>
					</display:column>
					<display:column titleKey="general.finishTime" sortable="true">
						<c:if test="${ schedulerLog.finishTime != null }">
							<fmt:formatDate value="${ schedulerLog.finishTime }" pattern="dd/MM/yyyy hh:mm a" />
						</c:if>
					</display:column>
					<display:column titleKey="general.message" sortable="false">
						<c:out value="${ schedulerLog.message }" />
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
	document.location.href = "${pageContext.request.contextPath}/web/scheduler/detail/new";
}

function deleteRecords() {
    if ($("[name=id]:checked").length > 0) {
        if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
            $("#filterForm").attr("method", "POST");
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/scheduler/detail/delete");
            return true;
        }
    }
    return false;
}

function firenow(schedulerDetailId) {
   	var url = "${pageContext.request.contextPath}/web/scheduler/detail/firenow/"+schedulerDetailId
	if (confirm('<fmt:message key="general.firenow.confirmation"/>')) {
	   $("#filterForm").attr("method", "POST");
	   $("#filterForm").attr("action", url);
       return true;
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