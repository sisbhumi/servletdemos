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

import com.flyaway.model.Flight;
import com.flyaway.utils.FlightDataUtil;

@WebServlet("/registerPage")
public class RegisterPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/mydb")
	private DataSource datasource;
	private FlightDataUtil fdu;
	public static int flightPrice=0;
   
	public void init(ServletConfig config) throws ServletException {
		fdu = new FlightDataUtil(datasource);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int flightid = Integer.parseInt(request.getParameter("flight_id"));
	String person=request.getParameter("person");
	flightPrice=Integer.parseInt(request.getParameter("price"));
	Flight flight=fdu.getFlightdetails(flightid,person);
	request.setAttribute("Flight",flight);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/personal_details.jsp");
	dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
