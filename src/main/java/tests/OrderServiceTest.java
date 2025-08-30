/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import corrected.ejercicio5.DependencyInjector;
import corrected.ejercicio5.OrderService;

/**
 *
 * @author jacks
 */
public class OrderServiceTest {

    public static void main(String[] args) {
        DependencyInjector injector = new DependencyInjector();
        corrected.ejercicio5.OrderService orderService = injector.createOrderService();
        OrderService orderServiceTest = injector.createTestOrderService();

        // PROBLEMA: No podemos inyectar mocks para testing
        // PROBLEMA: No podemos cambiar implementaciones sin modificar OrderService
        // PROBLEMA: Testing es difícil porque hace operaciones reales (archivos, emails)
        orderService.processOrder("CUSTOMER-123",
                new String[]{"PRODUCT-1", "PRODUCT-2"},
                "EMAIL");
        orderServiceTest.processOrder("CUSTOMER-123",
                new String[]{"PRODUCT-1", "PRODUCT-2"},
                "EMAIL");

        orderService.cancelOrder("ORDER-123");
    }
}
