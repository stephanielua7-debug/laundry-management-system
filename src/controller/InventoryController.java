package controller;

import java.util.Scanner;

import model.Inventory;
import service.InventoryService;

import util.InputValidator;
import util.ConsoleHelper;

import view.InventoryView;

public class InventoryController {

    private Scanner scanner;

    private InventoryService service = new InventoryService();

    private InventoryView view = new InventoryView();

    public InventoryController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {

        boolean running = true;

        while (running) {

            ConsoleHelper.printHeader(
                    "INVENTORY MANAGEMENT");

            System.out.println("1. Add Inventory");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Inventory");
            System.out.println("4. Delete Inventory");
            System.out.println("5. View Low Stock");
            System.out.println("0. Back");

            int choice = InputValidator.getInt(
                    scanner, "Enter choice: ");

            switch (choice) {

                case 1:
                    addItem();
                    break;

                case 2:
                    viewItems();
                    break;

                case 3:
                    updateItem();
                    break;

                case 4:
                    deleteItem();
                    break;

                case 5:
                    viewLowStock();
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

    private void addItem() {

        String name = InputValidator.getString(
                scanner, "Item Name: ");

        double quantity = InputValidator.getNonNegativeDouble(
                scanner, "Quantity: ");

        String unit = InputValidator.getString(
                scanner, "Unit (bottle, kg, pack): ");

        double reorderLevel = InputValidator.getNonNegativeDouble(
                scanner, "Reorder Level: ");

        service.addItem(
                name, quantity, unit, reorderLevel);

        System.out.println(
                "Inventory item successfully added!");
    }

    private void viewItems() {

        view.displayInventory(
                service.getAllItems());
    }

    private void updateItem() {

        int id = InputValidator.getInt(
                scanner, "Enter Item ID: ");

        Inventory item = service.getItemById(id);

        if (item == null) {

            System.out.println("Item not found!");
            return;
        }

        String name = InputValidator.getString(
                scanner, "New Item Name: ");

        double quantity = InputValidator.getNonNegativeDouble(
                scanner, "New Quantity: ");

        String unit = InputValidator.getString(
                scanner, "New Unit: ");

        double reorderLevel = InputValidator.getNonNegativeDouble(
                scanner, "New Reorder Level: ");

        service.updateItem(
                id, name, quantity, unit, reorderLevel);

        System.out.println("Inventory updated!");
    }

    private void deleteItem() {

        int id = InputValidator.getInt(
                scanner, "Enter Item ID: ");

        if (service.deleteItem(id)) {

            System.out.println("Item deleted!");

        } else {

            System.out.println("Item not found!");
        }
    }

    private void viewLowStock() {

        view.displayInventory(
                service.getLowStockItems());
    }
}