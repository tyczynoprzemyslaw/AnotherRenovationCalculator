package logic;

import java.util.LinkedHashMap;
import java.util.Map;

public class House {
    int id;
    String name;
    String city;
    String adress;
    int customer_id = 1;
    Map<Integer,Room> mapOfRooms = new LinkedHashMap<>();

    public House(Integer id,String name, String city, String adress, int customer_id, Map<Integer, Room> mapOfRooms) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.adress = adress;
        this.customer_id = customer_id;
        this.mapOfRooms = mapOfRooms;
    }
    public House(String name, String city, String adress, int customer_id) {
        this.name = name;
        this.city = city;
        this.adress = adress;
        this.customer_id = customer_id;

    }



    public House() {

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
