package corrected.strategies;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servicio para calcular y formatear duraciones de servicios
 * Respeta SRP - solo se encarga de cálculos de tiempo
 */
public class DurationService {
    
    public double calculateServiceCost(int hours, double hourlyRate) {
        return hours * hourlyRate;
    }
    
    public String formatDuration(int hours) {
        if (hours < 1) {
            return "Menos de 1 hora";
        } else if (hours == 1) {
            return "1 hora";
        } else if (hours < 24) {
            return hours + " horas";
        } else {
            int days = hours / 24;
            int remainingHours = hours % 24;
            return days + " día(s)" + (remainingHours > 0 ? " y " + remainingHours + " hora(s)" : "");
        }
    }
    
    public String formatServiceDate(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return dateTime.format(formatter);
    }
    
    public boolean isServiceDateValid(LocalDateTime serviceDate) {
        return serviceDate.isAfter(LocalDateTime.now());
    }
}
