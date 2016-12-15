<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="panel">
		<div class="panel-heading">
			<fmt:message key="general.unauthorized" /> 
		</div>
		<div class="panel-body text-center text-danger">
			<h1><strong><fmt:message key="general.unauthorized"/></strong></h1>
		</div>
	</div>	
</div>

<commons:footer />