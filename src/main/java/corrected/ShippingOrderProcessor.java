package corrected;

import java.time.LocalDate;

/**
 * Implementación que maneja órdenes y envíos.
 * Cumple con ISP al implementar solo las interfaces que necesita.
 */
public class ShippingOrderProcessor implements OrderManager, ShippingService {
    
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
    
    @Override
    public void calculateShippingCost(String orderId) {
        System.out.println("Costo de envío calculado para orden: " + orderId);
    }
    
    @Override
    public void scheduleDelivery(String orderId, LocalDate date) {
        System.out.println("Entrega programada para orden " + orderId + " en fecha: " + date);
    }
    
    @Override
    public void trackShipment(String orderId) {
        System.out.println("Rastreando envío de orden: " + orderId);
    }
}
