
package controller;

import service.PaymentService;
import repository.LaundryOrderRepository;
import view.PaymentView;
import view.LaundryProcessingView;
import util.ConsoleHelper;

public class PaymentController {

    private PaymentService paymentService;
    private LaundryOrderRepository orderRepository;
    private PaymentView paymentView;
    private LaundryProcessingView processingView;

    public PaymentController(
            PaymentService paymentService,
            LaundryOrderRepository orderRepository,
            PaymentView paymentView) {

        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
        this.paymentView = paymentView;
        this.processingView = new LaundryProcessingView();
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n========== PAYMENT MANAGEMENT ==========");
            System.out.println("1. Pay Laundry Order");
            System.out.println("2. View Payment Records");
            System.out.println("0. Back to Main Menu");

            int choice = ConsoleHelper.readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    payOrder();
                    break;

                case 2:
                    paymentView.displayPayments(
                            paymentService.getAllPayments());
                    ConsoleHelper.pause();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void payOrder() {

        processingView.displayOrders(
                orderRepository.findAll());

        String orderId = ConsoleHelper.readString("Enter Order ID: ");

        System.out.println("\nPayment Methods");
        System.out.println("1. Cash");
        System.out.println("2. Bank Transfer");
        System.out.println("3. Other");

        int choice = ConsoleHelper.readInt("Select Payment Method: ");

        String method;

        switch (choice) {
            case 1:
                method = "Cash";
                break;

            case 2:
                method = "Bank Transfer";
                break;

            case 3:
                method = "Other";
                break;

            default:
                System.out.println("Invalid payment method!");
                ConsoleHelper.pause();
                return;
        }

        try {

            paymentView.displaySuccess(
                    paymentService.payLaundry(orderId, method));

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        ConsoleHelper.pause();
    }
}
