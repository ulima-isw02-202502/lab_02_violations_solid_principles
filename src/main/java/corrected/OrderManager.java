package corrected;

/**
 * Interface que maneja operaciones básicas de órdenes.
 * Cumple con ISP al ser específica y no forzar implementaciones innecesarias.
 */
public interface OrderManager {
    
    /**
     * Crea una nueva orden
     * @param customerId ID del cliente
     * @param productIds Array de IDs de productos
     */
    void createOrder(String customerId, String[] productIds);
    
    /**
     * Cancela una orden existente
     * @param orderId ID de la orden a cancelar
     */
    void cancelOrder(String orderId);
    
    /**
     * Actualiza el estado de una orden
     * @param orderId ID de la orden
     * @param status Nuevo estado
     */
    void updateOrderStatus(String orderId, String status);
}
