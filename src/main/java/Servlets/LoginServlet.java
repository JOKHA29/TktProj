package Servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Models.Admin;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO dao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("id") != null)
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dao = (UserDAO) getServletContext().getAttribute("UserDAO");
        String username = req.getParameter("username");
        String password = req.getParameter("pwd");
        boolean userID = dao.CheckUser(username,password);
        if (username.equals(Admin.username) && password.equals(Admin.pass)){
            req.getRequestDispatcher("WEB-INF/admin.jsp").forward(req, resp);
        }
        else if(userID){
            req.getSession().setAttribute("id",userID);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        }

        else if(dao.CheckUsername(username)) req.getRequestDispatcher("WEB-INF/wrongPassword.jsp").forward(req, resp);
        else req.getRequestDispatcher("WEB-INF/wrongUsername.jsp").forward(req, resp);
    }
}