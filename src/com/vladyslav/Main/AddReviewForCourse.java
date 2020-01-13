package com.vladyslav.Main;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.vladyslav.Entity.Course;
import com.vladyslav.Entity.Review;
import com.vladyslav.Entity.Student;
import com.vladyslav.Entity.StudentDetail;

public class AddReviewForCourse {

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
			
//			Student student = new Student("Oleg", "Omeliy", "omeliy33@gmail.com");
//			
//			Course course = new Course("Speak English - very eazy");
//			
//			session.save(student);
//			session.save(course);
//		
//			course.addStudent(student);
			
			Student student =session.get(Student.class, 3);
		
			List<Course> courses = session.createQuery("from Course").getResultList();
			
			for(int i=0; i<courses.size(); i++) {
				student.addCourseForStudent(courses.get(i));
			}
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			
			session.close();
			factory.close();
		}
	}
}
