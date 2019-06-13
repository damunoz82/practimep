package com.karinasoft.practimep.db.repository;

import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.karinasoft.practimep.domain.Usuario;

public interface UsuarioRepository extends CassandraRepository<Usuario, Long> {
	
	Optional<Usuario> findByEmail(String email);
	
	Boolean existsByEmail(String email);

}
