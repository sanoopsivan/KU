
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid">

			<form id="searchCustomerForm">
				<div class="row">

					<div class="col-md-4 topPadding">
						<input type="text" class="form-control" id="searchCustomerByQuery"
							placeholder="Search" name="q" />
					</div>
					<div class="col-md-4 topPadding">
						<div class="form-group">
							<select class="form-control" id="searchCustomerByStatus"
								name="searchCustomerByStatus">
								<option selected value="ALL">Status</option>
								<c:forEach var="status" items="${statusList}">
									<option value="${status.value}">${status.label}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-md-4 topPadding">
						<div class="form-group">
							<input type='text' class="form-control" id='searchByArea'
								placeholder="Area" name="searchByArea" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 topPadding">
						<input type='text' class="form-control" id='datetimepicker_1'
							placeholder="From Date" name="fromDate" />
					</div>
					<div class="col-md-4 topPadding">
						<input type='text' class="form-control" id='datetimepicker_2'
							placeholder="Till Date" name="tillDate" />
					</div>
					<div class="col-md-2 topPadding">
						<button class="btn btn-default" id="searchCustomerSubmitButton">Search</button>
					</div>
					<div class="col-md-2 topPadding">
						<button class="btn btn-default" id="searchCustomerClearButton">Clear</button>
					</div>

				</div>

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
										<th>Name</th>
										<th>Mobile</th>
										<th>Status</th>
										<th>Date</th>
										<th>Expiry Date</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody id="customerTableBody">

									<!-- April 10, 2016 - Ananthakirshnan: To be shown when no user is available -->
									<!-- <tr id="noCustomerAvailable">
										<td colspan="5" class="text-center">No users available.
											Please click to 'Add' to add new users.</td>
										<td>
											<a href=addUser.html " class="btn btn-success"> Add </a>
										</td>
									</tr> -->

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 topPadding">
						<div class="form-group">
							<select class="form-control" id="paginationHelper"
								name="paginationHelper">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="15">15</option>
								<option value="20">20</option>
							</select>
						</div>
					</div>
					<div class="col-md-8 topPadding">
						<div id="pagination"></div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>





<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->