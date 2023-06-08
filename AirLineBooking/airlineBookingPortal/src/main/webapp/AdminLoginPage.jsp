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
<h2>Admin HomePage</h2>
	<form action="changePassword.jsp" method="post" >
		<input type="submit" value="Change Password"/>
	</form><br>

<br><form action="SourceList">
Master List of Sources: <input type="submit" value="view" />
</form>
<br><form action="DestinationList">
Master List of Destinations: <input type="submit" value="view" />
</form>
<br><form action="AirLineList">
Master List of AirLines: <input type="submit" value="view" />
</form>
<br><form action="FlightDetails">
Master List of Flights with details: <input type="submit" value="view" />
</form>

</div>
</body>
</html>