<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.group.listing" /> 
		</div>
		<div class="ibox-content">
			<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right">
					<input type="text" placeholder="Group Name" id="name" name="name" class="input-sm form-control inline" value="${name}" />	 
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
				</div>
				<div class="row tableAction">
					<div class="col-lg-12">
						<button type="submit" class="btn btn-danger btn-sm" onclick="return deleteRecords()"><fmt:message key="general.delete"/></button>
						<button type="button" class="btn btn-primary btn-sm" onclick="newRecord()"><fmt:message key="general.new"/></button>
					</div>
				</div>
				<br/>
				<display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped" requestURI="?" sort="external" partialList="true">
					<display:column media="html" title="<input type='checkbox' id='selectall'/><span class='custom-checkbox'></span>" class="selectAll">
						<input name="id" type="checkbox" value="${group.id}" />
						<span class='custom-checkbox'></span>
					</display:column>
					<display:column titleKey="general.name" sortable="true">
						<c:url var="editUrl" value="/web/group/edit/${ group.id }">
						</c:url>
						<a href="${ editUrl }"><c:out value="${ group.name }" /></a>
					</display:column>
					<display:column titleKey="general.lastUpdatedDate" sortable="true">
						<c:if test="${ group.modifiedDate != null }">
							<fmt:formatDate value="${ group.modifiedDate }" pattern="dd MMM yyyy hh:mm a" />
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
	document.location.href = "${pageContext.request.contextPath}/web/group/new";
}

function deleteRecords() {
    if ($("[name=id]:checked").length > 0) {
        if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
            $("#filterForm").attr("method", "POST");
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/group/delete");
            return true;
        }
    }
    return false;
}
</script>

<commons:footer />