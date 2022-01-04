package com.tb.pokebook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tb.pokebook.models.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long>{
	List <Expense> findByExpenseContaining(String expense);
	
	List<Expense> findAll();
	
	Optional<Expense> findById(Long id);
	
	void deleteById(Long id);
	
//	Book save();
	
}
