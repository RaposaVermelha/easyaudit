package com.easyaudit.easyaudit.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyaudit.easyaudit.entities.User;
import com.easyaudit.easyaudit.services.UserService;

//registra como Controller
@RestController
@RequestMapping(value = "/users") //teste de rota
public class UserResource {
	
	//injeção de dependecia a partir da classe UserService, bem melhor do que usar meteodo construtor :D
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // retorna a lista de usuario no body
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//dados mockados
	/*
	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Raposo", "123", "raposo@gmail.com");
		return ResponseEntity.ok().body(u); // retorna o usuario no body
	}
	*/
}
