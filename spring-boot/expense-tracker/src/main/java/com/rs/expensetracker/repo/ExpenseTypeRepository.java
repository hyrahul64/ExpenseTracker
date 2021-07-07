package com.rs.expensetracker.repo;

import com.rs.expensetracker.model.ExpenseType;
import org.springframework.data.repository.CrudRepository;


public interface ExpenseTypeRepository extends CrudRepository<ExpenseType, Integer> {
}
