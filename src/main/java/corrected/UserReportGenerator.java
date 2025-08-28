package corrected;

public class UserReportGenerator extends User {

    public UserReportGenerator() {
        super();
    }

    // Responsabilidad 4: Generación de reportes

    public String generateUserReport(User user) {
        DiscountCalculator dscto = new DiscountCalculator();
        return "=== REPORTE DE USUARIO ===\n"
                + "Nombre: " + user.name + "\n"
                + "Email: " + user.email + "\n"
                + "Tipo: " + user.userType + "\n"
                + "Total Compras: $" + user.totalPurchases + "\n"
                + "Descuento Aplicable: " + (dscto.calculateDiscount(user) * 100) + "%\n";
    }
}
