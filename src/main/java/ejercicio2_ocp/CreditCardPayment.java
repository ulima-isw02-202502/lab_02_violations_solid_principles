package ejercicio2_ocp;

/**
 * Implementación concreta para pagos con tarjeta de crédito.
 * Cumple con el contrato definido en PaymentMethod.
 */
public class CreditCardPayment implements PaymentMethod {
    
    @Override
    public boolean process(double amount, String cardData) {
        System.out.println("Procesando pago con tarjeta de crédito por $" + amount);
        
        // Simulación de validación de tarjeta
        if (cardData == null || cardData.length() < 16) {
            System.out.println("Error: Datos de tarjeta inválidos");
            return false;
        }
        
        // Simulación de procesamiento de tarjeta
        System.out.println("Validando tarjeta: " + cardData.substring(cardData.length() - 4));
        System.out.println("Pago con tarjeta procesado exitosamente");
        return true;
    }
    
    @Override
    public double calculateProcessingFee(double amount) {
        // Comisión del 3% para tarjetas de crédito
        return amount * 0.03;
    }
    
    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }
}
