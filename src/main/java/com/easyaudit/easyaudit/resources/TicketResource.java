package com.easyaudit.easyaudit.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyaudit.easyaudit.entities.Ticket;
import com.easyaudit.easyaudit.services.TicketService;


@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {
	
	@Autowired
	private TicketService service;
	
	@GetMapping
	public ResponseEntity<List<Ticket>> findAll() {
		List<Ticket> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable Long id) {
		Ticket obj = service.findById(id);
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
