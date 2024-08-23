package servlets;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/details-news")
public class DetailsNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));


        request.setAttribute("news", DBConnection.getNewsById(id));
        request.setAttribute("comments", DBConnection.getAllComments(id));


        request.getRequestDispatcher("/details-news.jsp").forward(request, response);

    }
}
