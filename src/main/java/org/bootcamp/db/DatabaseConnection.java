package org.bootcamp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/sistema_de_gestao_financeira_v2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection databaseConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
