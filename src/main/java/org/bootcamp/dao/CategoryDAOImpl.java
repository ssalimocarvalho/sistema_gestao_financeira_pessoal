package org.bootcamp.dao;

import org.bootcamp.db.DatabaseConnection;
import org.bootcamp.enums.Type;
import org.bootcamp.models.Category;
import org.bootcamp.models.Expenses;
import org.bootcamp.models.Incomes;
import org.bootcamp.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public void createCategory(Category category) {
        String sql = "INSERT INTO category(name,type) VALUES (?,?) RETURNING id";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {


            ps.setString(1, category.getName());
            ps.setString(2,category.getType().name());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                category.setId(rs.getInt("id"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        }

    @Override
    public void updateCategory(Category category) {
        String sql = "UPDATE  category SET name = ?, type=? WHERE id=? ";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {


            ps.setString(1, category.getName());
            ps.setString(2,category.getType().name());

            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCategory(int id) {
        String sql = "DELETE FROM category WHERE id = ?";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);
            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category getCategory(int id) {


        String sql = "SELECT * FROM category WHERE id = ?";

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String nameCategory = rs.getString("name");
                Type typeCategory = Type.valueOf(rs.getString("type"));

                return new Category(id,nameCategory,typeCategory);

            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Category> showAllCategory() {
        String sql = "SELECT * FROM category";

        List<Category> categoryList = new ArrayList<>();

        try(Connection connection = DatabaseConnection.databaseConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){


            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String nameCategory = rs.getString("name");
                Type typeCategory = Type.valueOf(rs.getString("type"));

                categoryList.add(new Category(id,nameCategory,typeCategory));

            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return categoryList;
    }
}
