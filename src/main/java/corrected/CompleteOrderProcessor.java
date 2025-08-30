package corrected;

import java.time.LocalDate;

/**
 * Implementación completa que usa composición para combinar funcionalidades.
 * Cumple con ISP al usar solo las interfaces que necesita sin implementarlas todas.
 */
public class CompleteOrderProcessor {
    
    private final OrderManager orderManager;
    private final PaymentHandler paymentHandler;
    private final ShippingService shippingService;
    private final InventoryManager inventoryManager;
    private final NotificationSender notificationSender;
    private final ReportGenerator reportGenerator;
    
    public CompleteOrderProcessor(
            OrderManager orderManager,
            PaymentHandler paymentHandler,
            ShippingService shippingService,
            InventoryManager inventoryManager,
            NotificationSender notificationSender,
            ReportGenerator reportGenerator) {
        
        this.orderManager = orderManager;
        this.paymentHandler = paymentHandler;
        this.shippingService = shippingService;
        this.inventoryManager = inventoryManager;
        this.notificationSender = notificationSender;
        this.reportGenerator = reportGenerator;
    }
    
    // Métodos que delegan a las interfaces específicas
    public void createOrder(String customerId, String[] productIds) {
        orderManager.createOrder(customerId, productIds);
        notificationSender.sendOrderConfirmation("ORDER-" + System.currentTimeMillis());
    }
    
    public void cancelOrder(String orderId) {
        orderManager.cancelOrder(orderId);
        notificationSender.sendOrderConfirmation(orderId);
    }
    
    public void updateOrderStatus(String orderId, String status) {
        orderManager.updateOrderStatus(orderId, status);
    }
    
    public boolean processPayment(String orderId, String method, String data) {
        return paymentHandler.processPayment(orderId, method, data);
    }
    
    public void processRefund(String orderId, double amount) {
        paymentHandler.processRefund(orderId, amount);
    }
    
    public void calculateShippingCost(String orderId) {
        shippingService.calculateShippingCost(orderId);
    }
    
    public void scheduleDelivery(String orderId, LocalDate date) {
        shippingService.scheduleDelivery(orderId, date);
        notificationSender.sendShippingNotification(orderId);
    }
    
    public void trackShipment(String orderId) {
        shippingService.trackShipment(orderId);
    }
    
    public boolean checkProductAvailability(String productId, int qty) {
        return inventoryManager.checkProductAvailability(productId, qty);
    }
    
    public void reserveProduct(String productId, int qty) {
        inventoryManager.reserveProduct(productId, qty);
    }
    
    public void releaseProductReservation(String productId, int qty) {
        inventoryManager.releaseProductReservation(productId, qty);
    }
    
    public void sendOrderConfirmation(String orderId) {
        notificationSender.sendOrderConfirmation(orderId);
    }
    
    public void sendShippingNotification(String orderId) {
        notificationSender.sendShippingNotification(orderId);
    }
    
    public void sendDeliveryNotification(String orderId) {
        notificationSender.sendDeliveryNotification(orderId);
    }
    
    public String generateOrderReport(String orderId) {
        return reportGenerator.generateOrderReport(orderId);
    }
    
    public String generateDailyReport(LocalDate date) {
        return reportGenerator.generateDailyReport(date);
    }
    
    public String generateCustomerReport(String customerId) {
        return reportGenerator.generateCustomerReport(customerId);
    }
}
