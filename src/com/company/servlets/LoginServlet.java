package com.company.servlets;

import com.company.db.db_utils.UserDataBase;
import com.company.db.repository.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    public static boolean checkParameters(String[] parameters, Map<String, String[]> parameterMap) {
        for (String parameter : parameters) {
            if (!parameterMap.containsKey(parameter)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] parameters = {"email", "password"};
        boolean checkResult = checkParameters(parameters, request.getParameterMap());

//todo убрать чекпарамс

        if (!checkResult) {
            System.out.println("Ашипка 1 - не все заполнил");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

        } else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = null;
            try {
                user = UserDataBase.getINSTANCE().login(email, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (user != null) {
                //сессионная ерунда
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                System.out.println("Успешный вход юзера с id = " + user.getID());
//                session.setAttribute("id", user.getID());

                int LogUserId = user.getID();
                request.setAttribute("id", Integer.parseInt(String.valueOf(LogUserId)));
                getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);

            } else {
                System.out.println("Ашипка 2 - накосячил в логине или пароле");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }
}
