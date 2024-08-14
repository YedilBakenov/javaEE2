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


@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User currentUser = (User)request.getSession().getAttribute("currentUser");

            response.sendRedirect("/profile.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = DBConnection.getUserByEmail(email);

        if(user!=null && user.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", session);

            response.sendRedirect("/profile");
        }
        else response.sendRedirect("/login");

    }
}
