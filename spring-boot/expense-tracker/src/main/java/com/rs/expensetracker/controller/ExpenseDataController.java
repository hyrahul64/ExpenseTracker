package com.rs.expensetracker.controller;

import com.rs.expensetracker.model.Expense;
import com.rs.expensetracker.service.ExpenseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class ExpenseDataController {

    @Autowired
    private ExpenseDataService expenseDataService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseDataService.findAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpense(@PathVariable("id") String id) {
        Integer expenseId = Integer.parseInt(id);
        return expenseDataService.findById(expenseId);
    }

    @DeleteMapping("/expenses/{id}")
    public void deleteExpense(@PathVariable("id") String id) {
        System.out.println("ExpenseDataController.deleteExpense -> " + id);
        Integer expenseId = Integer.parseInt(id);
        expenseDataService.deleteById(expenseId);
    }

    @PostMapping("/expenses")
    public Expense saveExpense(@RequestBody Expense expense) {
        return expenseDataService.saveExpense(expense);
    }

    @PutMapping("/expenses/{id}")
    public void updateExpense(@PathVariable("id") String id, @RequestBody Expense expense) {
        System.out.println("ExpenseDataController.updateExpense -> " + expense.toString());
        Integer expenseId = Integer.parseInt(id);
        if(expenseDataService.findById(expenseId) != null) {
            expenseDataService.saveExpense(expense);
        }
    }
}
