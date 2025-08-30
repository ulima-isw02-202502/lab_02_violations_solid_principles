package corrected.interfaces;

/**
 * Interface para productos que pueden ser enviados físicamente
 */
public interface Shippable {
    double calculateShippingCost();
    double getWeight();
    boolean requiresPhysicalDelivery();
}
