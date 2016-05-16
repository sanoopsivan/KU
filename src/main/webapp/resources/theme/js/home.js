$(function() {
	$('#datetimepicker_1').datetimepicker();
});
$(function() {
	$('#datetimepicker_2').datetimepicker();
});

$('document').ready(ajaxCall);

$("#searchCustomerForm").submit(function(event) {

	event.preventDefault();
	ajaxCall();

});

function ajaxCall() {
	var customers = '';
	$
			.ajax({
				method : 'post',
				url : "getUsers",
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
				},
				success : function(result) {
					customers = result;
					$('#loadingImageHolder').hide();
					$('#customerTable').show();
					$('#noCustomerAvailable').hide();
					$('#customerNotAvailable').hide();
					$
							.each(
									result,
									function(i, item) {
										var $tr = $('<tr>')
												.append(
														$(
																'<td class = "searchable">')
																.text(
																		item.customerID),
														$(
																'<td class = "searchable">')
																.text(item.name),
														$(
																'<td class = "searchable">')
																.text(
																		item.mobile),
														$(
																'<td class = "searchable">')
																.text(
																		item.dateAdded),
														$('<td>').text(
																item.status),
														$('<td>')
																.html(
																		'<a href = "'
																				+ item.viewProfile
																				+ '" class = "btn btn-success">View</a>'))
												.appendTo('#customerTable');
									});
					customers = new Bloodhound({
						datumTokenizer : Bloodhound.tokenizers.obj.whitespace(
								'name', 'customerID'),
						queryTokenizer : Bloodhound.tokenizers.whitespace,
						local : customers
					});

					$('#searchCustomer')
							.typeahead(
									{
										hint : true,
										highlight : true,
										minLength : 1
									},
									{
										name : 'customerID',
										display : 'name',
										displayKey : 'name',
										source : customers,
										templates : {
											notFound : [
													'<div class = "empty-message" style = "padding: 5px;">',
													'Customer not found',
													'</div>' ].join('\n')
										}
									});
				}
			});
}
