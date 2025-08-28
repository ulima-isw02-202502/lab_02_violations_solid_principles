package corrected;

public class DiscountCalculator extends User{

    public DiscountCalculator() {
        super();
    }

    // Responsabilidad 2: Cálculo de descuentos
    public double calculateDiscount(User user) {
        switch (user.userType) {
            case "PREMIUM":
                return user.totalPurchases > 1000 ? 0.20 : 0.15;
            case "VIP":
                return user.totalPurchases > 2000 ? 0.30 : 0.25;
            default:
                return user.totalPurchases > 500 ? 0.10 : 0.05;
        }
    }
}
