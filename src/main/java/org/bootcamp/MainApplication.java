package org.bootcamp;

import org.bootcamp.dao.UserDAO;
import org.bootcamp.dao.UserDAOImpl;
import org.bootcamp.db.DatabaseConnection;
import org.bootcamp.enums.Profile;
import org.bootcamp.enums.Type;
import org.bootcamp.models.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class MainApplication {
    public static void main(String[] args)  {
        Category category1 =  new Category("Internet", Type.EXPENSES);
        Category category2 =  new Category("Salario", Type.INCOMES);
        category1.setName("Transporte");


        System.out.println(category1);






        UserDAO userDAO = new UserDAOImpl();
        User user  = new User(0,"Salimo","ssalimo.carvalho@gmail.com","1233", Profile.ADMIN);
        userDAO.createUser(user);


    }
}
