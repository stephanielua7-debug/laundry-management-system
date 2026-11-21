import java.util.Scanner;

import controller.*;
import repository.*;
import service.*;
import view.*;

public class Main {

        // =================================
        // CLEAR TERMINAL SCREEN
        // =================================
        public static void clearScreen() {
                System.out.print("\033[H\033[2J");
                System.out.flush();
        }

        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                // =================================
                // ADMIN LOGIN
                // =================================

                AdminLoginView loginView = new AdminLoginView(scanner);

                AdminController adminController = new AdminController(loginView);

                boolean loggedIn = false;

                while (!loggedIn) {

                        clearScreen();

                        loggedIn = adminController.login();

                        if (!loggedIn) {
                                System.out.println("\nPress ENTER to try again...");
                                scanner.nextLine();
                        }
                }

                // =================================
                // REPOSITORIES
                // =================================

                CustomerRepository customerRepository = new CustomerRepository();

                LaundryOrderRepository orderRepository = new LaundryOrderRepository();

                LaundryServiceRepository serviceRepository = new LaundryServiceRepository();

                LaundryPaymentRepository paymentRepository = new LaundryPaymentRepository();

                // =================================
                // SERVICES
                // =================================

                CustomerService customerService = new CustomerService(customerRepository);

                LaundryServiceManager laundryServiceManager = new LaundryServiceManager(serviceRepository);

                LaundryReceivingService receivingService = new LaundryReceivingService();

                LaundryProcessingService processingService = new LaundryProcessingService(orderRepository);

                LaundryReleasingService releasingService = new LaundryReleasingService(orderRepository);

                LaundryPaymentService paymentService = new LaundryPaymentService(
                                orderRepository,
                                paymentRepository);

                LaundryReportService reportService = new LaundryReportService(
                                orderRepository,
                                customerRepository,
                                serviceRepository);

                // =================================
                // VIEWS
                // =================================

                MainMenu mainMenu = new MainMenu();

                CustomerView customerView = new CustomerView();

                // Pass the existing Scanner
                LaundryReceivingView receivingView = new LaundryReceivingView(scanner);

                LaundryServiceView serviceView = new LaundryServiceView();

                LaundryProcessingView processingView = new LaundryProcessingView();

                LaundryReleasingView releasingView = new LaundryReleasingView();

                PaymentView paymentView = new PaymentView();

                LaundryReportView reportView = new LaundryReportView();

                // =================================
                // CONTROLLERS
                // =================================

                CustomerController customerController = new CustomerController(
                                customerService,
                                customerView);

                // Updated constructor to match
                // LaundryReceivingController
                LaundryReceivingController receivingController = new LaundryReceivingController(
                                receivingService,
                                customerService,
                                laundryServiceManager,
                                receivingView);

                LaundryServiceController serviceController = new LaundryServiceController(
                                laundryServiceManager,
                                serviceView);

                LaundryProcessingController processingController = new LaundryProcessingController(
                                processingService,
                                orderRepository,
                                processingView);

                LaundryReleasingController releasingController = new LaundryReleasingController(
                                releasingService,
                                orderRepository,
                                releasingView);

                PaymentController paymentController = new PaymentController(
                                paymentService,
                                orderRepository,
                                paymentView);

                LaundryReportController reportController = new LaundryReportController(
                                reportService,
                                reportView);

                // =================================
                // DEFAULT LAUNDRY SERVICES
                // =================================

                laundryServiceManager.addService(
                                "Wash and Dry",
                                "Washing and drying only",
                                35.00);

                laundryServiceManager.addService(
                                "Wash, Dry and Fold",
                                "Complete laundry service",
                                45.00);

                laundryServiceManager.addService(
                                "Ironing",
                                "Ironing service",
                                25.00);

                // =================================
                // MAIN PROGRAM
                // =================================

                boolean running = true;

                while (running) {

                        clearScreen();

                        int choice = mainMenu.displayMenu();

                        switch (choice) {

                                case 1:
                                        // Customer Management
                                        customerController.showMenu();
                                        break;

                                case 2:
                                        // Receive Laundry
                                        receivingController.receiveLaundry();
                                        break;

                                case 3:
                                        // Laundry Service Management
                                        serviceController.showMenu();
                                        break;

                                case 4:
                                        // Laundry Processing
                                        processingController.showMenu();
                                        break;

                                case 5:
                                        // Release Completed Laundry
                                        releasingController.releaseLaundry();
                                        break;

                                case 6:
                                        // Laundry Reports
                                        reportController.displayReport();
                                        break;

                                case 7:
                                        // Payment Management
                                        paymentController.showMenu();
                                        break;

                                case 0:
                                        // Exit Program
                                        clearScreen();

                                        System.out.println(
                                                        "\n==================================");

                                        System.out.println(
                                                        " THANK YOU FOR USING MY SYSTEM!");

                                        System.out.println(
                                                        "==================================");

                                        running = false;
                                        break;

                                default:
                                        System.out.println("\nInvalid choice!");
                                        System.out.println("Press ENTER to continue...");
                                        scanner.nextLine();
                                        break;
                        }
                }

                // =================================
                // CLOSE SCANNER
                // =================================

                scanner.close();
        }
}
