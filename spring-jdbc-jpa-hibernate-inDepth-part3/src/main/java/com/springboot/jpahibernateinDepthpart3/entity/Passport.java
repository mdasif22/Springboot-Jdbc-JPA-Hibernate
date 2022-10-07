package com.springboot.jpahibernateinDepthpart3.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Passport {
	@Id
	@GeneratedValue
	private long id;
	private String number;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;
	
	Passport(){
		
	}
	public Passport(String number){
		this.number=number;
	}
	
	public Passport(Long id, String number) {
		super();
		this.id = id;
		this.number = number;
	}
	public Long getId() {
		return id;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getPassport() {
		return number;
	}
	public void setPassport(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Passport [name=" + number + "]";
	}
	
	
}
