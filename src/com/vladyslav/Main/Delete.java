package com.vladyslav.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.Entity.Student;
import com.vladyslav.Entity.StudentDetail;

public class Delete {

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
			
//			int id = 2;
//			Student tempStudent = session.get(Student.class, id);
//			session.delete(tempStudent);
			
			session.createQuery("delete from Student where id=1").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			
			session.close();
			
		}

	}

}
