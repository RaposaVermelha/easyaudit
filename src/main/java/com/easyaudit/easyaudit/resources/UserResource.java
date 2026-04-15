package com.easyaudit.easyaudit.resources;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyaudit.easyaudit.entities.User;

@RestController
@RequestMapping(value = "/users") //teste de rota
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Raposo", "123", "raposo@gmail.com");
		return ResponseEntity.ok().body(u); // retorna o usuario no body
	}
}
