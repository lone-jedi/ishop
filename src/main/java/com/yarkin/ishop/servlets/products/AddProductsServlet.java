package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.services.ProductService;
import com.yarkin.ishop.utils.templater.PageGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AddProductsServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // show form
        response.getWriter().print(PageGenerator.instance().getPage("products/add.ftl"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        productService.add(name, price);
        response.sendRedirect("/products");
    }
}
