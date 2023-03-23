<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
		</tr>
		<c:forEach var="students" items="${student_list}">
			<tr>
				<td>${students.id}</td>
				<td>${students.firstName}</td>
				<td>${students.lastName}</td>
				<td>${students.email}</td>
				<td><a href="deletestudent?studentId=${students.id}">Delete</a></td>
				<td><a href="updatestudent?studentId=${students.id}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>