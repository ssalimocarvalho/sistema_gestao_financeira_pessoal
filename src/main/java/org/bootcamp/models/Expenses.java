package org.bootcamp.models;

import org.bootcamp.enums.Type;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;

public class Expenses extends Transactions{


    public Expenses(int id,LocalDate date, String description, double amount, Type type, Category category, User user) {
        super(id,date, description, amount, type, category, user);
    }
}
