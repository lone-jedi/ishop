package com.yarkin.ishop.mappers;

import com.yarkin.ishop.entities.Product;
import com.yarkin.ishop.entities.User;
import org.apache.commons.text.StringEscapeUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserRowMapper {
    public User mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String email = StringEscapeUtils.escapeHtml4(resultSet.getString("email"));
        String passwordHash = resultSet.getString("password_hash");
        String passwordSalt = resultSet.getString("password_salt");

        User user = User.builder()
                .id(id)
                .email(email)
                .passwordHash(passwordHash)
                .passwordSalt(passwordSalt)
                .build();

        return user;
    }
}
