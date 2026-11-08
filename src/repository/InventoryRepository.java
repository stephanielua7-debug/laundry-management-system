package repository;

import model.Inventory;
import java.util.ArrayList;

public class InventoryRepository {

    private static ArrayList<Inventory> inventory = new ArrayList<>();

    public void add(Inventory item) {
        inventory.add(item);
    }

    public ArrayList<Inventory> getAll() {
        return new ArrayList<>(inventory);
    }

    public Inventory findById(int id) {

        for (Inventory item : inventory) {

            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public boolean update(Inventory updatedItem) {

        Inventory item = findById(updatedItem.getId());

        if (item != null) {

            item.setItemName(updatedItem.getItemName());

            item.setQuantity(updatedItem.getQuantity());

            item.setUnit(updatedItem.getUnit());

            item.setReorderLevel(
                    updatedItem.getReorderLevel());

            return true;
        }

        return false;
    }

    public boolean delete(int id) {

        Inventory item = findById(id);

        if (item != null) {
            inventory.remove(item);
            return true;
        }

        return false;
    }
}
