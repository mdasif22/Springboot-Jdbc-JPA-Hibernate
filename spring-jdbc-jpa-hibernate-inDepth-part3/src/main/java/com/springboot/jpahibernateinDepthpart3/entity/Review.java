package com.springboot.jpahibernateinDepthpart3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private long id;
	private String description;
	private String rating;
	@ManyToOne
	private Course course;
	Review(){
		
	}
	public Review(String rating,String number){
		this.rating=rating;
		this.description=number;
	}
	
	public Review(Long id, String number) {
		super();
		this.id = id;
		this.description = number;
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Long getId() {
		return id;
	}
	public String getDescip() {
		return description;
	}
	public void setDescip(String number) {
		this.description = number;
	}
	@Override
	public String toString() {
		return "Reviews [ "+rating +" "+ description + "]";
	}
	
	
}
