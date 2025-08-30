package ejercicio2_ocp;

/**
 * Implementación concreta para pagos con PayPal.
 * Cumple con el contrato definido en PaymentMethod.
 */
public class PayPalPayment implements PaymentMethod {
    
    @Override
    public boolean process(double amount, String paypalData) {
        System.out.println("Procesando pago con PayPal por $" + amount);
        
        // Simulación de autenticación PayPal
        if (paypalData == null || !paypalData.contains("@")) {
            System.out.println("Error: Email de PayPal inválido");
            return false;
        }
        
        // Simulación de procesamiento PayPal
        System.out.println("Autenticando cuenta PayPal: " + paypalData);
        System.out.println("Pago con PayPal procesado exitosamente");
        return true;
    }
    
    @Override
    public double calculateProcessingFee(double amount) {
        // Comisión del 2.5% para PayPal
        return amount * 0.025;
    }
    
    @Override
    public String getPaymentType() {
        return "PAYPAL";
    }
}
