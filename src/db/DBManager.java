package db;

import entity.Apartment;

import java.util.ArrayList;

public class DBManager {
    public static ArrayList<Apartment> collections = new ArrayList<>();

    public  static int id = 6;

    static {
        collections.add(new Apartment(1, 74.4, 4, 2.75, 600000, 10, null));
        collections.add(new Apartment(2, 32.2, 1, 2.75, 300000, 13, null));
        collections.add(new Apartment(3, 102.2, 6, 3.0, 1500000, 11, null));
        collections.add(new Apartment(4, 50.1, 2, 3.3, 1200000, 6, null));
        collections.add(new Apartment(5, 180, 8, 3.6, 5000000, 12, null));
    }

    public static ArrayList<Apartment> getAllApartments(){
        return collections;
    }

    public static Apartment getApById(int id) {

        return collections.stream().filter(s-> s.getId()==id).findFirst().orElseThrow();

    }

    public static void addAp(Apartment ap) {
        ap.setId(id);
        id++;
        collections.add(ap);

    }

    public static void deleteApById(int id) {
        collections.removeIf(s->s.getId()==id);
    }

    public static void updateAp(Apartment ap) {
        Apartment appFromBase = DBManager.getApById(ap.getId());

        appFromBase.setSize(ap.getSize());
        appFromBase.setRoom(ap.getRoom());
        appFromBase.setFloor(ap.getFloor());
        appFromBase.setHeight(ap.getHeight());
        appFromBase.setPrice(ap.getPrice());

    }
}
