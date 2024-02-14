package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Person p1 = new Person(1, "Ram", "ayodya", "naam");

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p1);
		
		tx.commit();

		session.close();
		System.out.println("Session  closed");

		System.out.println("Done...");
		factory.close();
	}

}
