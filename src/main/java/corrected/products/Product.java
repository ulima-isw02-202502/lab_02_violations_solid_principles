package corrected.products;

import corrected.strategies.PriceStrategy;

/**
 * Clase base abstracta para productos que respeta SRP
 * Solo maneja información básica del producto
 */
public abstract class Product {
    
    protected String name;
    protected double basePrice;
    protected PriceStrategy priceStrategy;
    
    public Product(String name, double basePrice, PriceStrategy priceStrategy) {
        this.name = name;
        this.basePrice = basePrice;
        this.priceStrategy = priceStrategy;
    }
    
    public double calculatePrice() {
        return priceStrategy.calculatePrice(basePrice);
    }
    
    public void processOrder() {
        System.out.println("Procesando pedido para: " + name);
        System.out.println("Precio: $" + calculatePrice());
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public double getBasePrice() {
        return basePrice;
    }
    
    public PriceStrategy getPriceStrategy() {
        return priceStrategy;
    }
    
    // Setter para permitir cambio de estrategia de precio
    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }
}
