package corrected.strategies;

/**
 * Servicio para manejar descargas de archivos
 * Respeta SRP - solo se encarga de la lógica de descarga
 */
public class FileDownload {
    
    public boolean downloadFile(String url, String fileName) {
        // Simula la descarga de un archivo
        System.out.println("Iniciando descarga de: " + fileName);
        System.out.println("Desde: " + url);
        
        try {
            // Simula tiempo de descarga
            Thread.sleep(100);
            System.out.println("Descarga completada: " + fileName);
            return true;
        } catch (InterruptedException e) {
            System.out.println("Error en la descarga: " + e.getMessage());
            return false;
        }
    }
    
    public void validateDownload(String fileName, long expectedSize) {
        System.out.println("Validando descarga: " + fileName);
        System.out.println("Tamaño esperado: " + expectedSize + " bytes");
        // Lógica de validación aquí
    }
}
