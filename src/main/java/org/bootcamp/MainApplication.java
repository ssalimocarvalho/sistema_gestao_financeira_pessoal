package org.bootcamp;

import org.bootcamp.db.DatabaseConnection;
import org.bootcamp.enums.Type;
import org.bootcamp.models.Category;
import org.bootcamp.models.Expenses;
import org.bootcamp.models.Incomes;
import org.bootcamp.models.Transactions;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class MainApplication {
    public static void main(String[] args)  {
        Category category1 =  new Category("Internet", Type.EXPENSES);
        Category category2 =  new Category("Salario", Type.INCOMES);
        category1.setName("Transporte");


        System.out.println(category1);



        Transactions incomes = new Incomes();
        Transactions expenses = new Expenses();


        System.out.println(incomes.algumasCoisa());
        System.out.println(expenses.algumasCoisa());



        try{
            Connection con = DatabaseConnection.databaseConnection();
            System.out.println("Conectado com sucesso com a base de dados");
        }catch (SQLException e){
            System.out.println("Erro ao conectar a base de dados");
            throw new RuntimeException(e);
        }




    }
}
