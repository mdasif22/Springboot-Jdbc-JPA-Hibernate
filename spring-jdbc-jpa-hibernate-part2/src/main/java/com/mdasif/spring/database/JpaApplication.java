package com.mdasif.spring.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mdasif.spring.database.entity.Person;
import com.mdasif.spring.database.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n Inserting user 1 -> {}",repository.insert(new Person(1,"Md Asif","Pune",new Date())));
		logger.info("\n Inserting user 2 -> {}",repository.insert(new Person(2,"Irfan Ali","AP",new Date())));
		logger.info("\n Inserting user 3 -> {}",repository.insert(new Person(3,"Javed","UP",new Date())));
		logger.info("\n Inserting user 1 -> {}",repository.insert(new Person("Md Asif","Pune",new Date())));

		logger.info("\n Update user 2 : -> {}",repository.update(new Person(2,"Md Raju","Siwan",new Date())));
		logger.info("\n Users 2 is : -> {}",repository.findById(2));
		repository.deleteById(3);
		
	}

}
