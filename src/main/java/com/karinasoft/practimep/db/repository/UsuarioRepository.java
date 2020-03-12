package com.karinasoft.practimep.db.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.karinasoft.practimep.domain.User;

public interface UsuarioRepository extends CassandraRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
	Boolean existsByEmail(String email);

}
