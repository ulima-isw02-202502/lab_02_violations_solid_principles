# Ejercicio 2: Solución al Principio OCP (Open/Closed Principle)

## Problema Identificado

La clase `PaymentProcessor` original violaba el principio OCP porque:

1. **Usaba switch statements** que requerían modificación cada vez que se agregaba un nuevo método de pago
2. **No estaba cerrada para modificación** - agregar Apple Pay requería:
   - Modificar el método `processPayment()`
   - Modificar el método `calculateProcessingFee()`
   - Agregar un nuevo método privado `processApplePay()`
3. **No estaba abierta para extensión** - no había forma de agregar funcionalidad sin tocar código existente

## Solución Implementada

### 1. Interfaz PaymentMethod
```java
public interface PaymentMethod {
    boolean process(double amount, String paymentData);
    double calculateProcessingFee(double amount);
    String getPaymentType();
}
```

### 2. Implementaciones Concretas
- `CreditCardPayment` - Maneja pagos con tarjeta de crédito
- `PayPalPayment` - Maneja pagos con PayPal
- `BankTransferPayment` - Maneja transferencias bancarias
- `BitcoinPayment` - Maneja pagos con Bitcoin
- `ApplePayPayment` - **NUEVO** método de pago agregado sin modificar código existente

### 3. PaymentProcessor Refactorizado
- **No usa switch statements** - usa polimorfismo
- **Registro de métodos de pago** - Map<String, PaymentMethod>
- **Método registerPaymentMethod()** - permite agregar nuevos métodos dinámicamente
- **Está cerrado para modificación** - no se modifica al agregar nuevos métodos
- **Está abierto para extensión** - nuevos métodos se agregan implementando la interfaz

## Beneficios de la Solución

### ✅ Cumple con OCP
- **Cerrado para modificación**: No se modifica código existente
- **Abierto para extensión**: Nuevos métodos de pago se agregan implementando la interfaz

### ✅ Patrón Strategy
- Cada método de pago es una estrategia independiente
- Fácil agregar nuevas estrategias sin afectar las existentes

### ✅ Polimorfismo
- No hay lógica condicional (switch/if-else)
- Comportamiento determinado por el tipo de objeto en tiempo de ejecución

### ✅ Bajo Acoplamiento
- `PaymentProcessor` no conoce implementaciones específicas
- Solo depende de la abstracción `PaymentMethod`

### ✅ Fácil Testing
- Se pueden crear mocks de `PaymentMethod` para testing
- Cada implementación se puede testear independientemente

## Ejemplo de Uso

```java
// Crear procesador
PaymentProcessor processor = new PaymentProcessor();

// Agregar nuevo método de pago SIN modificar código existente
ApplePayPayment applePay = new ApplePayPayment();
processor.registerPaymentMethod(applePay);

// Usar inmediatamente
processor.processPayment("APPLE_PAY", 100.0, "AP123456789");
```

## Comparación: Antes vs Después

| Aspecto | Antes (Violación OCP) | Después (Cumple OCP) |
|---------|----------------------|---------------------|
| **Switch Statements** | ❌ Sí, en múltiples métodos | ✅ No, usa polimorfismo |
| **Modificación para extensión** | ❌ Sí, obligatorio | ✅ No, opcional |
| **Nuevos métodos de pago** | ❌ Requieren modificar clase existente | ✅ Solo implementar interfaz |
| **Acoplamiento** | ❌ Alto, depende de implementaciones | ✅ Bajo, depende de abstracciones |
| **Testing** | ❌ Difícil, operaciones reales | ✅ Fácil, se pueden mockear |
| **Mantenibilidad** | ❌ Baja, cambios afectan toda la clase | ✅ Alta, cambios aislados |

## Conclusión

La refactorización demuestra cómo aplicar correctamente el principio OCP:

1. **Identificar** el código que requiere modificación para extensión
2. **Extraer** comportamientos variables a interfaces
3. **Implementar** el patrón Strategy con polimorfismo
4. **Eliminar** lógica condicional (switch/if-else)
5. **Probar** que la extensión funciona sin modificar código existente

El resultado es un sistema más mantenible, extensible y testeable que cumple completamente con el principio Open/Closed.
