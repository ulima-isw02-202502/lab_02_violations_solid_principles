package corrected;

import java.time.LocalDate;

/**
 * Interface que maneja operaciones de envío.
 * Cumple con ISP al ser específica para funcionalidades de envío.
 */
public interface ShippingService {
    
    /**
     * Calcula el costo de envío para una orden
     * @param orderId ID de la orden
     */
    void calculateShippingCost(String orderId);
    
    /**
     * Programa la entrega de una orden
     * @param orderId ID de la orden
     * @param date Fecha de entrega
     */
    void scheduleDelivery(String orderId, LocalDate date);
    
    /**
     * Rastrea el envío de una orden
     * @param orderId ID de la orden
     */
    void trackShipment(String orderId);
}
