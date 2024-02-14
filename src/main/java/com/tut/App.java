package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating student
		Student st = new Student();
		st.setSid(101);
		st.setName("lalit");
		st.setCity("mumbaiS");

		// creating address
		Address ad = new Address();
		ad.setStreet("Mira road");
		ad.setCity("Mumbai");
		ad.setOpen(true);
		ad.setAddDate(new Date());
		ad.setX(1234.124);
		// reading Image
		FileInputStream in = new FileInputStream("src/main/java/img.png");
		 byte[] data = new byte[in.available()];
		ad.setImage(data);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done..");

	}
}
