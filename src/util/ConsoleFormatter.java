
package util;

import java.util.Scanner;

public class ConsoleFormatter {

    // Display horizontal line
    public static void line() {
        System.out.println("==============================================");
    }

    // Display blank space
    public static void space() {
        System.out.println();
    }

    // Display formatted title
    public static void header(String title) {
        space();
        line();
        System.out.println("             " + title);
        line();
        space();
    }

    // Display section title
    public static void section(String title) {
        space();
        System.out.println("========== " + title + " ==========");
        space();
    }

    // Display success message
    public static void success(String message) {
        space();
        System.out.println("[SUCCESS] " + message);
        space();
    }

    // Display error message
    public static void error(String message) {
        space();
        System.out.println("[ERROR] " + message);
        space();
    }

    // Display information message
    public static void info(String message) {
        space();
        System.out.println("[INFO] " + message);
        space();
    }

    // Pause program
    public static void pause(Scanner scanner) {
        space();
        System.out.print("Press ENTER to continue...");
        scanner.nextLine();
        space();
    }

    // Clear terminal screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
