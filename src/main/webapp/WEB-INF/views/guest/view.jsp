<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.guest.view" /> 
		</div>
		<form:form class="form-horizontal" commandName="guestEntity" method="POST" role="form" action="${pageContext.request.contextPath}/web/guest/save/submit">
			<div class="ibox-content">
				<commons:notification-message/>
				<form:hidden path="id"/>
				
				<div class="form-group <form:errors path="nik">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="nik">
						<fmt:message key="guest.nik"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<form:input path="nik" id="nik" class="form-control" readonly="true"/>
						<form:errors path="nik" cssClass="help-block text-danger"/>
					</div>
				</div>
				<div class="form-group <form:errors path="nama">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="nama">
						<fmt:message key="guest.nama"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<form:input path="nama" class="form-control" readonly="true"/>
						<form:errors path="nama" cssClass="help-block text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">
						<fmt:message key="guest.kartuKeluarga"/>
					</label>
					<div class="col-sm-5">
						<form:input path="noKartuKeluarga" class="form-control" readonly="true"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">
						<fmt:message key="guest.pekerjaan"/>
					</label>
					<div class="col-sm-5">
						<form:input path="pekerjaan" class="form-control" readonly="true"/>
					</div>
				</div>
				<div class="form-group <form:errors path="jenisKelamin">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="jenisKelamin">
						<fmt:message key="guest.jenisKelamin"/>
					</label>
					<div class="col-sm-5">
						<form:input path="jenisKelamin" class="form-control" readonly="true"/>
						<form:errors path="jenisKelamin" cssClass="help-block text-danger"/>
					</div>
				</div>				
				<div class="form-group <form:errors path="alamat">has-error</form:errors>">
					<label class="col-sm-2 col-sm-2 control-label" for="alamat">
						<fmt:message key="guest.alamat"/>
						<span class="mandatory"><fmt:message key="general.mandatory"/></span>
					</label>
					<div class="col-sm-5">
						<form:textarea path="alamat" rows="5" class="form-control" readonly="true"/>
						<form:errors path="alamat" cssClass="help-block text-danger"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">
						<fmt:message key="guest.rtrw"/>
					</label>
					<div class="col-sm-2">
						<form:input path="rt" class="form-control" readonly="true"/>
					</div>
					<div class="col-sm-2">
						<form:input path="rw" class="form-control" readonly="true"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">
						<fmt:message key="guest.kelurahan"/>
					</label>
					<div class="col-sm-5">
						<form:input path="kelurahan" class="form-control" readonly="true"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">
						<fmt:message key="guest.kecamatan"/>
					</label>
					<div class="col-sm-5">
						<form:input path="kecamatan" class="form-control" readonly="true"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">
						<fmt:message key="guest.provinsi"/>
					</label>
					<div class="col-sm-5">
						<form:input path="provinsi" class="form-control" readonly="true"/>
					</div>
				</div>
				<div class="ibox-title">
					<fmt:message key="header.guest.detail" /> 
				</div>
				<div class="ibox-content">
					<div class="form-group <form:errors path="tujuan">has-error</form:errors>">
						<label class="col-sm-2 col-sm-2 control-label" for="tujuan">
							<fmt:message key="guest.tujuan"/>
							<span class="mandatory"><fmt:message key="general.mandatory"/></span>
						</label>
						<div class="col-sm-5">
							<form:textarea path="tujuan" rows="5" class="form-control" readonly="true"/>
							<form:errors path="tujuan" cssClass="help-block text-danger"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">
							<fmt:message key="guest.pic"/>
						</label>
						<div class="col-sm-5">
							<form:input path="pic" class="form-control" readonly="true"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">
							<fmt:message key="guest.instansi"/>
						</label>
						<div class="col-sm-5">
							<form:input path="instansi" class="form-control" readonly="true"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">
							<fmt:message key="guest.handphone"/>
						</label>
						<div class="col-sm-5">
							<form:input path="handphone" class="form-control" readonly="true"/>
						</div>
					</div>
					<div class="row tableAction">
						<div class="col-sm-offset-2 col-sm-5">
							<button type="button" class="btn btn-warning btn-sm" onclick="back()"><fmt:message key="general.back"/></button>
						</div>
					</div>	
				</div>		
			</div>
		</form:form>
	</div>
</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery-ui.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.11.0.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$('.datepicker').datetimepicker({
		pickTime : false,
		dateFormat : 'dd/mm/yy',
		maxDate : new Date()
	});
	
});

function back(){
	document.location.href = "${pageContext.request.contextPath}/web/guest/list";
}

function loadGuestData () {
	if ($('#nik').val() != '') {
		document.location.href = "${pageContext.request.contextPath}/web/guest/load/"+$('#nik').val();
	} else {
		alert("NIK tidak boleh kosong.");
		return false;
	}
	
}

</script>

<commons:footer />