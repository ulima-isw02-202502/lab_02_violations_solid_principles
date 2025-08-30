package ejercicio2_ocp;

/**
 * Implementación concreta para pagos con Apple Pay.
 * 
 * DEMOSTRACIÓN DE OCP:
 * Esta clase se puede agregar al sistema SIN modificar código existente.
 * Solo necesitamos registrarla en el PaymentProcessor usando registerPaymentMethod().
 */
public class ApplePayPayment implements PaymentMethod {
    
    @Override
    public boolean process(double amount, String applePayData) {
        System.out.println("Procesando pago con Apple Pay por $" + amount);
        
        // Simulación de validación de Apple Pay
        if (applePayData == null || !applePayData.startsWith("AP")) {
            System.out.println("Error: Token de Apple Pay inválido");
            return false;
        }
        
        // Simulación de procesamiento Apple Pay
        System.out.println("Validando token Apple Pay: " + applePayData);
        System.out.println("Pago con Apple Pay procesado exitosamente");
        return true;
    }
    
    @Override
    public double calculateProcessingFee(double amount) {
        // Comisión del 1.5% para Apple Pay
        return amount * 0.015;
    }
    
    @Override
    public String getPaymentType() {
        return "APPLE_PAY";
    }
}
