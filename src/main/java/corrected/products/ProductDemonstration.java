package corrected.products;

import corrected.strategies.*;
import java.time.LocalDateTime;

/**
 * Clase de demostración de la solución corregida
 * Muestra cómo la implementación respeta los principios SOLID
 */
public class ProductDemonstration {
    
    public static void main(String[] args) {
        System.out.println("=== SOLUCIÓN CORREGIDA - PRINCIPIOS SOLID ===\n");
        
        // Crear estrategias
        PriceStrategy standardStrategy = new StandardPriceStrategy();
        PriceStrategy physicalStrategy = new PhysicalProductPriceStrategy(0.15); // 15% impuestos
        PriceStrategy serviceStrategy = new ServicePriceStrategy(0.10); // 10% comisión
        WeightBasedShipping shippingStrategy = new WeightBasedShipping(2.5);
        
        // Crear productos usando composición y estrategias apropiadas
        Product[] products = {
            new PhysicalProduct("Laptop", 1000.0, 2.5, physicalStrategy, shippingStrategy),
            new DigitalProduct("Software", 50.0, standardStrategy, "exe", 1024000),
            new ServiceProduct("Consultoría", 200.0, serviceStrategy, 
                             LocalDateTime.now().plusDays(7), 4, "Consultor Experto")
        };
        
        // Procesar todos los productos sin excepciones
        for (Product product : products) {
            System.out.println("--- Procesando " + product.getName() + " ---");
            product.processOrder();
            System.out.println();
        }
        
        // Demostrar polimorfismo apropiado con interfaces
        demonstrateInterfaceSegregation(products);
    }
    
    private static void demonstrateInterfaceSegregation(Product[] products) {
        System.out.println("=== DEMOSTRACIÓN DE SEGREGACIÓN DE INTERFACES ===\n");
        
        for (Product product : products) {
            System.out.println("Producto: " + product.getName());
            
            // Solo productos físicos implementan Shippable
            if (product instanceof corrected.interfaces.Shippable) {
                corrected.interfaces.Shippable shippable = (corrected.interfaces.Shippable) product;
                System.out.println("  - Es enviable: Peso = " + shippable.getWeight() + " kg");
                System.out.println("  - Costo envío: $" + shippable.calculateShippingCost());
            }
            
            // Solo productos digitales implementan Downloadable
            if (product instanceof corrected.interfaces.Downloadable) {
                corrected.interfaces.Downloadable downloadable = (corrected.interfaces.Downloadable) product;
                System.out.println("  - Es descargable: Formato = " + downloadable.getFileFormat());
                System.out.println("  - Tamaño: " + downloadable.getFileSize() + " bytes");
            }
            
            // Solo servicios implementan Serviceable
            if (product instanceof corrected.interfaces.Serviceable) {
                corrected.interfaces.Serviceable serviceable = (corrected.interfaces.Serviceable) product;
                System.out.println("  - Es servicio: Proveedor = " + serviceable.getServiceProvider());
                System.out.println("  - Duración: " + serviceable.getDurationInHours() + " horas");
            }
            
            System.out.println();
        }
    }
}
