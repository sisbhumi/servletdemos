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
<h2>Login Credentials Required</h2>
	<form action="AdminServlet" method="post">
		<table>
			<tr>
				<td>User Name</td>
				<td><input name="name" type="text" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type ="password" required></td>
			</tr>
			
				<td><input type="submit" value="Login" /></td>
			</tr>
			
			
		</table>

<br>
<br>
	</form>
	<form action="insertdata.jsp" method="post" >
	<table>
	 </tr>
			
				<td><input type="submit" value="Sign Up" /></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>