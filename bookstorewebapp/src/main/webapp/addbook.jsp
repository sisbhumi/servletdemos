<%@ page import="java.util.*, bookstorewebapp.servlets.AddBook"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>BookName</th>
		</tr>
		
		<c:forEach var="book" items="${book_list}">
			<tr>

				<td>${book.getName()}</td> 
				
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>