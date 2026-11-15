
package controller;

import service.LaundryProcessingService;
import repository.LaundryOrderRepository;
import view.LaundryProcessingView;
import util.ConsoleHelper;

public class LaundryProcessingController {

    private LaundryProcessingService processingService;
    private LaundryOrderRepository orderRepository;
    private LaundryProcessingView processingView;

    public LaundryProcessingController(
            LaundryProcessingService processingService,
            LaundryOrderRepository orderRepository,
            LaundryProcessingView processingView) {

        this.processingService = processingService;
        this.orderRepository = orderRepository;
        this.processingView = processingView;
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n========== LAUNDRY PROCESSING ==========");
            System.out.println("1. View Laundry Orders");
            System.out.println("2. Update Laundry Status");
            System.out.println("0. Back to Main Menu");

            int choice = ConsoleHelper.readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    processingView.displayOrders(
                            orderRepository.findAll());
                    ConsoleHelper.pause();
                    break;

                case 2:
                    updateStatus();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void updateStatus() {

        processingView.displayOrders(
                orderRepository.findAll());

        String orderId = ConsoleHelper.readString("Enter Order ID: ");

        processingView.displayStatusOptions();

        int statusChoice = ConsoleHelper.readInt("Select New Status: ");

        try {

            processingService.updateLaundryStatus(
                    orderId,
                    statusChoice);

            System.out.println("\nLaundry Status Updated Successfully!");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        ConsoleHelper.pause();
    }
}
