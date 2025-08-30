package tests;

import corrected.products.*;
import corrected.strategies.*;
import violations.*;
import java.time.LocalDateTime;

/**
 * Clase de comparación entre las violaciones y la solución corregida
 */
public class SolidComparisonTest {
    
    public static void main(String[] args) {
        System.out.println("=== COMPARACIÓN: VIOLACIONES vs SOLUCIÓN CORREGIDA ===\n");
        
        demonstrateViolations();
        System.out.println("\n" + "=".repeat(60) + "\n");
        demonstrateCorrectedSolution();
    }
    
    private static void demonstrateViolations() {
        System.out.println("--- CÓDIGO CON VIOLACIONES SOLID ---");
        System.out.println("Problemas identificados:");
        System.out.println("• LSP: DigitalProduct lanza excepción en calculateShippingCost()");
        System.out.println("• ISP: Todos los productos deben implementar métodos irrelevantes");
        System.out.println("• SRP: Product maneja múltiples responsabilidades\n");
        
        violations.Product[] violatingProducts = {
            new violations.PhysicalProduct("Laptop", 1000.0, 2.5),
            new violations.DigitalProduct("Software", 50.0),
            new violations.ServiceProduct("Consultoría", 200.0)
        };
        
        for (violations.Product product : violatingProducts) {
            try {
                System.out.println("Procesando: " + product.getName());
                product.processOrder();
            } catch (Exception e) {
                System.out.println("❌ ERROR: " + e.getMessage());
            }
            System.out.println();
        }
    }
    
    private static void demonstrateCorrectedSolution() {
        System.out.println("--- SOLUCIÓN CORREGIDA (SOLID) ---");
        System.out.println("Mejoras implementadas:");
        System.out.println("✅ LSP: Cada clase implementa solo comportamientos apropiados");
        System.out.println("✅ ISP: Interfaces segregadas (Shippable, Downloadable, Serviceable)");
        System.out.println("✅ SRP: Responsabilidades separadas usando Strategy pattern");
        System.out.println("✅ OCP: Fácil extensión mediante nuevas estrategias");
        System.out.println("✅ DIP: Dependencias invertidas con interfaces\n");
        
        // Crear estrategias
        PriceStrategy standardStrategy = new StandardPriceStrategy();
        PriceStrategy physicalStrategy = new PhysicalProductPriceStrategy(0.15);
        PriceStrategy serviceStrategy = new ServicePriceStrategy(0.10);
        WeightBasedShipping shippingStrategy = new WeightBasedShipping(2.5);
        
        corrected.products.Product[] correctedProducts = {
            new corrected.products.PhysicalProduct("Laptop", 1000.0, 2.5, physicalStrategy, shippingStrategy),
            new corrected.products.DigitalProduct("Software", 50.0, standardStrategy, "exe", 1024000),
            new corrected.products.ServiceProduct("Consultoría", 200.0, serviceStrategy, 
                             LocalDateTime.now().plusDays(7), 4, "Consultor Experto")
        };
        
        for (corrected.products.Product product : correctedProducts) {
            try {
                System.out.println("Procesando: " + product.getName());
                product.processOrder();
                System.out.println("✅ Procesado exitosamente");
            } catch (Exception e) {
                System.out.println("❌ ERROR inesperado: " + e.getMessage());
            }
            System.out.println();
        }
        
        // Demostrar flexibilidad de la solución
        System.out.println("--- FLEXIBILIDAD DE LA SOLUCIÓN ---");
        corrected.products.PhysicalProduct laptop = (corrected.products.PhysicalProduct) correctedProducts[0];
        System.out.println("Cambio dinámico de estrategia de precio:");
        System.out.println("Precio original: $" + laptop.calculatePrice());
        laptop.setPriceStrategy(new StandardPriceStrategy());
        System.out.println("Precio sin impuestos: $" + laptop.calculatePrice());
    }
}
