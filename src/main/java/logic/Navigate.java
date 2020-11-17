package logic;

import databse.Driver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static databse.Mapper.loadRoomsFromDatabaseToMap;
import static databse.QueryConstructor.insertRoom;


public class Navigate {

    private static final String CHOICE_COMUNICAT = "What You want to do? ";
    private static final String HELLO_MESSAGE = "HELLO :) It's simply renovation calculator. All data are saved in database";
    private static final String MENU_CHOICE_CREATE_NEW_ROOM = "1- Create new room";
    private static final String MENU_CHOISE_SHOW_ROOMS = "2- Show all rooms";
    private static final String MENU_CHOISE_HOUSES = "Show all houses";
    private static final String MENU_CHOISE_DELETE_ALL_ROOMS = "4- Delete all data";
    private static final String MENU_CHOISE_EXIT = "5- EXIT";
    private static final String MENU_CHOISE_CREATE_RAPORT = "Create raport";

    private static final String WALLA_LENGTH = "Length of wall A: ";
    private static final String WALL_LENGTH = "Length of wall B: ";
    private static final String HIGH = "High of Room: ";

    private static final String TYPE_NUMBER = "Type number!: ";
    private final static String MESSAGE_CREATED_ROOM = "Correctly create new Room";


    Scanner scan = new Scanner(System.in);
    int choise = 0;
    Map<Integer, Room> map = new LinkedHashMap<>();
    Room newRoom = new Room();
    Driver driver = new Driver();
    Map<Integer, House> mapMain = new LinkedHashMap<>();

    public void Start() {

        while (choise != 5) {

            displayMainMenu();
            choise = getNumber();

            if (choise == 1) {
                createNewRoom();
            } else if (choise == 2) {
                showRoomsFromDatabase();
            } else if (choise == 4) {
                driver.deleteAllRooms();
            }
        }
    }

    private int getNumber() {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println(TYPE_NUMBER);
        }
        return scan.nextInt();
    }



    private void showRoomsFromDatabase() {
        map = loadRoomsFromDatabaseToMap();
        ShowAllRooms();
        PressKey();
    }

    private void createNewRoom() {
        newRoom = NewRoom();
        PressKey();
        driver.getConnectionToInsertOrUpdate(insertRoom(newRoom));
    }

    private void displayMainMenu() {
        System.out.println(HELLO_MESSAGE);
        System.out.println(CHOICE_COMUNICAT);
        System.out.println(MENU_CHOICE_CREATE_NEW_ROOM);
        System.out.println(MENU_CHOISE_SHOW_ROOMS);
        System.out.println(MENU_CHOISE_HOUSES);
        System.out.println(MENU_CHOISE_DELETE_ALL_ROOMS);
        System.out.println(MENU_CHOISE_EXIT);
    }

    /*private void displayHousesMenu() {
        System.out.println(HOUSES_MENU_HELLO_MESSAGE);
        private static final String HOUSES_MENU_HELLO_MESSAGE = "Hello, What You wanna do?";
        System.out.println(CHOICE_COMUNICAT);
        System.out.println(MENU_CHOICE_CREATE_NEW_ROOM);
        System.out.println(MENU_CHOISE_SHOW_ROOMS);
        System.out.println(MENU_CHOISE_HOUSES);
        System.out.println(MENU_CHOISE_DELETE_ALL_ROOMS);
        System.out.println(MENU_CHOISE_EXIT);
    }
*/
    public void PressKey() {

        System.out.println("Press enter to continue...");
        scan.nextLine();
        scan.nextLine();

    }

    public double getDouble() {
        while (!scan.hasNextDouble()) {
            scan.next();
            System.out.println(TYPE_NUMBER);
        }
        return scan.nextDouble();

    }

    public Room NewRoom() {

        Room exampleRoom = createRoomFromInputNumbers();
        map.put(exampleRoom.getId(), exampleRoom);

        System.out.println(MESSAGE_CREATED_ROOM);
        showRoom(exampleRoom.getId());
        return exampleRoom;
    }

    private Room createRoomFromInputNumbers() {
        System.out.println("Put name: ");
        String name = scan.nextLine();

        System.out.println("Put length of wall A: ");
        double wallA = getDouble();

        System.out.println("Put length of wall B: ");
        double wallB = getDouble();

        System.out.println("Put heigh of room: ");
        double heigh = getDouble();

        return new Room(name, wallA, wallB, heigh);
    }

    public void ShowAllRooms() {

        //keys = null;
        Set<Integer> keys = map.keySet();
        for (Integer k : keys) {
            System.out.println("Control" + k);
            showRoom(k);

        }
    }

    public void showRoom(Integer k) {

        System.out.println();
        System.out.println(map.get(k).getName());
        System.out.println(WALLA_LENGTH + map.get(k).getWallA());
        System.out.println(WALL_LENGTH + map.get(k).getWallB());
        System.out.println(HIGH + map.get(k).getHigh());
    }



}
