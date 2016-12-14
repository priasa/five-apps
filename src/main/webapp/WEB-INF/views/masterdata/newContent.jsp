<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />
<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.masterdata.addeditcontent" /> 
		</div>
		<div class="ibox-content">
			<commons:notification-message/>
			<form:form class="form-horizontal" commandName="masterDataContentDTO" method="POST"
                           action="${pageContext.request.contextPath}/web/masterdata/content/save/submit/${parentId}">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label" for="code">
                            <fmt:message key="md.key"/>
                            <span class="mandatory"><fmt:message key="general.mandatory"/></span>
                        </label>
                        <div class="col-sm-5">
                            <form:input type="text" path="code" value="${masterDataContentDTO.code}" class="form-control"/>
                            <form:errors path="code" class="help-block text-danger"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label" for="fieldValue">
                            <fmt:message key="md.value"/>
                            <span class="mandatory"><fmt:message key="general.mandatory"/></span>
                        </label>
                        <div class="col-sm-5">
                            <form:input type="text" path="fieldValue" value="${masterDataContentDTO.fieldValue}" class="form-control"/>
                            <form:errors path="fieldValue" class="help-block text-danger"/>
                        </div>
                    </div>
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
function cancel() {
    document.location.href = "${pageContext.request.contextPath}/web/masterdata/edit/${parentId}";
}

</script>
<commons:footer />