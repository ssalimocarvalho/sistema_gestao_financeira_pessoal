package org.bootcamp.models;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;

public class Expenses extends Transactions{
    public Expenses(LocalDate date, String description, double amount, Category category, User user) {
        super(date, description, amount, category, user);
    }
    public Expenses() {
        super();
    }

    @Override
    public String algumasCoisa() {
        return "Algumas coisa de Expenses";
    }
}
