package com.karinasoft.practimep.workers;

import java.util.List;

import org.springframework.data.cassandra.core.CassandraOperations;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.querybuilder.Select.Where;
import com.karinasoft.practimep.domain.Student;

public class StudentWorkers {

	private CassandraOperations cassandraTemplate;
	
	public StudentWorkers(CassandraOperations cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}
	
	public boolean deleteStudent(int id) {
		Student student = getStudent(id);
		
		cassandraTemplate.delete(student);
		return true;
	}
	
	public Student updateStudent(Student student) {
		cassandraTemplate.update(student);
		return student;
	}
	
	public Student createStudent(Student student) {
		cassandraTemplate.insert(student);
		return student;
	}
	
	public List<Student> getAllStudents() {
		Select selectAllStudents = QueryBuilder.select().from("student");
		List<Student> students = cassandraTemplate.select(selectAllStudents, Student.class);
		return students;
	}
	
	public Student getStudent(int id) {
		Where filterStudentById = QueryBuilder.select().from("student").where(QueryBuilder.eq("id", id));
		Student student = cassandraTemplate.selectOne(filterStudentById, Student.class);
		
		return student;
	}
}
