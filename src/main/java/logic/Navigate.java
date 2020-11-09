package logic;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import databse.*;


public  class Navigate {
	   Scanner scan = new Scanner(System.in);
	   int choise=0;
	   Map<String, Room> map = new LinkedHashMap<>();
	   Room newRoom = new Room();
	   Driver driver = new Driver();
	   QueryConstructor query = new QueryConstructor();	
	/**
	 * 
	 */
	public void Start() {
		
			while (choise != 5 ) {
				System.out.println("HELLO :) It's simply renovation calculator. All data are saved in database");
				System.out.println("What You want to do? ");
				System.out.println("1- Create new room");
				System.out.println("2- Show all rooms");
				System.out.println("3- Create raport");
				System.out.println("4- Delete all data");
				System.out.println("5- EXIT");
				
				
			
				while(!scan.hasNextInt()){
		            scan.next();
		            System.out.println("Podaj liczbe!");
		        	
		        }
				
				
				choise = scan.nextInt();
				
				if (choise==1) {
					newRoom=NewRoom();
					PressKey();					
					driver.getConnectionToInsertOrUpdate(query.insertRoom(newRoom));
					
				}
				else if (choise==2) {
					map=driver.loadRoomsFromDatabaseToMap();
					ShowAllRooms();
					PressKey();
				}
				else if (choise==4) {
					driver.getConnectionToInsertOrUpdate("DELETE FROM rooms");
					
				}
			
			
			}
	}
	
	
	public void ShowAllRooms() {
		
		Set<String> keys = map.keySet();
        for(String k:keys){
            showRoom(k);
            
        }
	}
	public void PressKey(){
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
		scan.nextLine();		
		
	}
	
	
	public void checkIfScannerIsDouble() {
		while(!scan.hasNextDouble()){
            scan.next();
            System.out.println("Podaj liczbe!");
        	
        }
		
	}
	public Room NewRoom() {
		
			
		
		System.out.println("Put name: ");
		String name =scan.nextLine();
		name =scan.nextLine();
		
		System.out.println("Put length of wall A: ");
		checkIfScannerIsDouble();
		double wallA =scan.nextDouble();
		
		System.out.println("Put length of wall B: ");
		checkIfScannerIsDouble();
		double wallB =scan.nextDouble();
		
		System.out.println("Put heigh of room: ");
		checkIfScannerIsDouble();
		double heigh =scan.nextDouble();	
			
		Room exampleRoom= new Room(name,wallA,wallB,heigh);
		map.put(exampleRoom.getName(),exampleRoom);
		System.out.println("Correctly create new Room");
		showRoom(exampleRoom.getName());
	
		
		return exampleRoom;
		
	}
	
	public void showRoom(String k) {
		  System.out.println();
		  System.out.println(map.get(k).getName());
          System.out.println("Length of wall A: " + map.get(k).getWallA());
          System.out.println("Length of wall B: " + map.get(k).getWallB());
          System.out.println("High of Room: "+ map.get(k).getHigh());
		
	}
		
	

}
