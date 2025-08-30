package corrected.products;

import corrected.interfaces.Shippable;
import corrected.strategies.PriceStrategy;
import corrected.strategies.WeightBasedShipping;

/**
 * Producto físico que implementa Shippable
 * Respeta ISP implementando solo las interfaces que necesita
 */
public class PhysicalProduct extends Product implements Shippable {
    
    private double weight;
    private WeightBasedShipping shippingStrategy;
    
    public PhysicalProduct(String name, double basePrice, double weight, 
                          PriceStrategy priceStrategy, WeightBasedShipping shippingStrategy) {
        super(name, basePrice, priceStrategy);
        this.weight = weight;
        this.shippingStrategy = shippingStrategy;
    }
    
    @Override
    public double calculateShippingCost() {
        return shippingStrategy.calculateShippingCost(weight);
    }
    
    @Override
    public double getWeight() {
        return weight;
    }
    
    @Override
    public boolean requiresPhysicalDelivery() {
        return true;
    }
    
    @Override
    public void processOrder() {
        super.processOrder();
        System.out.println("Peso: " + weight + " kg");
        System.out.println("Costo envío: $" + calculateShippingCost());
        System.out.println("Preparando para envío físico");
    }
}
