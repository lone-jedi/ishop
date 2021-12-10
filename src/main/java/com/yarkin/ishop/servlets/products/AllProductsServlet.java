package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.entities.Product;
import com.yarkin.ishop.services.ProductService;
import com.yarkin.ishop.utils.templater.PageGenerator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllProductsServlet extends HttpServlet {
    private static final ProductService PRODUCT_SERVICE = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(
                PageGenerator.instance().getPage("products/all.ftl",
                        Map.of("products", PRODUCT_SERVICE.getAll())));
    }
}
