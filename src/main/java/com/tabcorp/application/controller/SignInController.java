package com.tabcorp.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tabcorp.application.dao.UserRepository;
import com.tabcorp.application.entity.User;

import lombok.extern.slf4j.Slf4j;

/*
@Slf4j
@Validated
@RestController
@RequestMapping("/api/signin")
public class SignInController {
	
	@Autowired
    UserRepository repository;  
	
	
	@Autowired
    PasswordEncoder passwordEncoder;

    public SignInController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        //this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/")
    User signin(@RequestParam String email, @RequestParam String password) {
       User u = new User( null, email, passwordEncoder.encode(password), User.Role.USER, 0D);
        return repository.save(u);
    }

    @PostMapping("/validateEmail")
    Boolean emailExists(@RequestParam String email) {
        return repository.existsByEmail(email);
    }
    
}
*/