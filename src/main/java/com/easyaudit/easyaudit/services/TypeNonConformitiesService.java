package com.easyaudit.easyaudit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyaudit.easyaudit.entities.TypeNonConformities;
import com.easyaudit.easyaudit.repositories.TypeNonConformitiesRepository;

@Service
public class TypeNonConformitiesService {
	
	@Autowired
	private TypeNonConformitiesRepository repository;
	
	public List<TypeNonConformities> findAll() {
		return repository.findAll();
	}
	
	public TypeNonConformities findById(Long id) {
		Optional<TypeNonConformities> obj = repository.findById(id);
		return obj.get();
	}

}
