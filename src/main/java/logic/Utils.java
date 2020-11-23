package logic;

import java.util.Scanner;

public class Utils {
    private static final String TYPE_NUMBER = "Type number!: ";

    private static final Scanner scan = new Scanner(System.in);

    public static void PressKey() {

        System.out.println("Press enter to continue...");
        scan.nextLine();
    }

    public static int getNumber() {
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println(TYPE_NUMBER);
        }
        return scan.nextInt();
    }

    public static double getDouble() {
        while (!scan.hasNextDouble()) {
            scan.next();
            System.out.println(TYPE_NUMBER);
        }
        return scan.nextDouble();

    }

}
