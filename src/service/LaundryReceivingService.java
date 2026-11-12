
package service;

import model.*;
import repository.*;
import util.IdGenerator;

import java.time.LocalDate;
import java.util.List;

public class LaundryReceivingService {

    private LaundryOrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private LaundryServiceRepository serviceRepository;

    public LaundryReceivingService(
            LaundryOrderRepository orderRepository,
            CustomerRepository customerRepository,
            LaundryServiceRepository serviceRepository) {

        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
    }

    public LaundryOrder receiveLaundry(String customerId, String serviceId, double weight, LocalDate dueDate,
            List<LaundryItem> items) {

        if (customerRepository.findById(customerId) == null) {
            throw new IllegalArgumentException("Customer not found!");
        }

        LaundryService service = serviceRepository.findById(serviceId);

        if (service == null) {
            throw new IllegalArgumentException("Service not found!");
        }

        if (weight <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be greater than zero!");
        }

        if (dueDate == null || dueDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(
                    "Due date cannot be in the past!");
        }

        double totalAmount = weight * service.getPricePerKg();

        LaundryReceiving order = new LaundryReceiving(
                IdGenerator.generateOrderId(), customerId, serviceId, weight, totalAmount, dueDate, items);

        orderRepository.save(order);

        return order;
    }
}
