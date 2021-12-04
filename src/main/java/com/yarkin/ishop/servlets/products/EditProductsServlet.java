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
import java.util.Map;

public class EditProductsServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> parameters = new HashMap<>();

        try {
            long id = Long.parseLong(request.getParameter("id"));
            parameters.put("product", productService.get(id));
            response.getWriter().print(
                    PageGenerator.instance().getPage("products/edit.ftl", parameters));
        } catch(RuntimeException e) {
            response.sendRedirect("/404?error_message=" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        long id = Long.parseLong(request.getParameter("id"));;

        try {
            productService.update(id, name, price);
            response.sendRedirect("/products");
        } catch(RuntimeException e) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("product", new Product(id, name, price));
            parameters.put("error_message", e.getMessage());
            response.getWriter().print(
                    PageGenerator.instance().getPage("products/edit.ftl", parameters));
        }
    }
}
