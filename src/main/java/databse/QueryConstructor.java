package databse;

import logic.House;
import logic.Room;

public class QueryConstructor {
	public final static String GET_NAME_OF_ALL_TABLES = "SELECT table_name FROM information_schema.tables WHERE table_schema='calculator'";
	public final static String GET_HAUSES_FROM_DATABASE = "SELECT id, house_name, city, adress, customer_id FROM houses";
	final static String QUERY_DELETE_ALL_ROOMS = "DELETE FROM rooms";


	public  static String insertRoom(Room roomDataToDatabse) {
			
			return "INSERT INTO `rooms` (`room_name`, `wallA`, `wallB`, `high`, `area_Walls`, `area_Ceiling`, `total_Area`, `circumference`)" +
			"VALUES ('"+ roomDataToDatabse.getName() + "',"
			+ " '"+roomDataToDatabse.getWallA()+"', '"
				  + roomDataToDatabse.getWallB()+"', '"
				  + roomDataToDatabse.getHigh()+"', '"
				  + roomDataToDatabse.areaWalls()+"', '"
				  + roomDataToDatabse.areaCeiling()+"', '"
				  + roomDataToDatabse.totalArea()+"', '"
				  + roomDataToDatabse.circumferenceOfRoom()+"')";
			
		}
	public  static String insertHouse(House HouseDataToDatabse) {

		return "INSERT INTO `houses` (`house_name`, `city`, `adress`, `customer_id`)" +
				"VALUES ('"+ HouseDataToDatabse.getHouseName() + "',"
				+ " '"+HouseDataToDatabse.getCity()+"', '"
				+ HouseDataToDatabse.getAdress()+"', '"
				+ HouseDataToDatabse.getCustomer_id()+"')";


	}

}
