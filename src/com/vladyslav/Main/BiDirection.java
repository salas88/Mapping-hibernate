package com.vladyslav.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.Entity.Student;
import com.vladyslav.Entity.StudentDetail;

public class BiDirection {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .addAnnotatedClass(StudentDetail.class)
				 .buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {

			// start transaction
			session.beginTransaction();
			
			int id =1;
			StudentDetail studentInfo = session.get(StudentDetail.class, id);
			
			System.out.println("associate student " + studentInfo.getStudent());
			session.getTransaction().commit();
			
		}finally {
			
			session.close();
			
		}

	}

}
