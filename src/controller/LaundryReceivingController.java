
package controller;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.LaundryOrder;
import model.LaundryItem;

import service.LaundryReceivingService;
import service.CustomerService;
import service.LaundryServiceManager;

import view.LaundryReceivingView;

public class LaundryReceivingController {

    private LaundryReceivingView view;
    private LaundryReceivingService service;

    private List<LaundryItem> pendingItems = new ArrayList<>();

    // CONSTRUCTOR
    public LaundryReceivingController(
            LaundryReceivingService service,
            CustomerService customerService,
            LaundryServiceManager laundryServiceManager,
            LaundryReceivingView view) {

        this.service = service;
        this.view = view;
    }

    // RECEIVE LAUNDRY
    public void receiveLaundry() {

        System.out.println("\n========== LAUNDRY RECEIVING ==========");
        System.out.println("ADMIN: Enter Customer Information\n");

        pendingItems.clear();

        // CUSTOMER INFORMATION
        String name;

        do {
            name = view.getInput("Customer Name: ");

            if (name.isEmpty()) {
                System.out.println("Customer name cannot be empty.");
            }

        } while (name.isEmpty());

        String contact;

        do {
            contact = view.getInput("Contact Number: ");

            if (contact.isEmpty()) {
                System.out.println("Contact number cannot be empty.");
            }

        } while (contact.isEmpty());

        Customer customer = new Customer(name, contact);

        // LAUNDRY ITEMS
        System.out.println("\n========== LAUNDRY ITEMS ==========");
        System.out.println("Enter the clothes submitted by the customer.");
        System.out.println("Press ENTER on Item Name when finished.\n");

        int totalPieces = 0;

        while (true) {

            String itemName = view.getInput("Item Name: ");

            if (itemName.isEmpty()) {

                if (totalPieces == 0) {
                    System.out.println(
                            "Please enter at least one laundry item.");
                    continue;
                }

                break;
            }

            int quantity = view.getInteger("Quantity: ");

            pendingItems.add(new LaundryItem(itemName, quantity));

            totalPieces += quantity;

            System.out.println("Item added successfully!\n");
        }

        // SELECT LAUNDRY SERVICE
        view.displayServices();

        int choice = view.selectService();

        String serviceName;
        double pricePerKg;

        switch (choice) {

            case 1:
                serviceName = "Wash and Dry";
                pricePerKg = 35;
                break;

            case 2:
                serviceName = "Wash, Dry and Fold";
                pricePerKg = 45;
                break;

            default:
                serviceName = "Ironing";
                pricePerKg = 25;
                break;
        }

        // ENTER WEIGHT
        double weight = view.getWeight();

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

        // DISPLAY ORDER SUMMARY
        view.displayOrderSummary(order);

        pendingItems.clear();
    }
}
