package com.tb.pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tb.pokebook.models.Expense;
import com.tb.pokebook.services.ExpenseService;

@Controller
public class MainController {
	
	public final ExpenseService expenseServ;
	public MainController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		List<Expense> expenses = expenseServ.allExpenses();
//		model.addAttribute("expense", expenses);
//		return "index.jsp";
//	}
	
	//==========================
	//create routes and index
	//==========================
	@RequestMapping("/expenses")
	public String index(@ModelAttribute("exp") Expense expense, Model model) {
		List<Expense> expenses = expenseServ.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
		}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createExpense(@Valid @ModelAttribute("exp") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseServ.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expenseServ.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	//==========================
	//show one route
	//==========================
	@RequestMapping("/expenses/{id}")
	public String showone(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseServ.findExpense(id);
		model.addAttribute("expense", expense);
		return "showone.jsp";
	}
	
	//==========================
	//edit routes
	//==========================
	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseServ.findExpense(id);
		model.addAttribute("exp", expense);
		return "edit.jsp";
	}
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("exp") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseServ.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	//==========================
	//delete routes
	//==========================
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/expenses";
	}
}
