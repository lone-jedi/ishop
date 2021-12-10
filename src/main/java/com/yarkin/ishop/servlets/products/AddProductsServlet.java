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

public class AddProductsServlet extends HttpServlet {
    private final ProductService PRODUCT_SERVICE;

    public AddProductsServlet(ProductService productService) {
        PRODUCT_SERVICE = productService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(PageGenerator.instance().getPage("products/add.ftl"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = 0;

        try {
            price = Double.parseDouble(request.getParameter("price"));
            PRODUCT_SERVICE.add(name, price);
            response.sendRedirect("/products");
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
