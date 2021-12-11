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
import java.util.HashMap;
import java.util.Map;

public class AddProductsServlet extends HttpServlet {
    private final ProductService productService;
    private final SecurityService securityService;

    public AddProductsServlet(ProductService productService, SecurityService securityService) {
        this.productService = productService;
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            securityService.auth((String) request.getSession().getAttribute("user_email"));
            response.getWriter().print(PageGenerator.instance().getPage("products/add.ftl"));
        } catch (AccessDeniedException e) {
            response.sendRedirect("/product/all?message=" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = 0;

        try {
            securityService.auth((String) request.getSession().getAttribute("user_email"));
            price = Double.parseDouble(request.getParameter("price"));
            productService.add(name, price);
            response.sendRedirect("/product/all");
        } catch (AccessDeniedException e) {
            response.sendRedirect("/product/all?message=" + e.getMessage());
        } catch (RuntimeException e) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", name);
            parameters.put("price", price);
            parameters.put("error_message", e.getMessage());
            response.getWriter().print(
                    PageGenerator.instance().getPage("products/add.ftl", parameters));
        }


    }
}
