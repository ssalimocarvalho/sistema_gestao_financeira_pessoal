package org.bootcamp.dao;

import org.bootcamp.db.DatabaseConnection;
import org.bootcamp.enums.Profile;
import org.bootcamp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public void createUser(User user) {

        String sql = "INSERT INTO users(name,email,password,profile) VALUES (?,?,?,?)";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){


            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getProfile().name());


            if(ps.executeUpdate()>0){
                System.out.println("User has been created");
            }else {
                System.out.println("User has not been created");
            }



        }catch (SQLException e){
            System.out.println("Nao foi possivel criar um usuario");
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateUser(int id) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }
}
