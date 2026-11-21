package view;

import model.Customer;
import java.util.Collection;

public class CustomerView {

    // Displays the list of customers.
    public void displayCustomers(Collection<Customer> customers) {

        System.out.println("\n========== CUSTOMER LIST ==========");

        // Checks if there are no customers to display.
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        // Loops through the collection and displays each customer.
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("===================================");
    }

    // Displays messages to the user.
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
