package databse;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import logic.Room;

public class Driver {
	Connection conn =  null;
	Statement myStmt = null;	
	ResultSet myRs = null;
	
	
	private static String URL = "jdbc:mysql://localhost/calculator";
	private static String user = "root";
	private static String password = "";
	
		//String query = insertRoomToDatabase();
		
	public  void getConnectionToInsertOrUpdate(String insertQuery) {
		
	try {
		conn = connection();
		myStmt = conn.createStatement();		
	    myStmt.executeUpdate(insertQuery);    
   
	} catch (SQLException ex) {
	 
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}

	
}
	public ResultSet executeSelect(String query) {
	
		try {
			
			conn = connection();
			myStmt = conn.createStatement();
			return myStmt.executeQuery(query);			   		   

		} catch (SQLException ex) {
		  throw new RuntimeException(ex.getMessage());
		}	
	      		
	}
	
	public Connection connection() {
		try {
			conn = DriverManager.getConnection(URL, user, password);
			System.out.println("Po³¹czono");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public Map<String, Room> loadRoomsFromDatabaseToMap() {
		Map<String, Room> map = new LinkedHashMap<>();
		
		try {
			ResultSet result = executeSelect("SELECT room_name,wallA,wallB,high FROM rooms");
			while (result.next()) {
				String name = result.getString("room_name");
				double wallA = result.getDouble("wallA");
				double wallB = result.getDouble("wallB");
				double high = result.getDouble("high");
				Room mainRoom= new Room(name, wallA, wallB, high);
			
				map.put(mainRoom.getName(),mainRoom);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
}
