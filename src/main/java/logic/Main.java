package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;



import databse.*;

public class Main {

	public static void main(String[] args) {
		Navigate navigate = new Navigate();			
		QueryConstructor query = new QueryConstructor();
		Driver driver = new Driver();
		
		//ResultSet result = driver.executeSelect("SELECT * FROM rooms");
		
		
		navigate.Start();	
		//Room hideRoom = new Room("trying to insert from Navigate", 3.5, 4.2, 2.9);
		//driver.executeQuery("Select * from rooms");
		//driver.getConnectionToInsertOrUpdate(query.insertRoom(hideRoom));
		
	
	
		
		
	}
}
