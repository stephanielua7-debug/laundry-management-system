
package view;

import model.LaundryOrder;
import model.LaundryService;
import java.util.Collection;

public class LaundryReceivingView {

    // Displays all available laundry services.
    public void displayServices(Collection<LaundryService> services) {

        System.out.println("\n========== AVAILABLE SERVICES ==========");

        // Checks if there are no available services.
        if (services.isEmpty()) {
            System.out.println("No laundry services available.");
            return;
        }

        // Displays each laundry service.
        for (LaundryService service : services) {
            System.out.println(service);
        }
    }

    // Displays the receipt of a laundry order.
    public void displayOrder(LaundryOrder order) {

        System.out.println("\n========== LAUNDRY RECEIPT ==========");

        // Displays the order and customer information.
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer ID: " + order.getCustomerId());
        System.out.println("Service ID: " + order.getServiceId());
        System.out.println("Laundry Weight: " + order.getWeightKg() + " kg");

        // Displays the total amount with two decimal places.
        System.out.printf("Total Amount: PHP %.2f%n",
                order.getTotalAmount());

        // Displays the dates, status, and payment information.
        System.out.println("Received Date: " + order.getReceivedDate());
        System.out.println("Due Date: " + order.getDueDate());
        System.out.println("Status: " + order.getStatus());
        System.out.println("Payment: " + order.getPaymentStatus());

        System.out.println("=====================================");
    }
}
