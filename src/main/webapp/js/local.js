function initSelectAll() {
	$('#selectall').click(function() {
		var $checkbox = $(this).find(':checkbox');
		$checkbox.attr('checked', !$checkbox.attr('checked'));

		if ($('#selectall').is(":checked")) {
			$("#filterForm :checkbox").prop('checked', true);
		} else {
			$("#filterForm :checkbox").prop('checked', false);
		}

	});
}

