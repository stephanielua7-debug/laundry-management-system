
package model;

public class Customer {

    private String customerName;
    private String contactNumber;

    public Customer(String customerName, String contactNumber) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
