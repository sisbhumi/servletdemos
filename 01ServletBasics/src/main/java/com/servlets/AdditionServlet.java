package com.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String number1 = req.getParameter("number1");
		String number2 = req.getParameter("number2");
		PrintWriter out = res.getWriter();
		
		int result = 0;
		
		if(number1 == null || number1.isBlank() || number1.isEmpty() 
				|| number2 == null || number2.isBlank() || number2.isEmpty() ) {
			out.println("<p>Invalid Input</p>");
		}
		else {
			try {
					int num1 = Integer.parseInt(number1);
					int num2 = Integer.parseInt(number2);
					result = num1+num2;
					out.println("<p>Result = " + (result) + "</p>");
			}
			catch(NumberFormatException e) {
				out.println("<p>Invalid Input<p>");
				
			}
		}
		
		
	}

}
