package repository;

import model.Payment;
import java.util.ArrayList;

public class PaymentRepository {

    private static ArrayList<Payment> payments = new ArrayList<>();

    public void add(Payment payment) {
        payments.add(payment);
    }

    public ArrayList<Payment> getAll() {
        return new ArrayList<>(payments);
    }

    public Payment findById(int id) {

        for (Payment payment : payments) {

            if (payment.getId() == id) {
                return payment;
            }
        }

        return null;
    }

    public ArrayList<Payment> findByOrderId(int orderId) {

        ArrayList<Payment> result = new ArrayList<>();

        for (Payment payment : payments) {

            if (payment.getOrderId() == orderId) {
                result.add(payment);
            }
        }

        return result;
    }

    public boolean delete(int id) {

        Payment payment = findById(id);

        if (payment != null) {
            payments.remove(payment);
            return true;
        }

        return false;
    }
}
