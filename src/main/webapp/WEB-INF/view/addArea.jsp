<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addArea" method="post">
		<input type="text" name="areaCode" /> <input type="submit" />
	</form>

	<table>
		<thead>
			<tr>
				<!-- <th>Id</th> -->
				<th>Area</th>
			</tr>
		</thead>

		<tbody>
		<c:forEach var="area" items="${areaList}">
			<tr>
				<%-- <td><c:out value="${area.id}"/></td> --%>
				<td><c:out value="${area.areaName}"/> </td>
			
			
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
</body>
</html>