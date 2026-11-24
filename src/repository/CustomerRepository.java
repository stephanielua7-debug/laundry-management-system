
package view;

import model.Customer;
import java.util.Collection;

import util.ConsoleFormatter;

public class CustomerView {

    // Displays all registered customers with numbering.
    public void displayCustomers(Collection<Customer> customers) {

        ConsoleFormatter.printHeader("REGISTERED CUSTOMERS");

        if (customers.isEmpty()) {
            System.out.println("No registered customers.");
            return;
        }

        int number = 1;

        for (Customer customer : customers) {

            System.out.println(number + ". " + customer);
            number++;
        }

        System.out.println("========================================");
    }
}
