package servlets;

import db.DBConnection;
import db.DBManager;
import entity.Apartment;
import entity.City;
import entity.User;
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

        User user =(User)request.getSession().getAttribute("currentUser");

        if(user!=null){
            request.setAttribute("g", DBConnection.getAllCities());
            request.getRequestDispatcher("/add-ap.jsp").forward(request, response);
        }else response.sendRedirect("/login");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double size = Double.parseDouble(request.getParameter("size"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        double height = Double.parseDouble(request.getParameter("height"));
        double price = Double.parseDouble(request.getParameter("price"));
        int room = Integer.parseInt(request.getParameter("room"));
        int city_id = Integer.parseInt(request.getParameter("city_id"));

        City city = DBConnection.getCityById(city_id);

        Apartment ap = new Apartment();
        ap.setFloor(floor);
        ap.setHeight(height);
        ap.setRoom(room);
        ap.setSize(size);
        ap.setPrice(price);
        ap.setCity(city);

        DBConnection.addAp(ap);

        response.sendRedirect("/main");


    }
}
