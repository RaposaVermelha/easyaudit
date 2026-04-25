package com.easyaudit.easyaudit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.easyaudit.entities.TicketTypeNonConformity;
import com.easyaudit.easyaudit.repositories.TicketTypeNonConformityRepository;

@Service
public class TicketTypeNonConformityService {
	
	@Autowired
	private TicketTypeNonConformityRepository repository;
	
	public List<TicketTypeNonConformity> findAll() {
		return repository.findAll();
	}
	
	public TicketTypeNonConformity findById(Long id) {
		Optional<TicketTypeNonConformity> obj = repository.findById(id);
		return obj.get();
	}

}
