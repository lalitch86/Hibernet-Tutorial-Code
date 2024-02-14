package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Project Started");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Question q1 = new Question();
		q1.setQuestionID(1);
		q1.setQuestion("What us Java");

		Answer a1 = new Answer();
		a1.setAnswerId(1);
		a1.setAnswer("java is object orientated Programming language");
		a1.setQuestion(q1);

		Answer a2 = new Answer();
		a2.setAnswerId(2);
		a2.setAnswer("java is case sensitive");
		a2.setQuestion(q1);

		Answer a3 = new Answer();
		a3.setAnswerId(3);
		a3.setAnswer("java is WORA");
		a3.setQuestion(q1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswer(list);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(q1);

		session.save(a1);
		session.save(a2);
		session.save(a3);
		tx.commit();

		System.out.println("Done..");

		// for feching data
		Question q = (Question) session.get(Question.class, 1);
		System.out.println(q.getQuestionID());
		System.out.println(q.getQuestion());
		System.out.println(q.getAnswer().size());

//		for (Answer answer : q.getAnswer()) {
//			System.out.println(answer.getAnswer());
//		}

		session.close();
	}

}
