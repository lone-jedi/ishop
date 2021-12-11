package com.yarkin.ishop.servlets.security;

import com.yarkin.ishop.services.SecurityService;
import com.yarkin.ishop.utils.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    private final SecurityService securityService;

    public LoginServlet(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                PageGenerator.instance().getPage("security/login.ftl")
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            securityService.login(email, password);
            request.getSession().setAttribute("user_email", email);
            response.sendRedirect("/");
        } catch (RuntimeException e) {
            response.getWriter().write(
                    PageGenerator.instance().getPage("security/login.ftl",
                            Map.of("error_message", e.getMessage(),
                                    "email", email))
            );
        }
    }
}
