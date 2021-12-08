package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.services.ProductService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteProductsServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long id = Long.parseLong(request.getParameter("id"));
            productService.delete(id);
            response.sendRedirect("/products");
        } catch(RuntimeException e) {
            response.sendRedirect("/404?error_message=" + e.getMessage());
        }
    }
}
