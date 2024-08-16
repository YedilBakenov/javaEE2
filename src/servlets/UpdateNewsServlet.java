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
import java.sql.Timestamp;


@WebServlet(value = "/update-news")
public class UpdateNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("content");
        int userId = Integer.parseInt(request.getParameter("userId"));
        int news_id = Integer.parseInt(request.getParameter("news_id"));
        Timestamp date = Timestamp.valueOf(request.getParameter("date"));

        User user = DBConnection.getUserById(userId);

        News news = DBConnection.getNewsById(news_id);

        news.setContent(content);
        news.setUser(user);
        news.setDate(date);


        DBConnection.updateNews(news);

        response.sendRedirect("/get-news");


    }
}
