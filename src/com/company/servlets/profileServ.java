package com.company.servlets;

import com.company.db.repository.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class profileServ extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("user");
        String id = request.getParameter("id");
        if(loginUser != null){
            int LogUserId = loginUser.getID();
            request.setAttribute("id", Integer.parseInt(String.valueOf(LogUserId)));
            getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
        }
        else if (id != null) {
            request.setAttribute("id", Integer.parseInt(id));
            getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
