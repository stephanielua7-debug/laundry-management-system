
package controller;

import service.CustomerService;
import view.CustomerView;

import util.ConsoleHelper;
import util.ConsoleFormatter;

public class CustomerController {

    private CustomerService customerService;
    private CustomerView customerView;

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
            System.out.println("0. Back to Main Menu");

            int choice = ConsoleHelper.readInt("Enter choice: ");

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    customerView.displayCustomers(
                            customerService.getAllCustomers());

                    ConsoleHelper.pause();
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

        try {

            System.out.println();

            System.out.println(
                    customerService.addCustomer(name, phone));

            ConsoleFormatter.printSuccess(
                    "Customer Added Successfully!");

        } catch (Exception e) {

            ConsoleFormatter.printError(e.getMessage());
        }

        ConsoleHelper.pause();
    }
}
