package com.yarkin.ishop;

import com.yarkin.ishop.dao.ProductDao;
import com.yarkin.ishop.dao.UserDao;
import com.yarkin.ishop.services.ProductService;
import com.yarkin.ishop.services.SecurityService;
import com.yarkin.ishop.services.UserService;
import com.yarkin.ishop.servlets.errors.NotFoundServlet;
import com.yarkin.ishop.servlets.products.AddProductsServlet;
import com.yarkin.ishop.servlets.products.AllProductsServlet;
import com.yarkin.ishop.servlets.products.DeleteProductsServlet;
import com.yarkin.ishop.servlets.products.EditProductsServlet;
import com.yarkin.ishop.servlets.security.LoginServlet;
import com.yarkin.ishop.servlets.security.LogoutServlet;
import com.yarkin.ishop.servlets.security.RegistrationServlet;
import com.yarkin.ishop.utils.jdbc.logger.StatisticDataSource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;

public class Starter {
    private static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws Exception {
        // config
        final Connection CONNECTION = new StatisticDataSource().getConnection();
        final ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        // dao
        final ProductDao productDao = new ProductDao(CONNECTION);
        final UserDao userDao = new UserDao(CONNECTION);

        // service
        final ProductService productService = new ProductService(productDao);
        final UserService userService = new UserService(userDao);
        final SecurityService securityService = new SecurityService(userDao);

        // servlets
        final AddProductsServlet addProductsServlet = new AddProductsServlet(productService, securityService);
        final DeleteProductsServlet deleteProductsServlet = new DeleteProductsServlet(productService, securityService);
        final EditProductsServlet editProductsServlet = new EditProductsServlet(productService, securityService);
        final AllProductsServlet allProductsServlet = new AllProductsServlet(productService);

        final LoginServlet loginServlet = new LoginServlet(securityService);
        final LogoutServlet logoutServlet = new LogoutServlet();
        final RegistrationServlet registrationServlet = new RegistrationServlet(securityService);

        final NotFoundServlet notFoundServlet = new NotFoundServlet();

        // routing
        context.addServlet(new ServletHolder(addProductsServlet), "/product/add");
        context.addServlet(new ServletHolder(deleteProductsServlet), "/product/delete");
        context.addServlet(new ServletHolder(editProductsServlet), "/product/edit");
        context.addServlet(new ServletHolder(allProductsServlet), "/product/all");

        context.addServlet(new ServletHolder(loginServlet), "/login");
        context.addServlet(new ServletHolder(logoutServlet), "/logout");
        context.addServlet(new ServletHolder(registrationServlet), "/registration");

        context.addServlet(new ServletHolder(notFoundServlet), "/404");

        // TODO make home page
        context.addServlet(new ServletHolder(allProductsServlet), "/");

        // starting server
        Server server = new Server(DEFAULT_PORT);
        server.setHandler(context);
        server.start();
    }
}
