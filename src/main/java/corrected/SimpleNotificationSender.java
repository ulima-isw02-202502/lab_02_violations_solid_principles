package corrected;

/**
 * Implementación simple de NotificationSender.
 */
public class SimpleNotificationSender implements NotificationSender {
    
    @Override
    public void sendOrderConfirmation(String orderId) {
        System.out.println("Enviando confirmación de orden: " + orderId);
    }
    
    @Override
    public void sendShippingNotification(String orderId) {
        System.out.println("Enviando notificación de envío: " + orderId);
    }
    
    @Override
    public void sendDeliveryNotification(String orderId) {
        System.out.println("Enviando notificación de entrega: " + orderId);
    }
}
