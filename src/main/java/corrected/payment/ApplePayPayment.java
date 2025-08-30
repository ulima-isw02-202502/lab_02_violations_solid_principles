package corrected.payment;

import java.util.Map;

public class ApplePayPayment implements PaymentMethod {

	@Override
	public boolean process(double amount, Map<String, Object> data) {
		System.out.println("Procesando pago con Apple Pay: " + amount);
		return true;
	}

	@Override
	public double calculateProcessingFee(double amount) {
		return amount * 0.015; // 1.5% de comisión
	}

	@Override
	public String getPaymentType() {
		return "APPLE_PAY";
	}
}
