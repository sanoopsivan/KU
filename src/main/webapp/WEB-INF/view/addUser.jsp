<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
</html>