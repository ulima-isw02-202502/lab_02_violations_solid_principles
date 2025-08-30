package corrected.payment;

import java.util.Map;

public class PaymentProcessor {

    private final PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean processPayment(double amount, Map<String, Object> data) {
        double fee = paymentMethod.calculateProcessingFee(amount);
        System.out.println("Processing fee: " + fee);
        return paymentMethod.process(amount, data);
    }

    public String getPaymentType() {
        return paymentMethod.getPaymentType();
    }
}