package com.tb.dojosandninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tb.dojosandninjas.models.Dojo;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long>{

	List<Dojo> findAll();
	
	Optional<Dojo> findById(Long id); 
	
	void deleteById(Long id);
	
	//Dojo save (Dojo dojo);
}
