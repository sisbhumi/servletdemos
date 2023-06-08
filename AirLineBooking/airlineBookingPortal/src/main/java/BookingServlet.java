package com.flyaway.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

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


@WebServlet("/bookingservlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/mydb")
	private DataSource datasource;

	private Flight sf;
	private FlightDataUtil fdu;
	

	public void init(ServletConfig config) throws ServletException {
		fdu = new FlightDataUtil(datasource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String date = request.getParameter("date");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int person = Integer.parseInt(request.getParameter("person"));
		List<Flight> search = fdu.search(date, source, destination,person);
		
		request.setAttribute("Search",search);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/flight_details.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
