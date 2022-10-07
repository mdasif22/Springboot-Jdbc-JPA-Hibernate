package com.mdasif.spring.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.mdasif.spring.database.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Person findById(int id){
		return entityManager.find(Person.class, id);
	}
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	public void deleteById(int id) {
		Person person = entityManager.find(Person.class, id);
		entityManager.remove(person);
	}
}
