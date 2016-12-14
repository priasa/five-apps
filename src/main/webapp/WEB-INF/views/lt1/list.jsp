<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.lt1.listing" />
		</div>
		<div class="ibox-content">
		<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right"> 
					<input type="text"  placeholder="Kode Puskesmas" id="kodePuskesmas" name="kodePuskesmas" class="input-sm form-control inline" value="${kodePuskesmas}" />
					<input type="number" placeholder="Tahun" id="tahun" name="tahun" class="input-sm form-control inline" value="${tahun}"/>
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
				</div>
				<div class="row tableAction">
					<div class="col-lg-12">
						<button type="submit" class="btn btn-danger btn-sm" onclick="return deleteRecords()"><fmt:message key="general.delete"/></button>
					</div>
				</div>
				<br/>
				<display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped"
					requestURI="?" sort="external" partialList="true">
					<display:column media="html" title="<input type='checkbox' id='selectall'/><span class='custom-checkbox'></span>" class="selectAll">
						<input name="id" type="checkbox" value="${lt1.id}" />
						<span class="custom-checkbox"></span>
					</display:column>
					<display:column titleKey="general.code" sortable="true">
						<c:url var="editUrl" value="/web/lt1/view/${ lt1.id }">
						</c:url>
						<a href="${ editUrl }"><c:out value="${ lt1.id }" /></a>
					</display:column>
					<display:column titleKey="puskemas.kode" sortable="true">
						<c:out value="${ lt1.kodePuskesmas }" />
					</display:column>
					<display:column titleKey="puskemas.name" sortable="true">
						<c:out value="${ lt1.namaPuskesmas }" />
					</display:column>
					<display:column titleKey="general.year" sortable="true">
						<c:out value="${ lt1.tahun }" />
					</display:column>					
					<display:column titleKey="general.lastUpdatedDate" sortable="true">
						<c:if test="${ lt1.submittedDate != null }">
							<fmt:formatDate value="${ lt1.submittedDate }" pattern="dd/MM/yyyy hh:mm a" />
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

function deleteRecords() {
    if ($("[name=id]:checked").length > 0) {
        if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
            $("#filterForm").attr("method", "POST");
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/lt1/delete");
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