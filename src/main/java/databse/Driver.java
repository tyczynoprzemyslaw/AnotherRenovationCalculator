package databse;

import java.sql.*;

import logic.Room;

public class Driver {
	public static void main(String[] args) {
		
		String query = insertRoomToDatabase();
	try {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/calculator","root","");
		Statement myStmt = conn.createStatement();
		
	   myStmt.executeUpdate(insertRoomToDatabase());
	   
	   
	   //while (myRs.next()) {
		 //  System.out.println(myRs.getString("room_name"));
	  // }

	} catch (SQLException ex) {
	 
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}

	
}
	public void makeConnectionwithDatabase() {
		
	}
	public static  String insertRoomToDatabase() {
		
		return "INSERT INTO `rooms` (`room_name`, `wallA`, `wallB`, `high`, `area_Walls`, `area_Ceiling`, `total_Area`, `circumference`) VALUES ('kolejnypokoj', '6', '4.4', '2.5', NULL, NULL, NULL, NULL)";
		
	}
}
