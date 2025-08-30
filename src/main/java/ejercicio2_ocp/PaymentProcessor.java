package ejercicio2_ocp;

import java.util.HashMap;
import java.util.Map;

/**
 * Nueva implementación de PaymentProcessor que cumple con el principio OCP.
 * 
 * SOLUCIÓN AL PROBLEMA OCP:
 * - Usa el patrón Strategy con interfaces y polimorfismo
 * - Está cerrada para modificación (no hay switch statements)
 * - Está abierta para extensión (nuevos métodos de pago se agregan sin modificar)
 * - Usa un registro de métodos de pago para flexibilidad
 */
public class PaymentProcessor {
    
    private final Map<String, PaymentMethod> paymentMethods;
    
    public PaymentProcessor() {
        this.paymentMethods = new HashMap<>();
        // Registrar métodos de pago por defecto
        registerDefaultPaymentMethods();
    }
    
    /**
     * Registra un nuevo método de pago en el procesador.
     * Esto permite EXTENDER funcionalidad sin MODIFICAR código existente.
     * 
     * @param paymentMethod Implementación del método de pago
     */
    public void registerPaymentMethod(PaymentMethod paymentMethod) {
        if (paymentMethod != null) {
            paymentMethods.put(paymentMethod.getPaymentType().toUpperCase(), paymentMethod);
            System.out.println("Método de pago registrado: " + paymentMethod.getPaymentType());
        }
    }
    
    /**
     * Procesa un pago usando el método especificado.
     * No hay switch statements - usa polimorfismo.
     * 
     * @param paymentType Tipo de método de pago
     * @param amount Monto del pago
     * @param paymentData Datos específicos del método de pago
     * @return true si el pago fue exitoso
     */
    public boolean processPayment(String paymentType, double amount, String paymentData) {
        PaymentMethod method = paymentMethods.get(paymentType.toUpperCase());
        
        if (method == null) {
            throw new IllegalArgumentException("Método de pago no soportado: " + paymentType);
        }
        
        return method.process(amount, paymentData);
    }
    
    /**
     * Calcula la comisión de procesamiento para un método de pago.
     * No hay switch statements - usa polimorfismo.
     * 
     * @param paymentType Tipo de método de pago
     * @param amount Monto del pago
     * @return Comisión de procesamiento
     */
    public double calculateProcessingFee(String paymentType, double amount) {
        PaymentMethod method = paymentMethods.get(paymentType.toUpperCase());
        
        if (method == null) {
            return 0.0;
        }
        
        return method.calculateProcessingFee(amount);
    }
    
    /**
     * Obtiene la lista de métodos de pago disponibles.
     * 
     * @return Conjunto de tipos de métodos de pago registrados
     */
    public java.util.Set<String> getAvailablePaymentMethods() {
        return new java.util.HashSet<>(paymentMethods.keySet());
    }
    
    /**
     * Registra los métodos de pago por defecto.
     * Este método puede ser sobrescrito por subclases para personalizar
     * los métodos de pago disponibles.
     */
    protected void registerDefaultPaymentMethods() {
        registerPaymentMethod(new CreditCardPayment());
        registerPaymentMethod(new PayPalPayment());
        registerPaymentMethod(new BankTransferPayment());
        registerPaymentMethod(new BitcoinPayment());
    }
}
