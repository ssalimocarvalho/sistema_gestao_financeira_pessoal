package org.bootcamp.models;

import org.bootcamp.enums.Type;

import java.time.LocalDate;

public class Incomes extends Transactions {


    public Incomes(int id,LocalDate date, String description, double amount, Type type, Category category, User user) {
        super(id,date, description, amount, type, category, user);
    }
}
