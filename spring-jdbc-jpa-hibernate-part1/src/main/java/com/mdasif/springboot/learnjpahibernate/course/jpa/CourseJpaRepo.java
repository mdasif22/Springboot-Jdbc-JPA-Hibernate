package com.mdasif.springboot.learnjpahibernate.course.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mdasif.springboot.learnjpahibernate.course.Course;

@Repository
public class CourseJpaRepo {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	public void insert(Course course) {
		entityManager.merge(course);
	}
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
