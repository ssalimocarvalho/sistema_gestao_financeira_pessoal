package org.bootcamp.models;

import java.time.LocalDate;

public class Incomes extends Transactions {

    public Incomes(LocalDate date, String description, double amount, Category category, User user) {
        super(date, description, amount, category, user);
    }
    public Incomes() {
        super();
    }

    @Override
    public String algumasCoisa() {
        return "Algumas coisa de incomes";
    }
}
