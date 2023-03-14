package com.demo.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/DemoServlet")
public class DemoServletFilter extends HttpFilter implements Filter {

    
	public void destroy() {
		System.out.println("Filter destroyed");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Inside DemoServletFilter...");
		response.getWriter().println("Before Servlet...");
		chain.doFilter(request, response);
		response.getWriter().println("After Servlet");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Filter initialized");
	}

}
