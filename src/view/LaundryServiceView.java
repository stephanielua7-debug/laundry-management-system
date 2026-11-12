
package view;

import model.LaundryService;
import java.util.Collection;

public class LaundryServiceView {

    public void displayServices(Collection<LaundryService> services) {

        System.out.println("\n========== LAUNDRY SERVICES ==========");

        if (services.isEmpty()) {
            System.out.println("No services available.");
            return;
        }

        for (LaundryService service : services) {
            System.out.println(service);
        }

        System.out.println("======================================");
    }
}
