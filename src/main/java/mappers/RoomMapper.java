package mappers;

import databse.Driver;
import logic.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static logic.Navigate.*;


public class RoomMapper {

    public static Map<Integer, Room> loadRoomsFromDatabaseToMap() {
        Map<Integer, Room> map = new LinkedHashMap<>();

        try {
            Driver driver = new Driver();
            ResultSet result = driver.executeSelect("SELECT id, room_name,wallA,wallB,high,house_id FROM rooms");
            GetRoomsFromDatabaseToMap(map, result);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

    private static void GetRoomsFromDatabaseToMap(Map<Integer, Room> map, ResultSet result) throws SQLException {
        while (result.next()) {
            Room mainRoom = getRoomFromDatabase(result);
            map.put(mainRoom.getId(),mainRoom);
        }
    }


    private static Room getRoomFromDatabase(ResultSet result) throws SQLException {
            Integer id = result.getInt("id");
            String name = result.getString("room_name");
            double wallA = result.getDouble("wallA");
            double wallB = result.getDouble("wallB");
            double high = result.getDouble("high");
            Integer houseId = result.getInt("house_id");
        return new Room(name, wallA, wallB, high, id, houseId);
    }
    public static void ShowAllRooms(Map<Integer, Room> map) {

        //keys = null;
        Set<Integer> keys = map.keySet();
        for (Integer k : keys) {
            System.out.println("Control" + k);
            showRoom(k,map);

        }
    }

    public static void showRoom(Integer k,Map<Integer, Room> map) {

        System.out.println();
        System.out.println(map.get(k).getName());
        System.out.println(WALLA_LENGTH + map.get(k).getWallA());
        System.out.println(WALL_LENGTH + map.get(k).getWallB());
        System.out.println(HIGH + map.get(k).getHigh());
    }

    public static void showRoom(Room room) {

        System.out.println();
        System.out.println(room.getName());
        System.out.println(WALLA_LENGTH + room.getWallA());
        System.out.println(WALL_LENGTH + room.getWallB());
        System.out.println(HIGH + room.getHigh());
    }




}
