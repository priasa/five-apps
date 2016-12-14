<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.masterdata.addedit" /> 
		</div>
		<div class="ibox-content">
			<commons:notification-message/>
			<form:form id="filterForm" class="form-horizontal" commandName="masterData" method="POST" action="${pageContext.request.contextPath}/web/masterdata/save/submit">
				<form:hidden path="id"/>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label" for="name">
						<fmt:message key="general.name"/>
                        <span class="mandatory"><fmt:message key="general.mandatory"/></span>
                    </label>
                    <div class="col-sm-5">
                    	<form:input type="text" path="name" value="${masterData.name}" class="form-control" />
                    	<form:errors path="name" class="help-block text-danger"/>
                    </div>
                </div>
                <div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label" for="numberOnly">
						<fmt:message key="general.numberOnly"/>
                    </label>
                    <div class="col-sm-5">
                    	<form:checkbox path="numberOnly"/>
                    	<form:errors path="numberOnly" class="help-block text-danger"/>
                    </div>
                </div>
                 <c:set var="masterDataId" value="${empty masterData.id}"/>
                    <c:if test="${!masterDataId}">
                        <div class="well">
                            <div class="row tableAction">
                                <div class="col-lg-12">
                                	<sec:authorize access="hasAnyRole('ROLE_MASTER_DATA_DELETE')">
                                    	<button type="submit" class="btn btn-sm btn-danger" onclick="return deleteRecords()"><fmt:message key="general.delete"/></button>
                                    </sec:authorize>
                                    <sec:authorize access="hasAnyRole('ROLE_MASTER_DATA_ADD_EDIT')">
                                    	<button type="button" class="btn btn-sm btn-primary" onclick="newRecord()"><fmt:message key="general.new"/></button>
                                	</sec:authorize>
                                </div>
                            </div>
                            <br/>
                            <display:table id="${id}" name="${rows}" size="${size}" pagesize="20"
                                           export="false" class="table table-striped"
                                           requestURI="?" sort="external" partialList="true">
                                <display:column media="html" title="<input type='checkbox' id='selectall'/><span class='custom-checkbox'></span>" class="selectAll">
                                    <input name="contentId" type="checkbox" value="${content.code}" class="chk-row" />
                                    <span class="custom-checkbox"></span>
                                </display:column>
                                <display:column titleKey="md.key" sortable="true">
                                    <c:url var="editUrl" value="/web/masterdata/content/edit/${content.parentId.id}/${content.code }">
                                    </c:url>
                                    <a href="${ editUrl }"><c:out value="${content.code }" /></a>
                                </display:column>
                                <display:column titleKey="md.value" property="fieldValue" sortable="true"/>    
                                <display:column titleKey="general.lastUpdatedDate" sortable="true">
                                    <c:if test="${ content.modifiedDate != null }">
                                        <fmt:formatDate value="${ content.modifiedDate }" pattern="dd/MM/yyyy hh:mm a" />
                                    </c:if>
                                </display:column>
                            </display:table>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                        	<sec:authorize access="hasAnyRole('ROLE_MASTER_DATA_ADD_EDIT')">
                            	<button type="submit" class="btn btn-sm btn-primary"><fmt:message key="general.submit"/></button>
                           	</sec:authorize>
                            <button type="button" class="btn btn-sm btn-warning" onclick="cancel()"><fmt:message key="general.back"/></button>
                        </div>
                    </div>
                </form:form>
		</div>
	</div>
</div>		
<script type="text/javascript">
$(document).ready(function() {
    selectAll();
});

function newRecord() {
    document.location.href = "${pageContext.request.contextPath}/web/masterdata/content/new/${masterData.id}";
}

function deleteRecords() {
    if ($("[name=contentId]:checked").length > 0) {
        if (confirm('<fmt:message key="general.delete.confirmation"/>')) {
            $("#filterForm").attr("method", "POST");
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/masterdata/content/delete/${masterData.id}");
            return true;
        }
    }
    return false;
}
function cancel() {
    document.location.href = "${pageContext.request.contextPath}/web/masterdata/mdList";
}

function selectAll() {
	$('#selectall').click(function()	{
		if($(this).is(':checked'))	{
			$('#${id}').find('.chk-row').each(function()	{
				$(this).prop('checked', true);
				$(this).parent().parent().parent().addClass('selected');
			});
		}
		else	{
			$('#${id}').find('.chk-row').each(function()	{
				$(this).prop('checked' , false);
				$(this).parent().parent().parent().removeClass('selected');
			});
		}	
	});
}
</script>
<commons:footer />