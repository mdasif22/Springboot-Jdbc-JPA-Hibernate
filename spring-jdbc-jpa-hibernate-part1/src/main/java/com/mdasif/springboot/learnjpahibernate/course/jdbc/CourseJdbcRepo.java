package com.mdasif.springboot.learnjpahibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mdasif.springboot.learnjpahibernate.course.Course;

@Repository
public class CourseJdbcRepo {
	@Autowired
	private JdbcTemplate springJdbcTemp;
	private static String INSERT_QUERY ="insert into COURSE(id,name,author) values(?,?,?); ";
	private static String DELETE_QUERY ="delete from COURSE where id = ? ";
	private static String SELECT_QUERY ="select * from COURSE where id = ? ";
	
	public void insert(Course course) {
		springJdbcTemp.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
		
	}
	public void delete(long id) {
		springJdbcTemp.update(DELETE_QUERY,id);
		
	}
	public Course select(long id) {
		return springJdbcTemp.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
		
	}
	
}
