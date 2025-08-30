package corrected.payment;

import java.util.Map;


public interface PaymentMethod {
    boolean process(double amount, Map<String, Object> data);
    double calculateProcessingFee(double amount);
    String getPaymentType();
}