package com.demos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection con;
	private PreparedStatement preparedstatement;

	public void init(ServletConfig config) {
		try {

			ServletContext context = config.getServletContext();
			String dburl = context.getInitParameter("dburl");
			String dbuser = context.getInitParameter("dbuser");
			String dbpassword = context.getInitParameter("dbpassword");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dburl, dbuser, dbpassword);
			preparedstatement = con.prepareStatement("select * from user where email = ? and password = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		if (!isValidInput(name, false) || !isValidInput(password, false)) {
			out.println("Please enter valid input.");
			return;
		}

		try {
			preparedstatement.setString(1, name);
			preparedstatement.setString(2, password);
			ResultSet resultset = null;

			boolean result = preparedstatement.execute();
			if (result) {
				resultset = preparedstatement.getResultSet();
			} 
			
			if(resultset.next()) {
				System.out.println("User Successfully logged in. Navigating to home page");
				RequestDispatcher rd = request.getRequestDispatcher("homeservlet");
				String welcomeMsg = "welcome to servlet communication demo - " + name + " !!";
				request.setAttribute("meassage", welcomeMsg);
				rd.include(request, response);
			}
			else {
				out.println("<h1>Pls enter valid Input<p/>");
				return;
			}
			
		} catch (SQLException e) {
			out.println("Product not created. Error Occured. " + e.getMessage());
			e.printStackTrace();
		}
	}

	private boolean isValidInput(String inputValue, boolean isNumber) {
		if (inputValue == null || inputValue.isBlank() || inputValue.isEmpty()) {
			return false;
		} else if (isNumber) {
			Integer.parseInt(inputValue);
			return true;
		} else {
			return true;
		}
	}

	public void destroy() {
		try {
			if (con != null)
				con.close();
			if (preparedstatement != null)
				preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
