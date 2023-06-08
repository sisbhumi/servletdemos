package bookstorewebapp.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import bookstorewebapp.domain.Book;
import bookstorewebapp.utils.HibernateUtil;

public class HibernateDemo {

	public static void main(String[] args) {
		
		demo2();
	}

	private static void demo2() {
		
		Session session = HibernateUtil.getSessionfactory().openSession();	
		
		Query q = session.createQuery("from Book");
//		book = session.get(Book.class, 1 );
		
		List<Book> bookList = q.list() ;

		for( Book b:bookList) {
			System.out.println(b.getName());
		}
		
		session.close();
	}


}
