
// Import all classes from the controller package.
import controller.*;

// Import the LaundryService model class.
import model.LaundryService;

// Import all classes from the repository package.
import repository.*;

// Import all classes from the service package.
import service.*;

// Import all classes from the view package.
import view.*;

public class Main {

        public static void main(String[] args) {

                // =================================
                // REPOSITORIES
                // =================================

                // Create repositories to store and manage system data.
                CustomerRepository customerRepository = new CustomerRepository();

                LaundryOrderRepository orderRepository = new LaundryOrderRepository();

                LaundryServiceRepository serviceRepository = new LaundryServiceRepository();

                LaundryPaymentRepository paymentRepository = new LaundryPaymentRepository();

                // =================================
                // SERVICES
                // =================================

                // Handles customer-related operations.
                CustomerService customerService = new CustomerService(customerRepository);

                // Handles available laundry services.
                LaundryServiceManager laundryServiceManager = new LaundryServiceManager(serviceRepository);

                // Handles receiving laundry from customers.
                LaundryReceivingService receivingService = new LaundryReceivingService(
                                orderRepository,
                                customerRepository,
                                serviceRepository);

                // Handles the laundry processing operations.
                LaundryProcessingService processingService = new LaundryProcessingService(orderRepository);

                // Handles releasing completed laundry.
                LaundryReleasingService releasingService = new LaundryReleasingService(orderRepository);

                // Handles customer payment transactions.
                LaundryPaymentService paymentService = new LaundryPaymentService(
                                orderRepository,
                                paymentRepository);

                // Handles generating laundry reports.
                LaundryReportService reportService = new LaundryReportService(
                                orderRepository,
                                customerRepository,
                                serviceRepository);

                // =================================
                // VIEWS
                // =================================

                // Displays the main menu.
                MainMenu mainMenu = new MainMenu();

                // Displays customer information and menus.
                CustomerView customerView = new CustomerView();

                // Displays laundry receiving information.
                LaundryReceivingView receivingView = new LaundryReceivingView();

                // Displays available laundry services.
                LaundryServiceView serviceView = new LaundryServiceView();

                // Displays laundry processing information.
                LaundryProcessingView processingView = new LaundryProcessingView();

                // Displays laundry releasing information.
                LaundryReleasingView releasingView = new LaundryReleasingView();

                // Displays payment information and menus.
                PaymentView paymentView = new PaymentView();

                // Displays generated laundry reports.
                LaundryReportView reportView = new LaundryReportView();

                // =================================
                // CONTROLLERS
                // =================================

                // Connects customer operations with the customer view.
                CustomerController customerController = new CustomerController(
                                customerService,
                                customerView);

                // Controls the process of receiving customer laundry.
                LaundryReceivingController receivingController = new LaundryReceivingController(
                                receivingService,
                                customerService,
                                laundryServiceManager,
                                receivingView);

                // Controls laundry service management.
                LaundryServiceController serviceController = new LaundryServiceController(
                                laundryServiceManager,
                                serviceView);

                // Controls laundry processing operations.
                LaundryProcessingController processingController = new LaundryProcessingController(
                                processingService,
                                orderRepository,
                                processingView);

                // Controls the release of completed laundry.
                LaundryReleasingController releasingController = new LaundryReleasingController(
                                releasingService,
                                orderRepository,
                                releasingView);

                // Controls payment operations.
                PaymentController paymentController = new PaymentController(
                                paymentService,
                                orderRepository,
                                paymentView);

                // Controls the display of laundry reports.
                LaundryReportController reportController = new LaundryReportController(
                                reportService,
                                reportView);

                // =================================
                // DEFAULT LAUNDRY SERVICES
                // =================================

                // Add default laundry services when the program starts.
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

                // Controls whether the program continues running.
                boolean running = true;

                // Repeats the main menu until the user chooses to exit.
                while (running) {

                        // Display the main menu and get the user's choice.
                        int choice = mainMenu.displayMenu();

                        // Execute an action based on the selected menu option.
                        switch (choice) {

                                case 1:
                                        // Open customer management.
                                        customerController.showMenu();
                                        break;

                                case 2:
                                        // Receive laundry from customers.
                                        receivingController.receiveLaundry();
                                        break;

                                case 3:
                                        // Open laundry service management.
                                        serviceController.showMenu();
                                        break;

                                case 4:
                                        // Open laundry processing.
                                        processingController.showMenu();
                                        break;

                                case 5:
                                        // Release completed laundry.
                                        releasingController.releaseLaundry();
                                        break;

                                case 6:
                                        // Display laundry reports.
                                        reportController.displayReport();
                                        break;

                                case 7:
                                        // Open payment management.
                                        paymentController.showMenu();
                                        break;

                                case 0:
                                        // Exit the program.
                                        System.out.println("\n==================================");
                                        System.out.println(" THANK YOU FOR USING OUR SYSTEM!");
                                        System.out.println("==================================");

                                        running = false;
                                        break;

                                default:
                                        // Display a message for an invalid menu choice.
                                        System.out.println("\nInvalid choice!");
                        }
                }
        }
}
