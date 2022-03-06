package com.company.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "topic", urlPatterns = {"/topic"})
public class TopicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        if (id != null) {
            req.setAttribute("id", Integer.parseInt(id));
            getServletContext().getRequestDispatcher("/topic.jsp").forward(req, resp);
        }
    }

}
