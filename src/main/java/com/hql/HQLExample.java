package com.hql;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	public static void main(String[] args) {
		System.out.println("Project Started");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		// Select Queries
//		String query = "from Student";
//		Query q1 =session.createQuery(query);

//		String query = "from Student where city=:x";
//		Query q2= session.createQuery(query);
//		q2.setParameter("x", "mumbai");

//		String query = "from Student as s where s.city=:x and s.name=:y";
//		Query q3 = session.createQuery(query);
//		q3.setParameter("x", "mumbai");
//		q3.setParameter("y", "lalit");
//
//		List<Student> list = q3.list();
//		for (Student student : list) {
//			System.out.println(student.getName() + "" + student.getCity() + ":" + student.getCert());
//		}
		// Update and delete queries
		Transaction tx = session.beginTransaction();
		// delete query
//		Query q1= session.createQuery("delete from Student s where s.city=:c");
//		q1.setParameter("c", "pune");
//		int r = q1.executeUpdate();
//		System.out.println("Deleted...");
//		
//		//Update Query
//		Query q1= session.createQuery("update from Student s set s.city=:c where s.name=:n");
//		q1.setParameter("c", "Mumbai");
//		q1.setParameter("n", "Ramesh");
//		int r = q1.executeUpdate();
//		System.out.println("Updated...");

		// join query getting error in query
//		Query q1 = session
//				.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
//		List<Object> list = q1.getResultList();
//		for (Object arr : list) {
//			System.out.println(arr.toString());
//		}

		System.out.println("Done");

		session.close();
		factory.close();

	}

}
