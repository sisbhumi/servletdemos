package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.flyaway.model.Flight;

@WebServlet("/SourceList")
public class SourceList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/mydb")
	private DataSource datasource;
	Set<String> source=new HashSet<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.datasource=datasource;
		Connection connection = null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		
		PrintWriter out=response.getWriter();
	
		try {
			connection = this.datasource.getConnection();
		String sql = "select Flight_Source from flights";
		statement = connection.createStatement();
		
		resultSet=statement.executeQuery(sql);
		
		while(resultSet.next()) {
			String s=resultSet.getString("Flight_Source");
			source.add(s);
		}
		
		
		request.setAttribute("Sources", source);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Source.jsp");
		dispatcher.forward(request, response);
		
		
		
		 
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
		out.println("<br>Password Updated Successfully");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
