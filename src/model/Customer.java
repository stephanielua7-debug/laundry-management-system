package model;

// Customer class belongs to the model package.
public class Customer {

    // Private attributes to store customer information.
    // Private means these variables cannot be accessed directly
    // from other classes.
    private String customerId;
    private String name;
    private String phone;

    // Constructor: initializes the customer's information
    // whenever a new Customer object is created.
    public Customer(String customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    // Getter: returns the customer's ID.
    public String getCustomerId() {
        return customerId;
    }

    // Getter: returns the customer's name.
    public String getName() {
        return name;
    }

    // Getter: returns the customer's phone number.
    public String getPhone() {
        return phone;
    }

    // Setter: updates the customer's name.
    public void setName(String name) {
        this.name = name;
    }

    // Setter: updates the customer's phone number.
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString(): displays customer information
    // in a readable format.
    @Override
    public String toString() {
        return "Customer ID: " + customerId
                + " | Name: " + name
                + " | Phone: " + phone;
    }
}
