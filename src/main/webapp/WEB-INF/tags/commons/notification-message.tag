<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<c:if test="${!empty message}">
	<div class="alert alert-success alert-dismissable">
		<button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
		<fmt:message key='${message}' />
	</div>
</c:if>
<c:if test="${!empty customMessage}">
	<div class="alert alert-success alert-dismissable">
		<button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
		<c:out value='${customMessage}' />
	</div>
</c:if>
<c:if test="${!empty param.message}">
	<div class="alert alert-success alert-dismissable">
		<button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
		<fmt:message key='${param.message}' />
	</div>
</c:if>
<c:if test="${!empty error}">
	<div class="alert alert-danger alert-dismissable">
		<button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
		<fmt:message key='${error}' />
	</div>
</c:if>
<c:if test="${!empty param.error}">
	<div class="alert alert-danger alert-dismissable">
		<button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
		<fmt:message key='${param.error}' />
	</div>
</c:if>
<c:if test="${!empty customError}">
	<div class="alert alert-danger alert-dismissable">
		<button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button>
		<c:out value='${customError}' />
	</div>
</c:if>
