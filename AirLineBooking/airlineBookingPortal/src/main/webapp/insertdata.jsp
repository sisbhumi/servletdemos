<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="InsertData" method="post">
		<table>
			<tr>
				<td>User Name</td>
				<td><input name="name" type="text" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type ="password" required></td>
			</tr>
			</tr>
			
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
</form>
</body>
</html>