package com.vladyslav.Main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.Entity.Course;
import com.vladyslav.Entity.Review;
import com.vladyslav.Entity.Student;
import com.vladyslav.Entity.StudentDetail;

public class DeleteCourseAndCascadeDelReview {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .addAnnotatedClass(StudentDetail.class)
				 .addAnnotatedClass(Course.class)
				 .addAnnotatedClass(Review.class)
				 .buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {
			
			// start transaction
			session.beginTransaction();
		
			int theId = 4;
			Course course = session.get(Course.class, theId);
			
			session.delete(course);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			
			session.close();
			factory.close();
		}
	}
}
