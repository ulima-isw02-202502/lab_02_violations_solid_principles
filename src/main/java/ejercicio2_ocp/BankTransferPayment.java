package ejercicio2_ocp;

/**
 * Implementación concreta para transferencias bancarias.
 * Cumple con el contrato definido en PaymentMethod.
 */
public class BankTransferPayment implements PaymentMethod {
    
    @Override
    public boolean process(double amount, String bankData) {
        System.out.println("Procesando transferencia bancaria por $" + amount);
        
        // Simulación de validación bancaria
        if (bankData == null || bankData.length() < 10) {
            System.out.println("Error: Datos bancarios inválidos");
            return false;
        }
        
        // Simulación de procesamiento bancario
        System.out.println("Validando cuenta bancaria: " + bankData);
        System.out.println("Transferencia bancaria procesada exitosamente");
        return true;
    }
    
    @Override
    public double calculateProcessingFee(double amount) {
        // Comisión fija de $5 para transferencias bancarias
        return 5.0;
    }
    
    @Override
    public String getPaymentType() {
        return "BANK_TRANSFER";
    }
}
