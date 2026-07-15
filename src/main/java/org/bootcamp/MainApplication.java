package org.bootcamp;

import org.bootcamp.enums.Type;
import org.bootcamp.models.Category;
import org.bootcamp.models.Expenses;
import org.bootcamp.models.Incomes;
import org.bootcamp.models.Transactions;

import java.math.BigDecimal;

public class MainApplication {
    public static void main(String[] args) {
        Category category1 =  new Category("Internet", Type.EXPENSES);
        Category category2 =  new Category("Salario", Type.INCOMES);
        category1.setName("Transporte");


        System.out.println(category1);



        Transactions incomes = new Incomes();
        Transactions expenses = new Expenses();


        System.out.println(incomes.algumasCoisa());
        System.out.println(expenses.algumasCoisa());



    }
}
