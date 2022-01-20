package com.devsuperior.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;
	
	@Transactional
	public CityDTO insert(CityDTO dto) {
		City newCity = new City();
		newCity.setId(dto.getId());
		newCity.setName(dto.getName());
		
		newCity = repository.save(newCity);
		
		return new CityDTO(newCity);
	}
	
	@Transactional
	public List<CityDTO> findAll() {
		List<City> list = repository.findAll(Sort.by("name"));
		return list.stream().map(city -> new CityDTO(city)).collect(Collectors.toList());
	}
	
}
