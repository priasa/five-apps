<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.masterdata.listing" />
		</div>
		<div class="ibox-content">
			<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
                 <div class="form-group pull-right">
                 	<input type="text" id="name" name="name" class="input-sm form-control inline" placeholder="<fmt:message key="general.name" />" value="${name}" />
					<input type="submit" class="btn btn-primary btn-sm" value="<fmt:message key='general.search' />" />
                  </div>
			      <div class="row tableAction">
                </div>
                <br/>
                <display:table id="${id}" name="${rows}" size="${size}" pagesize="20" export="false" class="table table-striped" requestURI="?" sort="external" partialList="true">
                    
                    <display:column titleKey="general.name" sortable="true">
                        <c:url var="editUrl" value="/web/masterdata/edit/${md.id }">
                        </c:url>
                        <a href="${ editUrl }"><c:out value="${md.name }" /></a>
                    </display:column>
                    <display:column titleKey="general.lastUpdatedDate" sortable="true">
                        <c:if test="${ md.modifiedDate != null }">
                            <fmt:formatDate value="${ md.modifiedDate }" pattern="dd/MM/yyyy hh:mm a" />
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
	
	function newRecord() {
		document.location.href = "${pageContext.request.contextPath}/web/masterdata/new";
    }
	
	function deleteRecords() {
		if ($("[name=id]:checked").length > 0) {
			if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
				$("#filterForm").attr("method", "POST");
				$("#filterForm").attr("action", "${pageContext.request.contextPath}/web/masterdata/delete");
                return true;
               }
			}
		return false;
	}
</script>
<commons:footer />