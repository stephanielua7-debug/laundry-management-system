
package view;

import util.ConsoleHelper;

public class MainMenu {

    public int displayMenu() {

        System.out.println("\n==============================================");
        System.out.println("          LAUNDRY MANAGEMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("1. Customer Management");
        System.out.println("2. Laundry Receiving");
        System.out.println("3. Laundry Services");
        System.out.println("4. Laundry Processing");
        System.out.println("5. Laundry Releasing");
        System.out.println("6. Laundry Records and Reports");
        System.out.println("7. Payment Management");
        System.out.println("0. Exit");
        System.out.println("==============================================");

        return ConsoleHelper.readInt("Enter your choice: ");
    }
}
