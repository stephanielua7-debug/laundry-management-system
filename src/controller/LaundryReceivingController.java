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

public class LaundryReceivingController {

    private LaundryReceivingView view;
    private LaundryReceivingService service;
    private CustomerService customerService;
    private LaundryServiceManager laundryServiceManager;

    private List<LaundryItem> pendingItems = new ArrayList<>();

    // CONSTRUCTOR
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

        System.out.println("\n========== LAUNDRY RECEIVING ==========");

        pendingItems.clear();

        // DISPLAY REGISTERED CUSTOMERS
        Collection<Customer> customers = customerService.getAllCustomers();

        if (customers.isEmpty()) {

            System.out.println("\nNo registered customers found!");
            System.out.println("Please add a customer first.");

            view.getInput("\nPress ENTER to continue...");
            return;
        }

        System.out.println("\n========== REGISTERED CUSTOMERS ==========");

        for (Customer customer : customers) {

            System.out.println(
                    customer.getCustomerId() + " - "
                            + customer.getCustomerName() + " - "
                            + customer.getContactNumber());
        }

        // SELECT CUSTOMER
        Customer customer = null;

        while (customer == null) {

            String customerId = view.getInput("\nEnter Customer ID: ").trim();

            customer = customerService.findCustomerById(customerId);

            if (customer == null) {
                System.out.println("Customer not found! Try again.");
            }
        }

        System.out.println("\nCustomer Selected Successfully!");
        System.out.println("Customer Name: "
                + customer.getCustomerName());
        System.out.println("Contact Number: "
                + customer.getContactNumber());

        // LAUNDRY ITEMS
        System.out.println("\n========== LAUNDRY ITEMS ==========");
        System.out.println("Enter the clothes submitted by the customer.");
        System.out.println("Press ENTER on Item Name when finished.\n");

        int totalPieces = 0;

        while (true) {

            String itemName = view.getInput("Item Name: ");

            if (itemName.trim().isEmpty()) {

                if (totalPieces == 0) {
                    System.out.println(
                            "Please enter at least one laundry item.");
                    continue;
                }

                break;
            }

            int quantity = view.getInteger("Quantity: ");

            if (quantity <= 0) {
                System.out.println(
                        "Quantity must be greater than zero.");
                continue;
            }

            pendingItems.add(new LaundryItem(itemName, quantity));

            totalPieces += quantity;

            System.out.println("Item added successfully!\n");
        }

        // SELECT DYNAMIC LAUNDRY SERVICE
        Collection<LaundryService> availableServices = laundryServiceManager.getAllServices();

        if (availableServices.isEmpty()) {

            System.out.println("\nNo laundry services available!");
            pendingItems.clear();

            view.getInput("\nPress ENTER to continue...");
            return;
        }

        List<LaundryService> serviceList = new ArrayList<>(availableServices);

        System.out.println("\n========== AVAILABLE LAUNDRY SERVICES ==========");

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

            System.out.println("\nInvalid service selection!");
            pendingItems.clear();
            return;
        }

        LaundryService selectedService = serviceList.get(choice - 1);

        String serviceName = selectedService.getServiceName();

        double pricePerKg = selectedService.getPricePerKg();

        // ENTER WEIGHT
        double weight = view.getWeight();

        if (weight <= 0) {
            System.out.println("\nWeight must be greater than zero!");
            pendingItems.clear();
            return;
        }

        // CREATE ORDER
        LaundryOrder order = service.createOrder(
                customer,
                weight,
                serviceName,
                pricePerKg);

        // ADD LAUNDRY ITEMS
        for (LaundryItem item : pendingItems) {
            order.addLaundryItem(item);
        }

        // SAVE ORDER TO REPOSITORY
        service.saveOrder(order);

        // DISPLAY ORDER SUMMARY
        view.displayOrderSummary(order);

        pendingItems.clear();
    }
}