import interfaz.Logger;
import interfaz.NotificationService;
import interfaz.OrderRepository;
import mock.MockLogger;
import mock.MockNotificationService;
import mock.MockRepository;

public class DependencyInjector {
    public OrderService createOrderService() {
        NotificationService notificationService = new EmailNotificationService();
        Logger logger = new FileLoggerService();
        OrderRepository orderRepository = new DatabaseOrderRepository();
        return new OrderService(notificationService, logger, orderRepository);
    }

    public OrderService createTestOrderService() {
        NotificationService notificationService = new MockNotificationService();
        Logger logger = new MockLogger();
        OrderRepository orderRepository = new MockRepository();
        return new OrderService(notificationService, logger, orderRepository);
    }
}