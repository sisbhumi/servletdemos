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

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
    public AddUserServlet() {
        super();
    }
    
    public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String emailId = request.getParameter("email");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();

		try(Statement statement = con.createStatement();) {
			
			int result = statement.executeUpdate("INSERT INTO USER VALUES('" + firstName + "','" + lastName + "','"
					+ emailId + "','" + password + "');");
			if (result != 0) {
				out.println("<h1>Data Added Successfully.</h1>");
			} else
				out.println("<h1>Data not Added.</h1>");
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}
	
	public void destroy() {

		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
