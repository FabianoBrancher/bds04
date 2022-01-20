package com.devsuperior.bds04.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	public EventDTO insert(EventDTO dto) {
		
		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setDate(dto.getDate());
		entity.setUrl(dto.getUrl());
		entity.setCity(new City(dto.getCityId(), ""));
		
		entity = repository.save(entity);
		
		return new EventDTO(entity);
	}
	
	public Page<EventDTO> findAllPaged(Pageable pageable) {
		Page<Event> page = repository.findAll(pageable);
		return page.map(event -> new EventDTO(event));
	}
}
