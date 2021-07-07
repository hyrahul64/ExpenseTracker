package com.rs.expensetracker.repo;

import com.rs.expensetracker.model.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
    @Override
    List<Expense> findAll();
}
