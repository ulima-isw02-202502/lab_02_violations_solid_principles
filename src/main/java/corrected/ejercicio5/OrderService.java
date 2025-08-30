package corrected.ejercicio5;

public class OrderService {
    private NotificationService notificationService;
    private Logger logger;
    private OrderRepository repository;
    public OrderService(NotificationService notificationService, Logger logger, OrderRepository repository) {
        this.notificationService = notificationService;
        this.logger = logger;
        this.repository = repository;
    }
}
