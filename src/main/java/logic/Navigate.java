package logic;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public  class Navigate {
	   Scanner scan = new Scanner(System.in);
	   int choise=0;
	   Map<String, Room> map = new LinkedHashMap<>();
	   Room newRoom = new Room();
	
	public void Start() {
		
			while (choise != 5 ) {
				System.out.println("HELLO :) It's simply renovation calculator. All data are saved in database");
				System.out.println("What You want to do? ");
				System.out.println("1- Create new room");
				System.out.println("2- Show all rooms");
				System.out.println("3- Create raport");
				System.out.println("4- Delete all data");
				System.out.println("5- EXIT");
				
				choise = scan.nextInt();
				
				if (choise==1) {
					newRoom=NewRoom();
					PressKey();
					map.put(newRoom.getName(),newRoom);
				}
				else if (choise==2) {
					ShowAllRooms();
					PressKey();
				}
			
		
			}
	}
	
	public void ShowAllRooms() {
		
		Set<String> keys = map.keySet();
        for(String k:keys){
            System.out.println(map.get(k).getName());
            System.out.println("Length of wall A" + map.get(k).getWallA());
            System.out.println("Length of wall A" + map.get(k).getWallB());
            System.out.println("High of Room"+ map.get(k).getHigh());
            
        }
	}
	public void PressKey(){
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
		scan.nextLine();		
		
	}
	
	public Room NewRoom() {
		
			
		
		System.out.println("Put name: ");
		String name =scan.nextLine();
		name =scan.nextLine();
		
		System.out.println("Put length of wall A: ");
		double wallA =scan.nextDouble();
		
		System.out.println("Put length of wall B: ");
		double wallB =scan.nextDouble();
		
		System.out.println("Put heigh of room: ");
		double heigh =scan.nextDouble();	
			
		Room exampleRoom= new Room(name,wallA,wallB,heigh);
		
		System.out.println("Correctly create new Room");
		System.out.println("Name " + name);
		System.out.println("wallA " + wallA);
		System.out.println("wallB " + wallB);
		System.out.println("heigh " + heigh);
	
		
		return exampleRoom;
		
	}
		
	

}
