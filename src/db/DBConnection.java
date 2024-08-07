package db;

import entity.Apartment;

import java.sql.*;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;

    private static String jdbc = "jdbc:postgresql://localhost:5432/g126";
    private static String login = "postgres";
    private static String password = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbc, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<Apartment> getAllApp() {
        ArrayList<Apartment> list = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM apartments ORDER BY id ASC ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Apartment ap = new Apartment();
                ap.setId(resultSet.getInt("id"));
                ap.setHeight(resultSet.getDouble("height"));
                ap.setPrice(resultSet.getDouble("price"));
                ap.setFloor(resultSet.getInt("floor"));
                ap.setSize(resultSet.getDouble("size"));
                ap.setRoom(resultSet.getInt("room"));

                list.add(ap);

            }

            resultSet.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static void addAp(Apartment ap) {
        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO apartments (size, room, height, price, floor) " +
                    "VALUES (?, ?, ?, ?, ?) ");
            statement.setDouble(1, ap.getSize());
            statement.setInt(2, ap.getRoom());
            statement.setDouble(3, ap.getHeight());
            statement.setDouble(4, ap.getPrice());
            statement.setInt(5, ap.getFloor());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Apartment getApById(int id) {
        Apartment ap = new Apartment();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM apartments WHERE id = ? ");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                ap.setId(resultSet.getInt("id"));
                ap.setHeight(resultSet.getDouble("height"));
                ap.setPrice(resultSet.getDouble("price"));
                ap.setFloor(resultSet.getInt("floor"));
                ap.setSize(resultSet.getDouble("size"));
                ap.setRoom(resultSet.getInt("room"));
            }
            resultSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return ap;
    }

    public static void deleteApById(int id) {
        try{
            PreparedStatement statement = connection.prepareStatement("DELETE FROM apartments WHERE id = ? ");
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateAp(Apartment ap) {

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE apartments SET size = ?, " +
                    "room = ?, height = ?, price = ?, floor = ? WHERE id = ?");

            statement.setDouble(1, ap.getSize());
            statement.setInt(2, ap.getRoom());
            statement.setDouble(3, ap.getHeight());
            statement.setDouble(4, ap.getPrice());
            statement.setInt(5, ap.getFloor());
            statement.setInt(6, ap.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
