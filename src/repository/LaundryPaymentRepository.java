
package repository;

import model.LaundryPayment;
import java.util.*;

public class LaundryPaymentRepository {

    private Map<String, LaundryPayment> payments = new LinkedHashMap<>();

    public void save(LaundryPayment payment) {
        payments.put(payment.getPaymentId(), payment);
    }

    public Collection<LaundryPayment> findAll() {
        return payments.values();
    }
}
