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


@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String fullName = request.getParameter("full_name");

        User user = DBConnection.getUserByEmail(email);

        if(password.equals(rePassword) && user==null && email!=null && fullName!=null){

            User newUser = new User();
            newUser.setFull_name(fullName);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setRole_id(2);

            DBConnection.addUser(newUser);

            HttpSession session = request.getSession();
            session.setAttribute("currentUser", newUser);

            response.sendRedirect("/");
        }
        else response.sendRedirect("/login");

    }
}
