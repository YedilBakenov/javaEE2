package servlets;

import db.DBConnection;
import db.DBManager;
import entity.Apartment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/add-ap")
public class AddApServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      response.sendRedirect("/add-ap.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double size = Double.parseDouble(request.getParameter("size"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        double height = Double.parseDouble(request.getParameter("height"));
        double price = Double.parseDouble(request.getParameter("price"));
        int room = Integer.parseInt(request.getParameter("room"));

        Apartment ap = new Apartment();
        ap.setFloor(floor);
        ap.setHeight(height);
        ap.setRoom(room);
        ap.setSize(size);
        ap.setPrice(price);

        DBConnection.addAp(ap);

        response.sendRedirect("/main");


    }
}
