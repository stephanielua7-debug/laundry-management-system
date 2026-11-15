
package view;

import model.LaundryPayment;
import java.util.Collection;

public class PaymentView {

    public void displayPayments(Collection<LaundryPayment> payments) {

        System.out.println("\n========== PAYMENT RECORDS ==========");

        if (payments.isEmpty()) {
            System.out.println("No payment records found.");
            return;
        }

        for (LaundryPayment payment : payments) {
            System.out.println(payment);
        }

        System.out.println("=====================================");
    }

    public void displaySuccess(LaundryPayment payment) {

        System.out.println("\n========== PAYMENT RECEIPT ==========");
        System.out.println("Payment ID: " + payment.getPaymentId());
        System.out.println("Order ID: " + payment.getOrderId());

        System.out.printf("Amount Paid: PHP %.2f%n",
                payment.getAmount());

        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("Payment Date: " + payment.getPaymentDate());
        System.out.println("Payment Status: PAID");
        System.out.println("=====================================");
    }
}
