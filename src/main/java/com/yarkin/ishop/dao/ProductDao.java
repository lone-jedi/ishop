package com.yarkin.ishop.dao;

import com.yarkin.ishop.entities.Product;
import com.yarkin.ishop.mappers.ProductRowMapper;
import com.yarkin.ishop.utils.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String SELECT_ALL = "SELECT id, name, price, creation_date FROM product ORDER BY id DESC";
    public static final String INSERT = "INSERT INTO product(name, price) VALUES (?, ?);";
    private static final String DELETE_BY_ID = "DELETE FROM product WHERE id=?;";
    private static final String UPDATE = "UPDATE product SET name=?, price=? WHERE id=?;";
    private static final String SELECT_BY_ID = "SELECT id, name, price, creation_date FROM product WHERE id=?;";

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

    public void add(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(long id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setLong(3, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product get(long id) {
        Product product = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            product = PRODUCT_ROW_MAPPER.mapRow(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
