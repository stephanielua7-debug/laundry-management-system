package controller;

import java.util.Scanner;

import model.Order;
import model.Customer;
import model.LaundryService;

import service.OrderService;
import service.CustomerService;

import repository.ServiceRepository;

import util.InputValidator;
import util.IdGenerator;
import util.ConsoleHelper;

import view.OrderView;

public class OrderController {

    private Scanner scanner;

    private OrderService orderService = new OrderService();

    private CustomerService customerService = new CustomerService();

    private ServiceRepository serviceRepository = new ServiceRepository();

    private OrderView view = new OrderView();

    public OrderController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        boolean running = true;

        while (running) {

            ConsoleHelper.printHeader(
                    "ORDER MANAGEMENT");

            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order Status");
            System.out.println("4. Delete Order");
            System.out.println("0. Back");

            int choice = InputValidator.getInt(
                    scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                    createOrder();
                    break;

                case 2:
                    viewOrders();
                    break;

                case 3:
                    updateOrderStatus();
                    break;

                case 4:
                    deleteOrder();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            if (running) {
                ConsoleHelper.pause(scanner);
            }
        }
    }

    public void manageServices() {

        boolean running = true;

        while (running) {

            ConsoleHelper.printHeader(
                    "LAUNDRY SERVICES");

            System.out.println("1. Add Service");
            System.out.println("2. View Services");
            System.out.println("3. Update Service");
            System.out.println("4. Delete Service");
            System.out.println("0. Back");

            int choice = InputValidator.getInt(
                    scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                    addService();
                    break;

                case 2:
                    viewServices();
                    break;

                case 3:
                    updateService();
                    break;

                case 4:
                    deleteService();
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            if (running) {
                ConsoleHelper.pause(scanner);
            }
        }
    }

    private void addService() {

        String name = InputValidator.getString(
                scanner, "Service Name: ");

        String description = InputValidator.getString(
                scanner, "Description: ");

        double price = InputValidator.getPositiveDouble(
                scanner, "Price per KG: ");

        LaundryService service = new LaundryService(
                IdGenerator.generateServiceId(),
                name,
                description,
                price);

        serviceRepository.add(service);

        System.out.println("Service successfully added!");
    }

    private void viewServices() {

        System.out.println("\nAVAILABLE SERVICES");

        for (LaundryService service : serviceRepository.getAll()) {

            System.out.println(service);
        }
    }

    private void updateService() {

        int id = InputValidator.getInt(
                scanner, "Enter Service ID: ");

        LaundryService service = serviceRepository.findById(id);

        if (service == null) {

            System.out.println("Service not found!");
            return;
        }

        service.setName(
                InputValidator.getString(
                        scanner, "New Name: "));

        service.setDescription(
                InputValidator.getString(
                        scanner, "New Description: "));

        service.setPricePerKg(
                InputValidator.getPositiveDouble(
                        scanner, "New Price per KG: "));

        System.out.println("Service updated!");
    }

    private void deleteService() {

        int id = InputValidator.getInt(
                scanner, "Enter Service ID: ");

        if (serviceRepository.delete(id)) {

            System.out.println("Service deleted!");

        } else {

            System.out.println("Service not found!");
        }
    }

    private void createOrder() {

        if (customerService.getAllCustomers().isEmpty()) {

            System.out.println(
                    "Please register a customer first!");

            return;
        }

        if (serviceRepository.getAll().isEmpty()) {

            System.out.println(
                    "Please add a laundry service first!");

            return;
        }

        System.out.println("\nCUSTOMERS:");

        for (Customer customer : customerService.getAllCustomers()) {

            System.out.println(customer);
        }

        int customerId = InputValidator.getInt(
                scanner, "Enter Customer ID: ");

        if (customerService.getCustomerById(customerId) == null) {

            System.out.println("Customer not found!");
            return;
        }

        System.out.println("\nLAUNDRY SERVICES:");

        viewServices();

        int serviceId = InputValidator.getInt(
                scanner, "Enter Service ID: ");

        double weight = InputValidator.getPositiveDouble(
                scanner, "Enter Weight (KG): ");

        boolean success = orderService.createOrder(
                customerId, serviceId, weight);

        if (success) {

            System.out.println(
                    "Order successfully created!");

        } else {

            System.out.println(
                    "Unable to create order!");
        }
    }

    private void viewOrders() {

        view.displayOrders(
                orderService.getAllOrders());
    }

    private void updateOrderStatus() {

        int id = InputValidator.getInt(
                scanner, "Enter Order ID: ");

        Order order = orderService.getOrderById(id);

        if (order == null) {

            System.out.println("Order not found!");
            return;
        }

        System.out.println("1. RECEIVED");
        System.out.println("2. WASHING");
        System.out.println("3. READY");
        System.out.println("4. RELEASED");
        System.out.println("5. CANCELLED");

        int choice = InputValidator.getInt(
                scanner, "Select new status: ");

        String status;

        switch (choice) {

            case 1:
                status = "RECEIVED";
                break;

            case 2:
                status = "WASHING";
                break;

            case 3:
                status = "READY";
                break;

            case 4:
                status = "RELEASED";
                break;

            case 5:
                status = "CANCELLED";
                break;

            default:
                System.out.println("Invalid status!");
                return;
        }

        orderService.updateOrderStatus(id, status);

        System.out.println("Order status updated!");
    }

    private void deleteOrder() {

        int id = InputValidator.getInt(
                scanner, "Enter Order ID: ");

        if (orderService.deleteOrder(id)) {

            System.out.println("Order deleted!");

        } else {

            System.out.println("Order not found!")
        }
    }
}
