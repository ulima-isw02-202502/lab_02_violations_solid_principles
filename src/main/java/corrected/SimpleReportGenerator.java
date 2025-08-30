package corrected;

import java.time.LocalDate;

/**
 * Implementación simple de ReportGenerator.
 */
public class SimpleReportGenerator implements ReportGenerator {
    
    @Override
    public String generateOrderReport(String orderId) {
        return "Reporte de orden: " + orderId + " - Generado el " + LocalDate.now();
    }
    
    @Override
    public String generateDailyReport(LocalDate date) {
        return "Reporte diario del " + date + " - Generado el " + LocalDate.now();
    }
    
    @Override
    public String generateCustomerReport(String customerId) {
        return "Reporte del cliente: " + customerId + " - Generado el " + LocalDate.now();
    }
}
