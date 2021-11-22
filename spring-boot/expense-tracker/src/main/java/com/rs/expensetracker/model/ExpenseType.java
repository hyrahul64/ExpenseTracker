package com.rs.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ExpenseType {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name =  "expense_id")
    private Expense expense;

    @Column(name = "expense_type_key")
    private String expenseTypeKey;

    @Column(name = "expense_type_value")
    private String expenseTypeValue;

    public ExpenseType(){}

    public ExpenseType(Expense expense, String expenseTypeKey, String expenseTypeValue) {
        this.expenseTypeKey = expenseTypeKey;
        this.expenseTypeValue = expenseTypeValue;
        this.expense = expense;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public String getExpenseTypeKey() {
        return expenseTypeKey;
    }

    public void setExpenseTypeKey(String expenseTypeKey) {
        this.expenseTypeKey = expenseTypeKey;
    }

    public String getExpenseTypeValue() {
        return expenseTypeValue;
    }

    public void setExpenseTypeValue(String expenseTypeValue) {
        this.expenseTypeValue = expenseTypeValue;
    }

    @Override
    public String toString() {
        return "ExpenseType{" +
                "id=" + id +
                ", expense_id=" + expense.getId() +
                ", expenseTypeKey='" + expenseTypeKey + '\'' +
                ", expenseTypeValue='" + expenseTypeValue + '\'' +
                '}';
    }
}
