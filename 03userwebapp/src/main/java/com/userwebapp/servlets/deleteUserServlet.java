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

@WebServlet("/deleteUserServlet")
public class deleteUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Connection connection;
	
	public deleteUserServlet() {
		super();
	}

	public void init() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
	

		String password = request.getParameter("password");
		
		try(Statement statement = connection.createStatement();){
			
			int result = statement.executeUpdate("Delete from user where password = '"+password+"';");
			PrintWriter out = response.getWriter();
			if(result != 0) {
				out.println("Deleted successfully");
			}
			else
				out.println("Not Deleted");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	} 

	public void destroy() {
	
		try {
			if( connection != null) 
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}

}
