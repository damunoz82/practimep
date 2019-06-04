package com.karinasoft.practimep.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Select.Where;
import com.karinasoft.practimep.domain.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class StudentController {

	@Autowired
	private CassandraOperations cassandraTemplate;
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") String id) {
		System.out.println("In Delete Student..., deleting id");
		
		Where select = QueryBuilder.select().from("student").where(QueryBuilder.eq("id", id));
		Student student = cassandraTemplate.selectOne(select, Student.class);
		
		cassandraTemplate.delete(student);

		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
		System.out.println("In Update Student..., updateing: " + student.toString());
		
		cassandraTemplate.update(student);

		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		System.out.println("In Create Student..., saving: " + student.toString());
		
		cassandraTemplate.insert(student);

		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudents() {
		System.out.println("In get all Students Student...");
		
		Select select = QueryBuilder.select().from("student");
		List<Student> students = cassandraTemplate.select(select, Student.class);
		
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudent(@PathVariable("id") int id) {
		System.out.println("In get single Students Student..., id: " + id);
		
		Where select = QueryBuilder.select().from("student").where(QueryBuilder.eq("id", id));
		Student student = cassandraTemplate.selectOne(select, Student.class);
		
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
}
