<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.tenant.addedit" />
		</div>
		<div class="ibox-content">
			<commons:notification-message />
			<form:form class="form-horizontal" commandName="tenantEntity"
				method="POST" role="form"
				action="${pageContext.request.contextPath}/web/tenant/save/submit">

				<form:hidden path="id" />

				<div
					class="form-group <form:errors path="provinsi" >has-error</form:errors>">
					<label class="col-sm-2 control-label" for="provinsi"> <fmt:message
							key="general.provinsi" />
					</label>
					<div class="col-sm-5">
						<form:select id="provinsi" path="provinsi" class="form-control">
							<form:option value="">Select Provinsi</form:option>
							<c:forEach var="prov" items="${ provinsiList }">
								<form:option value="${ prov.kode }">
									<c:out value="${ prov.nama }" />
								</form:option>
							</c:forEach>
						</form:select>
						<form:errors path="provinsi" cssClass="help-block text-danger" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="kabupaten" >has-error</form:errors>">
					<label class="col-sm-2 control-label" for="kabupaten"> <fmt:message
							key="general.kabupaten" />
					</label>
					<div class="col-sm-5">
						<form:select id="kabupaten" path="kabupaten" class="form-control">
							<form:option value="">Select Kabupatan/Kota</form:option>
							<c:forEach var="kab" items="${ kabupatenList }">
								<form:option value="${ kab.kode }">
									<c:out value="${ kab.nama }" />
								</form:option>
							</c:forEach>
						</form:select>
						<form:errors path="kabupaten" cssClass="help-block text-danger" />
					</div>
				</div>

				<div
					class="form-group <form:errors path="tenantCode">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for=tenantCode>
						<fmt:message key="general.puskesmas" /> 
					</label>
					<div class="col-sm-5">
						<form:select id="tenantCode" path="tenantCode" class="form-control">
							<form:option value="">Select Puskesmas</form:option>
							<c:forEach var="pkm" items="${ puskesmasList }">
								<form:option value="${ pkm.kode }">
									<c:out value="${ pkm.nama }" />
								</form:option>
							</c:forEach>
						</form:select>
						<form:errors path="tenantCode" cssClass="help-block text-danger" />
					</div>
				</div>

				<div class="row tableAction">
					<div class="col-sm-offset-2 col-sm-5">
						<button type="submit" class="btn btn-primary btn-sm">
							<fmt:message key="general.submit" />
						</button>
						<button type="button" class="btn btn-warning btn-sm"
							onclick="cancel()">
							<fmt:message key="general.cancel" />
						</button>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>
<c:url var="findKabupatenByProvinsi" value="/web/kabupaten/listByProvinsi" />
<c:url var="findPkmByFilter" value="/web/puskesmas/listByFilter" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery-ui.min.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-ui-1.11.0.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$('.datepicker').datetimepicker({
		pickTime : false,
		dateFormat : 'dd/mm/yy',
		maxDate : new Date()
	});
	
	$('#provinsi').change(
			function() {
				$.getJSON('${findKabupatenByProvinsi}', {
					provinsi : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">Select Kabupaten/Kota</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].kode + '">'+ data[i].nama+ '</option>';
					}
					html += '</option>';
	 
					$('#kabupaten').html(html);
				});
			});
	
	$('#kabupaten').change(
			function() {
				$.getJSON('${findPkmByFilter}', {
					provinsi : $('#provinsi').val(),
					kabupaten : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">Select Puskesmas</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].kode + '">'+ data[i].nama+ '</option>';
					}
					html += '</option>';
	 
					$('#tenantCode').html(html);
				});
			});
});

function cancel(){
	document.location.href = "${pageContext.request.contextPath}/web/tenant/list";
}

</script>

<commons:footer />