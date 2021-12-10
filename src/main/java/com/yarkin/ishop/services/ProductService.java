package com.yarkin.ishop.services;

import com.yarkin.ishop.dao.ProductDao;
import com.yarkin.ishop.entities.Product;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class ProductService {
    private final ProductDao PRODUCT_DAO;

    public ProductService(ProductDao productDao) {
        PRODUCT_DAO = productDao;
    }

    public List<Product> getAll() {
        List<Product> products = PRODUCT_DAO.getAll();
        log.info("Get all products: {}", products.stream()
                .map(product -> String.valueOf(product))
                .collect(Collectors.joining("\n\t", "\n{\n\t", "\n}")));
        return products;
    }

    public void add(String name, double price) {
        add(new Product(name.trim(), price));
    }

    public void add(Product product) {
        validate(product);
        PRODUCT_DAO.add(product);
    }

    public void delete(long id) {
        PRODUCT_DAO.delete(id);
    }

    public void update(long id, String name, double price) {
        update(id, new Product(name, price));
    }

    public void update(long id, Product product) {
        validate(product);
        PRODUCT_DAO.update(id, product);
        log.info("Update product with id={} to {}", id, product);
    }

    public Product get(long id) {
        Product product = PRODUCT_DAO.get(id);
        log.info("Get product: {}", product);
        return product;
    }

    public boolean validate(Product product) {
        if(product.getName() == null ||
                Objects.equals(product.getName().trim(), "")) {
            throw new RuntimeException("Product name is empty");
        }

        if(product.getPrice() < 0) {
            throw new RuntimeException("Price '" + product.getPrice() + "'cannot be less than zero!");
        }

        return true;
    }
}
