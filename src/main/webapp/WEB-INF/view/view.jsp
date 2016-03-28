<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${admin.status}</h1>

	<%-- <table>
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.firstName}" /></td>
				<td><c:out value="${user.lastName}" /></td>
				<td><a href="edit?${user.userId}">Edit</a></td>
			</tr>
		</c:forEach>
	</table> --%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
				url : $("#searchForm").attr("action"),
				type : "GET",

				success : function(response) {
					alert( response );
				},
				error : function(xhr, status, error) {
					alert(xhr.responseText);
				}
			});
			
		});
		
	</script>
	<form action="ajax" method="get" id="searchForm">
	<input type="submit" id="submit"/>
		<div id="result"></div>
	</form>
</body>
</html>