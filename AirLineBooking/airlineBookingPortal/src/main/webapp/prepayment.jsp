<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<th>Name</th>
			<th>Age</th>
			<th>AadharNo</th>
			<th>ContactNo</th>
			
		</tr>
		
	
		
			<tr>
				<td>${personalDetails.name}</td>
				<td>${personalDetails.age}</td>
				<td>${personalDetails.aadharNo}</td>
				<td>${personalDetails.contactNo}</td>
				
			</tr>
			
	
		
	</table>
	<br>
	<br>
	<form action="payment.jsp" method="post">
	<input type="hidden" name="person" value="${personalDetails.person}" />
	<input type="submit" value="Proceed to Payment">
	</form>
</div>
</body>
</html>