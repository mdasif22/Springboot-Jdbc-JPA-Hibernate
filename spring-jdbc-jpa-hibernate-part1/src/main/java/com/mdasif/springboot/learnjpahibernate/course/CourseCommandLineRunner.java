package com.mdasif.springboot.learnjpahibernate.course;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mdasif.springboot.learnjpahibernate.course.Course;
import com.mdasif.springboot.learnjpahibernate.course.jdbc.CourseJdbcRepo;
import com.mdasif.springboot.learnjpahibernate.course.jpa.CourseJpaRepo;
import com.mdasif.springboot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepo;

@Component
@Transactional
public class CourseCommandLineRunner implements CommandLineRunner{

// For CourseJdbcRepo class
//	@Autowired
//	private CourseJdbcRepo repo;
	
// For CourseJpaRepo class
//	@Autowired
//	private CourseJpaRepo repo;
	
	// For CourseSpringDataJpaRepo class
	@Autowired
	private CourseSpringDataJpaRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Course(1,"Learn Spring","Javed"));
		repo.save(new Course(2,"Learn Java","Irfan"));
		repo.save(new Course(3,"Learn Python","Asif"));
		
		//repo.deleteById(3l);
		
		System.out.println(repo.findById(1l));
		System.out.println(repo.findById(2l));
		System.out.println(repo.findById(3l));
		
		System.out.println(repo.findAll());
		System.out.println(repo.count());
		
		System.out.println(repo.findByAuthor("Asif"));
	}

}
