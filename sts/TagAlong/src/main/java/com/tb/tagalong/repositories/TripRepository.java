package com.tb.tagalong.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tb.tagalong.models.Trip;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long>{
	
	Optional<Trip> findById(Long id);
	
	List<Trip> findAll();
	
	void deleteById(Long id);
	
	List<Trip> findByLocationContaining(String search);
	
//	Trip save(Trip t);
}
