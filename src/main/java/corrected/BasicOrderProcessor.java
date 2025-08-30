package corrected;

/**
 * Implementación básica que solo maneja operaciones de órdenes.
 * Cumple con ISP al implementar solo lo que realmente necesita.
 */
public class BasicOrderProcessor implements OrderManager {
    
    @Override
    public void createOrder(String customerId, String[] productIds) {
        System.out.println("Orden creada para cliente: " + customerId);
        System.out.println("Productos: " + String.join(", ", productIds));
    }
    
    @Override
    public void cancelOrder(String orderId) {
        System.out.println("Orden cancelada: " + orderId);
    }
    
    @Override
    public void updateOrderStatus(String orderId, String status) {
        System.out.println("Estado de orden " + orderId + " actualizado a: " + status);
    }
}
