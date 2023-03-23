package bookstorewebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.apache.catalina.SessionIdGenerator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import bookstorewebapp.domain.Book;
import bookstorewebapp.utils.HibernateUtil;

@WebServlet("/addBook") 
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Book book;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		Session session = HibernateUtil.getSessionfactory().openSession();
//
//		org.hibernate.Transaction transaction =  session.beginTransaction();
//
//		String name = request.getParameter("name");
//		String price = request.getParameter("price");
//		int b_price = Integer.parseInt(price);
//		
//		Book book = new Book(name, b_price);
//		
//		session.save(book);
//		
//		session.getTransaction().commit();
//		transaction.commit();
//		session.close();
		
//		request.setAttribute("book_list", bookList);
//
//		RequestDispatcher d = request.getRequestDispatcher("/addbook.jsp");
//		d.include(request, response);
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Session session = HibernateUtil.getSessionfactory().openSession();

		org.hibernate.Transaction transaction =  session.beginTransaction();

		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int b_price = Integer.parseInt(price);
		
		Book book = new Book(name, b_price);
		
		session.save(book);
		
		session.getTransaction().commit();
		
		Query q = session.createQuery("from Book");
//		book = session.get(Book.class, 1 );
		
		List<Book> bookList = q.list() ;

		for( Book b:bookList) {
			System.out.println(b.getName());
		}
		
		session.close();
		
		request.setAttribute("book_list", bookList);

		RequestDispatcher d = request.getRequestDispatcher("/addbook.jsp");
		d.include(request, response);
		

	}

}
