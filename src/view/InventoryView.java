package view;

import model.Inventory;
import java.util.ArrayList;

public class InventoryView {

    public void displayInventory(
            ArrayList<Inventory> items) {

        System.out.println("\nINVENTORY LIST");
        System.out.println("--------------------------------");

        if (items.isEmpty()) {
            System.out.println("No inventory items found.");
            return;
        }

        for (Inventory item : items) {
            System.out.println(item);
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
