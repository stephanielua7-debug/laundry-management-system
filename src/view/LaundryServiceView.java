package view;

import model.LaundryService;
import java.util.Collection;

public class LaundryServiceView {

    // Displays all services.
    public void displayServices(Collection<LaundryService> services) {

        System.out.println("\n========== LAUNDRY SERVICES ==========");

        if (services.isEmpty()) {
            System.out.println("No services available.");
        } else {

            for (LaundryService service : services) {
                System.out.println(service);
            }
        }

        System.out.println("======================================");
    }

    // Displays one service.
    public void displayService(LaundryService service) {

        System.out.println("\n========== SERVICE INFORMATION ==========");
        System.out.println("Service ID: " + service.getServiceId());
        System.out.println("Service Name: " + service.getServiceName());
        System.out.println("Description: " + service.getDescription());
        System.out.printf("Price per KG: PHP %.2f%n",
                service.getPricePerKg());
        System.out.println("=========================================");
    }
}