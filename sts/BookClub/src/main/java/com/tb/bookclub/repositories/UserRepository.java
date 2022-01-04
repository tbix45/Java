package com.tb.bookclub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tb.bookclub.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Long id);

}
