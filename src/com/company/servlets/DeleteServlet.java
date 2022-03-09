package com.company.servlets;


import com.company.db.db_utils.AnswerDataBase;
import com.company.db.db_utils.MessageDataBase;
import com.company.db.db_utils.TopicDataBase;
import com.company.db.db_utils.UserDataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

//1 - answ
// 2 - Message
// 3 - Topic
// 4 - user

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int table = Integer.parseInt(req.getParameter("table"));
        switch (table) {
            case 1 -> {
                AnswerDataBase.getINSTANCE().removeByID(id);
                getServletContext().getRequestDispatcher("/topic.jsp").forward(req, resp);
            }
            case 2 -> {
                MessageDataBase.getINSTANCE().removeByID(id);
                getServletContext().getRequestDispatcher("/").forward(req, resp);
            }
            case 3 -> {
                TopicDataBase.getINSTANCE().removeByID(id);
                AnswerDataBase.getINSTANCE().removeByTopID(id);
                getServletContext().getRequestDispatcher("/topics.jsp").forward(req, resp);
            }
            case 4 -> {
                UserDataBase.getINSTANCE().removeByID(id);
                getServletContext().getRequestDispatcher("/users.jsp").forward(req, resp);
            }
            default -> getServletContext().getRequestDispatcher("/").forward(req, resp);
        }
    }
}
