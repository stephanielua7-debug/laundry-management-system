package model;

public class Inventory {

    private int id;
    private String itemName;
    private double quantity;
    private String unit;
    private double reorderLevel;

    public Inventory(int id, String itemName,
            double quantity, String unit,
            double reorderLevel) {

        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unit = unit;
        this.reorderLevel = reorderLevel;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public double getReorderLevel() {
        return reorderLevel;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setReorderLevel(double reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Item: " + itemName
                + " | Quantity: " + quantity + " " + unit
                + " | Reorder Level: " + reorderLevel
                + " | Status: "
                + (quantity <= reorderLevel
                        ? "LOW STOCK"
                        : "AVAILABLE");
    }
}
