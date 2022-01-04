package com.tb.dojosandninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tb.dojosandninjas.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {

	List<Ninja> findByFirstNameContaining(String firstName);
	
	List<Ninja> findAll(); 
	
	Optional<Ninja> findById(Long id); 
	
	void deleteById(Long id);
	
	//Dojo save (Dojo dojo);
}
