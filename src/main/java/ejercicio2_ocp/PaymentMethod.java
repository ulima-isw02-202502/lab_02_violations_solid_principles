package ejercicio2_ocp;

/**
 * Interfaz que define el contrato para todos los métodos de pago.
 * Esta interfaz permite implementar el patrón Strategy y cumplir con OCP.
 */
public interface PaymentMethod {
    
    /**
     * Procesa un pago con el método específico
     * @param amount Monto del pago
     * @param paymentData Datos específicos del método de pago
     * @return true si el pago fue exitoso, false en caso contrario
     */
    boolean process(double amount, String paymentData);
    
    /**
     * Calcula la comisión de procesamiento para este método de pago
     * @param amount Monto del pago
     * @return Comisión de procesamiento
     */
    double calculateProcessingFee(double amount);
    
    /**
     * Obtiene el tipo de método de pago
     * @return Identificador del método de pago
     */
    String getPaymentType();
}
