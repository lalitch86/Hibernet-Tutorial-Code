package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Project Started");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Emp e1 = new Emp();
		Emp e2 = new Emp();

		e1.setEid(1);
		e1.setName("jay");

		e2.setEid(2);
		e2.setName("ramesh");

		Project p1 = new Project();
		Project p2 = new Project();
		p1.setPid(1);
		p1.setProjectName("LMS");

		p2.setPid(2);
		p2.setProjectName("BMS");
		List<Emp> l1 = new ArrayList<Emp>();

		List<Project> l2 = new ArrayList<Project>();

		l1.add(e1);
		l1.add(e2);
		l2.add(p1);
		l2.add(p2);

		e1.setProjects(l2);
		p2.setEmps(l1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		tx.commit();

		System.out.println("Done..");
		
		//can be used for fetch data

		session.close();

	}

}
