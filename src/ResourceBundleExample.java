import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {

    public static void main(String[] args) {
        // Establecer el locale a español
        Locale locale = new Locale("es", "ES");
        ResourceBundle messages = ResourceBundle.getBundle("languages.mensajes", locale);

        // Obtener mensajes
        String greeting = messages.getString("greeting");
        String farewell = messages.getString("farewell");

        System.out.println(greeting); // Output: ¡Hola
        System.out.println(farewell); // Output: Adiós
    }

}
