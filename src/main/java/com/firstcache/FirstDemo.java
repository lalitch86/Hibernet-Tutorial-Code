package com.firstcache;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.tut.Student;

public class FirstDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// By default enabled session caches or first level caches
		Session session = factory.openSession();
		System.out.println("Student");
		System.out.println("working something ... ");
		Student student = session.get(Student.class, 101);
		System.out.println(student);
		System.out.println(session.contains(student));
		System.out.println("Done...");
		session.close();
		factory.close();
	}

}
