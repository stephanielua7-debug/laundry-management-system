
package controller;

import model.LaundryItem;
import model.LaundryOrder;
import service.*;
import view.*;
import util.ConsoleHelper;
import util.DateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LaundryReceivingController {

    private LaundryReceivingService receivingService;
    private CustomerService customerService;
    private LaundryServiceManager laundryServiceManager;
    private LaundryReceivingView receivingView;
    private CustomerView customerView;

    public LaundryReceivingController(
            LaundryReceivingService receivingService,
            CustomerService customerService,
            LaundryServiceManager laundryServiceManager,
            LaundryReceivingView receivingView) {

        this.receivingService = receivingService;
        this.customerService = customerService;
        this.laundryServiceManager = laundryServiceManager;
        this.receivingView = receivingView;
        this.customerView = new CustomerView();
    }

    public void receiveLaundry() {

        try {

            if (customerService.getAllCustomers().isEmpty()) {
                System.out.println("Please register a customer first.");
                ConsoleHelper.pause();
                return;
            }

            customerView.displayCustomers(
                    customerService.getAllCustomers());

            String customerId = ConsoleHelper.readString("Enter Customer ID: ");

            if (customerService.findCustomer(customerId) == null) {
                System.out.println("Customer not found!");
                ConsoleHelper.pause();
                return;
            }

            receivingView.displayServices(
                    laundryServiceManager.getAllServices());

            String serviceId = ConsoleHelper.readString("Enter Service ID: ");

            double weight = ConsoleHelper.readDouble("Laundry Weight (kg): ");

            String dateInput = ConsoleHelper.readString("Due Date (YYYY-MM-DD): ");

            LocalDate dueDate = DateUtil.parseDate(dateInput);

            List<LaundryItem> items = new ArrayList<>();

            System.out.println("\nEnter Laundry Items");

            while (true) {

                String itemName = ConsoleHelper.readString(
                        "Item Name (blank to finish): ");

                if (itemName.isEmpty()) {
                    break;
                }

                int quantity = ConsoleHelper.readInt("Quantity: ");

                if (quantity <= 0) {
                    System.out.println("Quantity must be greater than zero.");
                    continue;
                }

                items.add(new LaundryItem(itemName, quantity));
            }

            LaundryOrder order = receivingService.receiveLaundry(
                    customerId,
                    serviceId,
                    weight,
                    dueDate,
                    items);

            receivingView.displayOrder(order);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

        ConsoleHelper.pause();
    }
}
