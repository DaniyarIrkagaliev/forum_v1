package com.company.servlets;

import com.company.db.db_utils.UserDataBase;
import com.company.db.repository.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import static com.company.utils.Password.generatePasswordHash;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
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
        request.setCharacterEncoding("utf8");
        String[] parameters = {"username", "email", "password"};
        boolean checkResult = checkParameters(parameters, request.getParameterMap());

        if (!checkResult) {
            System.out.println("Ашипка 1 - не все заполнил");
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            try {
                password = generatePasswordHash(password);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }

            UserDataBase.getINSTANCE().add(new User(0, email, username,  password));

            System.out.println("Удачная регистрация");
            //TODO проверка на успешную регистрацию
            response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");

        }

    }

}
