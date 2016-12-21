<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.twitter.stream.listing" />
		</div>
		<div class="ibox-content">
		<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right"> 
					<input type="text"  placeholder="Twitter Stream Code" id="streamCode" name="streamCode" class="input-sm form-control inline" value="${streamCode}" />
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
				</div>
				<div class="row tableAction">
					<div class="col-lg-12">
						<button type="button" class="btn btn-success btn-sm" onclick="newRecord()"><fmt:message key="general.new"/></button>
						<button type="submit" class="btn btn-warning btn-sm" onclick="return restartRecords()"><fmt:message key="general.restart"/></button>
						<button type="submit" class="btn btn-danger btn-sm" onclick="return deleteRecords()"><fmt:message key="general.delete"/></button>
					</div>
				</div>
				<br/>
				<display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped"
					requestURI="?" sort="external" partialList="true">
					<display:column media="html" title="<input type='checkbox' id='selectall'/><span class='custom-checkbox'></span>" class="selectAll">
						<input name="id" type="checkbox" value="${twitterStream.id}" />
						<span class="custom-checkbox"></span>
					</display:column>
					<display:column titleKey="general.code" sortable="true">
						<c:out value="${ twitterStream.code }" />
					</display:column>
					<display:column titleKey="general.status" sortable="false">
						<fmt:message key='twitter.stream.status.${ twitterStream.status }' />
					</display:column>
					<display:column titleKey="general.lastUpdatedDate" sortable="true">
						<c:if test="${ twitterStream.modifiedDate != null }">
							<fmt:formatDate value="${ twitterStream.modifiedDate }" pattern="dd/MM/yyyy hh:mm a" />
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
	document.location.href = "${pageContext.request.contextPath}/web/twitter/stream/new";
}

function deleteRecords() {
    if ($("[name=id]:checked").length > 0) {
        if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
            $("#filterForm").attr("method", "POST");
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/twitter/stream/delete");
            return true;
        }
    }
    return false;
}

function restartRecords() {
    if ($("[name=id]:checked").length > 0) {
        if (confirm('<fmt:message key="general.restart.confirmation"/>')) {
            $("#filterForm").attr("method", "POST");
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/twitter/stream/restart");
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