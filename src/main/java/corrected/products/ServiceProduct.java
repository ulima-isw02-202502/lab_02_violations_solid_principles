package corrected.products;

import corrected.interfaces.Serviceable;
import corrected.strategies.PriceStrategy;
import java.time.LocalDateTime;

/**
 * Producto de servicio que implementa Serviceable
 * Respeta ISP implementando solo las interfaces que necesita
 */
public class ServiceProduct extends Product implements Serviceable {
    
    private LocalDateTime serviceDate;
    private int durationInHours;
    private String serviceProvider;
    
    public ServiceProduct(String name, double basePrice, PriceStrategy priceStrategy,
                         LocalDateTime serviceDate, int durationInHours, String serviceProvider) {
        super(name, basePrice, priceStrategy);
        this.serviceDate = serviceDate;
        this.durationInHours = durationInHours;
        this.serviceProvider = serviceProvider;
    }
    
    @Override
    public LocalDateTime getServiceDate() {
        return serviceDate;
    }
    
    @Override
    public int getDurationInHours() {
        return durationInHours;
    }
    
    @Override
    public String getServiceProvider() {
        return serviceProvider;
    }
    
    @Override
    public boolean isServiceAvailable() {
        // Verifica si el servicio está disponible (fecha futura)
        return serviceDate.isAfter(LocalDateTime.now());
    }
    
    @Override
    public void processOrder() {
        super.processOrder();
        System.out.println("Proveedor: " + serviceProvider);
        System.out.println("Fecha programada: " + serviceDate);
        System.out.println("Duración: " + durationInHours + " horas");
        System.out.println("Disponible: " + (isServiceAvailable() ? "Sí" : "No"));
    }
    
    // Métodos adicionales para gestión del servicio
    public void setServiceDate(LocalDateTime serviceDate) {
        this.serviceDate = serviceDate;
    }
}
