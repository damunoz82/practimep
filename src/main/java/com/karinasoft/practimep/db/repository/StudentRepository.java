package com.karinasoft.practimep.db.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.karinasoft.practimep.domain.Student;

@Repository
public interface StudentRepository extends CassandraRepository<Student, Long>{

}
