
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid">

			<form id="searchCustomerForm">
				<div class="row">

					<div class="col-md-3 topPadding">
						<input type="text" class="form-control" id="searchCustomerByQuery"
							placeholder="Search Customer" name="q" />
					</div>
					<div class="col-md-3 topPadding">
						<div class="form-group">
							<select class="form-control" id="searchCustomerByStatus"
								name="searchCustomerByStatus">
								<option selected disabled>Status</option>
								<option>Activated</option>
								<option>Deactivated</option>
								<option>Pending For Activation</option>
							</select>
						</div>
					</div>
					<div class="col-md-2 topPadding">
						<input type='text' class="form-control" id='datetimepicker_1'
							placeholder="From Date" name="datetimepicker_1" />
					</div>
					<div class="col-md-2 topPadding">
						<input type='text' class="form-control" id='datetimepicker_2'
							placeholder="Till Date" name="datetimepicker_2" />
					</div>
					<div class="col-md-2 topPadding">
						<button class="btn btn-default" id="searchCustomerButton">Search</button>
					</div>

				</div>
			</form>
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">View Users</h1>
				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-responsive">
						<div id="loadingImageHolder" class="col-md-12 text-center">
							<img id="loadingImage"
								src="<c:url value="/resources/images/ajax-loader.gif" />"
								alt="Loading" />
						</div>

						<table id="customerTable"
							class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>KU ID</th>
		                            <th>First Name</th>
		                            <th>Last Number</th>
		                            <th>Mobile</th>
		                            <th>Status</th>
		                            <th>Date</th>
		                            <th>Action</th>
								</tr>
							</thead>
							<tbody id="customerTableBody">

								<!-- April 10, 2016 - Ananthakirshnan: To be shown when no user is available -->
								<tr id="noCustomerAvailable">
									<td colspan="5" class="text-center">No users available.
										Please click to 'Add' to add new users.</td>
									<td>
										<a href=addUser.html " class="btn btn-success"> Add </a>
									</td>
								</tr>

								<!-- April 10, 2016 - Ananthakirshnan: To be shown searched customer is not found -->
								<tr id="customerNotAvailable">
									<td colspan="5" class="text-center">No users available.
										Please click to 'Add' to add new users.</td>
									<td>
										<a href=addUser.html " class="btn btn-success"> Add </a>
									</td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>





<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->