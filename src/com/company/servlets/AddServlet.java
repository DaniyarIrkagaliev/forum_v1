package com.company.servlets;


import com.company.db.db_utils.AnswerDataBase;
import com.company.db.db_utils.MessageDataBase;
import com.company.db.db_utils.TopicDataBase;
import com.company.db.repository.Answer;
import com.company.db.repository.Message;
import com.company.db.repository.Topic;
import com.company.db.repository.User;
import com.company.servlets.builders.AnswHtmlFormBuilder;
import com.company.servlets.builders.MesHtmlFormBuilder;
import com.company.servlets.builders.TopHtmlFormBuilder;
import com.company.utils.CurrentTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "add", urlPatterns = {"/add"})
public class AddServlet extends HttpServlet {

//  1 - answ
// 2 - Message
// 3 - Topic

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String strTable = request.getParameter("table");
        if (strTable == null)
            strTable = "0";
        int table = Integer.parseInt(strTable);

        switch (table) {
            case 1 -> {
                String strTopic = request.getParameter("topic");
                if (strTopic == null)
                    strTopic = "0";
                int top = Integer.parseInt(strTopic);
                request.setAttribute("topic_id", top);
                request.setAttribute("form", AnswHtmlFormBuilder.getForm(top));
                System.out.println("TOP ID(get) = " + top);
            }
            case 2 -> {
                request.setAttribute("form", MesHtmlFormBuilder.getForm());
            }
            case 3 -> {
                request.setAttribute("form", TopHtmlFormBuilder.getForm());
            }
        }
        request.setAttribute("table", table);
        getServletContext().getRequestDispatcher("/add.jsp").forward(request, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        request.setCharacterEncoding("utf8");
        String strTable = request.getParameter("table");
        if (strTable == null)
            strTable = "0";
        int table = Integer.parseInt(strTable);


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);
        try {
            switch (table) {
                case 1 -> {
                    int top = Integer.parseInt(request.getParameter("topic_id"));
                    System.out.println("TOP ID(post) = " + top);
                    AnswerDataBase.getINSTANCE().add(new Answer(
                            1,
                            top,
                            request.getParameter("message"),
                            time,
                            currentUser.getID()));
                }
                case 2 -> MessageDataBase.getINSTANCE().add(new Message(
                        1,
                        currentUser.getID(),
                        request.getParameter("message"),
                        time));

                case 3 -> TopicDataBase.getINSTANCE().add(new Topic(
                        1,
                        request.getParameter("title"),
                        request.getParameter("description"),
                        time,
                        currentUser.getID()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/menu");
    }
}
