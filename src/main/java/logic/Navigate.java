package logic;
import databse.Driver;
import databse.QueryConstructor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static databse.Mapper.loadRoomsFromDatabaseToMap;


public  class Navigate {

	private static final String CHOISE_COMUNICAT= "What You want to do? ";
	private static final String HELLO_MESSAGE= "HELLO :) It's simply renovation calculator. All data are saved in database";
	private static final String MENU_CHOISE_1 = "1- Create new room";
	private static final String MENU_CHOISE_SHOW_ROOMS = "2- Show all rooms";
	private static final String MENU_CHOISE_CREATE_RAPORT = "3- Create raport";
	private static final String MENU_CHOISE_DELETE_ALL_ROOMS = "4- Delete all data";
	private static final String MENU_CHOISE_EXIT = "5- EXIT";

	private static final String WALLA_LENGTH = "Length of wall A: ";
	private static final String WALL_LENGTH = "Length of wall B: ";
	private static final String HIGH = "High of Room: ";

	Scanner scan = new Scanner(System.in);
	   int choise=0;
	   Map<String, Room> map = new LinkedHashMap<>();
	   Room newRoom = new Room();
	   Driver driver = new Driver();
	   QueryConstructor query = new QueryConstructor();	

	public void Start() {
		
			while (choise != 5 ) {

				displayMenu();
				choise = getNumber();
				
				if (choise==1) {
					createNewRoom();
				}
				else if (choise==2) {
					showRoomsFromDatabase();
				}
				else if (choise==4) {
					deleteAllRooms();
				}
			}
	}

	private int getNumber() {
		while(!scan.hasNextInt()){
			scan.next();
			System.out.println("Type number!: ");
		}
		return scan.nextInt();
	}

	private void deleteAllRooms() {
		driver.getConnectionToInsertOrUpdate("DELETE FROM rooms");
	}

	private void showRoomsFromDatabase() {
		map=loadRoomsFromDatabaseToMap();
		ShowAllRooms();
		PressKey();
	}

	private void createNewRoom() {
		newRoom=NewRoom();
		PressKey();
		driver.getConnectionToInsertOrUpdate(query.insertRoom(newRoom));
	}

	private void displayMenu() {
		System.out.println(HELLO_MESSAGE);
		System.out.println(CHOISE_COMUNICAT);
		System.out.println(MENU_CHOISE_1);
		System.out.println(MENU_CHOISE_SHOW_ROOMS);
		System.out.println(MENU_CHOISE_CREATE_RAPORT);
		System.out.println(MENU_CHOISE_DELETE_ALL_ROOMS);
		System.out.println(MENU_CHOISE_EXIT);
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
          System.out.println(WALLA_LENGTH + map.get(k).getWallA());
          System.out.println(WALL_LENGTH + map.get(k).getWallB());
          System.out.println(HIGH + map.get(k).getHigh());
	}

}
