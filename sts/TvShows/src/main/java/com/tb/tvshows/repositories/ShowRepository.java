package com.tb.tvshows.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tb.tvshows.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{

	Optional<Show> findById(Long id);
	
	List<Show> findAll();
	
	void deleteById(Long id);
	
//	Show save(Show s);
}
