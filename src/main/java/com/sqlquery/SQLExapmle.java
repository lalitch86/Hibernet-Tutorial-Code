package com.sqlquery;

import java.lang.annotation.Native;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.tut.Student;

public class SQLExapmle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		String query = "select * from student";
		NativeQuery nq = session.createSQLQuery(query);
		
		List<Object[]> list = nq.list();
		for (Object[] student : list) {
			//System.out.println(Arrays.deepToString(student));
			System.out.println(student[4] +"  "+student[0]);
		}
		
		session.close();
		factory.close();

	}

}
