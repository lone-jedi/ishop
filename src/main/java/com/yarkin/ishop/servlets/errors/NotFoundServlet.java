package com.yarkin.ishop.servlets.errors;

import com.yarkin.ishop.utils.templater.PageGenerator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
