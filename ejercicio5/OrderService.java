import interfaz.Logger;
import interfaz.NotificationService;
import interfaz.OrderRepository;

public class OrderService {
    private NotificationService notificationService;
    private Logger logger;
    private OrderRepository repository;

    public OrderService(NotificationService notificationService, Logger logger, OrderRepository repository) {
        this.notificationService = notificationService;
        this.logger = logger;
        this.repository = repository;
    }

    public void processOrder(String customerId, String[] productIds, String notificationType) {
        String orderData = "Cliente: " + customerId + ", Productos: " + String.join(",", productIds);
        repository.saveOrder(orderData);
        logger.log("Orden procesada: " + orderData);
        String customerData = repository.getCustomerData(customerId);
        notificationService.sendNotification(notificationType, customerData, "Su orden ha sido procesada.");
    }

    public void cancelOrder(String orderId) {
        logger.log("Orden cancelada: " + orderId);
        notificationService.sendNotification("cancel", "ClienteDesconocido", "Su orden " + orderId + " ha sido cancelada.");
    }
}