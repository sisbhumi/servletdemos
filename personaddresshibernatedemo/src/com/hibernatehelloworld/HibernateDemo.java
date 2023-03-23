package com.hibernatehelloworld;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.Address;
import com.hibernatehelloworld.domain.Person;
import com.hibernatehelloworld.utils.HibernateUtil;

public class HibernateDemo {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		session.beginTransaction();
		
		Address address1 = new Address("121 Md Street", "Indoer", "34454");
		Address address2 = new Address("841 ring road", "Khandwa", "12343");
		
		Person person = new Person("John", address1,address2);
		
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

}
