package corrected.ejercicio5;

public interface OrderRepository {
    void saveOrder(String orderData);
    String getCustomerData(String customerId);
}
