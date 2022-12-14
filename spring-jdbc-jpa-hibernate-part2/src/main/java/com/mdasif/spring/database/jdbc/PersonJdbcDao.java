package com.mdasif.spring.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mdasif.spring.database.entity.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate template;
	
	 class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthdate(rs.getTimestamp("birthdate"));
			return person;
		}
		 
	 }
	
	public List<Person> findAll(){
		return template.query("SELECT * FROM person", 
				new PersonRowMapper());
	}
	
	@SuppressWarnings("deprecation")
	public Person findById(int id){
		return template.queryForObject("SELECT * FROM person where id = ? ", new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	@SuppressWarnings("deprecation")
	public Person findByName(String name){
		return template.queryForObject("SELECT * FROM person where name = ? ", new Object[] {name},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id){
		return template.update("delete FROM person where id = ? ", new Object[] {id});
	}
	
	public int insert(Person person){
		return template.update("insert into person(id,name,location,birthdate)"
							  + " values(?,?,?,?);", new Object[] {person.getId(),person.getName(),
							  person.getLocation(),new Timestamp(person.getBirthdate().getTime())});
	}
	
	public int update(Person person){
		return template.update("update person "
							  + "set name = ?, location = ?, birthdate = ? "
							  + " where id = ? ;", new Object[] {person.getName(),
							  person.getLocation(),new Timestamp(person.getBirthdate().getTime()), person.getId() });
	}
	
	
}
