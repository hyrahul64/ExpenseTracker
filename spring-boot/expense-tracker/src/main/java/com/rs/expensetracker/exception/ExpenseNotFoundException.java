package com.rs.expensetracker.exception;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(String s) {
        super(s);
    }
}
