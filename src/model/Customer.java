
package model;

public class Customer {

    private String customerId;
    private String customerName;
    private String contactNumber;

    public Customer(
            String customerId,
            String customerName,
            String contactNumber) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Customer ID:" + customerId + "\nCustomerName: " + customerName
                + "\nContact Number: " + contactNumber;
    }
}
