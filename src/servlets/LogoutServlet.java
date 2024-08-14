package servlets;

import db.DBConnection;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user =(User)request.getSession().getAttribute("currentUser");

        if(user!=null){
          request.getSession().removeAttribute("currentUser");
           response.sendRedirect("/");
        }else response.sendRedirect("/login");

    }
}
