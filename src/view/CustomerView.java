
package view;

import model.Customer;
import java.util.List;
import util.ConsoleFormatter;

public class CustomerView {

    // Displays all registered customers
    public void displayCustomers(List<Customer> customers) {

        ConsoleFormatter.printHeader("REGISTERED CUSTOMERS");

        if (customers.isEmpty()) {
            System.out.println("No registered customers.");
            return;
        }

        System.out.printf(
                "%-5s %-12s %-20s %-15s %-25s%n",
                "No.",
                "Customer ID",
                "Customer Name",
                "Phone Number",
                "Email");

        System.out.println(
                "--------------------------------------------------------------------------");

        int number = 1;

        for (Customer customer : customers) {

            System.out.printf(
                    "%-5d %-12s %-20s %-15s %-25s%n",
                    number,
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getContactNumber(),
                    customer.getEmail());

            number++;
        }

        System.out.println(
                "==========================================================================");
    }
}
