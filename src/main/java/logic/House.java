package logic;

import java.util.LinkedList;
import java.util.List;

public class House {
    int id;
    String name;
    String city;
    String adress;
    int customer_id = 1;
    List<Room> listOfRooms = new LinkedList<>();

    public House(String name, String city, String adress, int customer_id, List<Room> listOfRooms) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.adress = adress;
        this.customer_id = customer_id;
        this.listOfRooms = listOfRooms;
    }

    public int getId() {
        return id;
    }

    public String getHouseName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAdress() {
        return adress;
    }

    public int getCustomer_id() {
        return customer_id;
    }



    }
