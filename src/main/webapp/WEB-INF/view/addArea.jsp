
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid col-xs-11 col-sm-11 col-md-11 col-lg-11">

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h1 class="page-header">Add Area</h1>
				</div>
			</div>

			<!-- BEGIN: User add form; March 13, 2016 - Ananthakrishnan -->
			<form role="form" action="addArea" method="post">

				<div class="row">

					<!-- BEGIN: Form fields LHS; March 13, 2016 - Ananthakrishnan -->
					<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
						<div class="row">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Area Name:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" name="areaCode" required class="form-control alphabets" id="areaCode">
							</div>
						</div>
						<div class="row customMarginTop">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">Available Area:</div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<c:forEach var="area" items="${areaList}">
									<tr>
										<%-- <td><c:out value="${area.id}"/></td> --%>
										<td>
											<c:out value="${area.areaName}" /><br>
										</td>
									</tr>
								</c:forEach>
							</div>
						</div>
						
					</div>
					<!-- END: Form fields LHS; March 13, 2016 - Ananthakrishnan -->

				</div>
				<div class="row customMarginTop pull-right">
					<a class="btn btn-danger" id="clearUser">Clear Fields</a>
					<a class="btn btn-success" id="submit">Add Area</a>
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
