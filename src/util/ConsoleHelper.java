package util;

import java.util.Scanner;

public class ConsoleHelper {

    public static void printLine() {

        System.out.println("==============================================");
    }

    public static void printHeader(String title) {

        printLine();

        System.out.println("       " + title);

        printLine();
    }

    public static void pause(Scanner scanner) {

        System.out.println();
        System.out.print("Press ENTER to continue...");

        scanner.nextLine();
    }

    public static void printMessage(String message) {

        System.out.println("\n" + message);
    }
}
