package corrected.strategies;

/**
 * Estrategia estándar de precios - sin modificaciones
 */
public class StandardPriceStrategy implements PriceStrategy {
    
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}
