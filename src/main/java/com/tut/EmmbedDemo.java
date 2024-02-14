package com.tut;

import java.io.IOException;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmmbedDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student
		Student s1 = new Student();
		s1.setSid(101);
		s1.setName("Lalit");
		s1.setCity("Mumbai");
		Certificate c1 = new Certificate();
		c1.setCourse("Java");
		c1.setDuration("2 Months");
		s1.setCert(c1);
		
		
		Student s2 = new Student();
		s2.setSid(102);
		s2.setName("Ramesh");
		s2.setCity("Pune");
		s2.setCert(c1);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(s1);
		session.save(s2);
		
		tx.commit();
		session.close();
		factory.close();
	
	}

}
