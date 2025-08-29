package concreta;

import interfaz.OrderRepository;

public class DatabaseOrderRepository implements OrderRepository {
    @Override
    public void saveOrder(String orderData) {
        System.out.println("[DB] Orden guardada: " + orderData);
    }

    @Override
    public String getCustomerData(String customerId) {
        System.out.println("[DB] Consultando datos de cliente: " + customerId);
        return "DatosCliente(" + customerId + ")";
    }
}