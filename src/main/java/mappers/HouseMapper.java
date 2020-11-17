package mappers;

import databse.Driver;
import logic.House;
import logic.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static databse.QueryConstructor.GET_NAME_OF_ALL_HOUSES;

public class HouseMapper {
    public static Map<Integer, Map<String, Room>> loadHousesToMapFromDatabase(){
        Map<Integer, Map<String, Room>> mapMain = new LinkedHashMap<>();
        try {
            Driver driver = new Driver();
            ResultSet MyRs = driver.executeSelect(GET_NAME_OF_ALL_HOUSES);
            while (MyRs.next()) {
                //String tableName = MyRs.get;
                //apMain.put(mainRoom.getName(),mainRoom);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mapMain;
        }

    private static House getHouseFromDatabase(ResultSet result) throws SQLException {
        String name = result.getString("house_name");
        int id = result.getInt("id");
        String city = result.getString("city");
        String adress = result.getString("adress");
        int customer_id = result.getInt("customer_id");
        List<Room> ListOfRooms = new LinkedList<>();
        return new House(name, city, adress, customer_id, ListOfRooms);
    }

    public void showHouse(Integer k,Map<Integer, House> mapMain) {
        System.out.println();
        System.out.println(mapMain.get(k).getHouseName());
        System.out.println(mapMain.get(k).getCity());
        System.out.println(mapMain.get(k).getAdress());

    }

    public void ShowAllHouses(Map<Integer, House> mapMain) {

        Set<Integer> keys = mapMain.keySet();
        for (Integer k : keys) {
            showHouse(k,  mapMain);
        }
    }
}
