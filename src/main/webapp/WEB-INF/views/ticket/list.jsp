<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.ticket.listing" />
		</div>
		<div class="ibox-content">
		<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right"> 
					<input type="text"  placeholder="Ticket No." id="ticketNumber" name="ticketNumber" class="input-sm form-control inline" value="${ticketNumber}" />
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
				</div>
				<div class="row tableAction">
					<div class="col-lg-12">
						<button type="button" class="btn btn-success btn-sm" onclick="newRecord()">New Request</button>
					</div>
				</div>
				<br/>
				<display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped"
					requestURI="?" sort="external" partialList="true">
					<display:column titleKey="ticket.ticketNumber" sortable="true">
						<c:out value="${ ticketEntity.ticketNumber }" />
					</display:column>
					<display:column titleKey="ticket.nik" sortable="true" >
						<c:out value="${ ticketEntity.nik }" />
					</display:column>
					<display:column titleKey="general.name" sortable="true" >
						<c:out value="${ ticketEntity.name }" />
					</display:column>
					<display:column titleKey="general.address" sortable="true">
						<c:out value="${ ticketEntity.address }" />
					</display:column>
					<display:column titleKey="general.dob" sortable="true">
						<c:out value="${ ticketEntity.dob }" />
					</display:column>
					<display:column titleKey="general.sex" sortable="true">
						<c:out value="${ ticketEntity.sex }" />
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
	document.location.href = "${pageContext.request.contextPath}/web/proposal/new";
}

function deleteRecords() {
    if ($("[name=id]:checked").length > 0) {
        if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
            $("#filterForm").attr("method", "POST");
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/proposal/new");
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