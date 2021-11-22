package com.rs.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name ="cost")
    private Integer cost;

    @Column(name = "date")
    private String date;

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "expense")
    private Set<ExpenseType> expenseTypes = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public Expense(){}

    public Expense(String description, Integer cost, String date, String type) {
        this.description = description;
        this.date = date;
        this.cost = cost;
        this.type = type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addExpenseType(ExpenseType expenseType) {
        expenseTypes.add(expenseType);
    }

    public Set<ExpenseType> getExpenseTypes() {
        return expenseTypes;
    }
    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
