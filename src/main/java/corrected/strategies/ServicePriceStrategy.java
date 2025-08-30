package corrected.strategies;

/**
 * Estrategia de precios para servicios con comisión
 */
public class ServicePriceStrategy implements PriceStrategy {
    
    private final double commissionRate;
    
    public ServicePriceStrategy(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * (1 + commissionRate);
    }
}
