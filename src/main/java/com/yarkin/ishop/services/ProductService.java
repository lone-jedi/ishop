package com.yarkin.ishop.services;

import com.yarkin.ishop.dao.ProductDao;
import com.yarkin.ishop.entities.Product;

import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDao();

    public List<Product> getAll() {
        return productDao.getAll();
    }

    public void add(String name, double price) {
        add(new Product(name, price));
    }

    public void add(Product product) {
        productDao.add(product);
    }

    public void delete(long id) {
        productDao.delete(id);
    }
}
