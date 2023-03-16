<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection con;
		PreparedStatement ps;
		
		public void jspInit(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
				ps = con.preparedStatement("insert into account values (?,?,?,?)");
		
			}catch(Exception e){
				e.printStacktrace();
			}
		}
		}
		
		public void jspDestroy(){
			try{
				ps.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
	
	<%
		int accno = Integer.parseInt(request.getParameter("accno"));
		int bal = Integer.parseInt(request.getParameter("bal"));
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lname");
		
		ps.setInt(1,accno);
		ps.setString(2,lname);
		ps.setString(3,fname);
		ps.setInt(4,bal);
		
		ps.executeUpdate();
	%>

</body>
</html>