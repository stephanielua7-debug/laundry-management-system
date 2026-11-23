package controller;

import model.LaundryService;
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

    // MAIN LAUNDRY SERVICES MENU
    public void showMenu() {

        while (true) {

            System.out.println("\n========== LAUNDRY SERVICES ==========");
            System.out.println("1. Add Laundry Service");
            System.out.println("2. View Laundry Services");
            System.out.println("3. Update Laundry Service");
            System.out.println("4. Delete Laundry Service");
            System.out.println("5. Search Laundry Service");
            System.out.println("0. Back to Main Menu");

            int choice = ConsoleHelper.readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    addService();
                    break;

                case 2:
                    viewServices();
                    break;

                case 3:
                    updateService();
                    break;

                case 4:
                    deleteService();
                    break;

                case 5:
                    searchService();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
                    ConsoleHelper.pause();
            }
        }
    }

    // ADD SERVICE
    private void addService() {

        try {
            String name = ConsoleHelper.readString("Service Name: ");
            String description = ConsoleHelper.readString("Description: ");
            double price = ConsoleHelper.readDouble("Price per KG: ");

            LaundryService service = serviceManager.addService(name, description, price);

            System.out.println("\nService Added Successfully!");
            serviceView.displayService(service);

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }

        ConsoleHelper.pause();
    }

    // VIEW SERVICES
    private void viewServices() {

        serviceView.displayServices(serviceManager.getAllServices());

        ConsoleHelper.pause();
    }

    // UPDATE SERVICE
    private void updateService() {

        serviceView.displayServices(serviceManager.getAllServices());

        String id = ConsoleHelper.readString("\nEnter Service ID to update: ");

        LaundryService existing = serviceManager.findService(id);

        if (existing == null) {
            System.out.println("\nService not found!");
            ConsoleHelper.pause();
            return;
        }

        System.out.println("\n========== UPDATE SERVICE ==========");

        serviceView.displayService(existing);

        try {
            String name = ConsoleHelper.readString("New Service Name: ");

            String description = ConsoleHelper.readString("New Description: ");

            double price = ConsoleHelper.readDouble("New Price per KG: ");

            LaundryService updated = serviceManager.updateService(
                    id, name, description, price);

            if (updated != null) {
                System.out.println("\nService Updated Successfully!");
                serviceView.displayService(updated);
            }

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }

        ConsoleHelper.pause();
    }

    // DELETE SERVICE
    private void deleteService() {

        serviceView.displayServices(serviceManager.getAllServices());

        String id = ConsoleHelper.readString("\nEnter Service ID to delete: ");

        LaundryService existing = serviceManager.findService(id);

        if (existing == null) {
            System.out.println("\nService not found!");
            ConsoleHelper.pause();
            return;
        }

        serviceView.displayService(existing);

        String confirmation = ConsoleHelper.readString(
                "\nAre you sure you want to delete this service? (Y/N): ");

        if (confirmation.equalsIgnoreCase("Y")) {

            boolean deleted = serviceManager.deleteService(id);

            if (deleted) {
                System.out.println("\nService Deleted Successfully!");
            } else {
                System.out.println("\nUnable to delete service.");
            }

        } else {
            System.out.println("\nDelete cancelled.");
        }

        ConsoleHelper.pause();
    }

    // SEARCH SERVICE
    private void searchService() {

        String id = ConsoleHelper.readString("\nEnter Service ID: ");

        LaundryService service = serviceManager.findService(id);

        if (service == null) {
            System.out.println("\nService not found!");
        } else {
            System.out.println("\nService Found!");
            serviceView.displayService(service);
        }

        ConsoleHelper.pause();
    }
}