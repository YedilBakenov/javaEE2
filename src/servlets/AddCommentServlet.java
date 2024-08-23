package servlets;

import db.DBConnection;
import entity.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/add-comment")
public class AddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User)request.getSession().getAttribute("currentUser");

        if(user!=null) {

            String commentText = request.getParameter("commentText");
            int newsId = Integer.parseInt(request.getParameter("newsId"));
            int userId = Integer.parseInt(request.getParameter("userId"));

            News news = DBConnection.getNewsById(newsId);
            User user1 = DBConnection.getUserById(userId);

            Comment comment = new Comment();
            comment.setText(commentText);
            comment.setNews(news);
            comment.setUser(user1);

            DBConnection.addComment(comment);

            response.sendRedirect("/details-news?id="+newsId);

        }else response.sendRedirect("/login");
    }
}
