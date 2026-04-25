package com.easyaudit.easyaudit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.easyaudit.entities.StatusNonConformities;
import com.easyaudit.easyaudit.repositories.StatusNonConformitiesRepository;

@Service
public class StatusNonConformitiesService {
	
	@Autowired
	private StatusNonConformitiesRepository repository;
	
	public List<StatusNonConformities> findAll() {
		return repository.findAll();
	}
	
	public StatusNonConformities findById(Long id) {
		Optional<StatusNonConformities> obj = repository.findById(id);
		return obj.get();
	}
}

