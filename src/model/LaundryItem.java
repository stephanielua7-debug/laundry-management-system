
package model;

public class LaundryItem {
    private String itemName;
    private int quantity;

    public LaundryItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return quantity + " x " + itemName;
    }
}
