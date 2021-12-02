package com.yarkin.ishop.mappers;

import com.yarkin.ishop.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProductRowMapper {
    public Product mapRow(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        Timestamp creationDate = resultSet.getTimestamp("creation_date");
        Product exam = Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .creationDate(creationDate)
                .build();
        return exam;
    }
}
