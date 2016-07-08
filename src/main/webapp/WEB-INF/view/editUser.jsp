
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid col-xs-11 col-sm-11 col-md-11 col-lg-11">

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h1 class="page-header">Update User</h1>
				</div>
			</div>

			<!-- BEGIN: User add form; March 13, 2016 - Ananthakrishnan -->
			<form role="form" id="userUpdateForm" name="userUpdateForm"
				method="post" action="/">

				<div class="row">

					<!-- BEGIN: Form fields LHS; March 13, 2016 - Ananthakrishnan -->
					<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
						<div class="row">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">First
								name:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" required class="form-control alphabets"
									id="firstName" name="firstName" value="${user.firstName}"
									<c:if test="${admin.status!='superadmin'}"> readonly="readonly"</c:if>>
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Last name:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" class="form-control alphabets" id="lastName"
									name="lastName" value="${user.lastName}">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Gender:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<c:set var="maleChecked" value="" />
								<c:set var="femaleChecked" value="" />
								<c:if test="${user.gender=='male'}">
									<c:set var="maleChecked" value="checked" />
								</c:if>
								<c:if test="${user.gender=='female'}">
									<c:set var="femaleChecked" value="checked" />
								</c:if>
								<label class="radio-inline">
									<input type="radio" name="gender" value="male" ${maleChecked} />Male
								</label>
								<label class="radio-inline">
									<input type="radio" name="gender" value="female"
										${femaleChecked} />Female
								</label>
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Address:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<textarea rows="4" cols="50" id="address" name="address">${user.address}</textarea>
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Area:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<select name="areaCode" id="areaCode numeric">
									<c:forEach var="area" items="${areaList}">
										<c:choose>
											<c:when test="${area.areaName == user.areaCode}">
												<option value="${area.areaName}" selected="selected">${area.areaName}</option>
											</c:when>
											<c:otherwise>
												<option value="${area.areaName}">${area.areaName}</option>
											</c:otherwise>
										</c:choose>

									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<!-- END: Form fields LHS; March 13, 2016 - Ananthakrishnan -->

					<!-- BEGIN: Form fields RHS; March 13, 2016 - Ananthakrishnan -->
					<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
						<div class="row">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">User
								Status:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" class="form-control numeric" readonly
									id="userStatus" name="userStatus" value="${user.status}">
							</div>
						</div>
						<div class="row">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Pin code:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" class="form-control numeric" id="pincode"
									name="pincode" value="${user.pincode}">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Mobile
								number:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8 input-group"
								style="padding-left: 15px; padding-right: 15px;">
								<div class="input-group-addon">+91</div>
								<input type="text" required class="form-control numeric"
									id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}"
									<c:if test="${admin.status!='superadmin'}"> readonly="readonly"</c:if>>
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Land
								number:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8 input-group"
								style="padding-left: 15px; padding-right: 15px;">
								<div class="input-group-addon">0471</div>
								<input type="text" class="form-control numeric"
									id="landLineNumber" name="landLineNumber"
									value="${user.landLineNumber}">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Email:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" class="form-control alphanumeric"
									id="emailId" name="emailId" value="${user.email}">
							</div>
						</div>
						<div class="row customMarginTop">&nbsp;</div>
					</div>
					<!-- END: Form fields RHS; March 13, 2016 - Ananthakrishnan -->

				</div>
				<div class="row customMarginTop pull-right">
					<c:if
						test="${admin.status=='superadmin' && user.status == 'ACTIVATED'}">
						<a class="btn btn-danger" id="deactivateUser">Deactivate</a>
					</c:if>
					<c:if test="${user.status != 'ACTIVATED'}">
						<a class="btn btn-success" id="activateUser">Activate</a>
					</c:if>
					<c:if test="${admin.status=='superadmin'}">
						<a class="btn btn-success" id="deleteUser">Delete</a>
					</c:if>
					<a class="btn btn-success" id="submitUser">Update</a>
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