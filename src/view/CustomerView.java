
package view;

import model.Customer;
import java.util.Collection;

public class CustomerView {

    public void displayCustomers(Collection<Customer> customers) {

        System.out.println("\n========== CUSTOMER LIST ==========");

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }

        System.out.println("===================================");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
