
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid">

			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Update User
						<small>Update user details</small>
					</h1>
				</div>
			</div>
			<h5>Status : ${user.status}</h5>
			<!-- BEGIN: User add form; March 13, 2016 - Ananthakrishnan -->
			<form role="form" id="userUpdateForm" name="userUpdateForm"
				method="post" action="/">

				<div class="row">

					<!-- BEGIN: Form fields LHS; March 13, 2016 - Ananthakrishnan -->
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-4">First name:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="firstName"
									name="firstName" value="${user.firstName}" readonly="readonly">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Last name:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="lastName"
									name="lastName" value="${user.lastName}">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Gender:</div>
							<div class="col-md-8">
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
							<div class="col-md-4">Address:</div>
							<div class="col-md-8">
								<textarea rows="4" cols="50" id="address" name="address">${user.address}</textarea>
							</div>
						</div>

						<div class="row customMarginTop">
							<div class="col-md-4">Area:</div>
							<div class="col-md-8">
								<select name="areaCode" id="areaCode">
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
					<div class="col-md-6">
						<div class="row">
							<div class="col-md-4">Pin code:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="pincode"
									name="pincode" value="${user.pincode}">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Mobile number:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="phoneNumber"
									name="phoneNumber" value="${user.phoneNumber}"
									readonly="readonly">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-md-4">Land number:</div>
							<div class="col-md-8">
								<input type="text" class="form-control" id="landLineNumber"
									name="landLineNumber" value="${user.landLineNumber}">
							</div>
						</div>
						<div class="row customMarginTop">&nbsp;</div>
					</div>
					<!-- END: Form fields RHS; March 13, 2016 - Ananthakrishnan -->

				</div>
				<div class="row customMarginTop pull-right">
					<button type="button" class="btn btn-success" id="update"
						name="update">Update</button>
					<c:if test="${user.status != 'ACTIVATED'}">
						<button type="button" class="btn btn-success" id="activate"
							name="activate">Activate</button>
					</c:if>
					<c:if
						test="${admin.status=='superadmin' && user.status == 'ACTIVATED'}">
						<button type="button" class="btn btn-success" id="deacivate"
							name="deacivate">Deactivate</button>
					</c:if>
				</div>

			</form>
			<!-- END: User add form; March 13, 2016 - Ananthakrishnan -->

		</div>
	</div>
</div>


<script src="<c:url value="/resources/js/includeHTML.js" />"></script>
<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->