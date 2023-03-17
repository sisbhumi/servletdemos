package com.userwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listUserServlet")
public class listUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	public void init(ServletConfig config) {
		try {
			
			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword =context.getInitParameter("dbpassword");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName;
		String lastName;
		String emailId ;
		PrintWriter out = response.getWriter();

		try(Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from user;");) {
			
			while(rs.next()) {
				
				firstName = rs.getString(1);
				lastName = rs.getString(2);
				emailId = rs.getString(3);
				
				out.print(firstName+" ");
				out.print(lastName+" ");
				out.print(emailId+" ");
				out.println();
			} 
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
			e.printStackTrace();
		}
	}
}
