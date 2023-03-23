package com.hibernatehelloworld;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.Guide;
import com.hibernatehelloworld.domain.Student;
import com.hibernatehelloworld.utils.HibernateUtil;

public class HibernateDemo {

	public static void main(String[] args) {
		
		demo1();
		demo2();
	}

	private static void demo2() {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		session.beginTransaction();
		
		Guide guide = new Guide("AB1224", "Peter Parker", 200);
		Student student1 = new Student("STU001", "Max Well", guide);
		
		session.save(student1);
		
		session.getTransaction().commit();
		
		session.close();
	}

	private static void demo1() {
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		session.beginTransaction();
		
		Guide guide = new Guide("AB1223", "Henry Parker", 2000);
		Student student1 = new Student("STU001", "Max Well", guide);
		Student student2 = new Student("STU002", "Raina Gia", guide);
		
		session.save(guide);
		session.save(student1);
		session.save(student2);
		
		session.getTransaction().commit();
		
		session.close();
	}

}
