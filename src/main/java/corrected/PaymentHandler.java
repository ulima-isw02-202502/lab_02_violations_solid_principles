package corrected;

/**
 * Interface que maneja operaciones de pago.
 * Cumple con ISP al ser específica para funcionalidades de pago.
 */
public interface PaymentHandler {
    
    /**
     * Procesa un pago para una orden
     * @param orderId ID de la orden
     * @param method Método de pago
     * @param data Datos del pago
     * @return true si el pago fue exitoso, false en caso contrario
     */
    boolean processPayment(String orderId, String method, String data);
    
    /**
     * Procesa un reembolso para una orden
     * @param orderId ID de la orden
     * @param amount Monto a reembolsar
     */
    void processRefund(String orderId, double amount);
}
