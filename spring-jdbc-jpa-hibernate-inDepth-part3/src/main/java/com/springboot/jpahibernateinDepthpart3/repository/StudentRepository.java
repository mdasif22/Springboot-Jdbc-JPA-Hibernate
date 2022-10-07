package com.springboot.jpahibernateinDepthpart3.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.jpahibernateinDepthpart3.entity.Passport;
import com.springboot.jpahibernateinDepthpart3.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class,id);
	}
	
	public void saveStudentWithPassport() {
			Passport passport = new Passport("Md1245");
			em.persist(passport);
			
			Student student = new Student("Sabina");
			student.setPassport(passport);
			em.persist(student);
	}
	
//	public Student save(Student student) {
//		if(student.getId()==null) {
//			em.persist(student);
//		}
//		else {
//			em.merge(student);
//		}
//		
//		return student;
//	}
	public void deleteById(Long id) {
		Student student = em.find(Student.class, id);
		em.remove(student);
	}
}
