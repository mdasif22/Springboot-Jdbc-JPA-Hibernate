package com.springboot.jpahibernateinDepthpart3;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springboot.jpahibernateinDepthpart3.entity.Course;
import com.springboot.jpahibernateinDepthpart3.repository.CourseRepository;
import com.springboot.jpahibernateinDepthpart3.repository.StudentRepository;

//This class is for all relationship related query n all.Here are all the methods.

@SpringBootApplication
public class RelationsApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository Studentrepo;
	@Autowired
	CourseRepository courseRepo;
	public static void main(String[] args) {
		SpringApplication.run(RelationsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Studentrepo.saveStudentWithPassport();
		
		courseRepo.addReviewsForCourse();
			
	}

}
