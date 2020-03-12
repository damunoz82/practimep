package com.karinasoft.practimep.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karinasoft.practimep.config.security.CurrentUser;
import com.karinasoft.practimep.config.security.UserPrincipal;
import com.karinasoft.practimep.db.repository.UsuarioRepository;
import com.karinasoft.practimep.domain.User;
import com.karinasoft.practimep.exceptions.ResourceNotFoundException;

@RestController
public class UserController {

    @Autowired
    private UsuarioRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findByEmail(userPrincipal.getName())
                .orElseThrow(
                		() -> new ResourceNotFoundException("User", "id", userPrincipal.getName()));
    }
}
