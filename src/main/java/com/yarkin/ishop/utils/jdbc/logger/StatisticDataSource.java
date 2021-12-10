package com.yarkin.ishop.utils.jdbc.logger;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

public class StatisticDataSource implements DataSource, AutoCloseable {
    // TODO Make better db name, default user & default password configuration
    private static final String DEFAULT_DB_URL = "jdbc:postgresql://127.0.0.1:5432/ishop";
    private static final String DEFAULT_DB_USER = "postgres";
    private static final String DEFAULT_DB_PASSWORD = "121212";

    private Connection connection;

    @Override
    public Connection getConnection()  {
        try {
            return getConnection(DEFAULT_DB_USER, DEFAULT_DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot open connection", e);
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        if(connection == null) {
            connection = new StatisticConnection(DriverManager.getConnection(DEFAULT_DB_URL, username, password));
        }
        return connection;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }
}
