
package controller;

import java.util.Scanner;

import service.PaymentService;
import service.OrderService;

import util.InputValidator;
import util.ConsoleHelper;

import view.PaymentView;
import model.Order;

public class PaymentController {

    private Scanner scanner;

    private PaymentService paymentService = new PaymentService();
    private OrderService orderService = new OrderService();
    private PaymentView view = new PaymentView();

    public PaymentController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        boolean running = true;

        while (running) {

            ConsoleHelper.printHeader("PAYMENT MANAGEMENT");

            System.out.println("1. Add Payment");
            System.out.println("2. View Payments");
            System.out.println("3. Delete Payment");
            System.out.println("0. Back");

            int choice = InputValidator.getInt(
                    scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                    addPayment();
                    break;

                case 2:
                    viewPayments();
                    break;

                case 3:
                    deletePayment();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            if (running) {
                ConsoleHelper.pause(scanner);
            }
        }
    }

    // ADD PAYMENT
    private void addPayment() {

        System.out.println("\n========== AVAILABLE ORDERS ==========");

        for (Order order : orderService.getAllOrders()) {
            System.out.println(order);
        }

        int orderId = InputValidator.getInt(
                scanner, "Enter Order ID: ");

        double amount = InputValidator.getPositiveDouble(
                scanner, "Payment Amount: PHP ");

        System.out.println("\n========== PAYMENT METHODS ==========");
        System.out.println("1. CASH");
        System.out.println("2. E-WALLET");
        System.out.println("3. DEBIT CARD");
        System.out.println("4. CREDIT CARD");
        System.out.println("5. BANK TRANSFER");

        int choice = InputValidator.getInt(
                scanner, "Select Payment Method: ");

        String method;

        switch (choice) {

            case 1:
                method = "CASH";
                break;

            case 2:
                method = "E-WALLET";
                break;

            case 3:
                method = "DEBIT CARD";
                break;

            case 4:
                method = "CREDIT CARD";
                break;

            case 5:
                method = "BANK TRANSFER";
                break;

            default:
                System.out.println("Invalid payment method!");
                return;
        }

        System.out.println("\n========== PAYMENT CONFIRMATION ==========");
        System.out.println("Order ID: " + orderId);
        System.out.println("Payment Amount: PHP " + amount);
        System.out.println("Payment Method: " + method);

        if (paymentService.addPayment(orderId, amount, method)) {

            System.out.println("\nPayment successfully recorded!");

        } else {

            System.out.println(
                    "\nPayment failed! Check the order ID "
                            + "and remaining balance.");
        }
    }

    // VIEW PAYMENTS
    private void viewPayments() {

        System.out.println("\n========== PAYMENT RECORDS ==========");

        view.displayPayments(
                paymentService.getAllPayments());
    }

    // DELETE PAYMENT
    private void deletePayment() {

        int id = InputValidator.getInt(
                scanner, "Enter Payment ID: ");

        if (paymentService.deletePayment(id)) {

            System.out.println("\nPayment deleted successfully!");

        } else {

            System.out.println("\nPayment not found!");
        }
    }
}
