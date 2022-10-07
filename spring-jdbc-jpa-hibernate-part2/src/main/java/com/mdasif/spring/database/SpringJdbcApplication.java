package com.mdasif.spring.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mdasif.spring.database.entity.Person;
import com.mdasif.spring.database.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(SpringJdbcApplication.class);
	
	@Autowired
	PersonJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\n All users -> {}",dao.findAll());
		logger.info("\n Users 101 is : -> {}",dao.findById(101));
		logger.info("\n Users Md Raju is : -> {}",dao.findByName("Md Raju"));
		logger.info("\n Deleting user 103.. No of rows deleted is : -> {}",dao.deleteById(103));
		logger.info("\n Inserting user 104 -> {}",dao.insert(new Person(104,"Irfan Ali","AP",new Date())));
		logger.info("\n Inserting user 104 -> {}",dao.insert(new Person(103,"Javed Alam","Mumbai",new Date())));
		logger.info("\n Update user 102 : -> {}",dao.update(new Person(102,"Md Raju","Siwan",new Date())));
		
	}

}
