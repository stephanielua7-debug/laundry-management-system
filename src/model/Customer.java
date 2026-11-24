
package model;

public class Customer extends Person {

    private String email;

    public Customer(String customerId, String customerName,
            String contactNumber, String email) {

        super(customerId, customerName, contactNumber);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "%-12s | %-20s | %-13s | %s",
                getCustomerId(),
                getCustomerName(),
                getContactNumber(),
                email);
    }
}
