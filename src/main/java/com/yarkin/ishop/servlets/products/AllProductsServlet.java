package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.entities.Product;
import com.yarkin.ishop.services.ProductService;
import com.yarkin.ishop.utils.templater.PageGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllProductsServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("products", products);
        response.getWriter().print(
                PageGenerator.instance().getPage("products/all.ftl", parameters));
    }
}
