package corrected.strategies;

/**
 * Estrategia de precios para productos físicos con impuestos
 */
public class PhysicalProductPriceStrategy implements PriceStrategy {
    
    private final double taxRate;
    
    public PhysicalProductPriceStrategy(double taxRate) {
        this.taxRate = taxRate;
    }
    
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * (1 + taxRate);
    }
}
