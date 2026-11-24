package view;

import java.util.Scanner;
import model.LaundryOrder;
import model.LaundryItem;

public class LaundryReceivingView {

    private Scanner scanner;

    public LaundryReceivingView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public int getInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(scanner.nextLine().trim());

                if (value > 0) {
                    return value;
                }

                System.out.println("Please enter a number greater than zero.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    public double getWeight() {
        while (true) {
            try {
                System.out.print("Enter Total Weight (kg): ");

                double weight = Double.parseDouble(
                        scanner.nextLine().trim());

                if (Double.isFinite(weight) && weight > 0) {
                    return weight;
                }

                System.out.println("Weight must be greater than zero.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid weight. Try again.");
            }
        }
    }

    public void displayServices() {
        System.out.println("\n========== AVAILABLE SERVICES ==========");
        System.out.println("1. Wash and Dry       - PHP 35/kg");
        System.out.println("2. Wash, Dry and Fold - PHP 45/kg");
        System.out.println("3. Ironing            - PHP 25/kg");
    }

    public int selectService() {
        while (true) {
            int choice = getInteger("Select Service: ");

            if (choice >= 1 && choice <= 3) {
                return choice;
            }

            System.out.println("Invalid service selection.");
        }
    }

    public void displayOrderSummary(LaundryOrder order) {

        System.out.println("\n========================================");
        System.out.println("           LAUNDRY ORDER SUMMARY");
        System.out.println("========================================");

        System.out.println("Order ID: " + order.getOrderId());

        System.out.println("Customer: " + order.getCustomer().getCustomerName());

        System.out.println("Contact: " + order.getCustomer().getContactNumber());

        System.out.println("\nLaundry Items:");

        int totalPieces = 0;

        for (LaundryItem item : order.getLaundryItems()) {
            System.out.println("- " + item);
            totalPieces += item.getQuantity();
        }

        System.out.println("Total Pieces: " + totalPieces);

        System.out.println("\nService: " + order.getServiceName());

        System.out.printf("Weight: %.2f kg%n", order.getWeight());

        System.out.printf("Price per kg: PHP %.2f%n",
                order.getPricePerKg());

        System.out.printf("Total Amount: PHP %.2f%n",
                order.getTotalAmount());

        System.out.println("========================================");
    }
}
