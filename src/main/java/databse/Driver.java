package databse;

import java.sql.*;

public class Driver {
	Connection conn =  null;
	Statement myStmt = null;	
	ResultSet myRs = null;
	
	
	private static final String URL = "jdbc:mysql://localhost/calculator";
	private static final String user = "root";
	private static final String password = "";

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
	
	private Connection connection() {
		try {
			conn = DriverManager.getConnection(URL, user, password);
			System.out.println("Connected with database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	

	
}
