package corrected;

/**
 * Implementación simple de InventoryManager.
 */
public class SimpleInventoryManager implements InventoryManager {
    
    @Override
    public boolean checkProductAvailability(String productId, int qty) {
        System.out.println("Verificando disponibilidad de producto: " + productId);
        System.out.println("Cantidad requerida: " + qty);
        return true; // Simulación de stock disponible
    }
    
    @Override
    public void reserveProduct(String productId, int qty) {
        System.out.println("Reservando producto: " + productId);
        System.out.println("Cantidad: " + qty);
    }
    
    @Override
    public void releaseProductReservation(String productId, int qty) {
        System.out.println("Liberando reserva de producto: " + productId);
        System.out.println("Cantidad: " + qty);
    }
}
