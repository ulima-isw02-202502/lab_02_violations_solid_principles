package corrected;

import java.time.LocalDate;

/**
 * Interface que maneja la generación de reportes.
 * Cumple con ISP al ser específica para funcionalidades de reportes.
 */
public interface ReportGenerator {
    
    /**
     * Genera un reporte para una orden específica
     * @param orderId ID de la orden
     * @return Reporte de la orden
     */
    String generateOrderReport(String orderId);
    
    /**
     * Genera un reporte diario
     * @param date Fecha del reporte
     * @return Reporte diario
     */
    String generateDailyReport(LocalDate date);
    
    /**
     * Genera un reporte para un cliente específico
     * @param customerId ID del cliente
     * @return Reporte del cliente
     */
    String generateCustomerReport(String customerId);
}
