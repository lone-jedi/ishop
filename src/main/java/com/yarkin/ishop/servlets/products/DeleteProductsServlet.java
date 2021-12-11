package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.exceptions.AccessDeniedException;
import com.yarkin.ishop.services.ProductService;
import com.yarkin.ishop.services.SecurityService;
import com.yarkin.ishop.utils.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteProductsServlet extends HttpServlet {
    private final SecurityService securityService;
    private final ProductService productService;

    public DeleteProductsServlet(ProductService productService, SecurityService securityService) {
        this.productService = productService;
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            securityService.auth((String) request.getSession().getAttribute("user_email"));
            long id = Long.parseLong(request.getParameter("id"));
            productService.delete(id);
            response.sendRedirect("/product/all");
        } catch (AccessDeniedException e) {
            response.sendRedirect("/product/all?message=" + e.getMessage());
        } catch (RuntimeException e) {
            response.sendRedirect("/404?error_message=" + e.getMessage());
        }
    }
}
