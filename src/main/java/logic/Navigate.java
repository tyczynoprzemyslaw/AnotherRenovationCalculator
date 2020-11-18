package logic;

import databse.Driver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static databse.QueryConstructor.insertRoom;
import static mappers.RoomMapper.*;


public class Navigate {

    private static final String CHOICE_COMUNICAT = "What You want to do? ";
    private static final String WHICH_HOUSE = "Which house you want choice ";
    private static final String HELLO_MESSAGE = "HELLO :) It's simply renovation calculator. All data are saved in database";
    private static final String MENU_CHOICE_CREATE_NEW_ROOM = "Create new room";
    private static final String MENU_CHOISE_SHOW_ROOMS = "Show all rooms";
    private static final String MENU_CHOISE_SHOW_HOUSES = "Show all houses";
    private static final String MENU_CHOISE_DELETE_ALL_ROOMS = "Delete all rooms";
    private static final String MENU_CHOISE_EXIT = "EXIT";
    private static final String MENU_CHOISE_CREATE_RAPORT = "Create raport";

    private static final String HOUSES_MENU_SHOW_ALL_HOUSES = "Show all houses";
    private static final String HOUSES_MENU_DELETE_SOME_HOUSES = "Delete some houses";
    private static final String HOUSES_MENU_DELETE_ALL_HOUSES = "Delete all houses";
    private static final String MENU_CHOICE_CREATE_NEW_HOUSE = "Create new house";

    public static final String WALLA_LENGTH = "Length of wall A: ";
    public static final String WALL_LENGTH = "Length of wall B: ";
    public static final String HIGH = "High of Room: ";

    private static final String TYPE_NUMBER = "Type number!: ";
    private final static String MESSAGE_CREATED_ROOM = "Correctly create new Room";


    Scanner scan = new Scanner(System.in);
    int choice = 0;
    Map<Integer, Room> map = new LinkedHashMap<>();
    Room newRoom = new Room();
    Driver driver = new Driver();
    Map<Integer, House> mapMain = new LinkedHashMap<>();
    House newHouse = new House();

    public void Start() {

        while (choice != 4) {

            displayMainMenu();
            choice = getNumber();

            if (choice == 1) {
                createNewRoom();
            } else if (choice == 2) {
                showRoomsFromDatabase();
            } else if (choice == 3) {
                driver.deleteAllRooms();
            }
        }
    }
    public void HouseMenu() {

        while (choice != 4) {

            displayMainMenu();
            choice = getNumber();

            if (choice == 1) {
                createNewRoom();
            } else if (choice == 2) {
                showRoomsFromDatabase();
            } else if (choice == 3) {
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
        ShowAllRooms(map);
        PressKey();
    }

    private void createNewRoom() {
        newRoom = NewRoom();
        PressKey();
        driver.getConnectionToInsertOrUpdate(insertRoom(newRoom));
    }

    private void createNewHouse() {
        //newHouse = NewHouse();
        PressKey();
        driver.getConnectionToInsertOrUpdate(insertRoom(newRoom));
    }

    private void displayMainMenu() {
        System.out.println(HELLO_MESSAGE);
        System.out.println(CHOICE_COMUNICAT);
        System.out.println("1 - " + MENU_CHOICE_CREATE_NEW_HOUSE);
        System.out.println("2 - " + MENU_CHOISE_SHOW_HOUSES);
        System.out.println("3 - " + HOUSES_MENU_DELETE_SOME_HOUSES);
        System.out.println("4 - " + MENU_CHOISE_EXIT);

    }

    private void displayMenu() {

        System.out.println(WHICH_HOUSE);
        System.out.println("1 - " + MENU_CHOICE_CREATE_NEW_HOUSE);
        System.out.println("2 - " + MENU_CHOISE_SHOW_HOUSES);
        System.out.println("3 - " + HOUSES_MENU_DELETE_SOME_HOUSES);
        System.out.println("4 - " + MENU_CHOISE_EXIT);
    }

    private void displayRoomsMenu() {
        System.out.println(CHOICE_COMUNICAT);
        System.out.println("1 - " + MENU_CHOICE_CREATE_NEW_ROOM);
        System.out.println("2 - " + MENU_CHOISE_SHOW_ROOMS);
        System.out.println("3 - " + MENU_CHOISE_DELETE_ALL_ROOMS);
        System.out.println("4 - " + MENU_CHOISE_EXIT);
    }

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
        showRoom(exampleRoom);
        return exampleRoom;
    }

    public Room createRoomFromInputNumbers() {
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





}
