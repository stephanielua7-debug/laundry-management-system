
package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Customer;
import model.LaundryOrder;
import model.LaundryItem;
import model.LaundryService;

import service.LaundryReceivingService;
import service.CustomerService;
import service.LaundryServiceManager;

import view.LaundryReceivingView;
import util.ConsoleFormatter;

public class LaundryReceivingController {

        private LaundryReceivingView view;
        private LaundryReceivingService service;
        private CustomerService customerService;
        private LaundryServiceManager laundryServiceManager;

        private List<LaundryItem> pendingItems = new ArrayList<>();

        public LaundryReceivingController(
                        LaundryReceivingService service,
                        CustomerService customerService,
                        LaundryServiceManager laundryServiceManager,
                        LaundryReceivingView view) {

                this.service = service;
                this.customerService = customerService;
                this.laundryServiceManager = laundryServiceManager;
                this.view = view;
        }

        // RECEIVE LAUNDRY
        public void receiveLaundry() {

                ConsoleFormatter.printHeader("LAUNDRY RECEIVING");

                pendingItems.clear();

                // DISPLAY REGISTERED CUSTOMERS
                Collection<Customer> customers = customerService.getAllCustomers();

                if (customers.isEmpty()) {

                        ConsoleFormatter.printError(
                                        "No registered customers found!");

                        ConsoleFormatter.printInfo(
                                        "Please add a customer first.");

                        view.getInput("\nPress ENTER to continue...");
                        return;
                }

                ConsoleFormatter.printSection("REGISTERED CUSTOMERS");

                for (Customer customer : customers) {

                        System.out.println(
                                        customer.getCustomerId() + " - "
                                                        + customer.getCustomerName() + " - "
                                                        + customer.getContactNumber());
                }

                // SELECT CUSTOMER
                Customer customer = null;

                while (customer == null) {

                        String customerId = view.getInput(
                                        "\nEnter Customer ID: ").trim();

                        customer = customerService.findCustomerById(customerId);

                        if (customer == null) {
                                ConsoleFormatter.printError(
                                                "Customer not found! Try again.");
                        }
                }

                ConsoleFormatter.printSuccess("Customer Selected Successfully!");

                System.out.println("Customer Name: "
                                + customer.getCustomerName());

                System.out.println("Contact Number: "
                                + customer.getContactNumber());

                // LAUNDRY ITEMS
                ConsoleFormatter.printSection("LAUNDRY ITEMS");

                System.out.println(
                                "Enter the clothes submitted by the customer.");

                System.out.println(
                                "Press ENTER on Item Name when finished.\n");

                int totalPieces = 0;

                while (true) {

                        String itemName = view.getInput("Item Name: ").trim();

                        // Stop adding items when ENTER is pressed.
                        if (itemName.isEmpty()) {

                                if (totalPieces == 0) {

                                        ConsoleFormatter.printError(
                                                        "Please enter at least one laundry item.");

                                        continue;
                                }

                                System.out.println();

                                ConsoleFormatter.printSuccess(
                                                "Laundry items recorded!");

                                break;
                        }

                        int quantity = view.getInteger("Quantity: ");

                        if (quantity <= 0) {

                                ConsoleFormatter.printError(
                                                "Quantity must be greater than zero.");

                                continue;
                        }

                        // Add laundry item to the pending list.
                        pendingItems.add(new LaundryItem(itemName, quantity));

                        totalPieces += quantity;

                        ConsoleFormatter.printSuccess(
                                        "Item added successfully!");
                }

                // SELECT LAUNDRY SERVICE
                Collection<LaundryService> availableServices = laundryServiceManager.getAllServices();

                if (availableServices.isEmpty()) {

                        ConsoleFormatter.printError(
                                        "No laundry services available!");

                        pendingItems.clear();

                        view.getInput("\nPress ENTER to continue...");
                        return;
                }

                List<LaundryService> serviceList = new ArrayList<>(availableServices);

                ConsoleFormatter.printSection("AVAILABLE LAUNDRY SERVICES");

                for (int i = 0; i < serviceList.size(); i++) {

                        LaundryService laundryService = serviceList.get(i);

                        System.out.println(
                                        (i + 1) + ". "
                                                        + laundryService.getServiceName()
                                                        + " - PHP "
                                                        + String.format("%.2f",
                                                                        laundryService.getPricePerKg())
                                                        + "/kg");
                }

                int choice = view.getInteger("\nSelect Service: ");

                if (choice < 1 || choice > serviceList.size()) {

                        ConsoleFormatter.printError(
                                        "Invalid service selection!");

                        pendingItems.clear();
                        return;
                }

                LaundryService selectedService = serviceList.get(choice - 1);

                String serviceName = selectedService.getServiceName();

                double pricePerKg = selectedService.getPricePerKg();

                // ENTER WEIGHT
                double weight = view.getWeight();

                if (weight <= 0) {

                        ConsoleFormatter.printError(
                                        "Weight must be greater than zero!");

                        pendingItems.clear();
                        return;
                }

                // CREATE ORDER
                LaundryOrder order = service.createOrder(
                                customer,
                                weight,
                                serviceName,
                                pricePerKg);

                // ADD LAUNDRY ITEMS TO ORDER
                for (LaundryItem item : pendingItems) {
                        order.addLaundryItem(item);
                }

                // SAVE ORDER
                service.saveOrder(order);

                // DISPLAY ORDER SUMMARY
                view.displayOrderSummary(order);

                pendingItems.clear();
        }
}
