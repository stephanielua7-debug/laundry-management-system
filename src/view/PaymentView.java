package view;

import model.LaundryPayment;
import java.util.Collection;

// Handles the display of payment records and receipts.
public class PaymentView {

    // Displays all payment records.
    public void displayPayments(Collection<LaundryPayment> payments) {

        System.out.println("\n========== PAYMENT RECORDS ==========");

        // Checks if there are no payment records.
        if (payments.isEmpty()) {
            System.out.println("No payment records found.");
            return;
        }

        // Displays each payment record.
        for (LaundryPayment payment : payments) {
            System.out.println(payment);
        }

        System.out.println("=====================================");
    }

    // Displays the payment receipt.
    public void displaySuccess(LaundryPayment payment) {

        System.out.println("\n========== PAYMENT RECEIPT ==========");

        // Displays payment details.
        System.out.println("Payment ID: " + payment.getPaymentId());
        System.out.println("Order ID: " + payment.getOrderId());

        // Displays the amount paid.
        System.out.printf("Amount Paid: PHP %.2f%n",
                payment.getAmount());

        // Displays payment information.
        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("Payment Date: " + payment.getPaymentDate());
        System.out.println("Payment Status: PAID");

        System.out.println("=====================================");
    }
}