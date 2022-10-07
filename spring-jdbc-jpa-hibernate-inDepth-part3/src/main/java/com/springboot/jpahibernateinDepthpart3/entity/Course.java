package com.springboot.jpahibernateinDepthpart3.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();
	
	Course(){
		
	}
	public Course(String name){
		this.name=name;
	}
	
	public Course(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void addReviews(Review reviews) {
		this.reviews.add(reviews);
	}
	public void removeReviews(Review reviews) {
		this.reviews.remove(reviews);
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}
	
	
}
