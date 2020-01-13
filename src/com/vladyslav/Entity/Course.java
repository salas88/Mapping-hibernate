package com.vladyslav.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(fetch =FetchType.LAZY, cascade= {CascadeType.DETACH, 
				CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="student_course",
			   joinColumns=@JoinColumn(name = "id_course"),
			   inverseJoinColumns=@JoinColumn(name = "id_student"))
	private List<Student> student;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id_course")
	private List<Review> reviews;
	
	public void addReview(Review tempReview) {
		if(reviews == null) {
		reviews = new ArrayList<>();}
		
		reviews.add(tempReview);
	}
	
	
	public void addStudent(Student tempStudent) {
		if(student == null) {
			student = new ArrayList<>();
		} else
			student.add(tempStudent);
	}
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}




	public List<Review> getReviews() {
		return reviews;
	}



	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}



	public Course() {}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", student=" + student + "]";
	}

	

}
