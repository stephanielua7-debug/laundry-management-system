package controller;

import java.util.Collection;
import java.util.Scanner;

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

            System.out.println("\n========== LAUNDRY PROCESSING ==========");

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
                        System.out.println("\nInvalid choice!");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter a valid number!");
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

        System.out.println("UPDATE LAUNDRY STATUS");

        System.out.print("\nEnter Order ID: ");
        String orderId = scanner.nextLine();

        LaundryOrder order = repository.findById(orderId);

        if (order == null) {

            System.out.println("Order not found!");

            System.out.print("\nPress ENTER to continue...");
            scanner.nextLine();
            return;
        }

        System.out.println("Customer: "
                + order.getCustomer().getCustomerName());

        System.out.println("Current Status: "
                + order.getOrderStatus());

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

            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("\nPress ENTER to continue...");
        scanner.nextLine();
    }
}
