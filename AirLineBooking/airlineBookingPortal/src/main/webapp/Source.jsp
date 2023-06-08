<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<table border="2">
		<tr>
			<th>Flight Sources</th>
			
			
		</tr>
		
		<c:forEach var="source" items="${Sources}">
		
			<tr>
				<td>${source}</td>
				
			
			</tr>
			
		</c:forEach>
		
	</table>
	<br>
	<a href="AdminLoginPage.jsp">Back</a>
</div>
</body>
</html>