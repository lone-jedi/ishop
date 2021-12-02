package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.services.ProductService;
import jakarta.servlet.http.HttpServlet;

public class EditProductsServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
}
