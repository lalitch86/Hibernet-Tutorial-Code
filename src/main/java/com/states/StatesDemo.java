package com.states;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StatesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Example of : ");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// createing student object
		Student student = new Student();
		student.setSid(101);
		student.setName("Lalit");
		student.setCity("Mumbai");
		student.setCert(new Certificate("Java Hibernet Course", "5 Months"));

		// student : Transient

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);// student : Persistent = session , database
		tx.commit();

		session.close();

		// student : Detaches
		student.setName("Lalit");
		System.out.println(student.getName());

		factory.close();
		System.out.println("Done ... ");
		
		// student : removed state 

	}

}
