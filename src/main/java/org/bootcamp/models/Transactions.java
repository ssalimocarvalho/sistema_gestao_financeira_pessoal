package org.bootcamp.models;

import java.time.LocalDate;

public abstract class Transactions {
    private LocalDate date;
    private String description;
    private double amount;
    private Category category;
    private User user;


    public Transactions(LocalDate date, String description, double amount, Category category, User user) {
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.user = user;
    }

    public Transactions() {

    }


   public abstract String algumasCoisa();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
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
