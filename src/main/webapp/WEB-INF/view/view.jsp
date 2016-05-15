
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid">

			<form id="searchCustomerForm">
				<div class="row">

					<div class="col-md-3 topPadding">
						<input type="text" class="form-control" id="searchCustomerByQuery"
							placeholder="Search Customer" />
					</div>
					<div class="col-md-3 topPadding">
						<div class="form-group">
							<select class="form-control" id="sel1">
								<option selected disabled>Status</option>
								<option>Activated</option>
								<option>Deactivated</option>
								<option>Pending For Activation</option>
							</select>
						</div>
					</div>
					<div class="col-md-2 topPadding">
						<input type='text' class="form-control" id='datetimepicker'/>
					</div>
					<div class="col-md-2 topPadding">
						<input type="text" class="form-control"
							id="searchCustomerByDateTill" placeholder="Till Date" />
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
							<th>User ID</th>
							<th>Name</th>
							<th>Contact Number</th>
							<th>Created On</th>
							<th>Status</th>
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





<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->