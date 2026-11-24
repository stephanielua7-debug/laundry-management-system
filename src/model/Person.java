
package model;

public class Person {

    private String customerId;
    private String customerName;
    private String contactNumber;

    public Person(String customerId, String customerName,
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
}
