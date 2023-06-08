package com.flyaway.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.flyaway.model.CustomerPersonalDetails;
import com.flyaway.utils.CustomerDetails;
import com.flyaway.utils.FlightDataUtil;

@WebServlet("/paymentservlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/mydb")
	private DataSource datasource;
	private CustomerDetails cd;
	public void init(ServletConfig config) throws ServletException {
		cd = new CustomerDetails(datasource);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String aadharNo = request.getParameter("aadharNo");
		String contactNo = request.getParameter("contactNo");
		String person=request.getParameter("person");
		CustomerPersonalDetails cpd=cd.getPersonalDetails(name,age,aadharNo,contactNo,person);
		request.setAttribute("personalDetails", cpd);
		RequestDispatcher requestdispatcher=request.getRequestDispatcher("/prepayment.jsp");
		requestdispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
