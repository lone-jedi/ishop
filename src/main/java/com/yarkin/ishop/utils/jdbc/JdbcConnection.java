package com.yarkin.ishop.utils.jdbc;

import com.yarkin.ishop.utils.jdbc.logger.StatisticDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConnection {
    private static Connection connection;

    public static Connection instance() {
        if(connection == null) {
            try {
                connection = new StatisticDataSource().getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Cannot open database connection", e);
            }
        }
        return connection;
    }
}
