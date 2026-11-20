package model;

// LaundryItem class belongs to the model package.
public class LaundryItem {

    // Private attributes to store laundry item information.
    private String itemName;
    private int quantity;

    // Constructor: initializes the item name and quantity
    // whenever a new LaundryItem object is created.
    public LaundryItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // Getter: returns the name of the laundry item.
    public String getItemName() {
        return itemName;
    }

    // Getter: returns the quantity of the laundry item.
    public int getQuantity() {
        return quantity;
    }

    // toString(): displays the quantity and item name
    // in a readable format.
    @Override
    public String toString() {
        return quantity + " x " + itemName;
    }
}
