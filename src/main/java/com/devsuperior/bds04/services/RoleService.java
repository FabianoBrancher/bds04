package com.devsuperior.bds04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.RoleDTO;
import com.devsuperior.bds04.entities.Role;
import com.devsuperior.bds04.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository repository;
	
	public RoleDTO insert(Long id, String authority) {
		Role entity = new Role(id, authority);
		entity = repository.save(entity);
		return new RoleDTO(entity);
	}
	
}
