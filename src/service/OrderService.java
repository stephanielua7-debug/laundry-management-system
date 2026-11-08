package service;

import model.Order;
import model.LaundryService;
import repository.OrderRepository;
import repository.ServiceRepository;
import java.util.ArrayList;
import util.IdGenerator;
import util.DateUtil;
import java.time.LocalDate;

public class OrderService {

    private OrderRepository orderRepository = new OrderRepository();

    private ServiceRepository serviceRepository = new ServiceRepository();

    public boolean createOrder(
            int customerId, int serviceId,
            double weightKg) {

        LaundryService service = serviceRepository.findById(serviceId);

        if (service == null || weightKg <= 0) {
            return false;
        }

        int id = IdGenerator.generateOrderId();

        double totalAmount = weightKg * service.getPricePerKg();

        Order order = new Order(
                id,
                customerId,
                serviceId,
                weightKg,
                totalAmount,
                "RECEIVED",
                LocalDate.parse(DateUtil.getCurrentDate()));

        orderRepository.add(order);

        return true;
    }

    public ArrayList<Order> getAllOrders() {
        return orderRepository.getAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id);
    }

    public boolean updateOrderStatus(
            int id, String status) {

        Order order = orderRepository.findById(id);

        if (order == null) {
            return false;
        }

        order.setStatus(status);

        return orderRepository.update(order);
    }

    public boolean deleteOrder(int id) {
        return orderRepository.delete(id);
    }
}
