package corrected.ejercicio5;

public class MockNotificationService implements NotificationService {
    @Override
    public void sendNotification(String type, String recipient, String message){
        System.out.println("Name: "+recipient);
        System.out.println("Message: "+message);
    };
}
