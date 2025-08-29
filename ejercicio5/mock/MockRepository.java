package mock;

import interfaz.OrderRepository;

public class MockRepository implements OrderRepository {
    @Override
    public void saveOrder(String orderData) {
        System.out.println("[MOCK REPO] Orden simulada: " + orderData);
    }

    @Override
    public String getCustomerData(String customerId) {
        System.out.println("[MOCK REPO] Consultando cliente simulado: " + customerId);
        return "MockCliente(" + customerId + ")";
    }
}