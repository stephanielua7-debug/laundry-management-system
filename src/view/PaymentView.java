package view;

import model.LaundryPayment;
import java.util.ArrayList;

public class PaymentView {

    public void displayPayments(
            ArrayList<LaundryPayment> payments) {

        System.out.println("\nPAYMENT LIST");
        System.out.println("--------------------------------");

        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        for (LaundryPayment payment : payments) {
            System.out.println(payment);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
