package corrected.products;

import corrected.interfaces.Downloadable;
import corrected.strategies.PriceStrategy;

/**
 * Producto digital que implementa Downloadable
 * Respeta LSP - no implementa métodos que no le corresponden
 */
public class DigitalProduct extends Product implements Downloadable {
    
    private String downloadUrl;
    private long fileSize;
    private String fileFormat;
    
    public DigitalProduct(String name, double basePrice, PriceStrategy priceStrategy,
                         String fileFormat, long fileSize) {
        super(name, basePrice, priceStrategy);
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
        this.downloadUrl = ""; // Se genera cuando se necesita
    }
    
    @Override
    public String getDownloadUrl() {
        if (downloadUrl.isEmpty()) {
            generateDownloadLink();
        }
        return downloadUrl;
    }
    
    @Override
    public long getFileSize() {
        return fileSize;
    }
    
    @Override
    public String getFileFormat() {
        return fileFormat;
    }
    
    @Override
    public void generateDownloadLink() {
        // Simula la generación de un link de descarga
        this.downloadUrl = "https://downloads.example.com/" + name.replaceAll(" ", "_") + "." + fileFormat;
    }
    
    @Override
    public void processOrder() {
        super.processOrder();
        System.out.println("Formato: " + fileFormat);
        System.out.println("Tamaño: " + fileSize + " bytes");
        System.out.println("Generando enlace de descarga...");
        System.out.println("Enlace: " + getDownloadUrl());
    }
}
