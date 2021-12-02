package com.yarkin.ishop.servlets.products;

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
        long id = Long.parseLong(request.getParameter("id"));
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("product", productService.get(id));
        response.getWriter().print(
                PageGenerator.instance().getPage("products/edit.ftl", parameters));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        productService.update(id, name, price);
        response.sendRedirect("/products");
    }
}
