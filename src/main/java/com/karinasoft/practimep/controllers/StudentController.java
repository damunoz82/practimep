package com.karinasoft.practimep.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.karinasoft.practimep.domain.Student;
import com.karinasoft.practimep.workers.StudentWorkers;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class StudentController {
	
	final static Logger logger = Logger.getLogger(StudentController.class);

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") int id) {
		
		logger.debug("In delete student - id: " + id);
		StudentWorkers worker = new StudentWorkers();
		worker.deleteStudent(id);

		return new ResponseEntity<>("Student was deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@PathVariable("id") String id, @Valid @RequestBody Student student) {
		
		logger.debug("In update student - student: " + student.toString());
		StudentWorkers worker = new StudentWorkers();
		worker.updateStudent(student);

		return new ResponseEntity<>("Student was updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) {
		
		logger.debug("In create student - student: " + student.toString());
		StudentWorkers worker = new StudentWorkers();
		worker.createStudent(student);

		return new ResponseEntity<>("Student was created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudents() {
		
		logger.debug("In get all student");
		StudentWorkers worker = new StudentWorkers();
		List<Student> students = worker.getAllStudents();
		
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getStudent(@PathVariable("id") int id) {
		
		logger.debug("In get student - id: " + id);
		StudentWorkers worker = new StudentWorkers();
		Student student = worker.getStudent(id);
		
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
}
