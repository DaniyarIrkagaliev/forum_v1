package com.company.servlets;

import com.company.db.db_utils.UserDataBase;
import com.company.db.repository.User;
import com.company.utils.Password;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;
        boolean matched = false;
        try {
            user = UserDataBase.getINSTANCE().selectBylogin(email);
            System.out.println("user= "+ user);
            String userPass = user.getPassword();
            System.out.println("userPass = "+ userPass);
            matched = Password.validatePassword(password, userPass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        if (matched) {
            //сессионная ерунда
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            System.out.println("Успешный вход юзера с id = " + user.getID());
//                session.setAttribute("id", user.getID());
            int LogUserId = user.getID();
            request.setAttribute("id", user.getID());
            System.out.println(LogUserId);
            getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);

        } else {
            System.out.println("Ашипка 2 - накосячил в логине или пароле");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }


}
