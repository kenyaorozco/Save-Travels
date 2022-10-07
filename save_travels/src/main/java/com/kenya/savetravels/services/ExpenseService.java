package com.kenya.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenya.savetravels.models.Expense;
import com.kenya.savetravels.repositories.ExpenseRepo;

@Service
public class ExpenseService {
	
	@Autowired 
	private ExpenseRepo expenseRepo;

	// Get all entries 
	   public List<Expense> allEntries() {
	        return expenseRepo.findAll();
	    }
	   
	   // Create a new entry
	   public Expense createEntry(Expense e) {
	        return expenseRepo.save(e);
	    }
	   
	   // READ ONE ENTRY 
	   public Expense findEntry(Long id) {
	        Optional<Expense> optionalExpense = expenseRepo.findById(id);
	        if(optionalExpense.isPresent()) {
	            return optionalExpense.get();
	        } else {
	            return null;
	        }
	    }
	   
	   
	   //Update
	   public Expense updateEntry( Expense e) {
		   Expense updateEntry = expenseRepo.save(e);
		   return updateEntry;
		   
	   }
	   
	   // Delete 
	   
	   public void deleteEntry(Long id) {
		   expenseRepo.deleteById(id); 
	   }
	   
	   

}
