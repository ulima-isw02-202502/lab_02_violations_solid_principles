package corrected.payment;

import java.util.Map;


public class CreditCardPayment implements PaymentMethod {

    @Override
    public boolean process(double amount, Map<String, Object> data) {
        System.out.println("Procesando pago con Tarjeta de Crédito: " + amount);
        // Aquí podrías agregar lógica real de procesamiento
        return true;
    }

    @Override
    public double calculateProcessingFee(double amount) {
        return amount * 0.02; // 2% de comisión
    }

    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }
}