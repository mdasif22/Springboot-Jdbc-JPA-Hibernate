package com.springboot.jpahibernateinDepthpart3.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springboot.jpahibernateinDepthpart3.entity.Course;
import com.springboot.jpahibernateinDepthpart3.entity.Review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class CourseRepository {
	@Autowired
	EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Course findById(Long id) {
		return em.find(Course.class,id);
	}
	public Course save(Course course) {
		if(course.getId()==null) {
			em.persist(course);
		}
		else {
			em.merge(course);
		}
		
		return course;
	}
	public void deleteById(Long id) {
		Course course = em.find(Course.class, id);
		em.remove(course);
	}
	public void addReviewsForCourse() {
		//Get the course 103
		Course course = findById(103L);
		logger.info("\n course.getReviews() -> {}",course.getReviews());
		
		//Add 2 reviews to it
		Review review1 = new Review("5","Very Nice");
		Review review2 = new Review("4","Nice");
		
		//Setting the relationships
		course.addReviews(review1);
		review1.setCourse(course);
		
		course.addReviews(review2);
		review2.setCourse(course);
		
		//Save it to database
		em.persist(review1);
		em.persist(review2);
	}
}
