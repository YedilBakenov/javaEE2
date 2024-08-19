package servlets;

import db.DBConnection;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");

        if (user == null || user.getRole_id() == 2) {
            response.sendRedirect("/403.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user =(User)request.getSession().getAttribute("currentUser");

        if(user!=null &&  user.getRole_id()==1){

        String content = request.getParameter("content");
        int userID = Integer.parseInt(request.getParameter("userId"));

        User user1 = DBConnection.getUserById(userID);

        News news = new News();
        news.setContent(content);
        news.setUser(user1);

        DBConnection.addNews(news);

        response.sendRedirect("/get-news");

        }else response.sendRedirect("/403.jsp");
    }
}
