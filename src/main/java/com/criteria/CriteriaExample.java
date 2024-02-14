package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// By default enabled session caches or first level caches
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Student.class);
		//c.add(Restrictions.eq("cert.course", "android"));
		//c.add(Restrictions.gt("id", 101));
		//c.add(Restrictions.lt("id", 101));
		//c.add(Restrictions.isNull("id"));
		c.add(Restrictions.eq("cert.course", "java%"));
		
		
		List<Student> students = c.list();
		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println("Done...");
		session.close();
		factory.close();

	}

}
