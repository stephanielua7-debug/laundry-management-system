package view;

import model.Customer;
import java.util.ArrayList;

public class CustomerView {

    public void displayCustomers(
            ArrayList<Customer> customers) {

        System.out.println("\nCUSTOMER LIST");
        System.out.println("--------------------------------");

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
