package controller;

import java.util.Scanner;
import model.Customer;
import service.CustomerService;
import view.CustomerView;
import util.InputValidator;
import util.ConsoleHelper;

public class CustomerController {

    private Scanner scanner;

    private CustomerService service = new CustomerService();

    private CustomerView view = new CustomerView();

    public CustomerController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        boolean running = true;

        while (running) {

            ConsoleHelper.printHeader("CUSTOMER MANAGEMENT");

            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("0. Back");

            int choice = InputValidator.getInt(scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    viewCustomers();
                    break;

                case 3:
                    updateCustomer();
                    break;

                case 4:
                    deleteCustomer();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            if (running) {
                ConsoleHelper.pause(scanner);
            }
        }
    }

    private void addCustomer() {

        String name = InputValidator.getString(scanner, "Customer Name: ");

        String phone = InputValidator.getString(scanner, "Phone Number: ");

        String address = InputValidator.getString(scanner, "Address: ");

        service.addCustomer(name, phone, address);

        view.displayMessage("Customer successfully added!");
    }

    private void viewCustomers() {

        view.displayCustomers(
                service.getAllCustomers());
    }

    private void updateCustomer() {

        int id = InputValidator.getInt(
                scanner, "Enter Customer ID: ");

        Customer customer = service.getCustomerById(id);

        if (customer == null) {

            view.displayMessage("Customer not found!");
            return;
        }

        String name = InputValidator.getString(scanner, "New Name: ");

        String phone = InputValidator.getString(scanner, "New Phone: ");

        String address = InputValidator.getString(scanner, "New Address: ");

        service.updateCustomer(id, name, phone, address);

        view.displayMessage("Customer successfully updated!");
    }

    private void deleteCustomer() {

        int id = InputValidator.getInt(scanner, "Enter Customer ID: ");

        if (service.deleteCustomer(id)) {

            view.displayMessage(
                    "Customer successfully deleted!");

        } else {

            view.displayMessage("Customer not found!");
        }
    }
}
