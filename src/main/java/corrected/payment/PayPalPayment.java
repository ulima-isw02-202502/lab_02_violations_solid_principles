package corrected.payment;

import java.util.Map;

public class PayPalPayment implements PaymentMethod {

    @Override
    public boolean process(double amount, Map<String, Object> data) {
        System.out.println("Procesando pago con PayPal: " + amount);
        return true;
    }

    @Override
    public double calculateProcessingFee(double amount) {
        return amount * 0.03; // 3% de comisión
    }

    @Override
    public String getPaymentType() {
        return "PAYPAL";
    }
}