package repository;

// Imports the LaundryPayment class
import model.LaundryPayment;

// Imports Java utility classes such as Map, LinkedHashMap, and Collection
import java.util.*;

public class LaundryPaymentRepository {

    // Creates a LinkedHashMap to store payment records.
    // String represents the Payment ID.
    // LaundryPayment represents the payment information.
    private Map<String, LaundryPayment> payments = new LinkedHashMap<>();

    // Saves a new payment or updates an existing payment.
    public void save(LaundryPayment payment) {
        payments.put(payment.getPaymentId(), payment);
    }

    // Retrieves and returns all saved payment records.
    public Collection<LaundryPayment> findAll() {
        return payments.values();
    }
}
