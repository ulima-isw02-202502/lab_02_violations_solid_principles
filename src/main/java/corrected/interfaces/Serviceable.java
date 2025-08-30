package corrected.interfaces;

import java.time.LocalDateTime;

/**
 * Interface para productos de servicios
 */
public interface Serviceable {
    LocalDateTime getServiceDate();
    int getDurationInHours();
    String getServiceProvider();
    boolean isServiceAvailable();
}
