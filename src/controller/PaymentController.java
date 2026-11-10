package controller;

import java.util.Scanner;

import service.PaymentService;
import service.OrderService;

import util.InputValidator;
import util.ConsoleHelper;

import view.PaymentView;

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

            ConsoleHelper.printHeader(
                    "PAYMENT MANAGEMENT");

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

    private void addPayment() {

        System.out.println("\nAVAILABLE ORDERS:");

        for (model.Order order : orderService.getAllOrders()) {

            System.out.println(order);
        }

        int orderId = InputValidator.getInt(
                scanner, "Enter Order ID: ");

        double amount = InputValidator.getPositiveDouble(
                scanner, "Payment Amount: PHP ");

        System.out.println("1. CASH");
        System.out.println("2. GCASH");
        System.out.println("3. BANK TRANSFER");

        int choice = InputValidator.getInt(
                scanner, "Payment Method: ");

        String method;

        switch (choice) {

            case 1:
                method = "CASH";
                break;

            case 2:
                method = "GCASH";
                break;

            case 3:
                method = "BANK TRANSFER";
                break;

            default:
                System.out.println("Invalid method!");
                return;
        }

        if (paymentService.addPayment(
                orderId, amount, method)) {

            System.out.println(
                    "Payment successfully recorded!");

        } else {

            System.out.println(
                    "Payment failed! Check the order ID "
                            + "and remaining balance.");
        }
    }

    private void viewPayments() {

        view.displayPayments(
                paymentService.getAllPayments());
    }

    private void deletePayment() {

        int id = InputValidator.getInt(
                scanner, "Enter Payment ID: ");

        if (paymentService.deletePayment(id)) {

            System.out.println("Payment deleted!");

        } else {

            System.out.println("Payment not found!");
        }
    }
}
