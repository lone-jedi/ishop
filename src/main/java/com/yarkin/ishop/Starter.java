package com.yarkin.ishop;

import com.yarkin.ishop.servlets.products.AddProductsServlet;
import com.yarkin.ishop.servlets.products.AllProductsServlet;
import com.yarkin.ishop.servlets.products.DeleteProductsServlet;
import com.yarkin.ishop.servlets.products.EditProductsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Starter {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws Exception {
        AddProductsServlet addProductsServlet = new AddProductsServlet();
        DeleteProductsServlet deleteProductsServlet = new DeleteProductsServlet();
        EditProductsServlet editProductsServlet = new EditProductsServlet();
        AllProductsServlet allProductsServlet = new AllProductsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(addProductsServlet), "/products/add");
        context.addServlet(new ServletHolder(deleteProductsServlet), "/products/delete");
        context.addServlet(new ServletHolder(editProductsServlet), "/products/edit");
        context.addServlet(new ServletHolder(allProductsServlet), "/products");

        Server server = new Server(DEFAULT_PORT);
        server.setHandler(context);

        server.start();
    }
}
