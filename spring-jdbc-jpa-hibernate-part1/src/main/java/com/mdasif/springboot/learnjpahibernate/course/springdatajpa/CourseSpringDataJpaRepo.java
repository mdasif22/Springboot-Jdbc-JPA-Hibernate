package com.mdasif.springboot.learnjpahibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mdasif.springboot.learnjpahibernate.course.Course;

public interface CourseSpringDataJpaRepo extends JpaRepository<Course, Long>{
	List<Course> findByAuthor(String author);
}
