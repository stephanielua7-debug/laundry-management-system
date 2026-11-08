package view;

import java.util.Scanner;
import util.ConsoleHelper;

public class MainMenu {

    public void display() {

        ConsoleHelper.printHeader(
                "LAUNDRY MANAGEMENT SYSTEM");

        System.out.println("1. Customer Management");
        System.out.println("2. Laundry Services");
        System.out.println("3. Order Management");
        System.out.println("4. Payment Management");
        System.out.println("5. Inventory Management");
        System.out.println("6. Reports");
        System.out.println("0. Exit");

        ConsoleHelper.printLine();

        System.out.print("Enter your choice: ");
    }

    public int getChoice(Scanner scanner) {

        while (true) {

            try {

                int choice = Integer.parseInt(
                        scanner.nextLine());

                return choice;

            } catch (NumberFormatException e) {

                System.out.print(
                        "Invalid choice. Enter again: ");
            }
        }
    }
}
