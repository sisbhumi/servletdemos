package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;





@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/mydb")
	private DataSource datasource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.datasource=datasource;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultSet=null;
		String user1="";
		String pass1="";
		PrintWriter out=response.getWriter();
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		try {
			connection = this.datasource.getConnection();
			
			String sql = "select * from admin where username = ? and password= ?";
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			resultSet = preparedstatement.executeQuery();
			while (resultSet.next()) {
				String user = resultSet.getString("username");
				String pass= resultSet.getString("password");
				
				user1=user;
				pass1=pass;
						
			}
			if(user1.equals(username) && pass1.equals(password)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminLoginPage.jsp");
				dispatcher.forward(request, response);
			}
			
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHomePage.jsp");
				dispatcher.include(request, response);
				out.println("<br><div align=center><SPAN style=color:red> Invalid Credentials !!!</SPAN></div>");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
