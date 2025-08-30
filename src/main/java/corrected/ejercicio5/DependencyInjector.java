package corrected.ejercicio5;

public class DependencyInjector {
    public OrderService createOrderService(){
        EmailNotificationService emailNotificationService = new EmailNotificationService();
        FileLoggerService fileLoggerService = new FileLoggerService();
        DatabaseOrderRepository databaseOrderRepository = new DatabaseOrderRepository();
        OrderService orderService = new OrderService(emailNotificationService, fileLoggerService, databaseOrderRepository);
        return orderService;
    }
    public OrderService createTestOrderService(){
        MockNotificationService mockNotificationService = new MockNotificationService();
        MockLogger mockLogger = new MockLogger();
        MockRepository mockRepository = new MockRepository();
        OrderService orderService = new OrderService(mockNotificationService, mockLogger, mockRepository);
        return orderService;
    }
}
