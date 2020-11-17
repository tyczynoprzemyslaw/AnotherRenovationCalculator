package logic;

import databse.Driver;
import databse.QueryConstructor;

import static databse.QueryConstructor.insertHouse;

public class Main {

	public static void main(String[] args) {
		//Navigate navigate = new Navigate();
		QueryConstructor query = new QueryConstructor();
		Driver driver = new Driver();
		
		//ResultSet result = driver.executeSelect("SELECT * FROM rooms");
		House house = new House("Black_House", "Gdynia", "Teczka 7", 4);

		driver.getConnectionToInsertOrUpdate(insertHouse(house));
		//navigate.Start();
		//Room hideRoom = new Room("trying to insert from Navigate", 3.5, 4.2, 2.9);
		//driver.executeQuery("Select * from rooms");
		//driver.getConnectionToInsertOrUpdate(query.insertRoom(hideRoom));
		
	
	
		
		
	}
}
