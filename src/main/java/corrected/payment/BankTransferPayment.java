package corrected.payment;

import java.util.Map;

public class BankTransferPayment implements PaymentMethod {

    @Override
    public boolean process(double amount, Map<String, Object> data) {
        System.out.println("Procesando pago con Transferencia Bancaria: " + amount);
        // Aquí podrías agregar lógica real de transferencia bancaria usando los datos del mapa
        return true;
    }

    @Override
    public double calculateProcessingFee(double amount) {
        return 5.0; // comisión fija
    }

    @Override
    public String getPaymentType() {
        return "BANK_TRANSFER";
    }
}