package com.seconfcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class SecondCacheExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// By default enabled session caches or first level caches
		Session session1 = factory.openSession();
		System.out.println("Session 1 started");
		Student student1 = session1.get(Student.class, 101);
		System.out.println(student1);
		session1.close();
		System.out.println("Session 1 closed");

		Session session2 = factory.openSession();
		System.out.println("Session 2 started");
		Student student2 = session2.get(Student.class, 102);
		System.out.println(student2);
		session2.close();
		System.out.println("Session 2 closed");

		System.out.println("Done...");
		factory.close();

	}

}
