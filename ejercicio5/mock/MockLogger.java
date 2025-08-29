package mock;

import interfaz.Logger;

public class MockLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("[MOCK LOG] " + message);
    }
}