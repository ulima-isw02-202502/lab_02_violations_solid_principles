package corrected.ejercicio5;

public interface OrderRepository {
    void saveOrder(String orderData);
    String getCustomerName(int customerId);
}
