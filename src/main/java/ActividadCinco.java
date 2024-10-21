import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class ActividadCinco {
    static final Logger LOGGER = LogManager.getRootLogger();
    public static final String RUTA_FICHERO = "src/main/java/FicherosJava/properties.cnf";
    public static final String RUTA_FICHERO2 = "src/FicherosJava/properties2.cnf";

    public static void main(String[] args) {

        mostrarPropiedades(RUTA_FICHERO);
        cargarPropiedades(RUTA_FICHERO);
    }


    public static void mostrarPropiedades(String nombreFichero) {


        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(new File(nombreFichero)));

            System.out.println("Todas las propiedades " + prop);
            System.out.println("\n");

            //Mostrar las propiedades de una a una
            prop.list(System.out);
            System.out.println("\n");

            Set<Object> keys = prop.keySet();
            System.out.println("Mi estilo: ");
            for (Object key : keys) {
                System.out.println(key + "--" + prop.getProperty(key.toString()));
            }
            System.out.println("\n");

        } catch (FileNotFoundException e) {
            LOGGER.error("ERROR " + "\n" + "El fichero no ha sido encontrado" + e.getMessage());

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }

    }

    public static void cargarPropiedades(String nombreFichero) {

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(new File(nombreFichero)));
            prop.put("Color", "naranja");
            prop.put("Valor", "19.5");
            prop.put("Procedencia", "China");
            prop.store(new FileOutputStream(new File(nombreFichero),true), "");


            prop.list(System.out);

        } catch (FileNotFoundException e) {
            LOGGER.error("ERROR " + "\n" + "El fichero no ha sido encontrado" + e.getMessage());

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
    }

}
