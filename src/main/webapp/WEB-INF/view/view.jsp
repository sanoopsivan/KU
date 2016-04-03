
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">

	<div id="page-wrapper">

		<div class="container-fluid">

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						View Users
						<small>View all users in the system</small>
					</h1>
				</div>
			</div>
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-striped">
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
					<tbody>

						<!-- BEGIN: Loop this to show all user details on load; March 12, 2016 - Ananthakirshnan -->
						<tr>
							<td>KU3326</td>
							<td>Ananthakrishnan Prakash</td>
							<td>9874563210</td>
							<td>10/03/2016</td>
							<td>Active</td>
							<td>
								<button type="button" class="btn btn-success dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">View</button>
							</td>
						</tr>
						<!-- END: Loop this to show all user details on load; March 12, 2016 - Ananthakirshnan -->

						<!-- BEGIN: Example table entry, delete after use; March 12, 2016 - Ananthakirshnan -->
						<tr>
							<td>KU3325</td>
							<td>Bipin R Chandran</td>
							<td>9856321401</td>
							<td>10/03/2016</td>
							<td>Deactive</td>
							<td>
								<button type="button" class="btn btn-success dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">View</button>
							</td>
						</tr>
						<tr>
							<td>KU3324</td>
							<td>Sanoop Sivan</td>
							<td>9875362140</td>
							<td>10/03/2016</td>
							<td>Pending</td>
							<td>
								<button type="button" class="btn btn-success dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">View</button>
							</td>
						</tr>
						<!-- END: Example table entry, delete after use; March 12, 2016 - Ananthakirshnan -->

					</tbody>
				</table>
			</div>

		</div>

	</div>

</div>

<script src="<c:url value="/resources/js/includeHTML.js" />"></script>
<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->