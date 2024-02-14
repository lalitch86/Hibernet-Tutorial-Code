package com.pagination;

import com.tut.Student;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HQLPagination {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Query query = session.createQuery("from Student");
		query.getFirstResult();
		query.setMaxResults(4);
		
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student.getSid()+":"+student.getName()+":"+student.getCity());
		}
		session.close();
		factory.close();
	}

}
