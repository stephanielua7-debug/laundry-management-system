
package service;

import model.Customer;
import model.LaundryItem;
import model.LaundryOrder;

public class LaundryReceivingService {

    private int orderCounter = 1001;

    public LaundryOrder createOrder(
            Customer customer,
            double weight,
            String serviceName,
            double pricePerKg) {

        String orderId = "ORD-" + orderCounter++;

        return new LaundryOrder(
                orderId,
                customer,
                weight,
                serviceName,
                pricePerKg);
    }

    public void addLaundryItem(
            LaundryOrder order,
            String itemName,
            int quantity) {

        LaundryItem item = new LaundryItem(itemName, quantity);

        order.addLaundryItem(item);
    }
}
