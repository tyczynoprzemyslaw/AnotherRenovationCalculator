package databse;

import java.sql.*;

import logic.Room;

public class Driver {
	Connection conn =  null;
	Statement myStmt = null;	
	
		//String query = insertRoomToDatabase();
		
	public void getConnectionToInsert(String insertQuery) {
		
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/calculator","root","");
		myStmt = conn.createStatement();		
	    myStmt.executeUpdate(insertQuery);   
	   
	   

	} catch (SQLException ex) {
	 
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}

	
}
	public void makeConnectionwithDatabase() {
		
	}
	
}
