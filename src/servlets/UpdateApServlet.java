package servlets;

import db.DBConnection;
import entity.Apartment;
import entity.City;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/update-ap")
public class UpdateApServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double size = Double.parseDouble(request.getParameter("size"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        double height = Double.parseDouble(request.getParameter("height"));
        double price = Double.parseDouble(request.getParameter("price"));
        int room = Integer.parseInt(request.getParameter("room"));
        int id = Integer.parseInt(request.getParameter("id"));

        int city_id = Integer.parseInt(request.getParameter("city_id"));

        City city = DBConnection.getCityById(city_id);

        Apartment ap = DBConnection.getApById(id);
        ap.setFloor(floor);
        ap.setHeight(height);
        ap.setRoom(room);
        ap.setSize(size);
        ap.setPrice(price);
        ap.setCity(city);

        DBConnection.updateAp(ap);

        response.sendRedirect("/main");


    }
}
