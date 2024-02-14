package com.tut;

import java.io.IOException;

//get() and load() method
//get() method return null if object not found in caches or database
//while returning a object get() first checks whether object is exits in caches or not if not then it hits database

//load() method returns objectnotfound exception if object not found in caches or database

//load() returns proxy in place and only initialize the object or hit the database if any method other than getid() is called
//on persistent or entity object .this is called lazy initialization//it increases the performance 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Student student = session.load(Student.class,101);
		System.out.println(student);

		Address ad = session.get(Address.class, 2);
		System.out.println(ad.getStreet() + "" + ad.getCity());

		session.close();
		factory.close();

	}
}
