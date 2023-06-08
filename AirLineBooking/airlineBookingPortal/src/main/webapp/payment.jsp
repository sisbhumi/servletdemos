<%@ page import="com.flyaway.controller.RegisterPage" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
int price=RegisterPage.flightPrice;
int person=Integer.parseInt(request.getParameter("person"));
out.println("Number Of persons entered= "+person+"<br>");
out.println("Price of flight per person= "+price+"<br>");
out.println("Amount to Pay= Rs "+price*person+"<br>");
out.println("<br>");
%>
</div>
<div align="center">
<form action="final.html" method="post">
<table>

			<tr>
				<td>Card No</td>
				<td><input name="cardno" type="text" required></td>
			</tr>
			<tr>
				<td>Name On Card</td>
				<td><input name="nameoncard" type ="text" required></td>
			</tr>
			<tr>
				<td>Card Expiry date</td>
				<td><input name="expiry" type="date" required></td>
			</tr>
			<tr>
				<td>Cvv</td>
				<td><input name="cvv" type="text" required></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Pay" /></td>
			</tr>
		</table>
		</form>
</div>
</body>
</html>