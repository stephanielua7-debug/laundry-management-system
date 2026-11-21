
package model;

public class Customer {

    private String customerId;
    private String customerName;
    private String contactNumber;

    // Constructor for Customer Management
    public Customer(
            String customerId,
            String customerName,
            String contactNumber) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    // Constructor for Laundry Receiving
    public Customer(String customerName, String contactNumber) {

        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    // GETTERS

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    // SETTERS

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
