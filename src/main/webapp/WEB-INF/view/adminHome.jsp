
<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->


<div id="wrapper">
	<div id="page-wrapper">
		<div class="container-fluid col-xs-11 col-sm-11 col-md-11 col-lg-11">

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<h1 class="page-header">
						Admin Home
						<small>Add Unique User Id and/or User Area</small>
					</h1>
				</div>
			</div>

			<!-- BEGIN: User add form; March 13, 2016 - Ananthakrishnan -->


			<div class="row">

				<!-- BEGIN: Form fields LHS; March 13, 2016 - Ananthakrishnan -->
				<form action="addUniqueID" method="post">
					<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
						<div class="row">
							<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4"><input type="text" required class="form-control alphabets"
									id="format" name="format"></div>
							<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
								<input type="text" required class="form-control alphabets"
									id="value" name="value">
							</div>
						</div>
						
						<div class="row customMarginTop">
							<a class="btn btn-success" id="addId">Add Unique User ID</a>
						</div>
					</div>
				</form>
				<!-- END: Form fields LHS; March 13, 2016 - Ananthakrishnan -->

				<!-- BEGIN: Form fields RHS; March 13, 2016 - Ananthakrishnan -->
				<div class="col-xs-12 col-sm-6 col-lg-6 col-md-6">
					
					<div class="row">
						<div class="col-xs-5 col-sm-4 col-lg-4 col-md-4">User Area:</div>
						<div class="col-xs-7 col-sm-8 col-lg-8 col-md-8">
							<input type="text" class="form-control numeric" id="userArea"
								name="userArea">
						</div>
					</div>
					<div class="row customMarginTop">
						<a class="btn btn-success" id="userArea">Add User Area</a>
					</div>
				</div>
				<!-- END: Form fields RHS; March 13, 2016 - Ananthakrishnan -->

			</div>



		</div>
	</div>
</div>


<script src="<c:url value="/resources/js/includeHTML.js" />"></script>
<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->