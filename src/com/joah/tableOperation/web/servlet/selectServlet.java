package com.joah.tableOperation.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "selectServlet",urlPatterns = "/com/joah/tableOperation/web/servlet/selectServlet")
public class selectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("this is selectServlet. ");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
