package logic;

import java.util.LinkedHashMap;
import java.util.Map;


import databse.*;

public class Main {

	public static void main(String[] args) {
		//Navigate navigate = new Navigate();	
		//navigate.Start();
		QueryConstructor query = new QueryConstructor();
		Driver driver = new Driver();
		Room hideRoom = new Room("firstWithcompleteData", 3.5, 4.2, 2.9);
		driver.getConnectionToInsert(query.insertRoomToDatabase(hideRoom));
		
	
		
		
	}
}
