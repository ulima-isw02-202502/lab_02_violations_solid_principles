package corrected.ejercicio5;

public class MockLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message+"Desde Mock logger");
    }
}
