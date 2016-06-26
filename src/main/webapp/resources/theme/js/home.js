$(function() {
	$('#datetimepicker_1').datetimepicker({
		format : 'YYYY-MM-DD'
	});
});
$(function() {
	$('#datetimepicker_2').datetimepicker({
		format : 'YYYY-MM-DD'
	});
});

$(document.body).on('click', '.page', function(e) {
	e.preventDefault();
	ajaxCall(this.id);
});

$(document).ready(function() {
	$('#paginationHelper').on('change', function(e) {
		e.preventDefault();
		ajaxCall(1);
	});
});

$('document').ready(function() {
	ajaxGetAreas();
	ajaxGetSearchHelp();
	ajaxCall(1);

});

$("#searchCustomerForm").submit(function(event) {

	event.preventDefault();
	ajaxCall(1);

});

function ajaxCall(k) {
	var id = k;
	var searchHelper = new Array();
	$
			.ajax({
				method : 'post',
				url : "ajax/getUsers",
				async : true,
				data : {
					q : $('#searchCustomerByQuery').val(),
					status : $('#searchCustomerByStatus').val(),
					startDate : $('#datetimepicker_1').val(),
					endDate : $('#datetimepicker_2').val(),
					area : $('#searchByArea').val(),
					page : id,
					paginationHelper : $('#paginationHelper').val(),
				},
				beforeSend : function(result) {
					$('#loadingImageHolder').show();
					$('#customerTable').hide();
					$('.searchResultRow').remove();
					$('.pagination').remove()
				},
				error : function() {
					$('#loadingImageHolder').hide();
					$('#customerTable').show();
					/* $('#noCustomerAvailable').show(); */
					AddUser();
					$('#customerNotAvailable').hide();
					$('.searchResultRow').remove()
				},
				success : function(result) {
					var flag = true;
					$('#loadingImageHolder').hide();
					$('#customerTable').show();
					$('#noCustomerAvailable').hide();
					$('#customerNotAvailable').hide();
					$('.searchResultRow').remove();
					$('.pagination').remove();
					if (result.totalPages == 0) {
						showNoResult();
						$('#paginationHelper').hide();

					}

					$
							.each(
									result.userList,
									function(i, item) {
										flag = false;
										var name = item.firstName + ' '
												+ item.lastName;
										searchHelper.push(name);
										searchHelper.push(item.phoneNumber);
										var $tr = $(
												'<tr class="searchResultRow">')
												.append(
														$(
																'<td class = "searchResultColumn">')
																.text(item.kuid),
														$(
																'<td class = "searchResultColumn">')
																.text(item.name),
														$(
																'<td class = "searchResultColumn">')
																.text(
																		item.phoneNumber),
														$(
																'<td class = "searchResultColumn">')
																.text(
																		item.status),
														$(
																'<td class = "searchResultColumn">')
																.text(
																		item.creationDate),
														$(
																'<td class = "searchResultColumn">')
																.html(
																		'<a href = "view/'
																				+ item.userId
																				+ "/editUser"
																				+ '" class = "btn btn-success">View</a>'))
												.appendTo('#customerTable');
									});
					$("#pagination").append("<ul class='pagination'></ul>");
					if ((result.totalPages) > 1)
						pagination(result.totalPages, result.currentPage);

					/*
					 * $("#pagination").append("<ul class='pagination'></ul>");
					 * $(result.totalPages).each(function() {
					 * $(".pagination").append( "<li><a href='' class='page'
					 * id='1'>1</a></li>"); });
					 */
					/*
					 * $("#pagination").append("<ul class='pagination'></ul>");
					 * $(".pagination").append( "<li><a href='' class='page'
					 * id='1'>1</a></li>");
					 */

				}
			});
}

