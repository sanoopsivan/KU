
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid col-xs-11 col-sm-11 col-md-11 col-lg-11">

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h1 class="page-header">Add User</h1>
				</div>
			</div>

			<!-- BEGIN: User add form; March 13, 2016 - Ananthakrishnan -->
			<form role="form" action="addUser" id="userAddForm"
				name="userAddForm" method="post">

				<div class="row">

					<!-- BEGIN: Form fields LHS; March 13, 2016 - Ananthakrishnan -->
					<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
						<div class="row">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">First
								name:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" required class="form-control alphabets"
									id="firstName" name="firstName">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Last name:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" class="form-control alphabets" id="lastName"
									name="lastName">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Gender:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<label class="radio-inline">
									<input type="radio" name="gender" value="male">Male
								</label>
								<label class="radio-inline">
									<input type="radio" name="gender" value="female">Female
								</label>
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Address:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<textarea rows="4" cols="50" id="address" name="address"
									style="resize: none;"></textarea>
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Area:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<select name="areaCode" id="areaCode numeric">
									<c:forEach var="area" items="${areaList}">
										<option value="${area.areaName}">${area.areaName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<!-- END: Form fields LHS; March 13, 2016 - Ananthakrishnan -->

					<!-- BEGIN: Form fields RHS; March 13, 2016 - Ananthakrishnan -->
					<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
						<div class="row">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Pin code:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" class="form-control numeric" id="pincode"
									name="pincode">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Mobile
								number:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8 input-group"
								style="padding-left: 15px; padding-right: 15px;">
								<div class="input-group-addon">+91</div>
								<input type="text" required class="form-control numeric"
									id="phoneNumber" name="phoneNumber">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Land
								number:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8 input-group"
								style="padding-left: 15px; padding-right: 15px;">
								<div class="input-group-addon">0471</div>
								<input type="text" class="form-control numeric"
									id="landLineNumber" name="landLineNumber">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Email:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" class="form-control alphanumeric"
									id="emailId" name="emailId">
							</div>
						</div>
						<div class="row customMarginTop">&nbsp;</div>
					</div>
					<!-- END: Form fields RHS; March 13, 2016 - Ananthakrishnan -->

				</div>
				<div class="row customMarginTop pull-right">
					<a class="btn btn-danger" id="clearUser">Clear Fields</a>
					<a class="btn btn-success" id="submitUser">Add User</a>
					<input type="submit" style="display: none;" id="submitHandle"
						name="submitHandle">
				</div>

			</form>
			<!-- END: User add form; March 13, 2016 - Ananthakrishnan -->

		</div>
	</div>
</div>


<script src="<c:url value="/resources/js/includeHTML.js" />"></script>
<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->