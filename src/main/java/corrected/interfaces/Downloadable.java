package corrected.interfaces;

/**
 * Interface para productos que pueden ser descargados
 */
public interface Downloadable {
    String getDownloadUrl();
    long getFileSize();
    String getFileFormat();
    void generateDownloadLink();
}
