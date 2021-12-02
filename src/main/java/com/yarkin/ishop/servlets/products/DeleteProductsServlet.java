package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.services.ProductService;
import jakarta.servlet.http.HttpServlet;

public class DeleteProductsServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
}
