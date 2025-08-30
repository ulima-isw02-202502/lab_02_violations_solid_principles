package corrected.ejercicio5;

public class OrderService {
    private NotificationService notificationService;
    private Logger logger;
    private OrderRepository repository;
    public OrderService(NotificationService notificationService, Logger logger, OrderRepository repository) {
        this.notificationService = notificationService;
        this.logger = logger;
        this.repository = repository;
    }
    public void processOrder(String customerId, String[] productIds, String notificationType){
        logger.log("Iniciando procesamiento de pedido para cliente: " + customerId);

        String customerData = repository.getCustomerData(customerId);
        logger.log("Datos de cliente obtenidos: " + customerData);

        String orderId = "ORDER-" + System.currentTimeMillis();
        String orderData = "Pedido " + orderId + " para cliente " + customerId + " con productos: "
                + String.join(", ", productIds);

        repository.saveOrder(orderData);
        logger.log("Pedido guardado: " + orderId);

        if ("EMAIL".equalsIgnoreCase(notificationType)) {
            String message = "Estimado cliente, su pedido " + orderId + " ha sido procesado exitosamente.";
            notificationService.sendNotification(notificationType,customerData, message);
            logger.log("Notificación enviada por EMAIL al cliente: " + customerId);
        } else if ("MOCK".equalsIgnoreCase(notificationType)) {
            logger.log("Notificación MOCK: Pedido " + orderId + " procesado (no se envió email real).");
        } else {
            logger.log("Tipo de notificación no reconocido: " + notificationType);
        }

        logger.log("Pedido procesado completamente: " + orderId);
    }


    public void cancelOrder(String orderId){
        logger.log("Cancelando pedido: " + orderId);

        repository.saveOrder("CANCELLED: " + orderId);


        //Falta notification
        logger.log("Pedido cancelado: " + orderId);

    }
}
