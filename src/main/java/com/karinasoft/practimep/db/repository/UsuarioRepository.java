package com.karinasoft.practimep.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karinasoft.practimep.domain.User;

public interface UsuarioRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
	Boolean existsByEmail(String email);

}
