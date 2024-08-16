package db;

import entity.Apartment;
import entity.City;
import entity.News;
import entity.User;

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

    public static ArrayList<City>getAllCities(){
        ArrayList<City>list = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cities ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                City city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                city.setRegion(resultSet.getString("region"));

                list.add(city);
            }

            resultSet.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }


    public static ArrayList<Apartment> getAllApp() {
        ArrayList<Apartment> list = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM apartments ap " +
                    "INNER JOIN cities c on c.id = ap.city_id ORDER BY ap.id ASC ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Apartment ap = new Apartment();
                ap.setId(resultSet.getInt("id"));
                ap.setHeight(resultSet.getDouble("height"));
                ap.setPrice(resultSet.getDouble("price"));
                ap.setFloor(resultSet.getInt("floor"));
                ap.setSize(resultSet.getDouble("size"));
                ap.setRoom(resultSet.getInt("room"));

                City city = new City();
                city.setId(resultSet.getInt("city_id"));
                city.setName(resultSet.getString("name"));
                city.setRegion(resultSet.getString("region"));

                ap.setCity(city);

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

            PreparedStatement statement = connection.prepareStatement("INSERT INTO apartments (size, room, height, price, floor, city_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)");
            statement.setDouble(1, ap.getSize());
            statement.setInt(2, ap.getRoom());
            statement.setDouble(3, ap.getHeight());
            statement.setDouble(4, ap.getPrice());
            statement.setInt(5, ap.getFloor());
            statement.setInt(6, ap.getCity().getId());

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
                    "room = ?, height = ?, price = ?, floor = ?, city_id = ? WHERE id = ?");

            statement.setDouble(1, ap.getSize());
            statement.setInt(2, ap.getRoom());
            statement.setDouble(3, ap.getHeight());
            statement.setDouble(4, ap.getPrice());
            statement.setInt(5, ap.getFloor());
            statement.setInt(6, ap.getCity().getId());
            statement.setInt(7, ap.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static City getCityById(int cityId) {
        City city = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cities WHERE id = ? ");
            statement.setInt(1, cityId);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                city = new City();
                city.setId(resultSet.getInt("id"));
                city.setRegion(resultSet.getString("region"));
                city.setName(resultSet.getString("name"));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return city;
    }

    public static User getUserByEmail(String email) {
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setPassword(resultSet.getString("password"));
            }
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }


    public static ArrayList<News> getAllNews() {
        ArrayList<News> news = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM news n " +
                    "INNER JOIN users u " +
                    "ON n.user_id = u.id " +
                    "ORDER BY n.date DESC ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                News newsFromBase = new News();
                newsFromBase.setId(resultSet.getInt("id"));
                newsFromBase.setContent(resultSet.getString("content"));
                newsFromBase.setDate(resultSet.getTimestamp("date"));

                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));

                newsFromBase.setUser(user);

                news.add(newsFromBase);
            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return news;
    }

    public static User getUserById(int userID) {
        User user = new User();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ? ");
            statement.setInt(1, userID);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static void addNews(News news) {

        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO news (content, user_id, date) " +
                    "VALUES (?, ?, NOW())");
            statement.setString(1, news.getContent());
            statement.setInt(2, news.getUser().getId());


            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static News getNewsById(int id) {
        News news = new News();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * " +
                    "FROM news n " +
                    "INNER JOIN users u " +
                    "ON n.user_id = u.id WHERE n.id = ? ");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                news.setId(resultSet.getInt("id"));
                news.setContent(resultSet.getString("content"));
                news.setDate(resultSet.getTimestamp("date"));

                User user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setFull_name(resultSet.getString("full_name"));
                user.setId(resultSet.getInt("user_id"));

                news.setUser(user);
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }


        return news;
    }

    public static void deleteNewsById(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM news WHERE id = ?");
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateNews(News news) {
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE news SET content = ?, " +
                    "date = ? WHERE id = ? ");

            statement.setString(1,news.getContent());
            statement.setTimestamp(2, news.getDate());
            statement.setInt(3, news.getId());

            statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
