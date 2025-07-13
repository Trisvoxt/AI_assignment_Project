package util;

import java.util.Scanner;

public class InputHelper {
    public static int readInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public static double readDouble(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public static String readString(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
