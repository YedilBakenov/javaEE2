package servlets;

import db.DBConnection;
import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(value = "/details-ap")
public class DetailsApServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("kv", DBConnection.getApById(id));
        request.setAttribute("cities", DBConnection.getAllCities());


        request.getRequestDispatcher("/details-ap.jsp").forward(request, response);

    }
}
