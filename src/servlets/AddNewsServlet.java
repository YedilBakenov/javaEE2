package servlets;

import db.DBConnection;
import entity.Apartment;
import entity.City;
import entity.News;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/add-news")
public class AddNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        int userID = Integer.parseInt(request.getParameter("userId"));

        User user = DBConnection.getUserById(userID);

        News news = new News();
        news.setContent(content);
        news.setUser(user);

        DBConnection.addNews(news);

        response.sendRedirect("/get-news");


    }
}
