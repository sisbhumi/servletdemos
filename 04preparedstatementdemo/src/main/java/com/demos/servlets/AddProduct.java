package com.demos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Connection con;
	private PreparedStatement preparedstatement;

	@Resource(name = "jdbc/schooladmin")
	public void init(ServletConfig config) {
		try {
			
			ServletContext context = config.getServletContext();
					String dburl = context.getInitParameter("dburl");
					String dbuser = context.getInitParameter("dbuser");
					String dbpassword =context.getInitParameter("dbpassword");
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(dburl, dbuser, dbpassword);
					preparedstatement = con.prepareStatement("insert into product values (?,?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("descr");
		String price = request.getParameter("price");
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		if( !isValidInput(id,true) || !isValidInput(name,false) || !isValidInput(description,false) || !isValidInput(price,true)) {
			out.println("Please enter valid input.");
			return;
		}
		
		try {
			preparedstatement.setInt(1, Integer.parseInt(id));
			preparedstatement.setString(2, name);
			preparedstatement.setString(3, description);
			preparedstatement.setInt(4, Integer.parseInt(price));
			int result = preparedstatement.executeUpdate();
			out.println("Product Created. result = "+ result);
		} catch (SQLException e) {
			out.println("Product not created. Error Occured. "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	private boolean isValidInput(String inputValue, boolean isNumber ) {
		if( inputValue == null || inputValue.isBlank() || inputValue.isEmpty()) {
			return false;
		}else if(isNumber) {
			Integer.parseInt(inputValue);
			return true;
		}else {
			return true;
		}
	}
	
	public void destroy() {
		try {
			if (con != null)
				con.close();
			if( preparedstatement != null )
				preparedstatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
