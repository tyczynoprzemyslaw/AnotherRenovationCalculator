package databse;

import logic.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;


public class Mapper {

    public static Map<String, Room> loadRoomsFromDatabaseToMap() {
        Map<String, Room> map = new LinkedHashMap<>();

        try {
            Driver driver = new Driver();
            ResultSet result = driver.executeSelect("SELECT room_name,wallA,wallB,high FROM rooms");
            while (result.next()) {
                Room mainRoom = getRoom(result);
                map.put(mainRoom.getName(),mainRoom);

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }


    private static Room getRoom(ResultSet result) throws SQLException {
        String name = result.getString("room_name");
        double wallA = result.getDouble("wallA");
        double wallB = result.getDouble("wallB");
        double high = result.getDouble("high");
        Room mainRoom= new Room(name, wallA, wallB, high);
        return mainRoom;
    }


}
