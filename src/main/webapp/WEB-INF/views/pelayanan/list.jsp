<%@ include file="/WEB-INF/views/includes/taglibs.jsp"%>

<commons:header />

<div class="wrapper wrapper-content animated fadeIn">
	<div class="ibox float-e-margins">
		<div class="ibox-title">
			<fmt:message key="header.pelayanan.listing" />
		</div>
		<div class="ibox-content">
		<commons:notification-message/>
			<form id="filterForm" method="GET" action="?" class="form-inline">
				<div class="form-group pull-right"> 
					<input type="text"  placeholder="Kode Puskesmas" id="kodePuskesmas" name="kodePuskesmas" class="input-sm form-control inline" value="${kodePuskesmas}" />
					<input type="number" placeholder="Tahun" id="tahun" name="tahun" class="input-sm form-control inline" value="${tahun}"/>
					<select id="bulan" name="bulan" class="input-sm form-control inline">
							<option value="0">Pilih...</option>
							<option value="1">Januari</option>
							<option value="2">Februari</option>
							<option value="3">Maret</option>
							<option value="4">April</option>
							<option value="5">Mei</option>
							<option value="6">Juni</option>
							<option value="7">Juli</option>
							<option value="8">Agustus</option>
							<option value="9">September</option>
							<option value="10">Oktober</option>
							<option value="11">November</option>
							<option value="12">Desember</option>
							
						</select>
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
						<input name="id" type="checkbox" value="${pelayananEntity.id}" />
						<span class="custom-checkbox"></span>
					</display:column>
					<display:column titleKey="general.code" sortable="true">
						<c:url var="editUrl" value="/web/pelayanan/view/${ pelayananEntity.id }">
						</c:url>
						<a href="${ editUrl }"><c:out value="${ pelayananEntity.id }" /></a>
					</display:column>
					<display:column titleKey="general.name" sortable="true">
						<c:out value="${ pelayananEntity.nama }" />
					</display:column>
					<display:column titleKey="puskemas.kode" sortable="true">
						<c:out value="${ pelayananEntity.kodePuskesmas }" />
					</display:column>
					<display:column titleKey="puskemas.name" sortable="true">
						<c:out value="${ pelayananEntity.namaPuskesmas }" />
					</display:column>
					<display:column titleKey="general.year" sortable="true">
						<c:out value="${ pelayananEntity.tahun }" />
					</display:column>
					<display:column titleKey="general.month" sortable="true">
						<c:choose>
						    <c:when test="${pelayananEntity.bulan == 1}">
						       Januari
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 2}">
						       Februari
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 3}">
						       Maret
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 4}">
						       April
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 5}">
						       Mei
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 6}">
						       Juni
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 7}">
						       Juli
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 8}">
						       Agustus
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 9}">
						       September
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 10}">
						       Oktober
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 11}">
						       November
						    </c:when>
						    <c:when test="${pelayananEntity.bulan == 12}">
						       Desember
						    </c:when>
						    <c:otherwise>
						        NONE.
						    </c:otherwise>
						</c:choose>
					</display:column>
					<display:column titleKey="general.lastUpdatedDate" sortable="true">
						<c:if test="${ pelayananEntity.submittedDate != null }">
							<fmt:formatDate value="${ pelayananEntity.submittedDate }" pattern="dd/MM/yyyy hh:mm a" />
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
            $("#filterForm").attr("action", "${pageContext.request.contextPath}/web/pelayanan/delete");
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