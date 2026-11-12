
package service;

import model.*;
import repository.*;

import java.util.Collection;

public class LaundryReportService {

    private LaundryOrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private LaundryServiceRepository serviceRepository;

    public LaundryReportService(
            LaundryOrderRepository orderRepository,
            CustomerRepository customerRepository,
            LaundryServiceRepository serviceRepository) {

        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    public Collection<LaundryOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public Customer getCustomer(String customerId) {
        return customerRepository.findById(customerId);
    }

    public LaundryService getService(String serviceId) {
        return serviceRepository.findById(serviceId);
    }

    public int getTotalOrders() {
        return orderRepository.findAll().size();
    }

    public double getTotalPaid() {

        double total = 0;

        for (LaundryOrder order : orderRepository.findAll()) {

            if (order.getPaymentStatus().equals("Paid")) {
                total += order.getTotalAmount();
            }
        }

        return total;
    }
}
