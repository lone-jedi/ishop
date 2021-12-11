package com.yarkin.ishop.servlets.security;

import com.yarkin.ishop.services.SecurityService;
import com.yarkin.ishop.utils.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RegistrationServlet extends HttpServlet {
    private final SecurityService securityService;

    public RegistrationServlet(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                PageGenerator.instance().getPage("security/registration.ftl")
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            securityService.register(email, password);
            response.sendRedirect("/login");
        } catch (RuntimeException e) {
            response.getWriter().write(
                    PageGenerator.instance().getPage("security/registration.ftl",
                            Map.of("error_message", e.getMessage(),
                                    "email", email))
            );
        }
    }
}
