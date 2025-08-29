package mock;

import interfaz.NotificationService;

public class MockNotificationService implements NotificationService {
    @Override
    public void sendNotification(String type, String recipient, String message) {
        System.out.println("[MOCK NOTIFICATION] " + type + " a " + recipient + ": " + message);
    }
}