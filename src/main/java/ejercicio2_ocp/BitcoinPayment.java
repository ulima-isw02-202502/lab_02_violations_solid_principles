package ejercicio2_ocp;

/**
 * Implementación concreta para pagos con Bitcoin.
 * Cumple con el contrato definido en PaymentMethod.
 */
public class BitcoinPayment implements PaymentMethod {
    
    @Override
    public boolean process(double amount, String bitcoinAddress) {
        System.out.println("Procesando pago con Bitcoin por $" + amount);
        
        // Simulación de validación de dirección Bitcoin
        if (bitcoinAddress == null || 
            (!bitcoinAddress.startsWith("bc1") && !bitcoinAddress.startsWith("1"))) {
            System.out.println("Error: Dirección Bitcoin inválida");
            return false;
        }
        
        // Simulación de procesamiento Bitcoin
        System.out.println("Validando dirección Bitcoin: " + bitcoinAddress);
        System.out.println("Pago con Bitcoin procesado exitosamente");
        return true;
    }
    
    @Override
    public double calculateProcessingFee(double amount) {
        // Comisión del 0.1% para Bitcoin
        return amount * 0.001;
    }
    
    @Override
    public String getPaymentType() {
        return "BITCOIN";
    }
}
