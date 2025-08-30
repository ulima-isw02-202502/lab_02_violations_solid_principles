package tests;

import corrected.*;
import java.time.LocalDate;

/**
 * Demostración de la solución al problema ISP.
 * Muestra cómo las interfaces segregadas resuelven el problema de la "fat interface".
 */
public class ISPSolutionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE SOLUCIÓN ISP ===\n");
        
        // 1. BasicOrderProcessor - Solo implementa OrderManager
        System.out.println("1. BasicOrderProcessor (solo OrderManager):");
        OrderManager basicProcessor = new BasicOrderProcessor();
        basicProcessor.createOrder("CUSTOMER-001", new String[]{"PROD-1", "PROD-2"});
        basicProcessor.updateOrderStatus("ORDER-123", "PROCESSING");
        basicProcessor.cancelOrder("ORDER-456");
        System.out.println();
        
        // 2. ShippingOrderProcessor - Implementa OrderManager + ShippingService
        System.out.println("2. ShippingOrderProcessor (OrderManager + ShippingService):");
        ShippingOrderProcessor shippingProcessor = new ShippingOrderProcessor();
        shippingProcessor.createOrder("CUSTOMER-002", new String[]{"PROD-3"});
        shippingProcessor.calculateShippingCost("ORDER-789");
        shippingProcessor.scheduleDelivery("ORDER-789", LocalDate.now().plusDays(3));
        shippingProcessor.trackShipment("ORDER-789");
        System.out.println();
        
        // 3. CompleteOrderProcessor - Usa composición para combinar funcionalidades
        System.out.println("3. CompleteOrderProcessor (composición de interfaces):");
        
        // Crear implementaciones de las interfaces
        OrderManager orderManager = new BasicOrderProcessor();
        PaymentHandler paymentHandler = new SimplePaymentHandler();
        ShippingService shippingService = new ShippingOrderProcessor();
        InventoryManager inventoryManager = new SimpleInventoryManager();
        NotificationSender notificationSender = new SimpleNotificationSender();
        ReportGenerator reportGenerator = new SimpleReportGenerator();
        
        // Crear el procesador completo
        CompleteOrderProcessor completeProcessor = new CompleteOrderProcessor(
            orderManager, paymentHandler, shippingService, 
            inventoryManager, notificationSender, reportGenerator
        );
        
        // Demostrar funcionalidad completa
        completeProcessor.createOrder("CUSTOMER-003", new String[]{"PROD-4", "PROD-5"});
        completeProcessor.processPayment("ORDER-999", "CREDIT_CARD", "****1234");
        completeProcessor.calculateShippingCost("ORDER-999");
        completeProcessor.scheduleDelivery("ORDER-999", LocalDate.now().plusDays(5));
        completeProcessor.checkProductAvailability("PROD-4", 2);
        completeProcessor.reserveProduct("PROD-4", 2);
        completeProcessor.sendOrderConfirmation("ORDER-999");
        
        String report = completeProcessor.generateOrderReport("ORDER-999");
        System.out.println("Reporte generado: " + report);
        
        System.out.println("\n=== BENEFICIOS DE LA SOLUCIÓN ISP ===");
        System.out.println("✅ Las clases solo implementan lo que realmente necesitan");
        System.out.println("✅ No hay métodos que lancen UnsupportedOperationException");
        System.out.println("✅ Fácil agregar nuevas funcionalidades sin modificar interfaces existentes");
        System.out.println("✅ Mejor separación de responsabilidades");
        System.out.println("✅ Más fácil de testear y mantener");
    }
}
