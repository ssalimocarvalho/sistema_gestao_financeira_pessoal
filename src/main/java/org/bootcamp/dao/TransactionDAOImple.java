package org.bootcamp.dao;

import org.bootcamp.db.DatabaseConnection;
import org.bootcamp.enums.Type;
import org.bootcamp.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransactionDAOImple implements TransactioDAO{

    @Override
    public void createTransaction(Transactions transaction) {
        String sql = "INSERT INTO transactions(amount,date,description,categoryId,userId,type) VALUES (?,?,?,?,?,?) RETURNING id";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){



            ps.setDouble(1, transaction.getAmount());
            ps.setDate(2, java.sql.Date.valueOf(transaction.getDate()));
            ps.setString(3, transaction.getDescription());
            ps.setInt(4, transaction.getCategory().getId());
            ps.setInt(5, transaction.getUser().getId());
            ps.setString(6, transaction.getType().name());

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                transaction.setId(rs.getInt("id"));
            }



        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTransaction(Transactions transaction) {
        String sql = "UPDATE  transactions SET amount=?,date=?,description=?,type=?,categoryId=?,userId=? WHERE id=? ";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){


            ps.setDouble(1, transaction.getAmount());
            ps.setDate(2, java.sql.Date.valueOf(transaction.getDate()));
            ps.setString(3, transaction.getDescription());
            ps.setString(4, transaction.getType().name());
            ps.setInt(5, transaction.getCategory().getId());
            ps.setInt(6, transaction.getUser().getId());

           ps.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTransaction(int id) {
        String sql = "DELETE FROM transactions WHERE id = ?";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transactions getTransactions(int id) {




        String sql = "SELECT * FROM transactions WHERE id = ?";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){

                CategoryDAO categoryDAO = new CategoryDAOImpl();
                UserDAO userDAO = new UserDAOImpl();
                double amount = rs.getDouble("amount");
                LocalDate date = rs.getDate("date").toLocalDate();
                String descriptions = rs.getString("descriptions");
                Type type = Type.valueOf(rs.getString("type"));
                int categoryId = rs.getInt("categoryId");
                int userId = rs.getInt("userId");

                Category category = categoryDAO.getCategory(categoryId);
                User user = userDAO.getUser(userId);


                if(Type.INCOMES.equals(type)){
                    return new Incomes(id,date,descriptions,amount,type,category,user);
                }else {
                    return new Expenses(id,date,descriptions,amount,type,category,user);
                }

            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public List<Transactions> showAllTransactions() {

        String sql = "SELECT * FROM transactions";
        List<Transactions> transactions = new ArrayList<>();
        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){


            ResultSet rs = ps.executeQuery();
            while (rs.next()){

                CategoryDAO categoryDAO = new CategoryDAOImpl();
                UserDAO userDAO = new UserDAOImpl();
                int id = rs.getInt("id");
                double amount = rs.getDouble("amount");
                LocalDate date = rs.getDate("date").toLocalDate();
                String descriptions = rs.getString("descriptions");
                Type type = Type.valueOf(rs.getString("type"));
                int categoryId = rs.getInt("categoryId");
                int userId = rs.getInt("userId");

                Category category = categoryDAO.getCategory(categoryId);
                User user = userDAO.getUser(userId);


                if(Type.INCOMES.equals(type)){
                    transactions.add(new Incomes(id,date,descriptions,amount,type,category,user));
                }else {
                    transactions.add(new Expenses(id,date,descriptions,amount,type,category,user));
                }

            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return transactions;
    }
}
