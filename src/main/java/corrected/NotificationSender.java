package corrected;

/**
 * Interface que maneja el envío de notificaciones.
 * Cumple con ISP al ser específica para funcionalidades de notificación.
 */
public interface NotificationSender {
    
    /**
     * Envía confirmación de orden
     * @param orderId ID de la orden
     */
    void sendOrderConfirmation(String orderId);
    
    /**
     * Envía notificación de envío
     * @param orderId ID de la orden
     */
    void sendShippingNotification(String orderId);
    
    /**
     * Envía notificación de entrega
     * @param orderId ID de la orden
     */
    void sendDeliveryNotification(String orderId);
}
