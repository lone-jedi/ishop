package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.services.ProductService;
import com.yarkin.ishop.utils.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AllProductsServlet extends HttpServlet {
    private final ProductService PRODUCT_SERVICE;

    public AllProductsServlet(ProductService productService) {
        PRODUCT_SERVICE = productService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("products", PRODUCT_SERVICE.getAll());
        parameters.put("user_email", request.getSession().getAttribute("user_email"));

        response.getWriter().write(
                PageGenerator.instance().getPage("products/all.ftl", parameters));
    }
}
