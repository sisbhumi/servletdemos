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
			<th>FlightId</th>
			<th>AirLines</th>
			<th>Price</th>
			<th>Date Choosen</th>
			
		</tr>
		
		<c:forEach var="search" items="${Search}">
		
			<tr>
				<td><a href="registerPage?flight_id=${search.flight_id}&person=${search.person}&price=${search.price}">${search.flight_id}</a></td>
				<td>${search.airline}</td>
				<td>${search.price}</td>
				<td>${search.date}</td>
			
			</tr>
			
		</c:forEach>
		
	</table>
	
</div>
</body>
</html>