package corrected.ejercicio5;

public class MockRepository implements OrderRepository{

    public void saveOrder(String orderData) {
        System.out.println("Guardando en base de datos: " + orderData);
        // Simulación de guardado en BD
    }

    @Override
    public String getCustomerData(int customerId) {
        return "Datos del cliente " + customerId + " desde BD";
    }

}