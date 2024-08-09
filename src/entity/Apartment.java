package entity;

public class Apartment {
    private int id;
    private double size;
    private int room;
    private double height;
    private double price;
    private int floor;
    private City city;

    public Apartment() {
    }

    public Apartment(int id, double size, int room, double height, double price, int floor, City city) {
        this.size = size;
        this.room = room;
        this.height = height;
        this.price = price;
        this.floor = floor;
        this.id = id;
        this.city = city;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
