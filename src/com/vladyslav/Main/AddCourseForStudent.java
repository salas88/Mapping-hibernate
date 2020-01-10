package com.vladyslav.Main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.Entity.Course;
import com.vladyslav.Entity.Student;
import com.vladyslav.Entity.StudentDetail;

public class AddCourseForStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .addAnnotatedClass(StudentDetail.class)
				 .addAnnotatedClass(Course.class)
				 .buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {
			
			// start transaction
			session.beginTransaction();
			int id = 3;
			Student student = session.get(Student.class, id);
			
			System.out.println("\n" + student.getCourse());
			
//			Course course = new Course("Html and Css course");
//			Course course2 = new Course("Basic Sprng and Hibernate");
//		
//
//			student.add(course);
//			student.add(course2);
//	
//			session.save(course);
//			session.save(course2);
			
		
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			
			session.close();
			
		}
	}
}
