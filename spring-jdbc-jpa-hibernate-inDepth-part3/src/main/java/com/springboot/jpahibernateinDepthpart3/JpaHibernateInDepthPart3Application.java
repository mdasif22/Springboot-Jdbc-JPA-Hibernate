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

//This class is for whatever i have done about JPA Hibernate n all. Here is all the methods.

//@SpringBootApplication
public class JpaHibernateInDepthPart3Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository Courserepo;
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateInDepthPart3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = Courserepo.findById(101L);
		logger.info("\n Course 101 is -> {}",course);
		//Courserepo.deleteById(103L);
		//logger.info("\n Course 103 is deleted ");
		
		//If we comment @generatedvalue then we have to give the ID for user
		// If we give @generatedvalue then it will automatically generate id for user
//		logger.info("\n Inserting user 104 -> {}",Courserepo.save(new Course(104L,"Raju")));
//		logger.info("\n Inserting user 104 -> {}",Courserepo.save(new Course(105L,"Rabina")));
		
		logger.info("\n Inserting user 104 -> {}",Courserepo.save(new Course("Raju")));
		logger.info("\n Inserting user 104 -> {}",Courserepo.save(new Course("Rabina")));
		
	}

}
