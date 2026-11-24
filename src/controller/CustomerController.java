
package controller;

import service.CustomerService;
import view.CustomerView;

import util.ConsoleHelper;
import util.ConsoleFormatter;

import model.Customer;

import java.util.Optional;

public class CustomerController {

    private final CustomerService customerService;
    private final CustomerView customerView;

    public CustomerController(
            CustomerService customerService,
            CustomerView customerView) {

        this.customerService = customerService;
        this.customerView = customerView;
    }

    public void showMenu() {

        while (true) {

            ConsoleFormatter.printHeader("CUSTOMER MANAGEMENT");

            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("0. Back to Main Menu");

            int choice = ConsoleHelper.readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    customerView.displayCustomers(
                            customerService.listAll());

                    ConsoleHelper.pause();
                    break;

                case 3:
                    searchCustomer();
                    break;

                case 4:
                    updateCustomer();
                    break;

                case 5:
                    deleteCustomer();
                    break;

                case 0:
                    return;

                default:
                    ConsoleFormatter.printError("Invalid choice!");
                    ConsoleHelper.pause();
            }
        }
    }

    // ADD CUSTOMER
    private void addCustomer() {

        String name = ConsoleHelper.readString("Customer Name: ");
        String phone = ConsoleHelper.readString("Phone Number: ");
        String email = ConsoleHelper.readString("Email: ");

        try {

            Customer customer = customerService.register(
                    name, phone, email);

            System.out.println();

            ConsoleFormatter.printSuccess(
                    "Customer Added Successfully!");

            System.out.println("Customer ID: "
                    + customer.getCustomerId());

        } catch (Exception e) {

            ConsoleFormatter.printError(e.getMessage());
        }

        ConsoleHelper.pause();
    }

    // SEARCH CUSTOMER
    private void searchCustomer() {

        String customerId = ConsoleHelper.readString("Enter Customer ID: ");

        Optional<Customer> customer = customerService.find(customerId);

        if (customer.isPresent()) {

            ConsoleFormatter.printHeader("CUSTOMER INFORMATION");

            System.out.println(customer.get());

        } else {

            ConsoleFormatter.printError("Customer not found!");
        }

        ConsoleHelper.pause();
    }

    // UPDATE CUSTOMER
    private void updateCustomer() {

        String customerId = ConsoleHelper.readString("Enter Customer ID: ");

        Optional<Customer> found = customerService.find(customerId);

        if (found.isEmpty()) {

            ConsoleFormatter.printError("Customer not found!");
            ConsoleHelper.pause();
            return;
        }

        Customer customer = found.get();

        System.out.println("\nCurrent Customer Information:");
        System.out.println(customer);

        System.out.println("\nEnter New Information:");

        String name = ConsoleHelper.readString("Customer Name: ");
        String phone = ConsoleHelper.readString("Phone Number: ");
        String email = ConsoleHelper.readString("Email: ");

        boolean updated = customerService.update(
                customerId, name, phone, email);

        if (updated) {
            ConsoleFormatter.printSuccess(
                    "Customer Updated Successfully!");
        }

        ConsoleHelper.pause();
    }

    // DELETE CUSTOMER
    private void deleteCustomer() {

        String customerId = ConsoleHelper.readString("Enter Customer ID: ");

        Optional<Customer> found = customerService.find(customerId);

        if (found.isEmpty()) {

            ConsoleFormatter.printError("Customer not found!");
            ConsoleHelper.pause();
            return;
        }

        System.out.println("\nCustomer Information:");
        System.out.println(found.get());

        String confirm = ConsoleHelper.readString(
                "Are you sure you want to delete this customer? (Y/N): ");

        if (confirm.equalsIgnoreCase("Y")) {

            if (customerService.delete(customerId)) {

                ConsoleFormatter.printSuccess(
                        "Customer Deleted Successfully!");
            }

        } else {

            System.out.println("Delete cancelled.");
        }

        ConsoleHelper.pause();
    }
}
