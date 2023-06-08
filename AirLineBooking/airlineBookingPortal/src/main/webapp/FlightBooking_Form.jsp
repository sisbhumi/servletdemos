<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" >
<h2>Enter Details to continue</h2>
	<form action="bookingservlet" method="post">
		<table>
			<tr>
				<td>Date Of Travel</td>
				<td><input name="date" type="date" required ></td>
			</tr>
			<tr>
				<td>Source</td>
				<td><input name="source" type ="text" required></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><input name="destination" type="text" required></td>
			</tr>
			<tr>
				<td>Number of Person</td>
				<td><input name="person" type="text" required></td>
			</tr>
			<tr>
				
				<td><input type="submit" value="Next" /></td>
			</tr>
		</table>


	</form>
</div>
</body>
</html>