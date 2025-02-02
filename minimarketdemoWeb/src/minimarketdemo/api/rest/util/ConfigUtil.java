package minimarketdemo.api.rest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Clase de utilidad para cargar y exponer propiedades de config.properties.
 */
public class ConfigUtil {

    private static final Properties PROPS = new Properties();

    static {
        // Bloque estático que se ejecuta una sola vez, 
        // cuando la clase se carga en la JVM.
        try (InputStream in = ConfigUtil.class.getResourceAsStream("/config.properties")) {
            if (in == null) {
                throw new RuntimeException("No se encontró el archivo config.properties en el classpath.");
            }
            PROPS.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Error al leer config.properties: " + e.getMessage(), e);
        }
    }

    /**
     * Retorna el valor de 'secret.key' definido en config.properties.
     */
    public static String getSecretKey() {
        return PROPS.getProperty("secret.key");
    }

    // Si tienes otras propiedades, podrías exponer más métodos:
    // public static String getOtroValor() { ... }
}
