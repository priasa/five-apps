<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.guest.listing" />
		</div>
		<div class="ibox-content">
		<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right"> 
					<input type="text"  placeholder="Request No." id="requestNumber" name="requestNumber" class="input-sm form-control inline" value="${requestNumber}" />
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
				</div>
				<div class="row tableAction">
					<div class="col-lg-12">
						<button type="button" class="btn btn-success btn-sm" onclick="newRecord()"><fmt:message key="general.escalationRequest"/></button>
					</div>
				</div>
				<br/>
				<display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped"
					requestURI="?" sort="external" partialList="true">
					<display:column media="html" title="<input type='checkbox' id='selectall'/><span class='custom-checkbox'></span>" class="selectAll">
						<input name="id" type="checkbox" value="${guestEntity.id}" />
						<span class="custom-checkbox"></span>
					</display:column>
					<display:column titleKey="guest.nik" sortable="true">
						<c:url var="editUrl" value="/web/guest/view/${ guestEntity.id }">
						</c:url>
						<a href="${ editUrl }"><c:out value="${ guestEntity.nik }" /></a>
					</display:column>
					<display:column titleKey="guest.nama" sortable="true">
						<c:out value="${ guestEntity.nama }" />
					</display:column>
					<display:column titleKey="guest.requestNumber" sortable="true">
						<c:url var="ticketUrl" value="/web/ticket/list?ticketNumber=${ guestEntity.requestNumber }">
						</c:url>
						<a href="${ ticketUrl }"><c:out value="${ guestEntity.requestNumber }" /></a>
					</display:column>
					<display:column titleKey="general.lastUpdatedDate" sortable="true">
						<c:if test="${ guestEntity.modifiedDate != null }">
							<fmt:formatDate value="${ guestEntity.modifiedDate }" pattern="dd/MM/yyyy hh:mm a" />
						</c:if>
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
	document.location.href = "${pageContext.request.contextPath}/web/ticket/list?ticketNumber=${ guestEntity.requestNumber }";
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