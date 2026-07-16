package org.bootcamp.models;

import org.bootcamp.enums.Type;

import java.time.LocalDate;

public abstract class Transactions {
    private int id;
    private LocalDate date;
    private String description;
    private double amount;
    private Type type;
    private Category category;
    private User user;



    public Transactions(int id,LocalDate date, String description, double amount, Type type, Category category, User user) {
       this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.user = user;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
