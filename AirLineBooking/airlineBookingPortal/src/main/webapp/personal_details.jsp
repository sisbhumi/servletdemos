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
<h2>Flight Details of Your Choice</h2>
<table border="2">
		<tr>
			<th>FlightId</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Date Choosen</th>
			<th>Airlines</th>
			<th>Price</th>
			
		</tr>
		
		
		
			<tr>
				<td>${Flight.flight_id}</td>
				<td>${Flight.source}</td>
				<td>${Flight.destination}</td>
				<td>${Flight.date}</td>
				<td>${Flight.airline}</td>
				<td>${Flight.price}</td>
				
			</tr>	
	</table>
</div>
<div align="center">
<h2>Enter Personal Details To Continue</h2>

<form action="paymentservlet" method="post">

<input type="hidden" name="person" value="${Flight.person}"/>
		<table>
			<tr>
				<td>Name</td>
				<td><input name="name" type="text" required></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input name="age" type ="text" required></td>
			</tr>
			<tr>
				<td>Aadhaar Number</td>
				<td><input name="aadharNo" type="text" required></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><input name="contactNo" type="text" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Next" /></td>
			</tr>
		</table>


	</form>
</div>
</body>
</html>