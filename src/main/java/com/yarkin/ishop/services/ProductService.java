package com.yarkin.ishop.services;

import com.yarkin.ishop.dao.ProductDao;
import com.yarkin.ishop.entities.Product;

import java.util.List;
import java.util.Objects;

public class ProductService {
    ProductDao productDao = new ProductDao();

    public List<Product> getAll() {
        return productDao.getAll();
    }

    public void add(String name, double price) {
        add(new Product(name.trim(), price));
    }

    public void add(Product product) {
        validate(product);
        productDao.add(product);
    }

    public void delete(long id) {
        productDao.delete(id);
    }

    public void update(long id, String name, double price) {
        update(id, new Product(name, price));
    }

    public void update(long id, Product product) {
        validate(product);
        productDao.update(id, product);
    }

    public Product get(long id) {
        return productDao.get(id);
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
