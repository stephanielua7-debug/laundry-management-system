import java.util.Scanner;

import controller.CustomerController;
import controller.OrderController;
import controller.PaymentController;
import controller.InventoryController;
import controller.ReportController;

import view.MainMenu;
import util.ConsoleHelper;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MainMenu menu = new MainMenu();

        boolean running = true;

        while (running) {

            menu.display();

            int choice = menu.getChoice(scanner);

            switch (choice) {

                case 1:

                    CustomerController customerController = new CustomerController(scanner);

                    customerController.run();

                    break;

                case 2:

                    OrderController serviceController = new OrderController(scanner);

                    serviceController.manageServices();

                    break;

                case 3:

                    OrderController orderController = new OrderController(scanner);

                    orderController.run();

                    break;

                case 4:

                    PaymentController paymentController = new PaymentController(scanner);

                    paymentController.run();

                    break;

                case 5:

                    InventoryController inventoryController = new InventoryController(scanner);

                    inventoryController.run();

                    break;

                case 6:

                    ReportController reportController = new ReportController();

                    reportController.run();

                    ConsoleHelper.pause(scanner);

                    break;

                case 0:

                    running = false;

                    System.out.println(
                            "\nThank you for using "
                                    + "Laundry Management System!");

                    break;

                default:

                    System.out.println(
                            "Invalid choice! Please try again.");

                    ConsoleHelper.pause(scanner);

                    break;
            }
        }

        scanner.close();
    }
}
