package com.kenya.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kenya.savetravels.models.Expense;
import com.kenya.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	// home route redirects to the expense route
	@GetMapping("/")
	public String home() {
		return "redirect:expenses";
	}

	// setting up the create method
	@GetMapping("/expenses")
	public String createEntry(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allDaEntries = expenseService.allEntries();
		model.addAttribute("allDaEntries", allDaEntries);
		return "index.jsp";
	}
	
	// Create a entry and redirecting after 
	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> allDaEntries = expenseService.allEntries();
			model.addAttribute("allDaEntries", allDaEntries);
			return "index.jsp";
		} else {
			expenseService.createEntry(expense);
			return "redirect:/expenses";
		}
	}
	
	// EDIT 
	@GetMapping("/edit/{id}")
	public String updateEntry(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findEntry(id);
		model.addAttribute("expense",expense);
		return "edit.jsp";
	}
	
	// Edit post 
	   @RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
	   public String updateEntry(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		   if(result.hasErrors()) {
			   return "edit.jsp";
		   } else {
			   expenseService.updateEntry(expense);
			   return "redirect:/";
		   }
	   }
	   
	   // Show one 
	   @GetMapping("/expense/{id}")
	   public String showOne(@PathVariable("id") Long id, Model model) {
		   Expense expense = expenseService.findEntry(id);
			model.addAttribute("expense",expense);
			return "display.jsp";
		   
	   }
	   
	   
	   // Delete 
	   @RequestMapping(value="/expense/{id}", method=RequestMethod.DELETE)
	   public String remove(@PathVariable("id") Long id) {
		   expenseService.deleteEntry(id);
		   return "redirect:/";
	   }
	   
	   

}
