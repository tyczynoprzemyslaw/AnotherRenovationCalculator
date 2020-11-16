package databse;

import logic.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import static databse.QueryConstructor.*;


public class Mapper {

    public static Map<Integer, Map<String, Room>> loadHousesToMapFromDatabase(){
        Map<Integer, Map<String, Room>> mapMain = new LinkedHashMap<>();
        try {
            Driver driver = new Driver();
            ResultSet MyRs = driver.executeSelect(GET_NAME_OF_ALL_TABLES);
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

    public static Map<String, Room> loadRoomsFromDatabaseToMap() {
        Map<String, Room> map = new LinkedHashMap<>();

        try {
            Driver driver = new Driver();
            ResultSet result = driver.executeSelect("SELECT room_name,wallA,wallB,high FROM rooms");
            while (result.next()) {
                Room mainRoom = getRoomFromDatabase(result);
                map.put(mainRoom.getName(),mainRoom);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }


    private static Room getRoomFromDatabase(ResultSet result) throws SQLException {
        String name = result.getString("room_name");
        double wallA = result.getDouble("wallA");
        double wallB = result.getDouble("wallB");
        double high = result.getDouble("high");
        return new Room(name, wallA, wallB, high);
    }


}
