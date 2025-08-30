package concreta;

import interfaz.NotificationService;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String type, String recipient, String message) {
        System.out.println("[EMAIL] Tipo: " + type + ", Para: " + recipient + ", Mensaje: " + message);
    }
}