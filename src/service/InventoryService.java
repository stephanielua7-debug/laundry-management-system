package service;

import model.Inventory;
import repository.InventoryRepository;
import java.util.ArrayList;
import util.IdGenerator;

public class InventoryService {

    private InventoryRepository repository = new InventoryRepository();

    public void addItem(
            String name, double quantity,
            String unit, double reorderLevel) {

        int id = IdGenerator.generateInventoryId();

        Inventory item = new Inventory(
                id, name, quantity, unit, reorderLevel);

        repository.add(item);
    }

    public ArrayList<Inventory> getAllItems() {
        return repository.getAll();
    }

    public Inventory getItemById(int id) {
        return repository.findById(id);
    }

    public boolean updateItem(
            int id, String name, double quantity,
            String unit, double reorderLevel) {

        Inventory item = new Inventory(
                id, name, quantity, unit, reorderLevel);

        return repository.update(item);
    }

    public boolean deleteItem(int id) {
        return repository.delete(id);
    }

    public ArrayList<Inventory> getLowStockItems() {

        ArrayList<Inventory> lowStock = new ArrayList<>();

        for (Inventory item : repository.getAll()) {

            if (item.getQuantity() <= item.getReorderLevel()) {

                lowStock.add(item);
            }
        }

        return lowStock;
    }
}
