package com.yarkin.ishop.servlets.products;

import com.yarkin.ishop.entities.Product;
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

public class EditProductsServlet extends HttpServlet {
    private final ProductService productService;
    private final SecurityService securityService;

    public EditProductsServlet(ProductService productService, SecurityService securityService) {
        this.productService = productService;
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            securityService.auth((String) request.getSession().getAttribute("user_email"));
            long id = Long.parseLong(request.getParameter("id"));
            response.getWriter().print(
                    PageGenerator.instance().getPage("products/edit.ftl",
                            Map.of("product", productService.get(id))));
        } catch (AccessDeniedException e) {
            response.sendRedirect("/product/all?message=" + e.getMessage());
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
            securityService.auth((String) request.getSession().getAttribute("user_email"));
            productService.update(id, name, price);
            response.sendRedirect("/product/all");
        } catch (AccessDeniedException e) {
            response.sendRedirect("/product/all?message=" + e.getMessage());
        } catch(RuntimeException e) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("product", new Product(id, name, price));
            parameters.put("error_message", e.getMessage());
            response.getWriter().print(
                    PageGenerator.instance().getPage("products/edit.ftl", parameters));
        }
    }
}
