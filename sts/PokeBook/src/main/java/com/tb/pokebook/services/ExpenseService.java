package com.tb.pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tb.pokebook.models.Expense;
import com.tb.pokebook.repositories.ExpenseRepo;

@Service
public class ExpenseService {

	private final ExpenseRepo expenseRepo;
	
	public ExpenseService(ExpenseRepo expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	//returns all items
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	//find one
	public Expense findExpense(Long id) {
		Optional<Expense>optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	public Expense createExpense(Expense b) {
		return expenseRepo.save(b);
	}
	
	public Expense updateExpense(Expense b) {
		return expenseRepo.save(b);
	}
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
}
