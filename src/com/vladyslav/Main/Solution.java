package com.vladyslav.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.Entity.Student;
import com.vladyslav.Entity.StudentDetail;

public class Solution {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .addAnnotatedClass(StudentDetail.class)
				 .buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		
		try {
			// Create object 
			Student student = new Student("Gaga", "Kiknadze", "gaga@gmai;.com");
			StudentDetail studentInfo = new StudentDetail("Kharkov", "daily");
			
			// associate objects together
			student.setStudentDetail(studentInfo);
			
			// start transaction
			session.beginTransaction();
			
			// save the object student
			// because of CascadeType.All this will also save student info 
			// object
			session.save(student);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			
			session.close();
			
		}

	}
}
