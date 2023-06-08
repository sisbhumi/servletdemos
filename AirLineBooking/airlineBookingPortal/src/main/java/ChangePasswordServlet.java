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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/mydb")
	private DataSource datasource;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.datasource=datasource;
		Connection connection = null;
		PreparedStatement preparedstatement=null;
		
		
		PrintWriter out=response.getWriter();
		String newpassword=request.getParameter("newpassword");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try {
			connection = this.datasource.getConnection();
		
		String sql = "update admin set password=? where username=? and password=?";
		preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setString(1, newpassword);
		preparedstatement.setString(2, username);
		preparedstatement.setString(3, password);
		
		 preparedstatement.executeUpdate();
		
		} catch (SQLException e1) {
			
			e1.printStackTrace();
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminLoginPage.jsp");
		dispatcher.include(request, response);
		out.println("<br>");
		out.println("<br><div align=center>Password Updated Successfully</div>");
		
	}
	
		
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
