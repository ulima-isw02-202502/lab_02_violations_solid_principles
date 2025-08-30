package corrected.ejercicio5;

public class DatabaseOrderRepository implements OrderRepository {

    @Override
    public void saveOrder(String orderData) {
        System.out.println("Data saved!!");
        System.out.println("Data: "+orderData);
    }

    @Override
    public String getCustomerData(String customerId) {
        return "Datos del cliente " + customerId + " desde BD";

    }
}
