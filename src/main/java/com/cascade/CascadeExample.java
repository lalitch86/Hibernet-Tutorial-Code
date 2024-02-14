package com.cascade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// without casacading
		Session session = factory.openSession();

		Question q1 = new Question();
		q1.setQuestionID(11);
		q1.setQuestion("what is cascading");

		Answer a1 = new Answer(11, "it is important concept in hibernet");
		Answer a2 = new Answer(12, "second answer");
		Answer a3 = new Answer(13, "third answer");

		List<Answer> list = new ArrayList<>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		q1.setAnswer(list);
		Transaction tx = session.beginTransaction();

		session.save(q1);
		session.save(a1);
		session.save(a2);
		session.save(a3);

		System.out.println("done...");

		// without cascading
		// casacading all will save all inter related data automatically can de done by
		// below line
		// @OneToMany(mappedBy = "question",fetch=FetchType.LAZY,cascade =
		// CascadeType.ALL)

		Question q2 = new Question();
		q2.setQuestionID(12);
		q2.setQuestion("what is python");

		Answer a4 = new Answer(14, "it is programing language for AIML");
		Answer a5 = new Answer(15, "second answer");
		Answer a6 = new Answer(16, "third answer");

		List<Answer> list1 = new ArrayList<>();
		list.add(a4);
		list.add(a5);
		list.add(a6);
		q2.setAnswer(list1);

		session.save(q2);
		// with cascading no need to save this will get saved automatically
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
		System.out.println("done...");
		tx.commit();
		session.close();
		factory.close();

	}

}
