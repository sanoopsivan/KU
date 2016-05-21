$(function() {
	$('#datetimepicker_1').datetimepicker();
});
$(function() {
	$('#datetimepicker_2').datetimepicker();
});

$(document.body).on('click', '.page', function(e) {
	e.preventDefault();
	ajaxCall();
});

$('document').ready(function() {
	ajaxGetAreas();
	ajaxCall()

});

$("#searchCustomerForm").submit(function(event) {

	event.preventDefault();
	ajaxCall();

});

function ajaxCall() {
	var searchHelper = new Array();
	$
			.ajax({
				method : 'post',
				url : "ajax/getUsers",
				async : true,
				data : {
					q : $('#searchCustomerByQuery').val(),
					searchCustomerByStatus : $('#searchCustomerByStatus').val(),
					datetimepicker_1 : $('#datetimepicker_1').val(),
					datetimepicker_2 : $('#datetimepicker_2').val(),
				},
				dataType : 'json',
				beforeSend : function(result) {
					$('#loadingImageHolder').show();
					$('#customerTable').hide();
				},
				error : function() {
					$('#loadingImageHolder').hide();
					$('#customerTable').show();
					$('#noCustomerAvailable').show();
					$('#customerNotAvailable').hide();
					$('.searchResultRow').remove()
				},
				success : function(result) {

					$('#loadingImageHolder').hide();
					$('#customerTable').show();
					$('#noCustomerAvailable').hide();
					$('#customerNotAvailable').hide();
					$('.searchResultRow').remove()
					$
							.each(
									result,
									function(i, item) {
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
																.text(
																		item.firstName),
														$(
																'<td class = "searchResultColumn">')
																.text(
																		item.lastName),
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
																		'<a href = "'
																				+ item.gender
																				+ '" class = "btn btn-success">View</a>'))
												.appendTo('#customerTable');
									});

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
						datumTokenizer : Bloodhound.tokenizers.obj
								.whitespace('key'),
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
										name : 'searchHelp',
										display : 'searchHelp',
										displayKey : 'searchHelp',
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
