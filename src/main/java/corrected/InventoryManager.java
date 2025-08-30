package corrected;

/**
 * Interface que maneja operaciones de inventario.
 * Cumple con ISP al ser específica para funcionalidades de inventario.
 */
public interface InventoryManager {
    
    /**
     * Verifica la disponibilidad de un producto
     * @param productId ID del producto
     * @param qty Cantidad requerida
     * @return true si hay stock suficiente, false en caso contrario
     */
    boolean checkProductAvailability(String productId, int qty);
    
    /**
     * Reserva un producto del inventario
     * @param productId ID del producto
     * @param qty Cantidad a reservar
     */
    void reserveProduct(String productId, int qty);
    
    /**
     * Libera la reserva de un producto
     * @param productId ID del producto
     * @param qty Cantidad a liberar
     */
    void releaseProductReservation(String productId, int qty);
}
