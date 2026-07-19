package org.bootcamp.enums;

public enum Type {
    INCOMES("Incomes"),
    EXPENSES("Expenses");

    private final String description;

    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
