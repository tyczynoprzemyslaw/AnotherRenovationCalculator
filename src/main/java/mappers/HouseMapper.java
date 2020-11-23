package mappers;

import databse.Driver;
import logic.House;
import logic.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static databse.QueryConstructor.GET_HAUSES_FROM_DATABASE;

public class HouseMapper {

    public static Map<Integer, House> loadHousesToMapFromDatabase() {
        Map<Integer, House> mapMain = new LinkedHashMap<>();
        try {
            Driver driver = new Driver();
            ResultSet MyRs = driver.executeSelect(GET_HAUSES_FROM_DATABASE);
            while (MyRs.next()) {
                House newHouse = getHouseFromDatabase(MyRs);
                mapMain.put(newHouse.getId(), newHouse);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return mapMain;
    }

    private static House getHouseFromDatabase(ResultSet result) throws SQLException {
        String name = result.getString("house_name");
        Integer id = result.getInt("id");
        String city = result.getString("city");
        String adress = result.getString("adress");
        int customer_id = result.getInt("customer_id");
        Map<Integer, Room> mapOfRooms = new LinkedHashMap<>();
        return new House(id, name, city, adress, customer_id, mapOfRooms);
    }

    public static void showHouse(Integer k, Map<Integer, House> mapMain) {
        System.out.println();
        System.out.println("ID: " + mapMain.get(k).getId());
        System.out.println(mapMain.get(k).getHouseName());
        System.out.println(mapMain.get(k).getCity());
        System.out.println(mapMain.get(k).getAdress());
    }

    public static void showHouse(House house) {
        System.out.println();
        System.out.println(house.getHouseName());
        System.out.println(house.getCity());
        System.out.println(house.getAdress());

    }

    public static void ShowAllHouses(Map<Integer, House> mapMain) {
        Set<Integer> keys = mapMain.keySet();
        for (Integer k : keys) {
            showHouse(k, mapMain);
        }
    }


}
