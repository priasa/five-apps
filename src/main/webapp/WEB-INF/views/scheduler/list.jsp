<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.scheduler.detail.listing" />
		</div>
		<div class="ibox-content">
		<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right"> 
					<input type="text"  placeholder="Job or Trigger Name" id="jobOrTriggerName" name="jobOrTriggerName" class="input-sm form-control inline" value="${jobOrTriggerName}" />
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
				</div>
				<div class="row tableAction">
					<div class="col-lg-12">
						<button type="button" class="btn btn-success btn-sm" onclick="newRecord()"><fmt:message key="general.new"/></button>
						<button type="submit" class="btn btn-danger btn-sm" onclick="return deleteRecords()"><fmt:message key="general.delete"/></button>
					</div>
				</div>
				<br/>
				<display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped"
					requestURI="?" sort="external" partialList="true">
					<display:column media="html" title="<input type='checkbox' id='selectall'/><span class='custom-checkbox'></span>" class="selectAll">
						<input name="id" type="checkbox" value="${schedulerDetail.id}" />
						<span class="custom-checkbox"></span>
					</display:column>
					<display:column titleKey="general.job" sortable="true">
						<c:url var="editUrl" value="/web/scheduler/detail/edit/${ schedulerDetail.id }"></c:url>
						<a href="${ editUrl }"><c:out value="${ schedulerDetail.jobName } / ${ schedulerDetail.groupJobName }" /></a>
					</display:column>
					<display:column titleKey="general.trigger" sortable="false">
						<c:out value="${ schedulerDetail.triggerName } / ${ schedulerDetail.groupTriggerName }" />
					</display:column>
					<display:column titleKey="general.jobClassName" sortable="false">
						<b><c:out value="${ schedulerDetail.jobClassName }" /></b>
					</display:column>
					<display:column titleKey="general.cronExpression" sortable="false">
						<b><c:out value="${ schedulerDetail.cronExpression }" /></b>
					</display:column>
					<display:column titleKey="general.lastUpdatedDate" sortable="true">
						<c:if test="${ schedulerDetail.modifiedDate != null }">
							<fmt:formatDate value="${ schedulerDetail.modifiedDate }" pattern="dd/MM/yyyy hh:mm a" />
						</c:if>
					</display:column>
					<display:column titleKey="general.action" sortable="false">
						<button type="submit" class="btn btn-sm btn-warning " onclick="return firenow('${schedulerDetail.id}')"><fmt:message key="general.firenow"/></button>
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