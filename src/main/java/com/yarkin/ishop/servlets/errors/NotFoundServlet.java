package com.yarkin.ishop.servlets.errors;

import com.yarkin.ishop.utils.templater.PageGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class NotFoundServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                PageGenerator.instance().getPage("errors/404.ftl",
                        Map.of("error_message", request.getParameter("error_message"))));
    }
}
