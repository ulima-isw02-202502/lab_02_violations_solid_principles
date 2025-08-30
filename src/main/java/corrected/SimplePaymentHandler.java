package corrected;

/**
 * Implementación simple de PaymentHandler.
 */
public class SimplePaymentHandler implements PaymentHandler {
    
    @Override
    public boolean processPayment(String orderId, String method, String data) {
        System.out.println("Procesando pago para orden: " + orderId);
        System.out.println("Método: " + method);
        System.out.println("Datos: " + data);
        return true; // Simulación de pago exitoso
    }
    
    @Override
    public void processRefund(String orderId, double amount) {
        System.out.println("Procesando reembolso para orden: " + orderId);
        System.out.println("Monto: $" + amount);
    }
}
