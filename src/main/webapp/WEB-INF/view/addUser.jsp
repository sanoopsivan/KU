
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid">

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Add User
						<small>Add new user details</small>
					</h1>
				</div>
			</div>

			<!-- BEGIN: User add form; March 13, 2016 - Ananthakrishnan -->
			<form role="form" action="addUser" id="userAddForm"
				name="userAddForm" method="post">

				<div class="row">

					<!-- BEGIN: Form fields LHS; March 13, 2016 - Ananthakrishnan -->
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-4">First name:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="firstName"
									name="firstName">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Last name:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="lastName"
									name="lastName">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Gender:</div>
							<div class="col-md-8">
								<label class="radio-inline">
									<input type="radio" name="gender" value="male">Male
								</label>
								<label class="radio-inline">
									<input type="radio" name="gender" value="female">Female
								</label>
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Address:</div>
							<div class="col-md-8">
								<textarea rows="4" cols="50" id="address" name="address"></textarea>
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Area:</div>
							<div class="col-md-8">
								<select name="areaCode" id="areaCode">
									<c:forEach var="area" items="${areaList}">
										<option value="${area.areaName}">${area.areaName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<!-- END: Form fields LHS; March 13, 2016 - Ananthakrishnan -->

					<!-- BEGIN: Form fields RHS; March 13, 2016 - Ananthakrishnan -->
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-4">Pin code:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="pincode"
									name="pincode">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Mobile number:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="phoneNumber"
									name="phoneNumber">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Land number:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="landLineNumber"
									name="landLineNumber">
							</div>
						</div>
						<div class="row customMarginTop">&nbsp;</div>
					</div>
					<!-- END: Form fields RHS; March 13, 2016 - Ananthakrishnan -->

				</div>
				<div class="row customMarginTop pull-right">
					<input type="submit" class="btn btn-success" id="submit"
						name="submit">
				</div>

			</form>
			<!-- END: User add form; March 13, 2016 - Ananthakrishnan -->

		</div>
	</div>
</div>


<script src="<c:url value="/resources/js/includeHTML.js" />"></script>
<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->