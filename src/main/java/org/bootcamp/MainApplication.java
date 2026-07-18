package org.bootcamp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bootcamp.dao.UserDAO;
import org.bootcamp.dao.UserDAOImpl;
import org.bootcamp.db.DatabaseConnection;
import org.bootcamp.enums.Profile;
import org.bootcamp.enums.Type;
import org.bootcamp.models.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/main.fxml"));

        Scene scene = new Scene(loader.load(), 700,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistma de gestao financeira");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
