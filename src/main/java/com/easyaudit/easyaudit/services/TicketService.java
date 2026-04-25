package com.easyaudit.easyaudit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.easyaudit.entities.Ticket;
import com.easyaudit.easyaudit.repositories.TicketRepository;

@Service
public class TicketService {
	@Autowired
	private TicketRepository repository;
	
	public List<Ticket> findAll() {
		return repository.findAll();
	}
	
	public Ticket findById(Long id) {
		Optional<Ticket> obj = repository.findById(id);
		return obj.get();
	}
}
