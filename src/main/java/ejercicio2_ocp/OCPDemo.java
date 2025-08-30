package ejercicio2_ocp;

import violations.PaymentProcessor;

/**
 * Clase de demostración que muestra la diferencia entre:
 * - Implementación con violaciones al principio OCP (switch statements)
 * - Implementación corregida que cumple con OCP (patrón Strategy)
 */
public class OCPDemo {
    
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DEL PRINCIPIO OCP ===\n");
        
        demonstrateOCPViolation();
        System.out.println();
        demonstrateOCPSolution();
        System.out.println();
        demonstrateExtensionWithoutModification();
    }
    
    /**
     * Demuestra el problema con la implementación que viola OCP
     */
    private static void demonstrateOCPViolation() {
        System.out.println("❌ PROBLEMA: Implementación que viola OCP");
        System.out.println("La clase PaymentProcessor usa switch statements:");
        System.out.println("- Para agregar Apple Pay, hay que MODIFICAR código existente");
        System.out.println("- Hay que agregar un nuevo case en processPayment()");
        System.out.println("- Hay que agregar un nuevo case en calculateProcessingFee()");
        System.out.println("- Hay que crear un nuevo método privado processApplePay()");
        System.out.println();
        
        try {
            // Intentar usar Apple Pay con la implementación que viola OCP
            violations.PaymentProcessor processor = new violations.PaymentProcessor();
            System.out.println("Intentando procesar pago con Apple Pay...");
            processor.processPayment("APPLE_PAY", 100.0, "AP123456789");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error esperado: " + e.getMessage());
            System.out.println("   Para soportar Apple Pay, hay que MODIFICAR la clase existente");
        }
    }
    
    /**
     * Demuestra la solución que cumple con OCP
     */
    private static void demonstrateOCPSolution() {
        System.out.println("✅ SOLUCIÓN: Implementación que cumple con OCP");
        System.out.println("La nueva clase PaymentProcessor usa el patrón Strategy:");
        System.out.println("- No hay switch statements");
        System.out.println("- Usa polimorfismo e interfaces");
        System.out.println("- Está cerrada para modificación");
        System.out.println("- Está abierta para extensión");
        System.out.println();
        
        ejercicio2_ocp.PaymentProcessor processor = new ejercicio2_ocp.PaymentProcessor();
        
        System.out.println("Métodos de pago disponibles:");
        for (String method : processor.getAvailablePaymentMethods()) {
            System.out.println("  - " + method);
        }
        System.out.println();
        
        // Procesar pagos con diferentes métodos
        System.out.println("Procesando pagos con la implementación corregida:");
        processor.processPayment("CREDIT_CARD", 100.0, "1234567890123456");
        System.out.println("Comisión: $" + processor.calculateProcessingFee("CREDIT_CARD", 100.0));
        System.out.println();
        
        processor.processPayment("PAYPAL", 50.0, "usuario@paypal.com");
        System.out.println("Comisión: $" + processor.calculateProcessingFee("PAYPAL", 50.0));
        System.out.println();
        
        processor.processPayment("BITCOIN", 200.0, "bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh");
        System.out.println("Comisión: $" + processor.calculateProcessingFee("BITCOIN", 200.0));
        System.out.println();
    }
    
    /**
     * Demuestra cómo extender funcionalidad sin modificar código existente
     */
    private static void demonstrateExtensionWithoutModification() {
        System.out.println("🚀 EXTENSIÓN SIN MODIFICACIÓN: Agregando Apple Pay");
        System.out.println("No necesitamos modificar ninguna clase existente.");
        System.out.println("Solo creamos una nueva implementación y la registramos.");
        System.out.println();
        
        ejercicio2_ocp.PaymentProcessor processor = new ejercicio2_ocp.PaymentProcessor();
        
        // Agregar Apple Pay SIN modificar código existente
        ApplePayPayment applePay = new ApplePayPayment();
        processor.registerPaymentMethod(applePay);
        System.out.println();
        
        System.out.println("Métodos de pago disponibles después de agregar Apple Pay:");
        for (String method : processor.getAvailablePaymentMethods()) {
            System.out.println("  - " + method);
        }
        System.out.println();
        
        // Usar Apple Pay inmediatamente
        System.out.println("Usando Apple Pay recién agregado:");
        processor.processPayment("APPLE_PAY", 75.0, "AP987654321");
        System.out.println("Comisión: $" + processor.calculateProcessingFee("APPLE_PAY", 75.0));
        System.out.println();
        
        System.out.println("✅ CONCLUSIÓN:");
        System.out.println("- Apple Pay se agregó SIN modificar código existente");
        System.out.println("- El sistema está ABIERTO para extensión");
        System.out.println("- El sistema está CERRADO para modificación");
        System.out.println("- Cumple completamente con el principio OCP");
    }
}
