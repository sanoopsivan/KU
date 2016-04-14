<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add new User</h2>
	<form action="addUser" method="post">
		FirstName
		<input type="text" name="firstName" />
		<br> LastName
		<input type="text" name="lastName" />
		<br>
		<label>Gender</label>
		<input type="radio" name="gender" value="male" />
		Male
		<input type="radio" name="gender" value="female" />
		Female <br> Address
		<textarea name="address" cols="20" rows="5"... ></textarea>
		<br> Area
		<select name="areaCode" id="item">
			<option value="area1" selected>Area1</option>
		</select>
		<br> pincode
		<input type="text" name="pincode" />
		<br> Mobile +91
		<input type="text" name="phoneNumber" />
		<br> Telephone
		<input type="text" name="telephone" />
		<br> E-mail
		<input type="text" name="email" />
		<br>
		<input type="submit" value="add" />
	</form>
</body>
</html> --%>

<%@ include file="/WEB-INF/view/common/header.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->

<div id = "wrapper">
    <div id = "page-wrapper">
        <div class = "container-fluid">

            <div class = "row">
                <div class = "col-lg-12">
                    <h1 class = "page-header">
                        Add User <small>Add new user details</small>
                    </h1>
                </div>
            </div>
            
            <!-- BEGIN: User add form; March 13, 2016 - Ananthakrishnan -->
            <form role = "form" action = "addUser" id = "userAddForm" name = "userAddForm" method="post">
                
                <div class = "row">                
                    
                    <!-- BEGIN: Form fields LHS; March 13, 2016 - Ananthakrishnan -->
                    <div class = "col-md-6">
                        <div class = "row">
                            <div class = "col-md-4">
                                First name:
                            </div>
                            <div class = "col-md-8">
                                <input type = "text" class = "form-control" id = "firstName" name = "firstName">
                            </div>
                        </div>
                        <div class = "row customMarginTop">
                            <div class = "col-md-4">
                                Last name:
                            </div>
                            <div class = "col-md-8">
                                <input type = "text" class = "form-control" id = "lastName" name = "lastName">
                            </div>
                        </div>
                        <div class = "row customMarginTop">
                            <div class = "col-md-4">
                                Gender:
                            </div>
                            <div class = "col-md-8">
                                <label class = "radio-inline"><input type = "radio" name = "gender">Male</label>
                                <label class = "radio-inline"><input type = "radio" name = "gender">Female</label>
                            </div>
                        </div>
                        <div class = "row customMarginTop">
                            <div class = "col-md-4">
                                Address:
                            </div>
                            <div class = "col-md-8">
                                <textarea rows = "4" cols = "50" id = "address" name = "address"></textarea>
                            </div>
                        </div>
                        <div class = "row customMarginTop">
                            <div class = "col-md-4">
                                Area:
                            </div>
                            <div class = "col-md-8">
                                <input type = "text" class = "form-control" id = "areaCode" name = "areaCode">
                            </div>
                        </div>
                    </div>
                    <!-- END: Form fields LHS; March 13, 2016 - Ananthakrishnan -->
                    
                    <!-- BEGIN: Form fields RHS; March 13, 2016 - Ananthakrishnan -->
                    <div class = "col-md-6">
                        <div class = "row">
                            <div class = "col-md-4">
                                Pin code:
                            </div>
                            <div class = "col-md-8">
                                <input type = "text" class = "form-control" id = "pincode" name = "pincode">
                            </div>
                        </div>
                        <div class = "row customMarginTop">
                            <div class = "col-md-4">
                                Mobile number:
                            </div>
                            <div class = "col-md-8">
                                <input type = "text" class = "form-control" id = "phoneNumber" name = "phoneNumber">
                            </div>
                        </div>
                        <div class = "row customMarginTop">
                            <div class = "col-md-4">
                                Land number:
                            </div>
                            <div class = "col-md-8">
                                <input type = "text" class = "form-control" id = "landLineNumber" name = "landLineNumber">
                            </div>
                        </div>
                        <div class = "row customMarginTop">
                            &nbsp;
                        </div>
                    </div>
                    <!-- END: Form fields RHS; March 13, 2016 - Ananthakrishnan -->
                    
                </div>
                <div class = "row customMarginTop pull-right">
                    <input type = "submit" class = "btn btn-success" id = "submit" name = "submit">
                </div>

            </form>
            <!-- END: User add form; March 13, 2016 - Ananthakrishnan -->

        </div>
    </div>
</div>


<script src="<c:url value="/resources/js/includeHTML.js" />"></script>
<%@ include file="/WEB-INF/view/common/footer.jsp"%><!-- March 12, 2016 - Ananthakrishnan: To inlcude navigation. -->