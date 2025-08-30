/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corrected.strategies;

/**
 * Estrategia de envío basada en peso
 */
public class WeightBasedShipping {
    
    private final double pricePerKg;
    
    public WeightBasedShipping(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }
    
    public double calculateShippingCost(double weight) {
        return weight * pricePerKg;
    }
}
