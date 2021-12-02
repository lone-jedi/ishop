package com.yarkin.ishop.dao;

import com.yarkin.ishop.entities.Product;
import com.yarkin.ishop.mappers.ProductRowMapper;
import com.yarkin.ishop.utils.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String SELECT_ALL = "SELECT id, name, price, creation_date FROM product";

    public static final ProductRowMapper PRODUCT_ROW_MAPPER = new ProductRowMapper();

    private final Connection connection = JdbcConnection.instance();


    public List<Product> getAll() {
        List<Product> result = null;

        try {
            ResultSet resultSet = connection.prepareStatement(SELECT_ALL).executeQuery();

            result = new ArrayList<>();
            while(resultSet.next()) {
                result.add(PRODUCT_ROW_MAPPER.mapRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