function ajaxGetAreas() {
	var areas = "";
	$
			.ajax({
				method : 'post',
				url : "ajax/getAreas",
				async : true,
				dataType : 'json',
				error : function() {
					console.log("Error");
				},
				success : function(result) {
					areas = result;
					areas = new Bloodhound({
						datumTokenizer : Bloodhound.tokenizers.obj
								.whitespace('areaName'),
						queryTokenizer : Bloodhound.tokenizers.whitespace,
						local : areas
					});

					$('#searchByArea')
							.typeahead(
									{
										hint : true,
										highlight : true,
										minLength : 1
									},
									{
										name : 'areaName',
										display : 'areaName',
										displayKey : 'areaName',
										source : areas,
										templates : {
											notFound : [
													'<div class = "empty-message" style = "padding: 5px;">',
													'Area not found', '</div>' ]
													.join('\n')
										}
									});

				}
			});

}

function ajaxGetSearchHelp() {
	var searchHelp = "";
	$
			.ajax({
				method : 'post',
				url : "ajax/getSearchHelp",
				async : true,
				dataType : 'json',
				error : function() {
					console.log("Error");
				},
				success : function(result) {
					searchHelp = result;
					searchHelp = new Bloodhound({
						datumTokenizer : Bloodhound.tokenizers.whitespace,
						queryTokenizer : Bloodhound.tokenizers.whitespace,
						local : searchHelp
					});

					$('#searchCustomerByQuery')
							.typeahead(
									{
										hint : true,
										highlight : true,
										minLength : 1
									},
									{
										name : 'searchHelp',
										source : searchHelp,
										templates : {
											notFound : [
													'<div class = "empty-message" style = "padding: 5px;">',
													'Nothing found..  ',
													'</div>' ].join('\n')
										}
									});

				}
			});

}

function pagination(j, k) {
	/* current page greater than 7 */
	if (k == 1) {
		$(".pagination").append(
				"<li class='page-item disabled'><a href='' class='previous inactiveLink' id='"
						+ k + "'>&laquo;</a></li></li>");
	} else {
		$(".pagination").append(
				"<li class='page-item'><a href='' class='previous' id='" + k
						+ "'>&laquo;</a></li></li>");
	}
	createPagination(j, k);
	/* total pages greater than 7 */
	if (j == k) {
		$(".pagination").append(
				"<li class='page-item disabled'><a href='' class='next inactiveLink' id='"
						+ k + "'>&raquo;</a></li></li>");
	} else {
		$(".pagination").append(
				"<li class='page-item'><a href='' class='next' id='" + k
						+ "'>&raquo;</a></li></li>");
	}
}

function createPagination(j, k) {
	var p = 7;
	if (j < 7)
		p = j;
	var i = 1;
	if (k > 7) {
		i = (k - 6);
		p = k;
	}
	for (i; i <= p; i++) {
		if (i == k) {
			$(".pagination").append(
					"<li class='page-item active'><a href='' class='page' id="
							+ i + ">" + i + "</a></li>");
		} else {

			$(".pagination").append(
					"<li class='page-item'><a href='' class='page' id=" + i
							+ ">" + i + "</a></li>");
		}
	}
}
function showNoResult() {
	$("#customerTable")
			.append(
					"<tr id='noCustomerAvailable'><td colspan='6' class='text-center'>No users available.\
	with the selected search features.</td>\
</tr>");
}
function AddUser() {
	$("#customerTable")
			.append(
					"<tr id='noCustomerAvailable'><td colspan='5' class='text-center'>No users available.\
Please Add new Users.</td>\
</tr>");

}

$(document.body).on('click', '.previous', function(e) {
	e.preventDefault();
	var id = parseFloat(this.id) - 1;
	console.log("previous :" + id);
	ajaxCall(id);
});

$(document.body).on('click', '.next', function(e) {
	e.preventDefault();
	var id = parseFloat(this.id) + 1;
	console.log("next :" + id)
	ajaxCall(id);
});

$(document.body).on('click', '#update', function(e) {
	e.preventDefault();
	document.userUpdateForm.action = 'updateUser';
	document.userUpdateForm.submit();
});

$(document.body).on('click', '#activate', function(e) {
	e.preventDefault();
	document.userUpdateForm.action = 'activateUser';
	document.userUpdateForm.submit();
});
$(document.body).on('click', '#deacivate', function(e) {
	e.preventDefault();
	document.userUpdateForm.action = 'deactivateUser';
	document.userUpdateForm.submit();
});
