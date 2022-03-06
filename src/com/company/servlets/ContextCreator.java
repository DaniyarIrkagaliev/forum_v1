package com.company.servlets;

import com.company.db.db_utils.AnswerDataBase;
import com.company.db.db_utils.MessageDataBase;
import com.company.db.db_utils.TopicDataBase;
import com.company.db.db_utils.UserDataBase;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextCreator implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContextListener.super.contextInitialized(servletContextEvent);
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("messagesC", MessageDataBase.getINSTANCE());
        servletContext.setAttribute("usersC", UserDataBase.getINSTANCE());
        servletContext.setAttribute("topicsC", TopicDataBase.getINSTANCE());
        servletContext.setAttribute("answersC", AnswerDataBase.getINSTANCE());
    }
}
