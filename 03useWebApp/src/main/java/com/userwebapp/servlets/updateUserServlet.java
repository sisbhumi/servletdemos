package com.userwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateUserServlet")
public class updateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con;  
	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();

		try(Statement statement = con.createStatement();) {
			
			int result = statement.executeUpdate("Update USER SET password = '" + password + "' where email= '"+ emailId +"';" ); 
			if (result != 0) {
				out.println("<h1>Updated Successfully.</h1>");
			} else
				out.println("<h1>Data not Added.</h1>");
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
	
	public void destroy() {
		
		try {
			if(con != null ) {
			con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

}
