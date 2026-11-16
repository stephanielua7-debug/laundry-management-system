import controller.*;

import model.LaundryService;

import repository.*;

import service.*;

import view.*;

public class Main {

        public static void main(String[] args) {

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

                LaundryReceivingService receivingService = new LaundryReceivingService(
                                orderRepository,
                                customerRepository,
                                serviceRepository);

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

                LaundryReceivingView receivingView = new LaundryReceivingView();

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

                        int choice = mainMenu.displayMenu();

                        switch (choice) {

                                case 1:
                                        customerController.showMenu();
                                        break;

                                case 2:
                                        receivingController.receiveLaundry();
                                        break;

                                case 3:
                                        serviceController.showMenu();
                                        break;

                                case 4:
                                        processingController.showMenu();
                                        break;

                                case 5:
                                        releasingController.releaseLaundry();
                                        break;

                                case 6:
                                        reportController.displayReport();
                                        break;

                                case 7:
                                        paymentController.showMenu();
                                        break;

                                case 0:

                                        System.out.println("\n==================================");
                                        System.out.println(" THANK YOU FOR USING OUR SYSTEM!");
                                        System.out.println("==================================");

                                        running = false;
                                        break;

                                default:

                                        System.out.println("\nInvalid choice!");
                        }
                }
        }
}
