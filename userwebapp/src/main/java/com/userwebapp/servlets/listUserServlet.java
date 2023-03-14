package com.userwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listUserServlet")
public class listUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    	
    public void init(){
    	try {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root" , "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public listUserServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Statement stm = con.createStatement();){
			ResultSet rs= stm.executeQuery("Select * from user");
			PrintWriter out = response.getWriter();
			
			while(rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String email = rs.getString(3);
				
				out.print(firstName+" ");
				out.print(lastName+" ");
				out.print(email+" ");
				out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void destroy() {
		if( con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
