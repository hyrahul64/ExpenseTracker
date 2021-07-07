package com.rs.expensetracker.service;

import com.rs.expensetracker.model.Expense;
import com.rs.expensetracker.repo.ExpenseRepository;
import com.rs.expensetracker.exception.ExpenseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ExpenseDataService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense findById(Integer id) {
        if(expenseRepository.existsById(id)) {
            return expenseRepository.findById(id).get();
        } else {
            throw new ExpenseNotFoundException("Expense not found.");
        }
    }

    public void deleteById(Integer id) {
        if(expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        } else {
            throw new ExpenseNotFoundException("Expense not found.");
        }
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Expense expense) {
        if(expenseRepository.existsById(expense.getId())) {
            expenseRepository.delete(expense);
        } else {
            throw new ExpenseNotFoundException("Expense not found.");
        }
    }

}
