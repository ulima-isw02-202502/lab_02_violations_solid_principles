package corrected;

public class NotificationService extends User {
    public NotificationService() {
    }

    // Responsabilidad 3: Envío de notificaciones
    public void sendWelcomeEmail(User user) {
        System.out.println("Enviando email de bienvenida a: " + user.email);
        System.out.println("Asunto: ¡Bienvenido " + user.name + "!");
        System.out.println("Cuerpo: Gracias por registrarte como usuario " + user.userType);
    }
}
