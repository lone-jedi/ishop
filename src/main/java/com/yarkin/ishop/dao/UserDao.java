package com.yarkin.ishop.dao;

import com.yarkin.ishop.entities.Product;
import com.yarkin.ishop.entities.User;
import com.yarkin.ishop.mappers.ProductRowMapper;
import com.yarkin.ishop.mappers.UserRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final String SELECT_BY_EMAIL = """
            SELECT id, email, password_hash, password_salt FROM \"user\" WHERE email=?;
            """;
    private static final String INSERT = "INSERT INTO \"user\"(email, password_hash, password_salt) VALUES(?, ?, ?);";

    private static final UserRowMapper USER_ROW_MAPPER = new UserRowMapper();
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public void validate(User user) {

    }

    public void add(User newUser) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT);) {
            preparedStatement.setString(1, newUser.getEmail());
            preparedStatement.setString(2, newUser.getPasswordHash());
            preparedStatement.setString(3, newUser.getPasswordSalt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error with adding user " + newUser.getEmail(), e);
        }
    }

    public User getByEmail(String email) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_EMAIL);) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                resultSet.next();
                return USER_ROW_MAPPER.mapRow(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error with getting user by email=" + email, e);
        }
    }
}
