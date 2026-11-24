
package controller;

import java.util.Collection;
import java.util.Scanner;
import util.ConsoleFormatter;

import model.LaundryOrder;

import service.LaundryProcessingService;
import repository.LaundryOrderRepository;

import view.LaundryProcessingView;

public class LaundryProcessingController {

    private LaundryProcessingService service;
    private LaundryOrderRepository repository;
    private LaundryProcessingView view;
    private Scanner scanner;

    // CONSTRUCTOR
    public LaundryProcessingController(
            LaundryProcessingService service,
            LaundryOrderRepository repository,
            LaundryProcessingView view,
            Scanner scanner) {

        this.service = service;
        this.repository = repository;
        this.view = view;
        this.scanner = scanner;
    }

    // SHOW LAUNDRY PROCESSING MENU
    public void showMenu() {

        boolean running = true;

        while (running) {

            System.out.println(" LAUNDRY PROCESSING ");
            System.out.println("1. View Laundry Orders");
            System.out.println("2. Update Laundry Status");
            System.out.println("0. Back to Main Menu");

            System.out.print("\nEnter choice: ");

            try {

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        viewLaundryOrders();
                        break;

                    case 2:
                        updateLaundryStatus();
                        break;

                    case 0:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice!");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    // VIEW ALL LAUNDRY ORDERS
    public void viewLaundryOrders() {

        Collection<LaundryOrder> orders = repository.findAll();

        view.displayOrders(orders);

        System.out.print("\nPress ENTER to continue...");
        scanner.nextLine();
    }

    // UPDATE LAUNDRY STATUS
    public void updateLaundryStatus() {

        System.out.println("\n========== UPDATE LAUNDRY STATUS ==========");

        Collection<LaundryOrder> orders = repository.findAll();

        if (orders.isEmpty()) {

            System.out.println("\nNo laundry orders available!");

            System.out.print("\nPress ENTER to continue...");
            scanner.nextLine();
            return;
        }

        // DISPLAY REGISTERED ORDERS
        view.displayOrders(orders);

        // ENTER ORDER ID
        System.out.print("\nEnter Order ID: ");

        String orderId = scanner.nextLine().trim();

        LaundryOrder order = repository.findById(orderId);

        if (order == null) {

            System.out.println("\nOrder not found!");

            System.out.print("\nPress ENTER to continue...");
            scanner.nextLine();
            return;
        }

        // DISPLAY ORDER INFORMATION
        System.out.println("\n========== ORDER INFORMATION ==========");

        System.out.println("Order ID: " + order.getOrderId());

        System.out.println("Customer: "
                + order.getCustomer().getCustomerName());

        System.out.println("Current Status: "
                + order.getOrderStatus());

        // DISPLAY STATUS OPTIONS
        view.displayStatusOptions();

        System.out.print("\nSelect New Status: ");

        try {

            int choice = Integer.parseInt(scanner.nextLine());

            service.updateLaundryStatus(orderId, choice);

            System.out.println("\nLaundry status updated successfully!");

            System.out.println("New Status: "
                    + order.getOrderStatus());

        } catch (NumberFormatException e) {

            System.out.println("\nPlease enter a valid number!");

        } catch (IllegalArgumentException e) {

            System.out.println("\nError: " + e.getMessage());
        }

        System.out.print("\nPress ENTER to continue...");
        scanner.nextLine();
    }
}
