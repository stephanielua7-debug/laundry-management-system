
package controller;

import service.LaundryServiceManager;
import view.LaundryServiceView;
import util.ConsoleHelper;

public class LaundryServiceController {

    private LaundryServiceManager serviceManager;
    private LaundryServiceView serviceView;

    public LaundryServiceController(
            LaundryServiceManager serviceManager,
            LaundryServiceView serviceView) {

        this.serviceManager = serviceManager;
        this.serviceView = serviceView;
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n========== LAUNDRY SERVICES ==========");
            System.out.println("1. Add Laundry Service");
            System.out.println("2. View Laundry Services");
            System.out.println("0. Back to Main Menu");

            int choice = ConsoleHelper.readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    addService();
                    break;

                case 2:
                    serviceView.displayServices(
                            serviceManager.getAllServices());
                    ConsoleHelper.pause();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void addService() {

        String name = ConsoleHelper.readString("Service Name: ");

        String description = ConsoleHelper.readString("Description: ");

        double price = ConsoleHelper.readDouble("Price per KG: ");

        try {

            System.out.println("\nService Added Successfully!");

            System.out.println(
                    serviceManager.addService(name, description, price));

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        ConsoleHelper.pause();
    }
}
