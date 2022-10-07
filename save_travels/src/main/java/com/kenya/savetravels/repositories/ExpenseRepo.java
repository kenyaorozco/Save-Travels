package com.kenya.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kenya.savetravels.models.Expense;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long> {
	
	List <Expense> findAll();
	
	
	
	

}