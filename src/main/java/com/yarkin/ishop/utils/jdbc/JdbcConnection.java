package com.yarkin.ishop.utils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/ishop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "121212";

    private static Connection connection;

    public static Connection instance() {
        if(connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
